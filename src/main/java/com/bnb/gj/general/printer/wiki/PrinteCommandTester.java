package com.bnb.gj.general.printer.wiki;

import java.io.StringWriter;

import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.AttributeSet;
import javax.print.attribute.HashPrintServiceAttributeSet;
import javax.print.attribute.standard.PrinterName;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

public class PrinteCommandTester {
	
	private static final String PRINTER_NAME = "office-kot-1";
	private TemplateProcesser templateProcesser = null; 
	
	public static void main(String[] args) {
		
		var t = new PrinteCommandTester();
		t.init();
		t.print(t.templateProcesser.getTemplateString());
		
	}
	

	private void init() {
		this.templateProcesser = new TemplateProcesser(generate()); 
		var string  = this.build();
		System.out.println(string);
	}
	
	private String build() {
		templateProcesser.build(PrintCommands.FONT).build(PrintCommands.ALIGN).build(PrintCommands.LINE).buildFeed();
		return templateProcesser.getTemplateString();
	}
	
	private String generate() {
		VelocityEngine velocityEngine = new VelocityEngine();
		velocityEngine.init();
		    
		Template t = velocityEngine.getTemplate("./src/main/java/com/bnb/gj/general/printer/test.vm");
		     
		VelocityContext context = new VelocityContext();
		context.put("name","Will john");
		StringWriter writer = new StringWriter();
		t.merge( context, writer );
		System.out.println("writer.toString() >> "+writer.toString());
		return writer.toString();
	}
	
	private void print(String printData) {
		try {
			AttributeSet attrSet = new HashPrintServiceAttributeSet(new PrinterName(PRINTER_NAME, null)); //EPSON TM-U220 ReceiptE4
			DocPrintJob job = PrintServiceLookup.lookupPrintServices(null, attrSet)[0].createPrintJob();       
			DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;
			Doc doc = new SimpleDoc(printData.getBytes(), flavor, null);
			job.print(doc, null);
			System.out.println("Done !");
		} catch (PrintException e) {
			e.printStackTrace();
		}
	}

}
