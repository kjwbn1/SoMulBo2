package com.example.joongwonkim.somulbo2.dbconnection;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;

import com.example.joongwonkim.somulbo2.data.Okjson;
import com.example.joongwonkim.somulbo2.model.Item;
import com.example.joongwonkim.somulbo2.view.NmapActivity;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;




public class DownLoadTask extends AsyncTask<Double, Integer, String> {

    String clientId = "pJ4dLhVpOHDtq762zrhh";//애플리케이션 클라이언트 아이디값";
    String clientSecret = "RAy133RV9k";//애플리케이션 클라이언트 시크릿값";
    private DownloadCallback mCallback;
    NmapActivity nmapActivity;
    Context context;
    Okjson asshole;


    public DownLoadTask(Context context){
        this.context=context;
        mCallback = (DownloadCallback)context;
    }





    @Override
    protected String doInBackground(Double... urls) {
        try {


            String x = URLEncoder.encode(urls[0].toString(), "UTF-8");
            String y = URLEncoder.encode(urls[1].toString(), "UTF-8");
//                        String addr = URLEncoder.encode("불정로 9", "UTF-8");
            String apiURL = "https://openapi.naver.com/v1/map/reversegeocode?"+" encoding=utf-8&coordType=latlng&query=" +y+ "," + x ; //json
//            String apiURL = "https://openapi.naver.com/v1/map/reversegeocode?"+addr;
//            String apiURL = "https://openapi.naver.com/v1/map/geocode.xml?query=" + addr; // xml
//            String apiURL = "https://openapi.naver.com/v1/map/geocode?query=" + addr; // xml
            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("X-Naver-Client-Id", clientId);
            con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
            int responseCode = con.getResponseCode();
            BufferedReader br;
            if(responseCode==200) { // 정상 호출
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else {  // 에러 발생
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            br.close();
            System.out.println(response.toString());

            String result = response.toString();

            JSONObject jsonObject = new JSONObject(result);


            Gson gson = new Gson();

            asshole = gson.fromJson(result , Okjson.class);



            String addr = asshole.getResult().getItems().get(1).address;

            return addr;

        } catch (Exception e) {
            System.out.println(e);
        }



        return null;
    }

    protected void onProgressUpdate(Integer... progress) {
    }

    @Override
    protected void onPostExecute(String result) {



        mCallback.updateFromDownload(result);
    }


}