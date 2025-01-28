package proof.seccomp.ProfileGenerator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "sc")
public class GeneratorController {
     GeneratorService generatorService;
     @Autowired
     public GeneratorController(GeneratorService generatorService){
        this.generatorService = generatorService;
     }
    @GetMapping("profile")
    public ProfileDto getProfile(@RequestBody List<TimeDto> list){
        return curlService.getCoords(list);
    }

}
