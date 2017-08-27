package net.guerlab.pay.alipay.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayConstants;
import com.alipay.api.internal.util.AlipaySignature;

import net.guerlab.pay.alipay.config.AlipayConfig;

public abstract class AlipayAbstractController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AlipayAbstractController.class);

    protected static final String TYPE = "ALIPAY";

    @Autowired
    protected AlipayConfig config;

    protected final boolean notify0(
            HttpServletRequest request) {
        Map<String, String> params = new HashMap<>();
        Map<String, String[]> requestParams = request.getParameterMap();
        for (String name : requestParams.keySet()) {
            String[] values = requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = i == values.length - 1 ? valueStr + values[i] : valueStr + values[i] + ",";
            }
            params.put(name, valueStr);
        }

        try {
            return AlipaySignature.rsaCheckV1(params, config.getAlipayPublicKey(), AlipayConstants.CHARSET_UTF8,
                    AlipayConstants.SIGN_TYPE_RSA2);
        } catch (AlipayApiException e) {
            LOGGER.debug(e.getMessage(), e);
        }

        return false;
    }
}
