package net.guerlab.sdk.alipay.controller;

import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayConstants;
import com.alipay.api.internal.util.AlipaySignature;

import net.guerlab.sdk.alipay.config.AlipayConfig;

/**
 * 支付宝基础客户端
 *
 * @author guer
 *
 */
public abstract class AlipayAbstractController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AlipayAbstractController.class);

    @Autowired
    protected AlipayConfig config;

    /**
     * 响应参数验证
     *
     * @param requestParams
     *            请求参数
     * @return 是否验签成功
     */
    protected final boolean notifyRsaCheck(
            Map<String, String[]> requestParams) {
        Map<String, String> params = requestParams.entrySet().stream().filter(AlipayAbstractController::entryCheck)
                .collect(Collectors.toMap(e -> e.getKey(), e -> String.join(",", e.getValue())));

        try {
            return AlipaySignature.rsaCheckV1(params, config.getAlipayPublicKey(), AlipayConstants.CHARSET_UTF8,
                    AlipayConstants.SIGN_TYPE_RSA2);
        } catch (AlipayApiException e) {
            LOGGER.debug(e.getMessage(), e);
        }

        return false;
    }

    private static boolean entryCheck(
            Entry<String, String[]> entry) {
        return entry != null && entry.getKey() != null && entry.getValue() != null;
    }
}
