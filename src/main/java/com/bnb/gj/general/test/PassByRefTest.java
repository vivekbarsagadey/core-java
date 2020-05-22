package com.bnb.gj.general.test;

public class PassByRefTest {

	public static void main(String[] args) {
		var passRef = new PassRef("Old Name");
		var self = new PassByRefTest();
		System.out.println("Before Change Name  :: "+passRef.name);
		self.chnageName(passRef, "Change Name");
		System.out.println("After Change Name ::  "+passRef.name);
		
	}

	private void chnageName(PassRef ref, String name) {
		ref.name = name;

	}

}

class PassRef {
	public String name;
	public PassRef(String name) {
		this.name = name;

	}

}
