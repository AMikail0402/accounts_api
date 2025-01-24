package proof.da.downtime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import proof.da.downtime.CurlService;
import proof.da.downtime.dto.TimeDto;
import proof.da.downtime.dto.CoordsDto;
import proof.da.downtime.dto.InputDto;
import proof.da.downtime.dto.OutputDto;

@RestController
@RequestMapping(path = "da")
public class DowntimeController {
    
   DowntimeService downtimeService;
   CurlService curlService;
    @Autowired
    public DowntimeController(DowntimeService downtimeService,
    CurlService curlService){
        this.downtimeService = downtimeService;
        this.curlService = curlService;
    }

    @GetMapping("graph")
    public CoordsDto getCoords(@RequestBody List<TimeDto> list){
        return curlService.getCoords(list);
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
