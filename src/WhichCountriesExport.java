
import edu.duke.*;
import org.apache.commons.csv.*;

public class WhichCountriesExport {
	public static void printCountriesExporting(CSVParser parser, String export){
		for(CSVRecord record : parser){
			if(record.get("Exports").contains(export)){
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
		String exported_good = "tea";
		FileResource input_file = new FileResource("./exports/exports_small.csv");
		CSVParser file_parser = input_file.getCSVParser();
		//printCountriesExporting(file_parser,exported_good);
		System.out.println("countryInfo = "+countryInfo(file_parser,"Germany"));
	}

}
