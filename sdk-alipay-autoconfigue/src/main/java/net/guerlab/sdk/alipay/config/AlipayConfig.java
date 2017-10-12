package net.guerlab.sdk.alipay.config;

import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 支付宝支付配置
 *
 * @author guer
 *
 */
@Component
@ConfigurationProperties(prefix = AlipayConfig.CONFIG_PREFIX)
public class AlipayConfig {

    public static final String CONFIG_PREFIX = "sdk.alipay";

    private boolean dev;

    private Map<String, String> retrunUrls;

    private String appId;

    private String privateKey;

    private String alipayPublicKey;

    private String signType;

    public boolean isDev() {
        return dev;
    }

    public void setDev(
            boolean dev) {
        this.dev = dev;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(
            String appId) {
        this.appId = appId;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(
            String privateKey) {
        this.privateKey = privateKey;
    }

    public String getAlipayPublicKey() {
        return alipayPublicKey;
    }

    public void setAlipayPublicKey(
            String alipayPublicKey) {
        this.alipayPublicKey = alipayPublicKey;
    }

    public Map<String, String> getRetrunUrls() {
        return retrunUrls;
    }

    public void setRetrunUrls(
            Map<String, String> retrunUrls) {
        this.retrunUrls = retrunUrls;
    }

    public String getRetrunUrl(
            String type) {
        return retrunUrls == null ? null : retrunUrls.get(type);
    }

    public String getSignType() {
        return signType;
    }

    public void setSignType(
            String signType) {
        this.signType = signType;
    }
}
