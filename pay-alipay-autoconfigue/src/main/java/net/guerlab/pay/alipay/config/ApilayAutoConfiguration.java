package net.guerlab.pay.alipay.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alipay.api.AlipayClient;
import com.alipay.api.AlipayConstants;
import com.alipay.api.DefaultAlipayClient;

@Configuration
@EnableConfigurationProperties(AlipayConfig.class)
public class ApilayAutoConfiguration {

    @Bean
    public AlipayClient client(
            AlipayConfig config) {

        String signType = AlipayConstants.SIGN_TYPE_RSA.equals(config.getSignType()) ? AlipayConstants.SIGN_TYPE_RSA
                : AlipayConstants.SIGN_TYPE_RSA2;

        DefaultAlipayClient client = new DefaultAlipayClient(AlipayUrlConstants.gateway(config.isDev()),
                config.getAppId(), config.getPrivateKey(), AlipayConstants.FORMAT_JSON, AlipayConstants.CHARSET_UTF8,
                config.getAlipayPublicKey(), signType);

        return client;
    }
}
