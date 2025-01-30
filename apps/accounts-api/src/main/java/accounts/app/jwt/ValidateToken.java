package accounts.app.jwt;

import java.io.IOException;
import java.security.cert.CertificateException;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.json.JSONObject;

import accounts.app.jwt.exception.UnauthorizedException;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class ValidateToken {
    static OkHttpClient client = getClient();
    static String kcUrl;
    static String kcClientId;
    static String kcClientSecret;
    static String kcRealm;
    // Später env
    static {
        
         kcUrl = System.getenv("KC_URL");
         kcClientId = System.getenv("KC_CLIENT_ID");
         kcClientSecret = System.getenv("KC_CLIENT_SECRET");
         kcRealm = System.getenv("KC_REALM");
            /*kcUrl = "https://iam/auth";
            kcClientId = "banking-client";
            kcClientSecret = "BFIHZHwOgiiyHOir0fKyGDfP2rUCkX88";
            kcRealm = "master";*/

    }

    public static void validate(String bearer){

        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        RequestBody body = RequestBody.create(mediaType, "client_id="+kcClientId+"&client_secret="+kcClientSecret+"&grant_type=client_credentials&token="
        +bearer.split("\s")[1]);
        Request request = new Request.Builder()
        .url(kcUrl+"/realms/"+kcRealm+"/protocol/openid-connect/token/introspect")
        .post(body)
        .addHeader("Content-Type", "application/x-www-form-urlencoded")
        .addHeader("User-Agent", "insomnia/2023.5.8")
        .build();

        try {
            Response response = client.newCall(request).execute();
            JSONObject rObject = new JSONObject(response.body().string());
            if(!rObject.getBoolean("active")){
                throw new UnauthorizedException();
            }
        } catch (IOException e) {
            //throw new UnauthorizedException();
            e.printStackTrace();
        }

    }

private static OkHttpClient getClient() {
  try {
    // Create a trust manager that does not validate certificate chains
    final TrustManager[] trustAllCerts = new TrustManager[] {
        new X509TrustManager() {
          @Override
          public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
          }

          @Override
          public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
          }

          @Override
          public java.security.cert.X509Certificate[] getAcceptedIssuers() {
            return new java.security.cert.X509Certificate[]{};
          }
        }
    };

    // Install the all-trusting trust manager
    final SSLContext sslContext = SSLContext.getInstance("SSL");
    sslContext.init(null, trustAllCerts, new java.security.SecureRandom());
    // Create an ssl socket factory with our all-trusting manager
    final SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();

    OkHttpClient.Builder builder = new OkHttpClient.Builder();
    builder.sslSocketFactory(sslSocketFactory, (X509TrustManager)trustAllCerts[0]);
    builder.hostnameVerifier(new HostnameVerifier() {
      @Override
      public boolean verify(String hostname, SSLSession session) {
        return true;
      }
    });

    OkHttpClient okHttpClient = builder.build();
    return okHttpClient;
  } catch (Exception e) {
    throw new RuntimeException(e);
  }
}
    


}