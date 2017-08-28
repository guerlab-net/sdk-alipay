/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.alipay.api;

import java.io.Serializable;

/**
 * 
 * @author jiehua
 * @version $Id: EncryptResponseItem.java, v 0.1 2016-3-28 下午4:34:57 jiehua Exp
 *          $
 */
public class ResponseParseItem implements Serializable {

    /**  */
    private static final long serialVersionUID = -27707404159419651L;

    /** 加密节点开始 */
    private int startIndex = -1;

    /** 加密节点结束 */
    private int endIndex = -1;

    /** 加密内容 */
    private String encryptContent = null;

    public ResponseParseItem(int startIndex, int endIndex, String encryptContent) {
        super();
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        this.encryptContent = encryptContent;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public int getEndIndex() {
        return endIndex;
    }

    public String getEncryptContent() {
        return encryptContent;
    }

}
