/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * @author 1999itukinao
 */
public class JsonHelper {
    //OpenWeatherMap APIのID・ベースURL
    private static final String APP_ID = "849da9621698bd3d0f1a38f34c64c66e";
    private static final String BASE_URL = "http://api.openweathermap.org/data/2.5/weather";
    
    /**
     * Httpリクエストで指定された都市名の天候情報を得るメソッド
     * @param city
     * @return cityの天候情報
     */
    public static String getResult(String city) {
        String result = "";
        try{
            URL url = new URL(BASE_URL +"?q="+ city +",jp&units=metric&appid="+ APP_ID); //countryを日本に指定(jp)
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.connect();
            BufferedReader bf = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String tmp = "";
            while((tmp = bf.readLine()) != null) {
                result += tmp;
            }
            bf.close();
            con.disconnect();
        }catch(Exception e) {
            e.getMessage();
        }
        return result;
    }
    
    /**
     * 文字列での検索結果をJsonオブジェクトに変換するメソッド
     * @param result
     * @return JsonNodeに変換した検索結果
     */
    public static JsonNode getJsonNode(String result) {
        JsonNode jn = null;
        try {
            JsonFactory jfactory = new JsonFactory();
            JsonParser parser = jfactory.createParser(result);
            
            ObjectMapper om = new ObjectMapper();
            jn = om.readTree(parser);
        }catch(Exception e) {
            e.printStackTrace();
        }
        return jn;
    }
    
    /**
     * Jsonオブジェクトから必要なパラメータを取得してHistoryDataBeansへ格納するメソッド
     * @param node
     * @return hdb
     */
    public static HistoryDataBeans getWeather(JsonNode node) {
        HistoryDataBeans hdb = new HistoryDataBeans();
        
        hdb.setTemp(node.get("main").get("temp").floatValue());
        hdb.setTemp_max(node.get("main").get("temp_max").floatValue());
        hdb.setTemp_min(node.get("main").get("temp_min").floatValue());
        hdb.setHumidity(node.get("main").get("humidity").floatValue());
        hdb.setIcon(node.get("weather").get(0).get("icon").textValue());
        hdb.setSpeed(node.get("wind").get("speed").floatValue());
        
        return hdb;
    }
        

}

