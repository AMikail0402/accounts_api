package proof.da.downtime;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.univocity.parsers.tsv.TsvParser;
import com.univocity.parsers.tsv.TsvParserSettings;

import proof.da.downtime.dto.OutputDto;
import proof.da.http.FetchFiles;
@Service
public class DowntimeService {

    static String nameRegex =  "((?:std|svc|ing).*\\_(\\d*))\\.json";
    static String fortUrl;
    static {
        if(System.getenv("FORT_URL") == null){
          fortUrl = "http://localhost";
        }
        else {
            fortUrl = System.getenv("FORT_URL");
        }
    }

    public OutputDto getAverage(String runName ,Double medianMilli){
        ArrayList<String> downloadLinks = new ArrayList<String>();
        
        try {
            setDownloadLinks(downloadLinks,runName);
            return calculateResult(downloadLinks, medianMilli,"average");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return null;
        
    }
    

    public OutputDto getMedian(String runName ,Double medianMilli){
        ArrayList<String> downloadLinks = new ArrayList<String>();
        
        try {
            setDownloadLinks(downloadLinks,runName);
            return calculateResult(downloadLinks, medianMilli,"median");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return null;
        
    }

    public OutputDto calculateResult(ArrayList<String> downloadLinks, Double medianMilli,String operation) throws JSONException, IOException{
        Pattern pattern = Pattern.compile(nameRegex);
        ArrayList<Double> downTimes = new ArrayList<Double>();
        ArrayList<Integer> testRuns = new ArrayList<Integer>();
        HashMap<Integer, Double> testRunDownTimes = new HashMap<Integer, Double>();

        for(String x : downloadLinks){
            JSONObject result = new JSONObject(FetchFiles.fechJson(x));
            Double maxMilli = result.getJSONObject("DurationHistogram").getDouble("Max")*1000;
            Double downTime = maxMilli-medianMilli;
            Matcher matcher = pattern.matcher(x);
            matcher.find();
            String testrun = matcher.group(2);
            testRunDownTimes.put(Integer.parseInt(testrun), downTime);
            testRuns.add(Integer.parseInt(testrun));
            downTimes.add(downTime);
        } 

        Collections.sort(downTimes);
        Collections.sort(testRuns);
        int size = downTimes.size();

        if(operation.equals("median")){
            if(downTimes.size() % 2 == 0 ){
                Double dt =  (downTimes.get(size/2) + downTimes.get((size/2) - 1))/2;
                return new OutputDto("Median der Ausfallzeiten beträgt: "+dt,returnCoordinates(testRunDownTimes, testRuns));
            }

            Double dt = downTimes.get(size/2);
            return new OutputDto("Median der Ausfallzeiten beträgt: "+dt,returnCoordinates(testRunDownTimes,testRuns));
        }
        else if (operation.equals("average")){

            return new OutputDto("Durchschnitt der Ausfallzeiten beträgt: "+calculateAverage(downTimes)
            ,returnCoordinates(testRunDownTimes,testRuns));
        }
        return null; 
    }

    private Double calculateAverage(ArrayList<Double> downTimes ){
            Double sum = 0.0;
            for(Double dt : downTimes){
                sum+=dt;
            }
            return sum/downTimes.size();
    }

    private String returnCoordinates(HashMap<Integer, Double> testRunDownTimes, ArrayList<Integer> testRuns){
            StringBuilder coords = new StringBuilder();
            for(int i : testRuns){
                  coords.append("("+i+","+testRunDownTimes.get(i)+")"+"\s");
            } 
            return coords.toString();
    }

    private void setDownloadLinks(ArrayList<String> downloadLinks, String runName) throws IOException{
        
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
            
            if(link.contains(runName)){
                downloadLinks.add(link.replace("http://localhost", fortUrl));
            }   
        }

        parser.stopParsing();
        
      } 
   }
}
