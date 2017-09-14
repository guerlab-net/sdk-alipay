package com.alipay.api;

/**
 * 响应解释器接口。响应格式可以是JSON, XML等等。
 * 
 * @author carver.gu
 * @since 1.0, Apr 11, 2010
 */
public interface AlipayParser<T extends AlipayResponse> {

    T parse(
            String rsp) throws AlipayApiException;

    Class<T> getResponseClass() throws AlipayApiException;

    SignItem getSignItem(
            AlipayRequest<?> request,
            String responseBody) throws AlipayApiException;

    String encryptSourceData(
            AlipayRequest<?> request,
            String body,
            String format,
            String encryptType,
            String encryptKey,
            String charset) throws AlipayApiException;

}
