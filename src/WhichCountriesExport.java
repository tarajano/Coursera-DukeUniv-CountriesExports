
import edu.duke.*;
import org.apache.commons.csv.*;

public class WhichCountriesExport {	
	public static void countriesExportingOverX(CSVParser parser, String amount_string){
		for(CSVRecord record : parser){
			if(record.get("Value (dollars)").length() > amount_string.length()){
				System.out.println(record.get("Country")+": "+record.get("Value (dollars)"));
			}
		}
	}
	public static int numberOfExportersOfX(CSVParser parser, String export){
		int exporters_count = 0;
		for(CSVRecord record : parser){
			if(record.get("Exports").contains(export)){
				exporters_count++;
			}
		}
		return exporters_count;
	}	
	public static void printCountriesExportingX(CSVParser parser, String export){
		for(CSVRecord record : parser){
			if(record.get("Exports").contains(export)){
				System.out.println(record.get("Country"));
			}
		}
	}
	public static void printCountriesExportingXnY(CSVParser parser, String export1, String export2){
		for(CSVRecord record : parser){
			if(record.get("Exports").contains(export1) && record.get("Exports").contains(export2)){
				System.out.println(record.get("Country"));
			}
		}
	}
	public static String countryInfo(CSVParser parser, String country){
		//get all info from country
		for(CSVRecord record : parser){
			if(record.get("Country").contains(country)){
				return record.get("Country")+": "+record.get("Exports")+": "+record.get("Value (dollars)");
			}
		}
		return "";
	}
	public static void main(String[] args) {
		FileResource input_file = new FileResource("./exports/exports_small.csv");
		CSVParser file_parser = input_file.getCSVParser();
		//printCountriesExportingXnY(file_parser,"gold","diamonds");
		//System.out.println("countryInfo = "+countryInfo(file_parser,"Germany"));
		//System.out.println("exporters = "+numberOfExportersOfX(file_parser,"gold"));
		countriesExportingOverX(file_parser,"$999,999,999");
	}

}
