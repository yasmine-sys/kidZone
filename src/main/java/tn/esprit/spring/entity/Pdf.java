package tn.esprit.spring.entity;


import java.awt.Color;
import java.io.IOException;
import java.util.List;
 
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.pdf.BarcodeQRCode;
import com.lowagie.text.*;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Image;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.*;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.*;
import com.itextpdf.text.*;
import com.itextpdf.text.BadElementException;


public class Pdf {
	 private List<ReservationEntity> listUsers;
     
	    public Pdf(List<ReservationEntity> listUsers) {
	        this.listUsers = listUsers;
	    }
	    private void writeTableHeader(PdfPTable table) {
	        PdfPCell cell = new PdfPCell();
	        cell.setBackgroundColor(Color.gray);
	        cell.setPadding(5);
	         
	        Font font = FontFactory.getFont(FontFactory.HELVETICA);
	        font.setColor(Color.WHITE);
	         
	       
	        cell.setPhrase(new Phrase("Enfant", font));
	        table.addCell(cell);
	         
	        cell.setPhrase(new Phrase("Event", font));
	        table.addCell(cell);
	        
	        cell.setPhrase(new Phrase("Parent", font));
	        table.addCell(cell); 
	        
	        cell.setPhrase(new Phrase("Date de Reservation", font));
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
	        PdfWriter.getInstance(document, response.getOutputStream());
	         
	        document.open();
	        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
	        font.setSize(18);
	        font.setColor(Color.BLUE);
	         
	        Paragraph p = new Paragraph("List of Reservations", font);
	        p.setAlignment(Paragraph.ALIGN_CENTER);
	         
	        document.add(p);
	         
	        PdfPTable table = new PdfPTable(4);
	        table.setWidthPercentage(100f);
	        table.setWidths(new float[] {3.0f, 3.0f, 3.0f,3.0f});
	        table.setSpacingBefore(10);
	         
	        writeTableHeader(table);
	        writeTableData(table);
	         
	        document.add(table);
	         
	       /* BarcodeQRCode barcodeQRCode = new BarcodeQRCode("https://memorynotfound.com", 1000, 1000, null);
	        com.itextpdf.text.Image codeQrImage = barcodeQRCode.getImage();
	        codeQrImage.scaleAbsolute(100, 100);
	       // document.add(codeQrImage);*/
	        document.close();
	         
	    }
}