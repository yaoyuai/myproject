package com.bosssoft.hr.javase;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author yaoyu
 * @version 1.0.0
 * @ClassName HttpFileDownloader.java
 * @Description TODO
 * @createTime 2022年06月19日 12:55:00
 */
public class HttpFileDownloader {
    /**
     * 下载文件的方法
     * @author yaoyu
     * @date 2022/6/19 12:55
     * @param remoteFilePath
     * @return boolean
     */
    public boolean download(String remoteFilePath){
        URL url=null;
        HttpURLConnection httpURLConnection=null;
        BufferedInputStream bufferedInputStream=null;
        BufferedOutputStream bufferedOutputStream=null;
        File file=new File("user.xml");
        try {
            url=new URL(remoteFilePath);
            httpURLConnection=(HttpURLConnection)url.openConnection();
            httpURLConnection.connect();
            bufferedInputStream=new BufferedInputStream(httpURLConnection.getInputStream());
            bufferedOutputStream=new BufferedOutputStream(new FileOutputStream(file));
            int length=2048;
            byte[] bytes=new byte[length];
            while((length=bufferedInputStream.read(bytes))!=-1){
                bufferedOutputStream.write(bytes,0,length);
            }
            bufferedOutputStream.close();
            bufferedInputStream.close();
            httpURLConnection.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(bufferedInputStream!=null){
                try {
                    bufferedInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(bufferedOutputStream!=null){
                try {
                    bufferedOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(httpURLConnection!=null){
                httpURLConnection.disconnect();
            }
        }
        return true;
    }

    public static void main(String[] args) {
        HttpFileDownloader httpFileDownloader=new HttpFileDownloader();
        System.out.println(httpFileDownloader.download("http://58.22.61.222:57903/javasexml/user.xml "));
    }
}
