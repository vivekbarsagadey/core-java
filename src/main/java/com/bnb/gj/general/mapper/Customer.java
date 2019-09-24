package com.bnb.gj.general.mapper;

import java.util.Date;

import lombok.Data;

@Data
public class Customer {
	
	private Date startDate;

	private Date endDate;

	private String receiptNumber;

	

	private Active status;
	
	private String id;
	
	private String storeId;
	
	private CustomerDetail customerDetail = new CustomerDetail();

}
