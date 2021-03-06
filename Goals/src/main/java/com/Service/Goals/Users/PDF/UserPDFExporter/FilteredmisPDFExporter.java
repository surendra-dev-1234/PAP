package com.Service.Goals.Users.PDF.UserPDFExporter;

import java.awt.Color;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.Service.Goals.Users.Entity.Goals;
import com.Service.Goals.Users.Entity.Quarter;
import com.Service.Goals.Users.Entity.UserScore;
import com.Service.Goals.Users.Entity.Users;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class FilteredmisPDFExporter {

	private List<UserScore> userscorelist;

	private List<Users> userslist;

	private List<Quarter> quarterlist;

	private List<Goals> goalslist;

	public FilteredmisPDFExporter(Object object) {
		super();
		this.userscorelist = (List<UserScore>) object;
		//		this.userslist=userslist2;
		//		this.quarterlist=quarterlist2;
		//		this.goalslist=goalslist2;
	}

	private void writeTableHeader(PdfPTable table) {

		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(Color.BLUE);
		cell.setPadding(5);

		com.lowagie.text.Font font = FontFactory.getFont(FontFactory.HELVETICA);
		font.setColor(Color.WHITE);

		cell.setPhrase(new Phrase("UserName", font));
		table.addCell(cell); 

		cell.setPhrase(new Phrase("Quarter", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("GoalName", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Year", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("SelfScore", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("ManagerScore", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("PEDScore", font));
		table.addCell(cell);

	}

	private void writeTableData(PdfPTable table) {
		for (UserScore userscore : userscorelist) {
			table.addCell(userscore.getUsername());
			table.addCell(userscore.getQuarter_name());
			table.addCell(userscore.getGoal_name());
			table.addCell(userscore.getYear());
			if(userscore.getSelf_score()==null) { 
				userscore.setSelf_score(0.0);
			}
			if(userscore.getRm_score()==null) {
				userscore.setRm_score(0.0);
			}
			if(userscore.getPed_score()==null) {
				userscore.setPed_score(0.0);
			}
			table.addCell(String.valueOf(userscore.getSelf_score()));
			table.addCell(String.valueOf(userscore.getRm_score()));
			table.addCell(String.valueOf(userscore.getPed_score()));
		}
	}

	public void export(HttpServletResponse response) throws DocumentException, IOException {
		Document document = new Document(PageSize.A4);
		PdfWriter.getInstance(document, response.getOutputStream());

		document.open();
		com.lowagie.text.Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		font.setSize(18);
		font.setColor(Color.BLUE);

		Image img = Image.getInstance("src/main/resources/indxx.png");

		document.add(img);

		Paragraph p = new Paragraph("Filtered Mis Report", font);
		p.setAlignment(Paragraph.ALIGN_CENTER);

		document.add(p);

		PdfPTable table = new PdfPTable(7);
		table.setWidthPercentage(100f);
		table.setSpacingBefore(10);

		writeTableHeader(table);
		writeTableData(table);

		document.add(table);

		document.close();

	}
}
