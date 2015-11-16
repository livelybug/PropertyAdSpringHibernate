package com.spring.views;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import com.spring.domain.PropertyBld;

public class PDFBuilder extends AbstractITextPdfView{

	@Override
	protected void buildPdfDocument(Map<String, Object> model,
			Document document, PdfWriter writer, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		 // get data model which is passed by the Spring container
		List<PropertyBld> prptList = (List<PropertyBld>) model.get("prptLst");
         
        document.add(new Paragraph("Property List"));
         
        PdfPTable table = new PdfPTable(6);
        table.setWidthPercentage(100.0f);
        table.setWidths(new float[] {0.5f, 2.0f, 2.0f, 2.0f, 2.0f, 4.0f});
        table.setSpacingBefore(10);
         
        // define font for table header row
        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(BaseColor.WHITE);
         
        // define table header cell
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(BaseColor.BLUE);
        cell.setPadding(5);
         
        // write table header
        cell.setPhrase(new Phrase("Propterty Name", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Address", font));
        table.addCell(cell);
 
        cell.setPhrase(new Phrase("Property Type", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Mobile", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Comment", font));
        table.addCell(cell);
         
        // write table row data
        for (PropertyBld property : prptList) {
            table.addCell(new Phrase("" + property.getPropertyName()));
            table.addCell(new Phrase(property.getAddress().getAddress() + " " + property.getAddress().getPostcode()));
            table.addCell(new Phrase(property.getRent_sale()));
            table.addCell(new Phrase(property.getpAgt().getMobile()));
            table.addCell(new Phrase(property.getComment()));
        }
         
        document.add(table);
    }
}