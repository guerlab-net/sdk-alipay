package net.guerlab.sdk.alipay.utils;

import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayConstants;
import com.alipay.api.internal.util.AlipaySignature;

import net.guerlab.sdk.alipay.properties.AlipayProperties;

/**
 * 通知回调工具类
 *
 * @author guer
 *
 */
public class NotifyUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(NotifyUtils.class);

    private NotifyUtils() {

    }

    /**
     * 回调数据通过支付宝公钥进行验签
     *
     * @param properties
     *            支付宝配置
     * @param requestParams
     *            请求参数
     * @return 是否检查通过
     */
    public static boolean rsaCheck(AlipayProperties properties, Map<String, String[]> requestParams) {
        try {
            return rsaCheck(properties, requestParams, false);
        } catch (Exception e) {
            LOGGER.debug(e.getMessage(), e);
            return false;
        }
    }

    /**
     * 回调数据通过支付宝公钥进行验签
     *
     * @param properties
     *            支付宝配置
     * @param requestParams
     *            请求参数
     * @param throwException
     *            检查失败是否抛出异常
     * @return 是否检查通过
     *
     * @throws NullPointerException
     *             当requestParams为空的时候抛出NullPointerException
     * @throws AlipayApiException
     *             支付宝公钥验签失败的时候抛出AlipayApiException
     */
    public static boolean rsaCheck(AlipayProperties properties, Map<String, String[]> requestParams,
            boolean throwException) throws AlipayApiException {
        if (requestParams == null) {
            if (throwException) {
                throw new NullPointerException("requestParams cann't be null");
            }
            return false;
        }

        Map<String, String> params = requestParams.entrySet().stream().filter(NotifyUtils::entryCheck)
                .collect(Collectors.toMap(e -> e.getKey(), e -> String.join(",", e.getValue())));

        try {
            return AlipaySignature.rsaCheckV1(params, properties.getAlipayPublicKey(), AlipayConstants.CHARSET_UTF8,
                    AlipayConstants.SIGN_TYPE_RSA2);
        } catch (AlipayApiException e) {
            LOGGER.debug(e.getMessage(), e);
            if (throwException) {
                throw e;
            }
        }

        return false;
    }

    private static boolean entryCheck(Entry<String, String[]> entry) {
        return entry != null && entry.getKey() != null && entry.getValue() != null;
    }

}