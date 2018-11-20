package BankCard;

import org.apache.http.HttpResponse;

import java.util.HashMap;
import java.util.Map;
import Id.HttpUtils;
import org.apache.http.util.EntityUtils;

public class BackCard {


    public static void main(String[] args) {
        String host = "https://bkcard3.market.alicloudapi.com";
        String path = "/bankcard3/check";
        String method = "GET";
        String appcode = "6656b05af8a44b45ab65a4c79*****";
        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);
        Map<String, String> querys = new HashMap<String, String>();
        querys.put("bankcard", "***848046971893****");  //银行卡
        querys.put("idcard", "511322199*090*****");     //身份证
        querys.put("name", "李x");                      //名字


        try {
            /**
             * 重要提示如下:
             * HttpUtils请从
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
             * 下载
             *
             * 相应的依赖请参照
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
             */
            HttpResponse response = HttpUtils.doGet(host, path, method, headers, querys);
            System.out.println(response.toString());
            //获取response的body
            System.out.println(EntityUtils.toString(response.getEntity()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
