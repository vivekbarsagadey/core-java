package com.bnb.gj.general.printer;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.ui.velocity.VelocityEngineUtils;

public class Test2 {
	public static void main(String[] args) {
		 
		PrinterService printerService = new PrinterService();
		
		System.out.println(printerService.getPrinters());
				
		//print some stuff
		//printerService.printString("POS-58-Series", "\n\n testing testing 1 2 3eeeee \n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		
		//System.out.println(VelocityTemplate.generate());
		
		//printerService.printString("\\\\192.168.100.12\\POS-58-Series", VelocityTemplate.generate());
		
		//printerService.printString("\\\\192.168.100.55\\EPSON TM-T82II Receipt", VelocityTemplate.generate());
		//printerService.printString("EPSON TM-T82II Receipt5 56", VelocityTemplate.generate());
		//printerService.printString("EPSON TM-T82II Receipt5", VelocityTemplate.generate());
		
		
		//printerService.printString("\\\\192.168.100.23\\POS-58-Series", VelocityTemplate.generate());
		
		//printerService.printHtml("office-kot-1", "./src/main/java/com/bnb/gj/general/printer/abc.html");
		
		//printerService.printPdf("\\\\192.168.100.23\\POS-58-Series", "./src/main/java/com/bnb/gj/general/printer/abc.pdf");
		printerService.printImage("\\\\192.168.100.23\\POS-58-Series", "./src/main/java/com/bnb/gj/general/printer/full-image.png");
		
		
 
		// cut that paper!
		//byte[] cutP = new byte[] { 0x1d, 'V', 1 };
 
		//printerService.printBytes("POS-58-Series", cutP);
	
	}

}

class VelocityTemplate{
	
	public static String generate() {
		VelocityEngine velocityEngine = new VelocityEngine();
		velocityEngine.init();
		    
		Template t = velocityEngine.getTemplate("./src/main/java/com/bnb/gj/general/printer/receipt.vm");
		     
		VelocityContext context = new VelocityContext();
		
		Bill bill = new Bill();
		
		bill.setName("koop");
		bill.setNumber("10001");
		bill.setAddress("Lane No 7, KP");
		
		var items = new ArrayList<Item>();
		items.add(new Item("aa","1","200","222"));
		items.add(new Item("weq","4","400","5552"));
		items.add(new Item("wrqw","3","5500","232"));
		items.add(new Item("wrwe","5","2550","232"));
		
		bill.setItems(items);
		
		context.put("bill",bill);
		context.put("name","Will");
		context.put("StringUtil", new StringUtil());
		
		
		List l = new ArrayList<>();
		l.add(new Item("aa","1","200","222"));
		context.put("list",l);
		
		     
		StringWriter writer = new StringWriter();
		t.merge( context, writer );
		System.out.println("writer.toString() >> "+writer.toString());
		return writer.toString();
	}
	
	public static String generateSpring() {
		VelocityEngine velocityEngine = new VelocityEngine();
		velocityEngine.init();
		
		Bill bill = new Bill();
		
		bill.setName("koop");
		bill.setNumber("10001");
		bill.setAddress("Lane No 7, KP");
		
		var items = new ArrayList<Item>();
		items.add(new Item("aa","1","200","222"));
		items.add(new Item("weq","4","400","5552"));
		items.add(new Item("wrqw","3","5500","232"));
		items.add(new Item("wrwe","5","2550","232"));
		
		bill.setItems(items);

		
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("billObj", bill);
		model.put("name", "Will");
    	String text = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "./src/main/java/com/bnb/gj/general/printer/index.vm", "UTF-8", model);
		
		
	
		System.out.println("new data >> "+text);
		return text;
	}
	
	public static String getStringFromHtml(String htmlString) {
		Document doc = Jsoup.parse(htmlString);
        String title = doc.title();
        String body = doc.body().text();
        return body;
	}
	
}



