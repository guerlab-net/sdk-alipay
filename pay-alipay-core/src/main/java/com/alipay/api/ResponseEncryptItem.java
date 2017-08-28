/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.alipay.api;

import java.io.Serializable;

/**
 * 
 * 
 * @author jiehua
 * @version $Id: EncryptReponseItem.java, v 0.1 2016-3-28 下午6:20:04 jiehua Exp $
 */
public class ResponseEncryptItem implements Serializable {

    /**  */
    private static final long serialVersionUID = 6680775791485372169L;

    /**
     * 响应返回
     */
    private String respContent;

    /**
     * 处理完后的返回
     */
    private String realContent;

    public ResponseEncryptItem(String respContent, String realContent) {
        super();
        this.respContent = respContent;
        this.realContent = realContent;
    }

    public String getRespContent() {
        return respContent;
    }

    public String getRealContent() {
        return realContent;
    }

}
