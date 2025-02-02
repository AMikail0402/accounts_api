package accounts.app.jwt;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.json.JSONArray;
import org.json.JSONObject;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;

import accounts.app.jwt.exception.UnauthorizedException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ValidateToken {
    static OkHttpClient client = getClient();
    static String kcUrl;
    static String kcClientId;
    static String kcClientSecret;
    static String kcRealm;
    static {
        
       kcUrl = System.getenv("KC_URL");
       kcRealm = System.getenv("KC_REALM");
         /* 
         // local Use only
         kcUrl = "https://iam/auth";
          kcClientId = "banking-client";
          kcClientSecret = "BFIHZHwOgiiyHOir0fKyGDfP2rUCkX88";
          kcRealm = "master";
          */ 

  }
    static RSAPublicKey pubkey = fetchPublicKey();
    // Später env



    public static void validate(String bearer){


     try {
        Algorithm algorithm = Algorithm.RSA256(pubkey, null);
        JWTVerifier verifier = JWT.require(algorithm)
                //more validations if needed
                .build();
        verifier.verify(bearer.split("\s")[1]);
     
        } catch (Exception e){
          e.printStackTrace();
           throw new UnauthorizedException();
        }

    }

 private static RSAPublicKey fetchPublicKey(){

  Request request = new Request.Builder()
  .url(kcUrl+"/realms/"+kcRealm+"/protocol/openid-connect/certs")
  .get()
  .addHeader("Content-Type", "application/x-www-form-urlencoded")
  .addHeader("User-Agent", "insomnia/2023.5.8")
  .build();

  try {
    Response response = client.newCall(request).execute();
    JSONObject rObject = new JSONObject(response.body().string());
    JSONArray keysArray = rObject.getJSONArray("keys");

    String publicKey = null;
    for (int i = 0; i < keysArray.length(); i++) {
        JSONObject key = keysArray.getJSONObject(i);
        if ("RS256".equals(key.getString("alg"))) {
            // x5c ist ein Array, das das Zertifikat enthält
            publicKey = key.getJSONArray("x5c").getString(0);
            break; // Wir brauchen nur den ersten passenden Schlüssel
        }
    }
      System.out.println(publicKey);

      byte[] encoded = Base64.getDecoder().decode(publicKey);
      CertificateFactory factory = CertificateFactory.getInstance("X.509");
      X509Certificate certificate = (X509Certificate) factory.generateCertificate(new ByteArrayInputStream(encoded));

               
      PublicKey publicKeyFromCert = certificate.getPublicKey();

      return (RSAPublicKey) publicKeyFromCert;

    } catch (Exception e) {
        //throw new UnauthorizedException();
        e.printStackTrace();
    }

    return null;


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