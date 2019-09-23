package com.bnb.gj.general.printer;

import java.io.StringWriter;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

public class PrinteCommandTester {
	
	private TemplateProcesser templateProcesser = null; 
	
	public static void main(String[] args) {
		
		var t = new PrinteCommandTester();
		t.init();
		
		
	}
	

	private void init() {
		this.templateProcesser = new TemplateProcesser(generate()); 
		var string  = this.build();
		System.out.println(string);
	}
	
	private String build() {
		templateProcesser.build(PrintCommands.FONT);
		return templateProcesser.getTemplateString();
	}
	
	private String generate() {
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
