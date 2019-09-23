package com.bnb.gj.general.mapper;

import java.util.Date;

import org.dozer.DozerBeanMapper;

public class UserMapper {

	
	
	public static void main(String[] args) {
		var mapper = new DozerBeanMapper() ;
		var customer = new Customer();
		customer.setEndDate(new Date());
		customer.setReceiptNumber("tattta");
		customer.setStartDate(new Date());
		customer.getCustomerDetail().setTotalAmt(200.00);
		customer.setStatus(Active.OFF);
		
		
		
		
		var user = mapper.map(customer, User.class);
		System.out.println(user);
		System.out.println(user.getStatusActive());
		System.out.println(user.getUserDetail().getTotal());
		
		
		
		user = new User();
		user.setChangeId("3000");
		mapper.map(customer,user);
		System.out.println(user);
		System.out.println(user.getChangeId());
		System.out.println(user.getStatusActive());
		System.out.println(user.getUserDetail().getTotal());
		
		
	}
}
