package com.bnb.gj.general.mapper;

import org.dozer.Mapping;

import lombok.Data;

@Data
public class UserDetail {
	
	@Mapping("totalAmt")
	private Double total;

	private Double totalDiscount;

	private Double totalBeverageAmt;

	private Double totalFoodAmt;

	private Double totalLiquorAmt;

}
