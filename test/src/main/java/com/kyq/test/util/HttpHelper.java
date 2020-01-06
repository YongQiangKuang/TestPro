package com.kyq.test.util;

import com.alibaba.fastjson.JSON;
import net.dongliu.requests.RawResponse;
import net.dongliu.requests.RequestBuilder;
import net.dongliu.requests.Requests;
import net.dongliu.requests.body.Part;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @ClassName HttpSDKPlugin
 * @Description http使用工厂
 * @Author duwanjiang
 * @Date 2019/10/23 11:11
 * Version 1.0
 **/
public class HttpHelper {
    private static final Logger logger = LoggerFactory.getLogger(HttpHelper.class);

    /**
     * 请求省中心门架接口服务
     *
     * @param request
     * @return
     */
    public static BaseUploadResponse uploadProvince(BaseUploadRequest request) {

        BaseUploadResponse response = new BaseUploadResponse();
        RawResponse rawResponse = postData(getProvinceUrl(request.getReqFileName()),
                TransferProp.PROVINCE_AUTHCODE, request.getReqFileName(), request.getReqData(),
                TransferProp.HTTPS_PROVINCE_ENABLED,
                TransferProp.HTTP_PROXY_PROVINCE_ENABLED,
                TransferProp.HTTP_PROXY_PROVINCE_IP,
                TransferProp.HTTP_PROXY_PROVINCE_PORT,
                getProvinceParts(request.getReqData(), request.getReqFileName()), null);
        response.setStateCode(rawResponse.getStatusCode());
        if (rawResponse.getStatusCode() == 200) {
            String res = rawResponse.readToText();
            Map reMap = JSON.parseObject(res, Map.class);
            int status = rawResponse.getStatusCode();
            response.setStateCode(status);
            response.setData(reMap);
        } else {
            response.setErrorMsg(rawResponse.readToText());
        }
        return response;
    }

    /**
     * 请求省中心门架接口服务
     *
     * @param request
     * @return
     */
    public static BaseDownResponse downloadProvince(BaseDownRequest request) throws IOException {
        return postResFile(request.getSavePath(), getProvinceUrl(request.getReqFileName()),
                TransferProp.PROVINCE_AUTHCODE, request.getReqFileName(), request.getReqData(),
                TransferProp.HTTPS_PROVINCE_ENABLED,
                TransferProp.HTTP_PROXY_PROVINCE_ENABLED,
                TransferProp.HTTP_PROXY_PROVINCE_IP,
                TransferProp.HTTP_PROXY_PROVINCE_PORT,
                getProvinceParts(request.getReqData(), request.getReqFileName()),
                null);
    }


    /**
     * 获取省中心接收系统请求地址
     * @param fileName
     * @return
     */
    private static String getProvinceUrl(String fileName){
        return TransferProp.PROVINCE_URL.concat("/dfs/").concat(TransferProp.PROVINCE_ID)
                .concat("/bin/").concat(fileName.replace(".", "@_@"));
    }

    private static List<Part<?>> getProvinceParts(byte[] contentBytes, String fileName){
        List<Part<?>> parts = null;
        try {
            parts = new ArrayList<>();
            parts.add(Part.text("fileName", fileName));
            parts.add(Part.file("binFile", fileName, contentBytes));
            parts.add(Part.text("sign", sign(
                    new String(contentBytes, StandardCharsets.UTF_8), fileName)));
        } catch (Exception e) {
            logger.error("获取省中心请求体异常", e);
        }
        return parts;
    }

