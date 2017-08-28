package com.alipay.api;

import java.io.Serializable;
import java.util.Map;

import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.util.StringUtils;

/**
 * API基础响应信息。
 * 
 * @author fengsheng
 */
public abstract class AlipayResponse implements Serializable {

    private static final long serialVersionUID = 5014379068811962022L;

    @ApiField("code")
    private String code;

    @ApiField("msg")
    private String msg;

    @ApiField("sub_code")
    private String subCode;

    @ApiField("sub_msg")
    private String subMsg;

    private String body;

    private Map<String, String> params;

    @Deprecated
    public String getErrorCode() {
        return this.getCode();
    }

    @Deprecated
    public void setErrorCode(
            String errorCode) {
        this.setCode(errorCode);
    }

    public String getCode() {
        return code;
    }

    public void setCode(
            String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(
            String msg) {
        this.msg = msg;
    }

    public String getSubCode() {
        return this.subCode;
    }

    public void setSubCode(
            String subCode) {
        this.subCode = subCode;
    }

    public String getSubMsg() {
        return this.subMsg;
    }

    public void setSubMsg(
            String subMsg) {
        this.subMsg = subMsg;
    }

    public String getBody() {
        return body;
    }

    public void setBody(
            String body) {
        this.body = body;
    }

    public Map<String, String> getParams() {
        return params;
    }

    public void setParams(
            Map<String, String> params) {
        this.params = params;
    }

    public boolean isSuccess() {
        return StringUtils.isEmpty(subCode);
    }

}
