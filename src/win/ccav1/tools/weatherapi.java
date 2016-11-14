package win.ccav1.tools;

/**
 * Created by Administrator on 2016/11/12.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


/**
 * @author lijinnan
 * @date:2013-11-11 下午6:12:26
 */

public class weatherapi {

    public static void main(String[] args) {
        getWeather("成都");
    }
    public static String getJson(String city) {
        String httpUrl = "http://apis.baidu.com/heweather/weather/free?city=";
        BufferedReader reader = null;
        String result = null;
        StringBuffer sbf = new StringBuffer();
        httpUrl = httpUrl  + city;
        System.out.println(httpUrl);
        try {
            URL url = new URL(httpUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            // 填入apikey到HTTP header
            connection.setRequestProperty("apikey",  "a79124c4594c2e5a0799a39ea8f64c87");
            connection.connect();
            InputStream is = connection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            String strRead = null;
            while ((strRead = reader.readLine()) != null) {
                sbf.append(strRead);
                sbf.append("\r\n");
            }
            reader.close();
            result = sbf.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    public static String getWeather(String city){
        String weather="查询失败";
        if (city.equals("chengdou")){
            city="chengdu";
        }
        try {
            String json = getJson(city);
            JSONObject jsonObject = JSONObject.fromObject(json);
            //JSONObject jsonObject=JSONObject.fromObject(json);
            //System.out.println(jsonObject);
            Object obj = jsonObject.get("HeWeather data service 3.0");
            JSONArray ja = JSONArray.fromObject(obj);
            JSONObject job = (JSONObject) ja.get(0);
            System.out.println("job" + job);//中文是查询之后返回是job{"status":"unknown city"}
            JSONArray ja1 = (JSONArray) job.get("daily_forecast");
            JSONObject cond = (JSONObject) (((JSONObject) ja1.get(1)).get("cond"));
            String txt_d = (String) cond.get("txt_d");//天气情况
            String date = ((JSONObject) ja1.get(1)).getString("date");
            JSONObject tmp = ((JSONObject) ja1.get(1)).getJSONObject("tmp");
            String maxTmp = tmp.getString("max") + "度";
            String minTmp = tmp.getString("min") + "度";
            JSONObject wind = ((JSONObject) ja1.get(1)).getJSONObject("wind");
            String windStr = wind.getString("dir") + ",风力" + wind.getString("sc");
            weather = txt_d + '\n' + date + '\n' + "温度：" + minTmp + "到" + maxTmp + '\n' + windStr;
        }
        catch (Exception e){
            return weather="查询失败";
        }
        return weather;
    }
}