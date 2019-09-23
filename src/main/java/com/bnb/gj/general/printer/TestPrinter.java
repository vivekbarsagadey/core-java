package com.bnb.gj.general.printer;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;

import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.ServiceUI;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.Copies;
import javax.print.attribute.standard.Media;
import javax.print.attribute.standard.MediaSizeName;
import javax.print.attribute.standard.OrientationRequested;

public class TestPrinter {

	public static void mainOld(String[] args) {
		// TODO Auto-generated method stub
		DocFlavor flavor = DocFlavor.URL.GIF;
		// PrintService[] services = PrintServiceLookup.lookupPrintServices(null, null);

		PrintService service = PrintServiceLookup.lookupDefaultPrintService();
		/*
		 * for (int i = 0; i < services.length; i++) {
		 * System.out.println(services[i].getName()); }
		 */

		if (!service.isDocFlavorSupported(flavor)) {
			System.err.println("The printer does not support the appropriate DocFlavor");
		}

	}

	public static void mainOld2(String[] args) {

		try {
			var jpegStream = new File(
					"D:\\project\\hotel-wiki\\workspace\\general\\src\\main\\java\\com\\bnb\\gj\\general\\printer\\Receipt.pdf");
			PrintService service = PrintServiceLookup.lookupDefaultPrintService();
			System.out.println("service name is " + service.getName());
			DocPrintJob job = service.createPrintJob();
			// URL url = new URL("/a.jpg");
			DocFlavor flavor = DocFlavor.INPUT_STREAM.AUTOSENSE;
			Doc doc = new SimpleDoc(new FileInputStream(jpegStream), DocFlavor.READER.TEXT_PLAIN, null);
			PrintRequestAttributeSet attrs = new HashPrintRequestAttributeSet();
			// attrs.add(OrientationRequested.PORTRAIT);
			// attrs.add(MediaSizeName.INVOICE);
			attrs.add((Media) service.getDefaultAttributeValue(Media.class));
			attrs.add(new Copies(2));
			job.print(doc, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void mainO(String[] args) {

		try {
			var jpegStream = new File(
					"D:\\project\\hotel-wiki\\workspace\\general\\src\\main\\java\\com\\bnb\\gj\\general\\printer\\Receipt.pdf");
			PrintService defaultPrintService = PrintServiceLookup.lookupDefaultPrintService();
			DocPrintJob printerJob = defaultPrintService.createPrintJob();
			SimpleDoc simpleDoc = null;
			simpleDoc = new SimpleDoc(jpegStream.toURL(), DocFlavor.URL.AUTOSENSE, null);
			printerJob.print(simpleDoc, null);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		try {
			FileInputStream fis= new FileInputStream(new File(
					"D:\\project\\hotel-wiki\\workspace\\general\\src\\main\\java\\com\\bnb\\gj\\general\\printer\\Receipt.pdf"));
			PrintService[] services = PrintServiceLookup.lookupPrintServices(null, null);
			PrintService service = PrintServiceLookup.lookupDefaultPrintService();
			System.out.println("The name is " + service.getName());
			DocFlavor flavor =DocFlavor.INPUT_STREAM.AUTOSENSE;

			PrintRequestAttributeSet attrs = new HashPrintRequestAttributeSet();
			//attrs.add(OrientationRequested.PORTRAIT);
			attrs.add(MediaSizeName.INVOICE);
			attrs.add(new Copies(1));
			PrintService selection = ServiceUI.printDialog(null, 100, 100, services, service, null, attrs);

			//URL url = new URL("https://upload.wikimedia.org/wikipedia/commons/6/6f/Wavy2.gif");
			//flavor = DocFlavor.URL.GIF;
			SimpleDoc doc = new SimpleDoc(fis, flavor, null);
			selection.createPrintJob().print(doc, attrs);
			
			
			fis.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
