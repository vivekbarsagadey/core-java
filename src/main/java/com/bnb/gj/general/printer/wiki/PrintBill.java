package com.bnb.gj.general.printer.wiki;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

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

import com.bnb.gj.general.printer.Bill;
import com.bnb.gj.general.printer.Item;
import com.bnb.gj.general.printer.StringUtil;

public class PrintBill {
	private static final String PRINTER_NAME = "office-kot-1";
	private TemplateProcesser templateProcesser = null; 

	public static void main(String[] args) {
		var t = new PrintBill();
		t.init();
		t.templateProcesser.getTemplateString();
		//t.print(t.templateProcesser.getTemplateString());
	}
	
	private void init() {
		this.templateProcesser = new TemplateProcesser(generate()); 
		var string  = this.build();
		System.out.println(string);
	}
	
	private String build() {
		templateProcesser.build(PrintCommands.FONT).build(PrintCommands.ALIGN).build(PrintCommands.LINE).build(PrintCommands.CHAR).build(PrintCommands.TAB).buildFeed();
		return templateProcesser.getTemplateString();
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
	
	public static String generate() {
		VelocityEngine velocityEngine = new VelocityEngine();
		velocityEngine.init();
		    
		Template t = velocityEngine.getTemplate("./src/main/java/com/bnb/gj/general/printer/bill-test.vm");
		     
		VelocityContext context = new VelocityContext();
		
		Bill bill = new Bill();
		
		bill.setName("koop");
		bill.setNumber("10001");
		bill.setAddress("Lane No 7, KP");
		
		var items = new ArrayList<Item>();
		items.add(new Item("Penne served in a Creamy Mushroom Sauce (Veg)","1","200","222"));
		items.add(new Item("Spaghetti Alio olio","4","400","5552"));
		items.add(new Item("Spaghetti Alio olio","3","5500","232"));
		items.add(new Item("sa d asd ads","5","2550","232"));
		
		bill.setItems(items);
		
		context.put("bill",bill);
		context.put("name","Will");
		context.put("StringUtil", new StringUtil());
		
		
		//List l = new ArrayList<>();
		//l.add(new Item("aa","1","200","222"));
		//context.put("list",l);
		
		     
		StringWriter writer = new StringWriter();
		t.merge( context, writer );
		System.out.println("writer.toString() >> "+writer.toString());
		return writer.toString();
	}

}
