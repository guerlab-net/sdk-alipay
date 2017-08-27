/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package com.alipay.api;

import java.util.Map;

/**
 *
 * @author runzhi
 */
public interface AlipayClient {

    <T extends AlipayResponse> T execute(
            AlipayRequest<T> request) throws AlipayApiException;

    <T extends AlipayResponse> T execute(
            AlipayRequest<T> request,
            String authToken) throws AlipayApiException;

    <T extends AlipayResponse> T execute(
            AlipayRequest<T> request,
            String accessToken,
            String appAuthToken) throws AlipayApiException;

    <T extends AlipayResponse> T pageExecute(
            AlipayRequest<T> request) throws AlipayApiException;

    <T extends AlipayResponse> T sdkExecute(
            AlipayRequest<T> request) throws AlipayApiException;

    <T extends AlipayResponse> T pageExecute(
            AlipayRequest<T> request,
            String method) throws AlipayApiException;

    <TR extends AlipayResponse, T extends AlipayRequest<TR>> TR parseAppSyncResult(
            Map<String, String> result,
            Class<T> requsetClazz) throws AlipayApiException;
}
