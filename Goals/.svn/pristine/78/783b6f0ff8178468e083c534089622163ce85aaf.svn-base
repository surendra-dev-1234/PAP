package com.Service.Goals.Users.PDF.UserPDFExporter;

import java.awt.Color;
import java.util.List;

import com.Service.Goals.Users.Entity.Quarter;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.*;
import com.lowagie.text.pdf.*;

public class QuaterPDFExporter {

	private List<Quarter> listQuaters;

	public QuaterPDFExporter(List<Quarter> listQuaters) {
		super();
		this.listQuaters = listQuaters;
	}

	private void writeTableHeader(PdfPTable table) {

		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(Color.BLUE);
		cell.setPadding(5);

		com.lowagie.text.Font font = FontFactory.getFont(FontFactory.HELVETICA);
		font.setColor(Color.WHITE);

		cell.setPhrase(new Phrase("Quarter ID", font));

		table.addCell(cell);

		cell.setPhrase(new Phrase("Name", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Start Month", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("End Month", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Domain ID", font));
		table.addCell(cell); 

		cell.setPhrase(new Phrase("Weight Freeze Month", font));
		table.addCell(cell); 

		cell.setPhrase(new Phrase("Weight Freeze Day", font));
		table.addCell(cell); 

		cell.setPhrase(new Phrase("Score Freeze Day", font));
		table.addCell(cell); 

		cell.setPhrase(new Phrase("Score Freeze Day", font));
		table.addCell(cell); 
	}

	private void writeTableData(PdfPTable table) {
		for (Quarter quater : listQuaters) {
			table.addCell(String.valueOf(quater.getQuarter_id()));
			table.addCell(quater.getName());
			table.addCell(quater.getStart_month());
			table.addCell(quater.getEnd_month());
			table.addCell(quater.getDomain_id());
			table.addCell(quater.getWeight_Freeze_Month());
			table.addCell(quater.getWeight_Freeze_Day());
			table.addCell(quater.getScore_Freeze_Month());
			table.addCell(quater.getScore_Freeze_Day());
		}
	}

	public void export(HttpServletResponse response) throws DocumentException, IOException {
		Document document = new Document(PageSize.A4);
		PdfWriter.getInstance(document, response.getOutputStream());

		document.open();
		com.lowagie.text.Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		font.setSize(18);
		font.setColor(Color.BLUE);

		Paragraph p = new Paragraph("List of Quaters", font);
		p.setAlignment(Paragraph.ALIGN_CENTER);

		document.add(p);

		PdfPTable table = new PdfPTable(9);
		table.setWidthPercentage(100f);
		table.setSpacingBefore(10);

		writeTableHeader(table);
		writeTableData(table);

		document.add(table);

		document.close();

	}
}
