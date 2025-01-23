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

    static String nameRegex =  "((std|svc|ing).*\\_\\d)\\.json";
    static String fortUrl;
    static {
        if(System.getenv("FORT_URL") == null){
          fortUrl = "http://localhost";
        }
        else {
            fortUrl = System.getenv("FORT_URL");
        }
    }
    

    public OutputDto getMedian(String runName ,Double medianMilli){
        ArrayList<String> downloadLinks = new ArrayList<String>();
        
        try {
            setDownloadLinks(downloadLinks,runName);
            String dt =  String.valueOf(getMedianDowntime(downloadLinks, medianMilli));
            return new OutputDto("Median der Ausfallzeiten beträgt: "+dt);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return null;
        
    }

    public static Double getMedianDowntime(ArrayList<String> downloadLinks, Double medianMilli) throws JSONException, IOException{
        Pattern pattern = Pattern.compile(nameRegex);
        ArrayList<Double> downTimes = new ArrayList<Double>();
        HashMap<String, Double> testRunDownTimes = new HashMap<String, Double>();

        for(String x : downloadLinks){
            JSONObject result = new JSONObject(FetchFiles.fechJson(x));
            Double maxMilli = result.getJSONObject("DurationHistogram").getDouble("Max")*1000;
            Double downTime = maxMilli-medianMilli;
            Matcher matcher = pattern.matcher(x);
            matcher.find();
            testRunDownTimes.put(matcher.group(1), downTime);
            downTimes.add(downTime);
           } 

        Collections.sort(downTimes);
        int size = downTimes.size();

        if(downTimes.size() % 2 == 0 ){
            return (downTimes.get(size/2) + downTimes.get((size/2) - 1))/2;
        }

        return downTimes.get(size/2);
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
