package com.bnb.gj.general.printer;

import java.io.StringWriter;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

public class VelocityTest {
	public static void main(String[] args) {
		 
	
		System.out.println(generate());
		
	
	}
	
	public static String generate() {
		VelocityEngine velocityEngine = new VelocityEngine();
		velocityEngine.init();
		    
		Template t = velocityEngine.getTemplate("./src/main/java/com/bnb/gj/general/printer/test.vm");
		     
		VelocityContext context = new VelocityContext();

		context.put("name","Will");
	
		
		     
		StringWriter writer = new StringWriter();
		t.merge( context, writer );
		System.out.println("writer.toString() >> "+writer.toString());
		return writer.toString();
	}
	

}




