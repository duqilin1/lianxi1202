package com.bawie.lianxi1202.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/*
 *@auther:杜其林
 *@Date: 2019/12/2
 *@Time:14:11
 *@Description:${DESCRIPTION}
 * */
public class NetUtil {
     private static NetUtil netUtil = new NetUtil();

    private NetUtil() {
    }

    public static NetUtil getInstance() {
        return netUtil;
    }

    public void getJson(final String connter, final HttpUri httpUri){
        new AsyncTask<Void, Void, String>() {
            @Override
            protected void onPostExecute(String values) {
                if (TextUtils.isEmpty(values)){
                    httpUri.onSheBai("请求失败");
                }else {
                    httpUri.ongetJson(values);
                }
            }

            @Override
            protected String doInBackground(Void... voids) {
                String json ="";
                try {
                    URL url = new URL(connter);
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.setConnectTimeout(5000);
                    httpURLConnection.setReadTimeout(5000);
                    httpURLConnection.connect();
                    if (httpURLConnection.getResponseCode() == 200){
                        InputStream inputStream = httpURLConnection.getInputStream();
                        json = io2String(inputStream);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return json;
            }
        }.execute();
    }

    private String io2String(InputStream inputStream) throws IOException {
        byte[] bytes = new byte[1024];
        int len = -1;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while ((len = inputStream.read(bytes)) != -1){
            byteArrayOutputStream.write(bytes,0,len);
        }
        byte[] bytes1 = byteArrayOutputStream.toByteArray();
        String json = new String(bytes1);
        return json;
    }

    public void getPath(final String a, final ImageView imageView){
        new AsyncTask<Void, Void, Bitmap>() {
            @Override
            protected void onPostExecute(Bitmap bitmap) {
                imageView.setImageBitmap(bitmap);
            }

            @Override
            protected Bitmap doInBackground(Void... voids) {
                Bitmap bitmap = null;
                try {
                    URL url = new URL(a);
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.setConnectTimeout(5000);
                    httpURLConnection.setReadTimeout(5000);
                    httpURLConnection.connect();
                    if (httpURLConnection.getResponseCode() == 200){
                        InputStream inputStream = httpURLConnection.getInputStream();
                        bitmap = io2Bitmap(inputStream);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return bitmap;
            }
        }.execute();
    }

    private Bitmap io2Bitmap(InputStream inputStream){
        return BitmapFactory.decodeStream(inputStream);
    }

    public boolean isWang(Context context){
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
            return true;
        }else {
            return false;
        }
    }

    public boolean isWifi(Context context){
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.getType() == connectivityManager.TYPE_WIFI) {
            return true;
        }else {
            return false;
        }
    }

    public boolean isMobile(Context context){
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.getType() == connectivityManager.TYPE_MOBILE) {
            return true;
        }else {
            return false;
        }
    }

    public interface HttpUri{
        void ongetJson(String json);

        void onSheBai(String throwable);
    }
}
