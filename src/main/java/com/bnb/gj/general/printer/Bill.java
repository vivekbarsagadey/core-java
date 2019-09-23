package com.bnb.gj.general.printer;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Bill{
	public String name;
	private String number;
	private String address;
	private String grandTotal;
	private List<Item> items;


}
