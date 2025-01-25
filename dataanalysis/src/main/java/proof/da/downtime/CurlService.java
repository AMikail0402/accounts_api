package proof.da.downtime;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import proof.da.downtime.dto.CoordsDto;
import proof.da.downtime.dto.MedianDto;
import proof.da.downtime.dto.OutputDto;
import proof.da.downtime.dto.TimeDto;

@Service
public class CurlService {

    String dateRegex =  "\\:\\d*$";
    Pattern pattern = Pattern.compile(dateRegex);


    public MedianDto getMedian(List<TimeDto> list){
        System.out.println("IN METHODE");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssSSS");

        ArrayList<Double> differences = new ArrayList<>();
        ArrayList<Double> medList = new ArrayList<Double>();
        int i = 1;
        Long beforeMilli = 0L;
        for(TimeDto tDto : list ){
            if(i ==1){
                    i++;
                    continue;
            }
            Double time = Double.parseDouble(tDto.time_total().replace("s", ""))*1000;
            medList.add(time);

            // calculating difference
            LocalDateTime elemTime = LocalDateTime.parse(tDto.sent_time(), formatter);
            String chSeconds = Long.toString(elemTime.toInstant(ZoneOffset.UTC).toEpochMilli()-beforeMilli);
            Double dSeconds = Double.parseDouble(chSeconds)/1000;

            differences.add(dSeconds);
            
            beforeMilli = elemTime.toInstant(ZoneOffset.UTC).toEpochMilli();
            //

         }
         
         return new MedianDto(
            "Die tendenzielle Latenz liegt bei: "+calcMedian(medList)+"ms",
            "Der tendenzielle Unterschied in der Absendezeit liegt bei: "+calcMedian(differences)*1000+"ms"
        );

    }


    private Double calcMedian(List<Double> list){
        
        Collections.sort(list);

        int size = list.size();

        // Calculate Median 
        if(size % 2 == 0 ){
           return (list.get(size /2) + list.get((size /2) - 1))/2;
        }
        
        return list.get(size /2);

    }


    public CoordsDto getCoords(List<TimeDto> list){
        StringBuilder graph = new StringBuilder();
        // formatter
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssSSS");
        LocalDateTime initTime = LocalDateTime.parse(list.get(0).sent_time(), formatter);
        Long initMillis = initTime.toInstant(ZoneOffset.UTC).toEpochMilli();
        int i = 1;
         for(TimeDto tDto : list ){
            if(i ==1){
                    i++;
                    continue;
            }
            Double time = Double.parseDouble(tDto.time_total().replace("s", ""))*1000;
            // calculating difference
            LocalDateTime elemTime = LocalDateTime.parse(tDto.sent_time(), formatter);
            String chSeconds = Long.toString(elemTime.toInstant(ZoneOffset.UTC).toEpochMilli()-initMillis);
            Double dSeconds = Double.parseDouble(chSeconds)/1000;
            //

            graph.append("("+dSeconds+","+Math.round(time * 1000.0) / 1000.0+")");
            i++;
         }
         return new CoordsDto(graph.toString());
    }
}
