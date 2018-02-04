package net.guerlab.sdk.alipay.config;

import java.util.Objects;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alipay.api.AlipayClient;
import com.alipay.api.AlipayConstants;
import com.alipay.api.DefaultAlipayClient;

/**
 * 支付宝客户端自动配置
 *
 * @author guer
 *
 */
@Configuration
@EnableConfigurationProperties(AlipayConfig.class)
public class ApilayAutoConfiguration {

    private static final String ERROR_MSG_APPID_NULL = "alipay application's appid cann't be null";

    private static final String ERROR_MSG_PRIVATE_KEY_NULL = "alipay application's privateKey cann't be null";

    private static final String ERROR_MSG_ALIPAY_PUBLIC_KEY_NULL = "alipay's publicKey cann't be null";

    /**
     * 构造支付宝客户端
     *
     * @param config
     *            支付宝配置
     * @return 支付宝客户端
     */
    @RefreshScope
    @Bean
    public AlipayClient alipayClient(
            AlipayConfig config) {

        String gatewayUrl = AlipayUrlConstants.gateway(config.isDev());
        String appId = Objects.requireNonNull(config.getAppId(), ERROR_MSG_APPID_NULL);
        String privateKey = Objects.requireNonNull(config.getPrivateKey(), ERROR_MSG_PRIVATE_KEY_NULL);
        String format = AlipayConstants.FORMAT_JSON;
        String charset = AlipayConstants.CHARSET_UTF8;
        String alipayPublicKey = Objects.requireNonNull(config.getAlipayPublicKey(), ERROR_MSG_ALIPAY_PUBLIC_KEY_NULL);
        String signType = AlipayConstants.SIGN_TYPE_RSA.equals(config.getSignType()) ? AlipayConstants.SIGN_TYPE_RSA
                : AlipayConstants.SIGN_TYPE_RSA2;

        return new DefaultAlipayClient(gatewayUrl, appId, privateKey, format, charset, alipayPublicKey, signType);
    }
}
