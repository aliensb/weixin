package win.ccav1.tools;

import net.sf.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by paul on 2016/11/22.
 */
public class TulingRobot {
    public static void main(String[] args) {
        System.out.println(getJson("成都","oPo9LwyGsrHhpSUM2nhuZpaSuRc"));
    }
    public static String getMessage(String json){
        JSONObject jsonObject = JSONObject.fromObject(json);
        String message=jsonObject.getString("text");
        return message;
    }
    public static String getJson(String keyWords,String userId){
        String httpUrl = "http://www.tuling123.com/openapi/api";
        String result = "查询失败";
        System.out.println("yuan"+keyWords+userId);
        try {
            keyWords=URLEncoder.encode(keyWords, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        Map<String,String> params=new HashMap<String,String>();
        params.put("key","b050967553334ccdb552646c4fadd386");
        params.put("info",keyWords);
        params.put("userid",userId);
        try{
            result=post(httpUrl,params);
            result=getMessage(result);
        }
        catch (Exception e){
        }
        return result;
    }
    public static String post(String path,Map<String,String> requestParamsMap) throws Exception{
        HttpURLConnection httpConn=null;
        BufferedReader in=null;
        PrintWriter out=null;
        StringBuilder params=new StringBuilder();
        // 组织请求参数
        Iterator it = requestParamsMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry element = (Map.Entry) it.next();
            params.append(element.getKey());
            params.append("=");
            params.append(element.getValue());
            params.append("&");
        }
        if (params.length() > 0) {
            params.deleteCharAt(params.length() - 1);
        }
        try {
            URL url=new URL(path);
            httpConn=(HttpURLConnection)url.openConnection();
            httpConn.setRequestMethod("POST");
            httpConn.setDoInput(true);
            httpConn.setDoOutput(true);

            //发送post请求参数
            out=new PrintWriter(httpConn.getOutputStream());
            System.out.println(params.toString());
            out.println(params.toString());
            out.flush();

            //读取响应
            if(httpConn.getResponseCode()==HttpURLConnection.HTTP_OK){
                StringBuffer content=new StringBuffer();
                String tempStr="";
                in=new BufferedReader(new InputStreamReader(httpConn.getInputStream(),"UTF-8"));
                while((tempStr=in.readLine())!=null){
                    content.append(tempStr);
                }
                System.out.println("huifu"+content.toString());
                //return "喊你去洗漱上去了，发锤子发，都不打你的狗熊联盟了！！";

                return content.toString();
            }else{
                throw new Exception("请求出现了问题!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            in.close();
            out.close();
            httpConn.disconnect();
        }
        return null;
    }

}
