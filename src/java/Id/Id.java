package Id;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import java.util.HashMap;
import java.util.Map;

public class Id {

    public static void main(String[] args) {
        String host = "https://idcardcert.market.alicloudapi.com";
        String path = "/idCardCert";
        String method = "GET";
        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139xxx
        headers.put("Authorization", "APPCODE " + "6656b05af8a44b45ab65a4******");
        Map<String, String> querys = new HashMap<String, String>();
        querys.put("idCard", "511322199*090*****");
        querys.put("name", "李奎");
        //JDK 1.8示例代码请在这里下载：  http://code.fegine.com/Tools.zip

        try {
            /**
             * 重要提示如下:
             * HttpUtils请从
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
             * 或者直接下载：
             * http://code.fegine.com/HttpUtils.zip
             * 下载
             *
             * 相应的依赖请参照
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
             * 相关jar包（非pom）直接下载：
             * http://code.fegine.com/aliyun-jar.zip
             */
            HttpResponse response = Id.HttpUtils.doGet(host, path, method, headers, querys);
            //System.out.println(response.toString());如不输出json, 请打开这行代码，打印调试头部状态码。
            //状态码: 200 正常；400 URL无效；401 appCode错误； 403 次数用完； 500 API网管错误
            //获取response的body
            System.out.println(EntityUtils.toString(response.getEntity()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //认证返回信息
    //{"status":"01","msg":"实名认证通过！","idCard":"511322199909067976","name":"李*","sex":"男","area":"四川省xx市xx县","province":"四川省","city":"xx市","prefecture":"xx县","birthday":"199x-9x-0x","addrCode":"51132x","lastCode":"6"}
}
