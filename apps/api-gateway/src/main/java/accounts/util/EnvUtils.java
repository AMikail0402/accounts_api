package accounts.util;

import java.io.BufferedReader;
import java.io.FileReader;

public class EnvUtils {


    public static String getEnv(String env){
        return System.getenv(env) == null ? System.getProperty(env) : System.getenv(env);
    }

    public static void readEnvs(){

        try {
            BufferedReader myReader = new BufferedReader(new FileReader(".env"));

            while(true){
                String line = myReader.readLine();
                if(line == null) break; 
                String[] env = line.split("=");
                System.setProperty(env[0],env[1]);
            }

            myReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
     
    }

}
