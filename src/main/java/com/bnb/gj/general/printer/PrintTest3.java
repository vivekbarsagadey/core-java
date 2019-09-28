package com.bnb.gj.general.printer;

import static java.lang.System.out;

import java.io.FileInputStream;
import java.io.IOException;

import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.AttributeSet;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.HashPrintServiceAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.PrinterName;
public class PrintTest3 {
	
	private static final String PRINTER_NAME = "\\\\192.168.100.23\\POS-58-Series";

	public static void mainOld(String[] args) {

		try {
			AttributeSet attrSet = new HashPrintServiceAttributeSet(new PrinterName(PRINTER_NAME, null)); //EPSON TM-U220 ReceiptE4
			
			DocPrintJob job = PrintServiceLookup.lookupPrintServices(null, attrSet)[0].createPrintJob();       
			//PrintServiceLookup.lookupDefaultPrintService().createPrintJob();  

			DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;
			Doc doc = new SimpleDoc(createPrintOption(), flavor, null);
			job.print(doc, null);
			System.out.println("Done !");
		} catch (PrintException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {

		PrinterService printerService = new PrinterService();

		out.println(printerService.getPrinters());
		try (final FileInputStream textStream = new FileInputStream("./src/main/java/com/bnb/gj/general/printer/print-file.txt")) {
			
			DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;
			Doc myDoc = new SimpleDoc(createPrintOption(), flavor, null); 
			PrintRequestAttributeSet aset = new HashPrintRequestAttributeSet(); 
			//aset.add(new Copies(1)); 
			//aset.add(MediaSize.ISO.A7);
			//aset.add(Finishings.STAPLE);
			
			PrintService printService[] = PrintServiceLookup.lookupPrintServices(
					flavor, aset);
			PrintService service = findPrintService(PRINTER_NAME, printService);
			DocPrintJob job = service.createPrintJob(); 
			try {
				job.print(myDoc, aset);
			} catch (PrintException e) {
				e.printStackTrace();
			} 
			
		} catch (IOException exception) {
			out.println("Exception encountered: " + exception);
		}
	}
	
	private static PrintService findPrintService(String printerName,
			PrintService[] services) {
		
		for (PrintService service : services) {
			System.out.println("name" + service.getName());
			if (service.getName().equalsIgnoreCase(printerName)) {
				return service;
			}
		}
 
		return null;
	}
	
	private static byte[] createPrintOption() {
		
		PrintOption p=new PrintOption();

		p.resetAll();
		p.initialize();
		p.feedBack((byte)2);
		p.color(0);
		p.alignCenter();
		p.doubleHeight(true);
		p.setText("The Dum Dum Name");
		p.doubleHeight(false);
		p.newLine();
		p.setText("Restaurant Dining");
		p.newLine();
		p.addLineSeperator();
		p.setText("Bling Bling");
		p.newLine();
		p.addLineSeperator();
		p.newLine();

		p.alignLeft();
		p.setText("POD No \t: 2001 \tTable \t: E511");
		p.newLine();              

		p.setText("Res Date \t: " +  "01/01/1801 22:59");

		p.newLine();
		p.setText("Session \t: Evening Session");
		p.newLine();
		p.setText("Staff \t: Bum Dale");
		p.newLine();
		p.addLineSeperator();
		p.newLine();
		p.alignCenter();
		p.setText(" - Some Items - ");
		p.newLine();
		p.alignLeft();
		p.addLineSeperator();

		p.newLine();

		p.setText("No \tItem\t\tUnit\tQty");
		p.newLine();
		p.addLineSeperator();
		p.setText("1" + "\t" + "Aliens Everywhere" + "\t" +  "Rats" + "\t" + "500");
		p.setText("1" + "\t" + "Aliens Everywhere" + "\t" +  "Rats" + "\t" + "500");
		p.setText("1" + "\t" + "Aliens Everywhere" + "\t" +  "Rats" + "\t" + "500");
		p.setText("1" + "\t" + "Aliens Everywhere" + "\t" +  "Rats" + "\t" + "500");
		p.setText("1" + "\t" + "Aliens Everywhere" + "\t" +  "Rats" + "\t" + "500");
		p.setText("1" + "\t" + "Aliens Everywhere" + "\t" +  "Rats" + "\t" + "500");

		p.addLineSeperator();
		p.feed((byte)3);
		p.finit();
		
		out.print( p.finalCommandSet().getBytes());
 
		return p.finalCommandSet().getBytes();
	}
	
	
	

}
