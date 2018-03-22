package d;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Start {
	
	private static String basePath = "http://www.mca.gov.in/Ministry/pdf/";
	private static Set<String> extensions = new HashSet<String>();
	private static int minLength = 1;
	private static int maxLength = 3;

	private static void addText() {
		extensions.add(".txt");
		extensions.add(".rtf");
	}
	
	private static void addCommaSeparated() {
		extensions.add(".csv");
	}
	
	private static void addXML() {
		extensions.add(".xml");
	}
	
	private static void addDB() {
		extensions.add(".db");
		extensions.add(".dbf");
		extensions.add(".sql");
	}
	
	private static void addBackup() {
		extensions.add(".bak");
	}
	
	private static void addDump() {
		extensions.add(".dmp");
	}
	
	private static void addConfiguration() {
		extensions.add(".cfg");
	}
	
	private static void addMicrosoftWordLegacy() {
		extensions.add(".doc");
		extensions.add(".dot");
		extensions.add(".wbk");
	}
	
	private static void addMicrosoftWord() {
		extensions.add(".docx");
		extensions.add(".docm");
		extensions.add(".dotx");
		extensions.add(".dotm");
		extensions.add(".docb");
	}
	
	private static void addMicrosoftExcelLegacy() {
		extensions.add(".xls");
		extensions.add(".xlt");
		extensions.add(".xlm");
	}
	
	private static void addMicrosoftExcel() {
		extensions.add(".xlsx");
		extensions.add(".xlsm");
		extensions.add(".xltx");
		extensions.add(".xltm");
	}
	
	private static void addMicrosoftExcelOthers() {
		extensions.add(".xlsb");
		extensions.add(".xla");
		extensions.add(".xlam");
		extensions.add(".xll");
		extensions.add(".xlw");
	}
	
	private static void addMicrosoftPowerPointLegacy() {
		extensions.add(".ppt");
		extensions.add(".pot");
		extensions.add(".pps");
	}
	
	private static void addMicrosoftPowerPointOOXML() {
		extensions.add(".pptx");
		extensions.add(".pptm");
		extensions.add(".potx");
		extensions.add(".potm");
		extensions.add(".ppam");
		extensions.add(".ppsx");
		extensions.add(".ppsm");
		extensions.add(".sldx");
		extensions.add(".sldm");
	}
	
	private static void addMicrosoftWorks() {
		extensions.add(".xlr");
		extensions.add(".wks");
		extensions.add(".wps");
	}
	
	private static void addMicrosoftAccessLegacy() {
		extensions.add(".ade");
		extensions.add(".adp");
		extensions.add(".mdt");
		extensions.add(".ldb");
	}
	
	private static void addMicrosoftAccessDatabaseLegacy() {
		extensions.add(".mdb");
		extensions.add(".cdb");
		extensions.add(".mda");
		extensions.add(".mdn");
		extensions.add(".mdf");
		extensions.add(".mde");
	}
	
	private static void addMicrosoftAccess() {
		extensions.add(".adn");
		extensions.add(".accda");
		extensions.add(".mdw");
		extensions.add(".mam");
		extensions.add(".maq");
		extensions.add(".mar");
		extensions.add(".mat");
		extensions.add(".maf");
		extensions.add(".laccdb");
	}
	
	private static void addMicrosoftAccessDatabase() {
		extensions.add(".accdb");
		extensions.add(".accde");
		extensions.add(".accdt");
		extensions.add(".accdr");
	}
	
	private static void addMicrosoftPublisher() {
		extensions.add(".pub");
	}
	
	private static void addOpenOfficeCalcSpreadsheet() {
		extensions.add(".ods");
	}
	
	private static void addOpenOfficeWriterDocument() {
		extensions.add(".odt");
	}
	
	private static void addPDF() {
		extensions.add(".pdf");
	}
	
	private static void addLatexDocument() {
		extensions.add(".tex");
	}
	
	private static void addWordPerfect() {
		extensions.add(".wpd");
	}
	
	private static void addXPS() {
		extensions.add(".xps");
	}
	
	private static void addExtensions() {
		addText();
		addCommaSeparated();
		addXML();
		addDB();
		addBackup();
		addDump();
		addConfiguration();
		addMicrosoftWordLegacy();
		addMicrosoftWord();
		addMicrosoftExcelLegacy();
		addMicrosoftExcel();
		addMicrosoftExcelOthers();
		addMicrosoftPowerPointLegacy();
		addMicrosoftPowerPointOOXML();
		addMicrosoftWorks();
		addMicrosoftAccessLegacy();
		addMicrosoftAccessDatabaseLegacy();
		addMicrosoftAccess();
		addMicrosoftAccessDatabase();
		addMicrosoftPublisher();
		addOpenOfficeCalcSpreadsheet();
		addOpenOfficeWriterDocument();
		addPDF();
		addLatexDocument();
		addWordPerfect();
		addXPS();
	}

	public static void main(String[] args) {
		addExtensions();
		HitApi hitApi = new HitApi(basePath, extensions, minLength, maxLength);
		String word = null;
		long counter = 0;
		long start = new Date().getTime();
		while(null != (word = hitApi.getNextWord())) {
			counter++;
			System.out.println(word);
		}
		long end = new Date().getTime();
		System.out.println();
		System.out.println("Total Words Generated of Length Boundary [" + minLength + "," + maxLength + "] -> " + counter);
		System.out.println("Total Time Taken (milliseconds) -> " + (end - start));
	}
	
	
	
}
