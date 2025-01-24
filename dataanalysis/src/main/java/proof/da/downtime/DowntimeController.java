package proof.da.downtime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import proof.da.downtime.dto.InputDto;
import proof.da.downtime.dto.OutputDto;

@RestController
@RequestMapping(path = "da")
public class DowntimeController {
    
   DowntimeService downtimeService;
    
    @Autowired
    public DowntimeController(DowntimeService downtimeService){
        this.downtimeService = downtimeService;
    }

    @GetMapping(path = "median")
    public OutputDto getMedianDowntime(@RequestBody InputDto InputDto){
        return downtimeService.getMedian(InputDto.runname(),InputDto.medianMilli());
    }

    @GetMapping(path = "average")
    public OutputDto getAverageDowntime(@RequestBody InputDto InputDto){
        return downtimeService.getAverage(InputDto.runname(),InputDto.medianMilli());
    }

}
