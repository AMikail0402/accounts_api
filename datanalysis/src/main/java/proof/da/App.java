package proof.da;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.univocity.parsers.tsv.TsvParser;
import com.univocity.parsers.tsv.TsvParserSettings;

import proof.da.http.FetchFiles;

/**
 * Hello world!
 */
public class App {

    static String tsvContent = "TsvHttpData-1.0\n"
    + "http://localhost/fortio/data/2025-01-23-105148_11_Fortio.json\t4108\tlObe4hu70nVG2IXoW6DWtQ==\n"
    + "http://localhost/fortio/data/2025-01-23-105020_10_Fortio.json\t4027\tu7e65W0ncrleEMcq0h+Uug==";
    // später über api-befehl 
    static String testRunName ="Fortio";
    static ArrayList<String> downloadLinks = new ArrayList<String>();
    static HashMap<String, Double> maxes = new HashMap<String, Double>();

    public static void main(String[] args) throws IOException {
          setDownloadLinks();
          for(String x : downloadLinks){
            System.out.println("LINK"+FetchFiles.fechJson(x));
            
          }
          
    }

    public static void setMax(){

    }

    public static void setDownloadLinks() throws IOException{
        
    TsvParserSettings settings = new TsvParserSettings();
    TsvParser parser = new TsvParser(settings);
    try (StringReader stringReader = new StringReader(FetchFiles.fechTsv())) {

        parser.beginParsing(stringReader);

        // Erste Zeile überspringen
        parser.parseNext();

        // Restliche Zeilen verarbeiten
        String[] row;
        while ((row = parser.parseNext()) != null) {
            String link = row[0]; 
            
            if(link.contains(testRunName)){
                downloadLinks.add(link);
            }
            
        }

        parser.stopParsing();
        
      } 
   }
}


