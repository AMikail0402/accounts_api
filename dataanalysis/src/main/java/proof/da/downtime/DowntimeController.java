package proof.da.downtime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import proof.da.downtime.dto.InputDto;
import proof.da.downtime.dto.OutputDto;

@RestController
@RequestMapping(path = "da/median")
public class DowntimeController {
    
   DowntimeService downtimeService;
    
    @Autowired
    public DowntimeController(DowntimeService downtimeService){
        this.downtimeService = downtimeService;
    }

    @GetMapping
    public OutputDto getMedianDowntime(@RequestBody InputDto InputDto){
        return downtimeService.getMedian(InputDto.runname(),InputDto.medianMilli());
    }

}
