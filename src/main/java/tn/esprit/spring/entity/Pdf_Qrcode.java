package tn.esprit.spring.entity;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
//import com.itextpdf.text.Font;
//import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
//import com.lowagie.text.Phrase;
import com.itextpdf.text.pdf.BarcodeQRCode;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
//import com.lowagie.text.pdf.PdfPCell;
//import com.lowagie.text.pdf.PdfPTable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import java.awt.Color;

public class Pdf_Qrcode {
	
	 private List<ReservationEntity> listUsers;
     
	    public Pdf_Qrcode(List<ReservationEntity> listUsers) {
	        this.listUsers = listUsers;}
	    private void writeTableHeader(PdfPTable table) {
	        PdfPCell cell = new PdfPCell();
	       // cell.setBackgroundColor(Color.gray);
	        cell.setPadding(5);
	         
	        Font font = FontFactory.getFont(FontFactory.HELVETICA);
	        font.setColor(Color.WHITE);
	         
	       
	        cell.setPhrase(new Phrase("Enfant"));
	        table.addCell(cell);
	         
	        cell.setPhrase(new Phrase("Event"));
	        table.addCell(cell);
	        
	        cell.setPhrase(new Phrase("Parent"));
	        table.addCell(cell); 
	        
	        cell.setPhrase(new Phrase("Date de Reservation"));
	        table.addCell(cell);       
	    }
	    private void writeTableData(PdfPTable table) {
	        for (ReservationEntity user : listUsers) {
	            table.addCell(String.valueOf(user.getEnfant().getPrenom()));
	            table.addCell(String.valueOf(user.getEvent().getTitre()));
	            table.addCell(String.valueOf(user.getEnfant().getUser().getPrenomU()));
	            table.addCell(String.valueOf(user.getDateReservation()));
	        
	        }
	    }
	     
	        public void export(HttpServletResponse response) throws DocumentException, IOException, BadElementException {
	        	Document document = new Document();
	            PdfWriter writer = PdfWriter.getInstance(document,response.getOutputStream());

	            document.open();
	            PdfContentByte cb = writer.getDirectContent();
		         
		        
		         
		        Paragraph p = new Paragraph("Reservations");
		        p.setAlignment(Paragraph.ALIGN_CENTER);
		       
		         
		        document.add(p);
		         
		        PdfPTable table = new PdfPTable(4);
		        table.setWidthPercentage(100f);
		        table.setWidths(new float[] {3.0f, 3.0f, 3.0f,3.0f});
		        table.setSpacingBefore(30);
		         
		        writeTableHeader(table);
		        writeTableData(table);
		         
		       document.add((Element) table);
		         
		       BarcodeQRCode barcodeQRCode = new BarcodeQRCode("https://i.pinimg.com/736x/e0/da/77/e0da778bf30ef8f0001ef513cb98cf15.jpg", 1000, 1000, null);
		        com.itextpdf.text.Image codeQrImage = barcodeQRCode.getImage();
		        codeQrImage.scaleAbsolute(100, 100);
		        codeQrImage.setAbsolutePosition(50, 500);
		       
		       document.add(codeQrImage);
		        document.close();
		         
}
}
