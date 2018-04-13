package com.example.ruby.fhapp.app.utils;

import android.util.Log;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.blankj.utilcode.util.EncryptUtils;


public class CustomUtils {
    //hashMap排序
    public static String hashMapSort(Map map,String sign)
    {
        String id ="";

        List<Map.Entry<String,String>> infoIds=new ArrayList<Map.Entry<String, String>>(map.entrySet());
        Collections.sort(infoIds, new Comparator<Map.Entry<String, String>>() {
            public int compare(Map.Entry<String, String> o1,
                               Map.Entry<String, String> o2) {
                return (o1.getKey()).toString().compareTo(o2.getKey().toString());
            }
        });
        for (int i = 0; i < infoIds.size(); i++) {
            id=id.concat(infoIds.get(i).toString()+sign);
        }
        return id;
    }


    //hashMap排序
    public static String hashMapAddSignSort(Map map)
    {

        String sign="&";

        return hashMapSort(map,sign);
    }

    //md5签名规则
    public static String md5toSignatureRules(Map map, String sign, String secret) {
        String signatureRules = "";
        String ca=hashMapSort(map,sign);
        try {
            String UrlString = URLEncoder.encode(ca,"utf-8").replace("%3D", "=").replace("%26", "&");
            String md5Signature=EncryptUtils.encryptMD5ToString(UrlString + "secret="+secret);
            signatureRules=UrlString + "sign=" + md5Signature.toLowerCase();
        }catch (UnsupportedEncodingException e) {

        }

        return signatureRules;
    }

    public static String md5toSignatureRules(Map map, String secret) {
        Log.e("test",md5toSignatureRules(map,"&",secret));
        return md5toSignatureRules(map,"&",secret);
    }

}
