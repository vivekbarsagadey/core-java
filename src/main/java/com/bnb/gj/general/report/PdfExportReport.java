package com.bnb.gj.general.report;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.ui.jasperreports.JasperReportsUtils;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

public class PdfExportReport {

	public void generateInvoiceFor() throws IOException {
		String sourceFileName = "sales-reports.jrxml";
		File pdfFile = File.createTempFile("my-invoice", ".pdf");

		// Initiate a FileOutputStream
		try (FileOutputStream pos = new FileOutputStream(pdfFile)) {
			final JasperReport report = loadTemplate(sourceFileName);
			final JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(Collections.EMPTY_LIST);
			JasperReportsUtils.renderAsPdf(report, new HashMap<String, Object>(), dataSource, pos);
			
			//JasperExportManager.exportReportToPdfFile(report, "D:\\\\projectjavacore-javasrcmainjavacombnbgjgeneralreport\\\\out.pdf");
		} catch (final Exception e) {
			e.printStackTrace();
		}

	}

	private JasperReport loadTemplate(String template_path) throws JRException {
		final InputStream reportInputStream = getClass().getResourceAsStream(template_path);
		final JasperDesign jasperDesign = JRXmlLoader.load(reportInputStream);

		return JasperCompileManager.compileReport(jasperDesign);
	}
	
	private void exp() {
		try {
			String sourceFileName = "D:\\project\\java\\core-java\\src\\main\\java\\com\\bnb\\gj\\general\\report\\sales-reports.jrxml";
			//Resource resource = new ClassPathResource("templates/reports/sales-reports.jrxml");
			//InputStream in = ClassLoader.class.getResourceAsStream(sourceFileName);
			ClassLoader classLoader = PdfExportReport.class.getClass().getClassLoader();
			File file = new File(sourceFileName);
			
			JasperReport jasperReport = JasperCompileManager.compileReport(new FileInputStream(file));
			Map<String, Object> parameters = new HashMap<String, Object>();

			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters);
			
			byte [] output =JasperExportManager.exportReportToPdf(jasperPrint);
			
			FileWriter fstream = new FileWriter("D:\\projectjavacore-javasrcmainjavacombnbgjgeneralreport\\out.pdf");  
	        BufferedWriter out = new BufferedWriter(fstream);  
	        for (Byte b: output) {  
	            out.write(b);  
	        }  
	        out.close();  

			
			//return ResponseEntity.ok().header("Content-Type", "application/pdf; charset=UTF-8").header("Content-Disposition", "inline; filename=\"receipt-generic.pdf\"").body(output);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		try {
			new PdfExportReport().generateInvoiceFor();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
