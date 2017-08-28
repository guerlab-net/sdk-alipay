package com.alipay.api.internal.mapping;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayRequest;
import com.alipay.api.AlipayResponse;
import com.alipay.api.SignItem;

/**
 * 动态格式转换器。
 * 
 * @author carver.gu
 * @since 1.0, Apr 11, 2010
 */
public interface Converter {

    <T extends AlipayResponse> T toResponse(
            String rsp,
            Class<T> clazz) throws AlipayApiException;

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
