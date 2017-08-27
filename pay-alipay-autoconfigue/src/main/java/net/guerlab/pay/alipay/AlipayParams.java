package net.guerlab.pay.alipay;

import com.alipay.api.internal.util.AlipayHashMap;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("支付宝支付参数")
public class AlipayParams {

    @ApiModelProperty("请求地址")
    private String url;

    @ApiModelProperty("支付参数")
    private AlipayHashMap params;

    public String getUrl() {
        return url;
    }

    public void setUrl(
            String url) {
        this.url = url;
    }

    public AlipayHashMap getParams() {
        return params;
    }

    public void setParams(
            AlipayHashMap params) {
        this.params = params;
    }
}