# sdk-alipay
> spring boot下支付宝的开箱既用环境

## 使用场景
> spring boot应用中需要接入支付宝

## 开始使用

> 1. pom.xml中引入依赖

```
<dependency>
    <groupId>net.guerlab</groupId>
    <artifactId>sdk-alipay-starter</artifactId>
    <version>1.3.0</version>
</dependency>
```

> 2. bootstrap.yml中增加配置

```
sdk:
  alipay:
    dev: true/false #默认false,为true表示使用沙箱环境
    sign-type: RSA2 #签名算法
    app-id: #应用ID
    private-key: #应用私钥
    alipay-public-key: #支付宝公钥
```

> 3. 增加控制器实现

```

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayClient;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.request.AlipayTradeWapPayRequest;

import net.guerlab.sdk.alipay.controller.AlipayAbstractController;


@RequestMapping("/pay/alipay")
public class AlipayController extends AlipayAbstractController {

    @Autowired
    private AlipayClient client;//支付宝请求sdk客户端

    /**
     * 支付请求
     */
    @GetMapping("/app/{orderId}")
    public String app(
            @PathVariable Long orderId,
            HttpServletResponse httpResponse) {
        
        JSONObject data = new JSONObject();
        data.put("out_trade_no", "201701010000001234"); //商户订单号
        data.put("product_code", "QUICK_MSECURITY_PAY"); //产品码, APP支付 QUICK_MSECURITY_PAY, PC支付 FAST_INSTANT_TRADE_PAY, 移动H5支付 QUICK_WAP_PAY
        data.put("total_amount", "0.01"); //订单金额
        data.put("subject", "测试订单"); //订单标题

        //APP支付
        AlipayTradeAppPayRequest request = new AlipayTradeAppPayRequest();
        //PC支付
        //AlipayTradePagePayRequest request = new AlipayTradePagePayRequest();
        //移动H5支付
        //AlipayTradeWapPayRequest request = new AlipayTradeWapPayRequest();
        request.setNotifyUrl("http://demo/pay/alipay/notify/1"); //异步通知地址
        request.setBizContent(data.toJSONString()); //业务参数

        //APP支付
        return client.sdkExecute(request).getBody();
        //PC支付
        //try {
        //    PrintWriter writer = httpResponse.getWriter();
        //    httpResponse.setContentType("text/html;charset=UTF-8");
        //    writer.write(client.pageExecute(request).getBody());
        //    writer.flush();
        //    writer.close();
        //    return null;
        //} catch (Exception e) {
        //    LOGGER.debug(e.getMessage(), e);
        //    return "创建支付信息失败";
        //}
        //移动H5支付
        //try {
        //    PrintWriter writer = httpResponse.getWriter();
        //    httpResponse.setContentType("text/html;charset=UTF-8");
        //    writer.write(client.pageExecute(request).getBody());
        //    writer.flush();
        //    writer.close();
        //    return null;
        //} catch (Exception e) {
        //    LOGGER.debug(e.getMessage(), e);
        //    return "创建支付信息失败";
        //}
    }

    @PostMapping("/notify/{orderId}")
    public String notify(
            @PathVariable Long orderId,
            HttpServletRequest request) {
        if (!notifyRsaCheck(request.getParameterMap())) {
            //这里处理验签失败
        }

        request.getParameter("trade_no");//获取请求参数中的商户订单号

        return "success";
    }
}
```