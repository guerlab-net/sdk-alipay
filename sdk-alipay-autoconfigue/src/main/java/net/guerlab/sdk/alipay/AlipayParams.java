package net.guerlab.sdk.alipay;

import com.alipay.api.internal.util.AlipayHashMap;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 支付宝支付参数
 *
 * @author guer
 *
 */
@ApiModel("支付宝支付参数")
public class AlipayParams {

    /**
     * 请求地址
     */
    @ApiModelProperty("请求地址")
    private String url;

    /**
     * 支付参数
     */
    @ApiModelProperty("支付参数")
    private AlipayHashMap params;

    /**
     * 返回请求地址
     *
     * @return 请求地址
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置请求地址
     *
     * @param url
     *            请求地址
     */
    public void setUrl(
            String url) {
        this.url = url;
    }

    /**
     * 返回支付参数
     *
     * @return 支付参数
     */
    public AlipayHashMap getParams() {
        return params;
    }

    /**
     * 设置支付参数
     *
     * @param params
     *            支付参数
     */
    public void setParams(
            AlipayHashMap params) {
        this.params = params;
    }
}