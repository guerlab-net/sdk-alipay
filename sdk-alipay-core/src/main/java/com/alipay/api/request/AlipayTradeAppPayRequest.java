package com.alipay.api.request;

import java.util.Map;

import com.alipay.api.AlipayObject;
import com.alipay.api.AlipayRequest;
import com.alipay.api.internal.util.AlipayHashMap;
import com.alipay.api.response.AlipayTradeAppPayResponse;

/**
 * ALIPAY API: alipay.trade.app.pay request
 *
 * @author auto create
 * @since 1.0, 2017-06-19 11:12:46
 */
public class AlipayTradeAppPayRequest implements AlipayRequest<AlipayTradeAppPayResponse> {

    private AlipayHashMap udfParams; // add user-defined text parameters

    private String apiVersion = "1.0";

    /**
     * app支付接口2.0
     */
    private String bizContent;

    public void setBizContent(String bizContent) {
        this.bizContent = bizContent;
    }

    public String getBizContent() {
        return bizContent;
    }

    private String terminalType;

    private String terminalInfo;

    private String prodCode;

    private String notifyUrl;

    private String returnUrl;

    private boolean needEncrypt = false;

    private AlipayObject bizModel = null;

    @Override
    public String getNotifyUrl() {
        return notifyUrl;
    }

    @Override
    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    @Override
    public String getReturnUrl() {
        return returnUrl;
    }

    @Override
    public void setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl;
    }

    @Override
    public String getApiVersion() {
        return apiVersion;
    }

    @Override
    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    @Override
    public void setTerminalType(String terminalType) {
        this.terminalType = terminalType;
    }

    @Override
    public String getTerminalType() {
        return terminalType;
    }

    @Override
    public void setTerminalInfo(String terminalInfo) {
        this.terminalInfo = terminalInfo;
    }

    @Override
    public String getTerminalInfo() {
        return terminalInfo;
    }

    @Override
    public void setProdCode(String prodCode) {
        this.prodCode = prodCode;
    }

    @Override
    public String getProdCode() {
        return prodCode;
    }

    @Override
    public String getApiMethodName() {
        return "alipay.trade.app.pay";
    }

    @Override
    public Map<String, String> getTextParams() {
        AlipayHashMap txtParams = new AlipayHashMap();
        txtParams.put("biz_content", bizContent);
        if (udfParams != null) {
            txtParams.putAll(udfParams);
        }
        return txtParams;
    }

    public void putOtherTextParam(String key, String value) {
        if (udfParams == null) {
            udfParams = new AlipayHashMap();
        }
        udfParams.put(key, value);
    }

    @Override
    public Class<AlipayTradeAppPayResponse> getResponseClass() {
        return AlipayTradeAppPayResponse.class;
    }

    @Override
    public boolean isNeedEncrypt() {

        return needEncrypt;
    }

    @Override
    public void setNeedEncrypt(boolean needEncrypt) {

        this.needEncrypt = needEncrypt;
    }

    @Override
    public AlipayObject getBizModel() {

        return bizModel;
    }

    @Override
    public void setBizModel(AlipayObject bizModel) {

        this.bizModel = bizModel;
    }

}
