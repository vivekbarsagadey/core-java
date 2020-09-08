package com.bnb.gj.general.lambda.steam;

import java.util.ArrayList;
import java.util.List;

public class ListTest {

	public static void main(String[] args) {
		List list = new ArrayList<String>();
		
		var str = list.stream().findFirst();
		System.out.println(">>>"+str.orElse("Empty"));
		

	}

}
