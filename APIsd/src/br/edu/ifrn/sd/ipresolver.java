package br.edu.ifrn.sd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.JSONObject;

/**
 *
 * @author Marcelo Fernandes
 */
public class ipresolver {

    public static void main(String[] args) throws IOException {

        /* Configuração da API */
        //String method = "getMyIp";
        String method2 = "resolveIp";
        String text = "&address=";
        String ip = "8.8.8.8";
        //String url = "https://mark-sutuer-ip-utils.p.mashape.com/api.php?_method=" + method;
        String url = "https://mark-sutuer-ip-utils.p.mashape.com/api.php?_method=" + method2 + text + ip;
        
        
        /* Tratar o Objeto JSON */
        JSONObject obj;
        
        obj = new JSONObject(getHttpGET(url));
        Object codeget = obj.get("host");
        String codeString = codeget.toString();
        /*
        Object codeget = obj.get("myIp");
        String codeString = codeget.toString();
        */
        
        /*Object text = obj.get("myIp");
        JSONArray traducaoArray = (JSONArray) text;
        String traducao = traducaoArray.getString(0);

        /*Object codeget = obj.get("code");
        String codeString = codeget.toString(); */

        System.out.println(obj);
        System.out.println(codeString);

    }
    /* Configuração HTTP */
    public static final String getHttpGET(String urlToRead) throws MalformedURLException, IOException {
        StringBuilder result = new StringBuilder();

        URL url = new URL(urlToRead);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-Type", "application/json");
        /*conn.setRequestProperty("Accept", "application/json"); */
        conn.setRequestProperty("Accept", "text/plain");
        conn.setRequestProperty("X-Mashape-Key","KHbGvlhemrmshCHjrY42gJHSploxp1d38aWjsnGzL6unXaBvTW");

        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }

        return result.toString();
    }

}