    /**
     * post请求响应文件函数
     *
     * @param savePathStr
     * @param url
     * @param auth
     * @param fileName
     * @param reqData
     * @param isSSL
     * @param isProxy
     * @param proxyIp
     * @param proxyPort
     * @return
     */
    private static BaseDownResponse postResFile(String savePathStr, String url, String auth,
                                                String fileName, byte[] reqData, boolean isSSL,
                                                boolean isProxy, String proxyIp, int proxyPort,
                                                List<Part<?>> parts, Map<String, Object> headers)
            throws IOException {
        BaseDownResponse response = new BaseDownResponse();
        RawResponse rawResponse = postData(url, auth, fileName, reqData, isSSL, isProxy,
                proxyIp, proxyPort, parts, headers);
        if (rawResponse.getStatusCode() == 200) {
            Path savePath = Paths.get(savePathStr).getParent();
            if (Files.exists(savePath)) {
                Files.createDirectories(savePath);
            }
            Path saveFilePath = Paths.get(savePathStr);
            rawResponse.writeToFile(saveFilePath);
        } else {
            response.setErrorMsg(rawResponse.readToText());
        }
        response.setStateCode(rawResponse.getStatusCode());
        return response;
    }

    /**
     * post请求函数
     *
     * @param url
     * @param auth
     * @param fileName
     * @param reqData
     * @param isSSL
     * @param isProxy
     * @param proxyIp
     * @param proxyPort
     * @return
     */
    private static RawResponse postData(String url, String auth, String fileName, byte[] reqData,
                                        boolean isSSL, boolean isProxy, String proxyIp, int proxyPort,
                                        List<Part<?>> parts, Map<String, Object> headers) {
        logger.debug("begin http post url:{},fileName:{},isSSL:{},isProxy:{}", url, fileName, isSSL, isProxy);
        logger.info("[httphelper]start http posturl:{},fileName:{}", url, fileName);
        if(headers == null){
            headers = new HashMap<>();
            headers.put("binfile-md5", encoderByMd5(reqData));
            headers.put("binfile-gzip", "true");
            headers.put("binfile-auth", auth);
        }
        //post
        if(parts == null){
            parts = new ArrayList<>();
            parts.add(Part.text("filename", fileName));
            parts.add(Part.file("binFile", fileName, reqData));
        }
        RequestBuilder builder = Requests.post(url).multiPartBody(parts).verify(isSSL);
        if (isProxy) {
            //设置代理
            Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxyIp, proxyPort));
            builder.proxy(proxy);
        }
        RawResponse rawResponse = builder.timeout(TransferProp.HTTP_CONNECTTIMEOUT)
                .headers(headers).send().charset("utf-8");
        return rawResponse;
    }

    public static String sign(String content, String fileName) {
        String re = getToSignStr(content, fileName);
        return encoderByMd5(re.getBytes(Charset.forName("UTF-8"))).toUpperCase();
    }
    public static String getToSignStr(String content, String fileName) {
        Map<String, Object> signMap = new HashMap<>();
        signMap.put("signType", "MD5");
        signMap.put("encryptType", "NONE");
        signMap.put("version", "1.0");
        signMap.put("binFile", encoderByMd5(content.getBytes(Charset.forName("UTF-8"))).toUpperCase());
        StringBuilder sb = new StringBuilder();
        Set keySet = signMap.keySet();
        List sortList = new ArrayList(keySet);
        sortList.sort(Comparator.comparing(Object::toString));
        for (Object key : sortList) {
            Object val = signMap.get(key);
            //空值不参与签名
            if (val == null || val.toString()=="") {
                continue;
            }
            sb.append(key);
            sb.append("=");
            sb.append(val);
            sb.append("&");
        }
        sb.append("filename".concat("=").concat(fileName));
        return sb.toString();
    }

    /**
     * post请求函数
     *
     * @param url
     * @param auth
     * @param fileName
     * @param reqData
     * @param isSSL
     * @param isProxy
     * @param proxyIp
     * @param proxyPort
     * @return
     */
    private static RawResponse postData(String url, String auth, String fileName, byte[] reqData,
                                        boolean isSSL, boolean isProxy, String proxyIp, int proxyPort) {
        return postData(url, auth, fileName, reqData, isSSL, isProxy, proxyIp, proxyPort,
                null, null);
    }


    public static String encoderByMd5(byte[] bytes) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] array = md.digest(bytes);
            return byteArrayToHex(array);
        } catch (Exception e) {
            logger.error("{},{}",e, "md5 encode error!  str " + bytes.toString());
        }
        return null;
    }

    public static void mkdirs(String dir) {
        File localFile = new File(dir);
        if ((!localFile.exists()) || (!localFile.isDirectory())) {
            synchronized (HttpHelper.class) {
                if ((localFile.exists()) && (localFile.isDirectory())) {
                    return;
                }
                boolean bool = localFile.mkdirs();
                if (!bool) {
                    throw new RuntimeException("创建文件夹失败,请查看application server权限设置path = " + dir);
                }
            }
        }
    }

    private static String byteArrayToHex(byte[] array) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < array.length; ++i) {
            sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
        }
        return sb.toString();
    }

    static class BaseUploadResponse {
        private Logger logger = LoggerFactory.getLogger(BaseUploadResponse.class);

        private String info;
        private String receiveTime;
        private Integer stateCode = 0;
        private String errorMsg = "无异常";
        private String reqFileName;
        private Map data;

        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
        }

        public String getReceiveTime() {
            return receiveTime;
        }

        public void setReceiveTime(String receiveTime) {
            this.receiveTime = receiveTime;
        }

        public Map getData() {
            return data;
        }

        public void setData(Map data) {
            this.data = data;
        }

        public Integer getStateCode() {
            return stateCode;
        }

        public void setStateCode(Integer stateCode) {
            this.stateCode = stateCode;
        }

        public String getErrorMsg() {
            return errorMsg;
        }

        public void setErrorMsg(String errorMsg) {
            this.errorMsg = errorMsg;
        }

        public String getReqFileName() {
            return reqFileName;
        }

        public void setReqFileName(String reqFileName) {
            this.reqFileName = reqFileName;
        }

        @Override
        public String toString() {
            return "BaseUploadResponse{" +
                    "info='" + info + '\'' +
                    ", receiveTime='" + receiveTime + '\'' +
                    ", data=" + data +
                    ", BaseResponse=" + "BaseResponse{" +
                    "stateCode=" + stateCode +
                    ", errorMsg='" + errorMsg + '\'' +
                    ", reqFileName='" + reqFileName + '\'' +
                    '}' +
                    '}';
        }
    }

    class BaseUploadRequest {
        private Logger logger = LoggerFactory.getLogger(BaseUploadRequest.class);

        private String url;
        private byte[] reqData;
        private String reqFileName;

        public String getReqFileName() {
            return reqFileName;
        }

        public void setReqFileName(String reqFileName) {
            this.reqFileName = reqFileName;
        }

        public byte[] getReqData() {
            return reqData;
        }

        public void setReqData(byte[] reqData) {
            this.reqData = reqData;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public BaseUploadRequest(){}

        public BaseUploadRequest(byte[] reqData, String reqFileName) {
            this.reqData = reqData;
            this.reqFileName = reqFileName;
        }

        @Override
        public String toString() {
            return "BaseRequest{" +
                    "reqData=" + Arrays.toString(reqData) +
                    ", reqFileName='" + reqFileName + '\'' +
                    ", url='" + url + '\'' +
                    '}';
        }
    }

    static class BaseDownResponse {
        private static Logger logger = LoggerFactory.getLogger(BaseDownResponse.class);
        private static SimpleDateFormat FORMAT_yyyy_MM_dd =  new SimpleDateFormat("yyyy-MM-dd");
        private String filePath;
        private Integer stateCode = 0;
        private String errorMsg = "无异常";
        private String reqFileName;

        public Integer getStateCode() {
            return stateCode;
        }

        public void setStateCode(Integer stateCode) {
            this.stateCode = stateCode;
        }

        public String getErrorMsg() {
            return errorMsg;
        }

        public void setErrorMsg(String errorMsg) {
            this.errorMsg = errorMsg;
        }

        public String getReqFileName() {
            return reqFileName;
        }

        public void setReqFileName(String reqFileName) {
            this.reqFileName = reqFileName;
        }

        public String getFilePath() {
            return filePath;
        }

        public void saveFile(String savePath, String fileName, byte[] data, int pos) throws IOException {
            if (StringUtil.isEmpty(savePath)) {
                savePath = "./sdk/download/";
            }
            String dir = savePath + "/" + FORMAT_yyyy_MM_dd.format(new Date()) + "/" + getDataType(fileName);
            mkdirs(dir);
            filePath = dir + "/" + fileName;
            Path localFile = Paths.get(dir, fileName);
            Files.copy(new ByteArrayInputStream(data, pos, data.length - pos), localFile);
        }

        private String getDataType(String fileName) {
            String[] arrayOfString = fileName.split("_");
            if (arrayOfString.length < 2) {
                return "DEFAULT";
            }
            return arrayOfString[0] + "_" + arrayOfString[1];
        }

        @Override
        public String toString() {
            return "BaseDownResponse{" +
                    "filePath='" + filePath + '\'' +
                    "} " + "BaseResponse{" +
                    "stateCode=" + stateCode +
                    ", errorMsg='" + errorMsg + '\'' +
                    ", reqFileName='" + reqFileName + '\'' +
                    '}';
        }

        public void moveFile(String savePath, String fileName, String file) throws IOException {
            if (StringUtil.isEmpty(savePath)) {
                savePath = "./sdk/download/";
            }

            String dir = savePath;
            mkdirs(dir);
            this.filePath = dir + "/" + fileName;
            Path localFile = Paths.get(dir, fileName);
            /**
             * ------------------------------
             * update by duwanjiang 2018/01/15 增加了空文件的判断
             * ------------------------------
             */
            if (file != null) {
                Files.move(Paths.get(file), localFile, StandardCopyOption.REPLACE_EXISTING);
            }
        }
    }

    static class BaseDownRequest {
        private static Logger logger = LoggerFactory.getLogger(BaseDownRequest.class);

        private String savePath;
        private String url;
        private byte[] reqData;
        private String reqFileName;

        public BaseDownRequest(){
            super();

        }
        public BaseDownRequest(byte[] reqData, String reqFileName, String savePath) {
            this.reqData = reqData;
            this.reqFileName = reqFileName;
            this.savePath = savePath;
        }

        public String getReqFileName() {
            return reqFileName;
        }

        public void setReqFileName(String reqFileName) {
            this.reqFileName = reqFileName;
        }

        public byte[] getReqData() {
            return reqData;
        }

        public void setReqData(byte[] reqData) {
            this.reqData = reqData;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getSavePath() {
            return savePath;
        }

        public void setSavePath(String savePath) {
            this.savePath = savePath;
        }

        @Override
        public String toString() {
            return "BaseDownRequest{" +
                    "savePath='" + savePath + '\'' +
                    '}'+"BaseRequest{" +
                    "reqData=" + Arrays.toString(reqData) +
                    ", reqFileName='" + reqFileName + '\'' +
                    ", url='" + url + '\'' +
                    '}';
        }
    }

    static class TransferProp {
        public static final String PROVINCE_URL = "province.url";
        public static final String PROVINCE_AUTHCODE = "province.authCode";
        public static final boolean HTTPS_PROVINCE_ENABLED = false;
        public static final boolean HTTP_PROXY_PROVINCE_ENABLED = false;
        public static final String HTTP_PROXY_PROVINCE_IP = "http.proxy.province.ip";
        public static final int HTTP_PROXY_PROVINCE_PORT = 8088;
        public static final int HTTP_CONNECTTIMEOUT = 6000;
        public static final String PROVINCE_ID = "50";
    }
}
