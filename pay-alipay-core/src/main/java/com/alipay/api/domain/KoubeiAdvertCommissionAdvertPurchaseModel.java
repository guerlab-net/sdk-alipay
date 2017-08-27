package com.alipay.api.domain;

import java.util.List;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

/**
 * 广告推广用于参与接口
 *
 * @author auto create
 * @since 1.0, 2017-01-17 21:29:21
 */
public class KoubeiAdvertCommissionAdvertPurchaseModel extends AlipayObject {

    private static final long serialVersionUID = 2853799552312438491L;

    @ApiField("channel_id")
    private String channelId;

    @ApiField("out_unique_id")
    private String outUniqueId;

    @ApiField("security_code")
    private String securityCode;

    @ApiField("tag")
    private String tag;

    @ApiListField("trigger_identifies")
    @ApiField("string")
    private List<String> triggerIdentifies;

    @ApiField("trigger_identify_type")
    private String triggerIdentifyType;

    @ApiField("user_identify")
    private String userIdentify;

    @ApiField("user_identify_type")
    private String userIdentifyType;

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(
            String channelId) {
        this.channelId = channelId;
    }

    public String getOutUniqueId() {
        return outUniqueId;
    }

    public void setOutUniqueId(
            String outUniqueId) {
        this.outUniqueId = outUniqueId;
    }

    public String getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(
            String securityCode) {
        this.securityCode = securityCode;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(
            String tag) {
        this.tag = tag;
    }

    public List<String> getTriggerIdentifies() {
        return triggerIdentifies;
    }

    public void setTriggerIdentifies(
            List<String> triggerIdentifies) {
        this.triggerIdentifies = triggerIdentifies;
    }

    public String getTriggerIdentifyType() {
        return triggerIdentifyType;
    }

    public void setTriggerIdentifyType(
            String triggerIdentifyType) {
        this.triggerIdentifyType = triggerIdentifyType;
    }

    public String getUserIdentify() {
        return userIdentify;
    }

    public void setUserIdentify(
            String userIdentify) {
        this.userIdentify = userIdentify;
    }

    public String getUserIdentifyType() {
        return userIdentifyType;
    }

    public void setUserIdentifyType(
            String userIdentifyType) {
        this.userIdentifyType = userIdentifyType;
    }

}
