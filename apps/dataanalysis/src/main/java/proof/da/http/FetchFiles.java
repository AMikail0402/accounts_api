package proof.da.http;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class FetchFiles {
    static OkHttpClient client = new OkHttpClient();
    static String fortUrl;
    // Später env
    static {
        if(System.getenv("FORT_URL") == null){
          fortUrl = "http://localhost";
        }
        else {
            fortUrl = System.getenv("FORT_URL");
        }
    }
    
    
    public static String fechTsv() throws IOException{
        Request request = new Request.Builder()
        .url(fortUrl+"/fortio/data/index.tsv")
        .get()
        .addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7")
        .addHeader("Accept-Language", "de,de-DE;q=0.9,en;q=0.8,en-GB;q=0.7,en-US;q=0.6")
        .build();

        Response response = client.newCall(request).execute();
        String responseBody  = response.body().string();
        response.close();
        return responseBody;
    }
    public static String fechJson(String link) throws IOException{
        Request request = new Request.Builder()
        .url(link)
        .get()
        .addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7")
        .addHeader("Accept-Language", "de,de-DE;q=0.9,en;q=0.8,en-GB;q=0.7,en-US;q=0.6")
        .build();

        Response response = client.newCall(request).execute();
        String responseBody  = response.body().string();
        response.close();
        return responseBody;
    }


}
