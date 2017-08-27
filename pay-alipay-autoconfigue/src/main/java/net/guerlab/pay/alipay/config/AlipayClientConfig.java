package net.guerlab.pay.alipay.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alipay.api.AlipayConstants;
import com.alipay.api.DefaultAlipayClient;

/**
 *
 *
 * @author guer
 *
 */
@Configuration
public class AlipayClientConfig {

    @Bean
    public DefaultAlipayClient client(
            AlipayConfig config) {
        DefaultAlipayClient client = new DefaultAlipayClient(config.getServerUrl(), config.getAppId(),
                config.getPrivateKey(), AlipayConstants.FORMAT_JSON, AlipayConstants.CHARSET_UTF8, config.getPulicKey(),
                AlipayConstants.SIGN_TYPE_RSA2);

        return client;
    }
}
