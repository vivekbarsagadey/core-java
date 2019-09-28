package com.bnb.gj.general.printer;

import jpos.CashDrawer;
import jpos.CashDrawerControl113;
import jpos.POSPrinter;
import jpos.POSPrinterControl113;

public class JavaPosServices {
	public static void main(String[] args) {
		POSPrinterControl113 printer = (jpos.POSPrinterControl113) new POSPrinter();
		//CashDrawerControl113 drawer = (CashDrawerControl113) new CashDrawer();
		try {
		        printer.open("office-kot-1");
		        printer.claim(100);

		        printer.setDeviceEnabled(true);
		    } catch (Exception e) {
		        System.err.println("Printer deactivated " + e.getMessage());
		        return;
		    }
		    try {
		        //drawer.open("CashDrawer");
		       // drawer.claim(100);
		       // drawer.setDeviceEnabled(true);
		    } catch (Exception e) {
		        System.out.println("Cashdrawer deactivated: " + e.getMessage());
		        return;
		    }
	}

}
