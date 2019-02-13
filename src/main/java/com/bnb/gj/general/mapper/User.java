package com.bnb.gj.general.mapper;

import java.util.Date;

import org.dozer.Mapping;

import lombok.Data;


@Data
public class User {
	private Date startDate;

	private Date endDate;

	private String receiptNumber;
	
	private String changeId;



	@Mapping("status")
	private Active statusActive;
	
	private String id;
	
	private String storeId;
	
	@Mapping("customerDetail")
	private UserDetail userDetail = new UserDetail();

}
