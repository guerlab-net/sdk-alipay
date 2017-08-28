package com.alipay.api.internal.mapping;

import java.util.List;

import com.alipay.api.AlipayApiException;

/**
 * 格式转换器。
 * 
 * @author carver.gu
 * @since 1.0, Apr 11, 2010
 */
public interface Reader {

    boolean hasReturnField(
            Object name);

    Object getPrimitiveObject(
            Object name);

    Object getObject(
            Object name,
            Class<?> type) throws AlipayApiException;

    List<?> getListObjects(
            Object listName,
            Object itemName,
            Class<?> subType) throws AlipayApiException;

}
