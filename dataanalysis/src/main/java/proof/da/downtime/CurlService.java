package proof.da.downtime;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import proof.da.downtime.dto.CoordsDto;
import proof.da.downtime.dto.TimeDto;

@Service
public class CurlService {

    String dateRegex =  "\\:\\d*$";
    Pattern pattern = Pattern.compile(dateRegex);


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
            System.out.println("INDEX"+i);
            System.out.println("ELEMTIME: "+elemTime);
            String chSeconds = Long.toString(elemTime.toInstant(ZoneOffset.UTC).toEpochMilli()-initMillis);
            Double dSeconds = Double.parseDouble(chSeconds)/1000;
            System.out.println("FINAL CHANGE MILLIS: "+dSeconds);
            //

            graph.append("("+dSeconds+","+Math.round(time * 1000.0) / 1000.0+")");
            i++;
         }
         return new CoordsDto(graph.toString());
    }
}
