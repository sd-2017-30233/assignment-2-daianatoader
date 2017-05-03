package report;

public class GenerateReport {
	public GenerateReport(){}
	
	public Report getReport(String fileType){
		if(fileType.equals(null))
			return null;
		if(fileType.equalsIgnoreCase("PDF"))
			return new GeneratePDF();
		if(fileType.equalsIgnoreCase("CSV"))
			return new GenerateCSV();
		return null;
	}
	
	public static void main(String[] args){
		GenerateReport r = new GenerateReport();
		Report rep = r.getReport("PDF");
		rep.generate("daia");
		
		Report rep2 = r.getReport("CSV");
		rep2.generate("daia");
	}
}
