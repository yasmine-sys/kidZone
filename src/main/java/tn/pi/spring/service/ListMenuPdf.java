package tn.pi.spring.service;

import java.awt.Color;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import tn.pi.entity.ListMenu;

public class ListMenuPdf {
	 private List<ListMenu> listmenu;
     
	    public ListMenuPdf(List<ListMenu> listmenu) {
	        this.listmenu = listmenu;
	    }
	 
	    private void writeTableHeader(PdfPTable table) {
	        PdfPCell cell = new PdfPCell();
	        cell.setBackgroundColor(Color.BLUE);
	        cell.setPadding(6);

	        Font font = FontFactory.getFont(FontFactory.HELVETICA);
	        font.setColor(Color.WHITE);
	         
	         
	        cell.setPhrase(new Phrase("Plat principale", font));
	        table.addCell(cell);
	         
	         
	        cell.setPhrase(new Phrase("Entree", font));
	        table.addCell(cell);
	        
	        cell.setPhrase(new Phrase("Desert", font));
	        table.addCell(cell);
	        
	        cell.setPhrase(new Phrase("Jour", font));
	        table.addCell(cell);
	        
	    }
	     
	    private void writeTableData(PdfPTable table) {
	        for (ListMenu ListMenu : listmenu) {
	            table.addCell((String.valueOf(ListMenu.getPlatprincipale())));
	            table.addCell((String.valueOf(ListMenu.getEntree())));
	            table.addCell((String.valueOf(ListMenu.getDesert())));
	            table.addCell((String.valueOf(ListMenu.getJour())));
	            

	        }
	    }
	     
	    public void export(HttpServletResponse response) throws DocumentException, IOException {
	        Document document = new Document(PageSize.A4);
	        PdfWriter.getInstance(document, response.getOutputStream());
	         
	        document.open();
	        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
	        font.setSize(20);
	        font.setColor(Color.BLUE);
	         
	        Paragraph p = new Paragraph("List of Menu", font);
	        p.setAlignment(Paragraph.ALIGN_CENTER);
	         
	        document.add(p);
	         
	        PdfPTable table = new PdfPTable(4);
	        table.setWidthPercentage(100f);
	        table.setWidths(new float[] {3.5f, 3.5f, 3.5f , 2.5f});
	        table.setSpacingBefore(5);
	         
	        writeTableHeader(table);
	        writeTableData(table);
	         
	        document.add(table);
	         
	        document.close();
	         
	    }
	}
