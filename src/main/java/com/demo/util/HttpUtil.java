package com.demo.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.demo.pojo.PhoneArea;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

/**
 * TODO:Responsibility description of this class.
 *
 * @author lichenxin@xinzhentech.com
 * @version 1.0
 * @since 2018/5/1 13:51
 */
public class HttpUtil {
    /**
     * 向指定URL发送GET方法的请求
     *
     */
    public static String get(String url) {
        BufferedReader in = null;
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("Accept-Charset", "utf-8");
            connection.setRequestProperty("contentType", "utf-8");
            connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            // 建立实际的连接
            connection.connect();
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(connection.getInputStream(),"GBK"));
            StringBuffer sb = new StringBuffer();
            String line;
            while ((line = in.readLine()) != null) {
                sb.append(line);
            }
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 发送HttpPost请求
     *
     * @param strURL
     *            服务地址
     * @param params
     *
     * @return 成功:返回json字符串<br/>
     */
    public static String jsonPost(String strURL, Map<String, String> params) {
        try {
            URL url = new URL(strURL);// 创建连接
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setUseCaches(false);
            connection.setInstanceFollowRedirects(true);
            connection.setRequestMethod("POST"); // 设置请求方式
            connection.setRequestProperty("Accept", "application/json"); // 设置接收数据的格式
            connection.setRequestProperty("Content-Type", "application/json"); // 设置发送数据的格式
            connection.connect();
            OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream(), "UTF-8"); // utf-8编码
            out.append(JSON.toJSONString(params));
            out.flush();
            out.close();

            int code = connection.getResponseCode();
            InputStream is = null;
            if (code == 200) {
                is = connection.getInputStream();
            } else {
                is = connection.getErrorStream();
            }

            // 读取响应
            int length = (int) connection.getContentLength();// 获取长度
            if (length != -1) {
                byte[] data = new byte[length];
                byte[] temp = new byte[512];
                int readLen = 0;
                int destPos = 0;
                while ((readLen = is.read(temp)) > 0) {
                    System.arraycopy(temp, 0, data, destPos, readLen);
                    destPos += readLen;
                }
                String result = new String(data, "UTF-8"); // utf-8编码
                return result;
            }

        } catch (IOException e) {
        }
        return "error"; // 自定义错误信息
    }

    public static PhoneArea getPhoneAreaByTel(String phoneNum){
        String s = HttpUtil.get("https://tcc.taobao.com/cc/json/mobile_tel_segment.htm?tel="+phoneNum);
        s = s.substring(s.indexOf("{"), s.length());
        PhoneArea area = null;
        try {
            area = JSONObject.parseObject(s,PhoneArea.class);
        }catch (Exception e){
            e.printStackTrace();
        }
        return area;
    }

    public static void main(String[] args) {
        PhoneArea area = getPhoneAreaByTel("18580770052");
        System.out.println(area);
    }
}
