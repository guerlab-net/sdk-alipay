package net.guerlab.sdk.alipay.config;

public interface AlipayUrlConstants {

    String OAUTH2 = "https://openauth.alipay.com/oauth2/";

    String OAUTH2_DEV = "https://openauth.alipaydev.com/oauth2/";

    String GATEWAY = "https://openapi.alipay.com/gateway.do";

    String GATEWAY_DEV = "https://openapi.alipaydev.com/gateway.do";

    static String oauth2(
            boolean dev) {
        return dev ? OAUTH2_DEV : OAUTH2;
    }

    static String gateway(
            boolean dev) {
        return dev ? GATEWAY_DEV : GATEWAY;
    }
}
