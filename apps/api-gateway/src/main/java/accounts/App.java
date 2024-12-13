package accounts;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import accounts.util.EnvUtils;


@SpringBootApplication
public class App 
{
    static {
        EnvUtils.readEnvs();
    }

    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
    }

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.FAIL_ON_SELF_REFERENCES, false);  // Deaktiviert Fehler bei Selbstreferenzen
        return mapper;
    }


}
