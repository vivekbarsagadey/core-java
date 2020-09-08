package com.bnb.gj.general.mon;

public class AtddArgumentsTest {
	
	public static void main(String arg[]){
		String inputDataPath = "L1Atdd-Cases-Testdata-All/Phone_Cases";
        AtddArguments atddArguments = AtddArgumentsMapper.map("/Users/RPZ796/Documents/");

        System.out.println(atddArguments.toString());
        System.out.println(atddArguments.getAbsInputfile());
        System.out.println(atddArguments.getAbsOutputfile());



    }

}
