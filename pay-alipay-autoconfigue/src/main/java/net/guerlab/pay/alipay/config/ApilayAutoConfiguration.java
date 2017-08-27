package net.guerlab.pay.alipay.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alipay.api.AlipayConstants;
import com.alipay.api.DefaultAlipayClient;

@Configuration
@EnableConfigurationProperties(AlipayConfig.class)
public class ApilayAutoConfiguration {

    @Bean
    public DefaultAlipayClient client(
            AlipayConfig config) {

        String signType = AlipayConstants.SIGN_TYPE_RSA.equals(config.getSignType()) ? AlipayConstants.SIGN_TYPE_RSA
                : AlipayConstants.SIGN_TYPE_RSA2;

        DefaultAlipayClient client = new DefaultAlipayClient(config.getServerUrl(), config.getAppId(),
                config.getPrivateKey(), AlipayConstants.FORMAT_JSON, AlipayConstants.CHARSET_UTF8, config.getPulicKey(),
                signType);

        return client;
    }
}
