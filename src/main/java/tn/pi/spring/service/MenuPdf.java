package tn.pi.spring.service;

	import java.util.List;
	import tn.pi.entity.Menu;
	import javax.servlet.http.HttpServletResponse;
	import java.awt.Color;
	import java.io.IOException;
	 
	 
	import com.lowagie.text.*;
	import com.lowagie.text.pdf.*;

	public class MenuPdf {
		 private List<Menu> listmenu;
	     
		    public MenuPdf(List<Menu> listmenu) {
		        this.listmenu = listmenu;
		    }
		 
		    private void writeTableHeader(PdfPTable table) {
		        PdfPCell cell = new PdfPCell();
		        cell.setBackgroundColor(Color.BLUE);
		        cell.setPadding(6);

		        Font font = FontFactory.getFont(FontFactory.HELVETICA);
		        font.setColor(Color.WHITE);
		         
		        cell.setPhrase(new Phrase("Menu Id", font));
		         
		        table.addCell(cell);
		         
		        cell.setPhrase(new Phrase("Menu contenu", font));
		        table.addCell(cell);
		         
		         
		        cell.setPhrase(new Phrase("idcantine", font));
		        table.addCell(cell);
		        
		    }
		     
		    private void writeTableData(PdfPTable table) {
		        for (Menu menu : listmenu) {
		            table.addCell(String.valueOf(menu.getIdmenu()));
		            table.addCell((String.valueOf(menu.getContenumenu())));
		            table.addCell((String.valueOf(menu.getCantine().getIdcantine())));

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
		         
		        PdfPTable table = new PdfPTable(3);
		        table.setWidthPercentage(100f);
		        table.setWidths(new float[] {3.5f, 3.5f, 3.5f});
		        table.setSpacingBefore(5);
		         
		        writeTableHeader(table);
		        writeTableData(table);
		         
		        document.add(table);
		         
		        document.close();
		         
		    }
		}
