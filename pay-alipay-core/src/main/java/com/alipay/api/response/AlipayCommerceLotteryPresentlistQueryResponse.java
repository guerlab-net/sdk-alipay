package com.alipay.api.response;

import java.util.List;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;
import com.alipay.api.domain.LotteryPresent;

import com.alipay.api.AlipayResponse;

/**
 * ALIPAY API: alipay.commerce.lottery.presentlist.query response.
 * 
 * @author auto create
 * @since 1.0, 2017-07-24 14:37:51
 */
public class AlipayCommerceLotteryPresentlistQueryResponse extends AlipayResponse {

	private static final long serialVersionUID = 4229852188487187868L;

	/** 
	 * 列表内容
	 */
	@ApiListField("results")
	@ApiField("lottery_present")
	private List<LotteryPresent> results;

	/** 
	 * 返回的列表的大小
	 */
	@ApiField("total_result")
	private Long totalResult;

	public void setResults(List<LotteryPresent> results) {
		this.results = results;
	}
	public List<LotteryPresent> getResults( ) {
		return this.results;
	}

	public void setTotalResult(Long totalResult) {
		this.totalResult = totalResult;
	}
	public Long getTotalResult( ) {
		return this.totalResult;
	}

}
