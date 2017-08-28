package com.alipay.api;

import java.util.Map;

/**
 * 请求接口。
 * 
 * @author carver.gu
 * @since 1.0, Sep 12, 2009
 */
public interface AlipayRequest<T extends AlipayResponse> {

    String getApiMethodName();

    Map<String, String> getTextParams();

    String getApiVersion();

    void setApiVersion(
            String apiVersion);

    String getTerminalType();

    void setTerminalType(
            String terminalType);

    String getTerminalInfo();

    void setTerminalInfo(
            String terminalInfo);

    String getProdCode();

    void setProdCode(
            String prodCode);

    String getNotifyUrl();

    void setNotifyUrl(
            String notifyUrl);

    String getReturnUrl();

    void setReturnUrl(
            String returnUrl);

    Class<T> getResponseClass();

    boolean isNeedEncrypt();

    void setNeedEncrypt(
            boolean needEncrypt);

    AlipayObject getBizModel();

    void setBizModel(
            AlipayObject bizModel);

}
