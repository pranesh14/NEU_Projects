package com.fifa.controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fifa.entity.PlayersTable;
import com.fifa.entity.TeamsTable;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfWriter;

public class CreatePDF {

	private static Font TIME_ROMAN = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
	private static Font TIME_ROMAN_SMALL = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);

	public static Document createPDF(String file, PlayersTable player, TeamsTable team, Long bidAmount) {

		Document document = null;

		try {
			document = new Document();
			PdfWriter.getInstance(document, new FileOutputStream(file));
			document.open();
			addMetaData(document);
			addContent(document, player, team, bidAmount);
			document.close();
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return document;

	}

	private static void addMetaData(Document document) {
		document.addTitle("Player Contract");
		document.addSubject("Contract Details");
		document.addAuthor("FIFA");
		document.addCreator("FIFA");
	}

	private static void addContent(Document document, PlayersTable player, TeamsTable team, Long bidAmount) throws DocumentException {

		try {
			Image team_logo = Image.getInstance("/"+"E:/Softwares/sts-bundle/Football_Players_Transfer_Software/Teams/"+team.getLogo());
			team_logo.setAlignment(Image.ALIGN_CENTER);
			team_logo.scaleToFit(100f, 100f);
			document.add(team_logo);
		} catch (MalformedURLException e) {
			System.out.println("Exception: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("Exception: " + e.getMessage());
		}

		Paragraph clubName = new Paragraph();
		createEmptyLine(clubName, 1);
		clubName.add(new Paragraph(team.getName(), TIME_ROMAN));
		clubName.setAlignment(Element.ALIGN_CENTER);
		createEmptyLine(clubName, 1);
		document.add(clubName);

		Paragraph date = new Paragraph();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
		date.add(new Paragraph(simpleDateFormat.format(new Date()), TIME_ROMAN_SMALL));
		date.setAlignment(Element.ALIGN_RIGHT);
		createEmptyLine(date, 1);
		document.add(date);

		Paragraph title = new Paragraph();
		String text = "CONTRACT AGREEMENT";
		Chunk chunk = new Chunk(text, TIME_ROMAN);
		chunk.setUnderline(0.2f, -2f);
		Phrase phrase = new Phrase(chunk);
		title.add(phrase);
		title.setAlignment(Element.ALIGN_CENTER);
		document.add(title);

		Paragraph summary = new Paragraph();
		createEmptyLine(summary, 1);
		summary.add(new Paragraph(
				"This is to certify that " + team.getName() + ", " + team.getCountry() + " signed " 
			    + player.getName() + " for a sum of $" + bidAmount.toString() + ".",
				TIME_ROMAN_SMALL));
		document.add(summary);
		
		Paragraph point1 = new Paragraph();
		createEmptyLine(point1, 1);
		point1.add(new Paragraph("1. " +
				player.getName() +" gets a salary of $1,000,000 annual and $80,000 every week.",
				TIME_ROMAN_SMALL));
		document.add(point1);

		Paragraph point2 = new Paragraph();
		createEmptyLine(point2, 1);
		point2.add(new Paragraph("2. The travelling expenditure of " +
				player.getName() +", match bonus and allowance will be taken care of by " + team.getName() + ".",
				TIME_ROMAN_SMALL));
		document.add(point2);
		
		Paragraph point3 = new Paragraph();
		createEmptyLine(point3, 1);
		point3.add(new Paragraph("3. The employment contract is for four years.",
				TIME_ROMAN_SMALL));
		document.add(point3);
		
		Paragraph point4 = new Paragraph();
		createEmptyLine(point4, 1);
		point4.add(new Paragraph("4. Upon contract expiry, " + team.getName() 
				+ " is entitled to extend the contract by a year.",
				TIME_ROMAN_SMALL));
		document.add(point4);
		
		Paragraph obligations = new Paragraph();
		createEmptyLine(obligations, 1);
		obligations.add(new Paragraph(
				"PLAYER OBLIGATIONS", TIME_ROMAN_SMALL));
		document.add(obligations);
		
		Paragraph point5 = new Paragraph();
		createEmptyLine(point5, 1);
		point5.add(new Paragraph("5.1. Attend all training sessions and team meetings of the Club.",
				TIME_ROMAN_SMALL));
		document.add(point5);
		
		Paragraph point6 = new Paragraph();
		createEmptyLine(point6, 1);
		point6.add(new Paragraph("5.2. Obey all reasonable directions of the Senior Coach, President, and Secretary of the Club.",
				TIME_ROMAN_SMALL));
		document.add(point6);
		
		Paragraph point7 = new Paragraph();
		createEmptyLine(point7, 1);
		point7.add(new Paragraph("5.3. During league matches, wear only such items of playing apparel as may be approved of or prescribed by the "+
				"League and to the extent that the same are not inconsistent therewith, the Club. ",
				TIME_ROMAN_SMALL));
		document.add(point7);
		
		Paragraph point8 = new Paragraph();
		createEmptyLine(point8, 1);
		point8.add(new Paragraph("5.4. Comply with all reasonable requirements of the Club relating to preparation for matches, attendance at social "
				+"functions, behaviour and dress.",
				TIME_ROMAN_SMALL));
		document.add(point8);
		
	}

	private static void createEmptyLine(Paragraph paragraph, int number) {
		for (int i = 0; i < number; i++) {
			paragraph.add(new Paragraph(" "));
		}
	}

}