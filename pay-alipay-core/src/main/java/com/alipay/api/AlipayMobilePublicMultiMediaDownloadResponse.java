/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.api;

import com.alipay.api.internal.mapping.ApiField;

public class AlipayMobilePublicMultiMediaDownloadResponse extends AlipayResponse {

    /** serialVersionUID */
    private static final long serialVersionUID = 4500718209713594926L;

    @ApiField("code")
    private String code;

    @ApiField("msg")
    private String msg;

    @Override
    public void setCode(
            String code) {
        this.code = code;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public void setMsg(
            String msg) {
        this.msg = msg;
    }

    @Override
    public String getMsg() {
        return msg;
    }

}
