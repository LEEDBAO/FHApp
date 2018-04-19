package com.example.ruby.fhapp.app.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.ColorMatrixColorFilter;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.blankj.utilcode.util.EncryptUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;




public class Utils {
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

    /**
     * 按钮被按下
     */
    public final static float[] BUTTON_PRESSED = new float[] {
            2.0f, 0, 0, 0, -50,
            0, 2.0f, 0, 0, -50,
            0, 0, 2.0f, 0, -50,
            0, 0, 0, 5, 0 };

    /**
     * 按钮恢复原状
     */
    public final static float[] BUTTON_RELEASED = new float[] {
            1, 0, 0, 0, 0,
            0, 1, 0, 0, 0,
            0, 0, 1, 0, 0,
            0, 0, 0, 1, 0 };

    public final static boolean checkAcitvty(Intent intent, Context context)
    {
        PackageManager packageManager =context.getPackageManager();
        return packageManager.resolveActivity(intent, PackageManager.MATCH_DEFAULT_ONLY)==null;
    }

    private static final View.OnTouchListener touchListener = new View.OnTouchListener() {

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                v.getBackground().setColorFilter(new ColorMatrixColorFilter(Utils.BUTTON_PRESSED));
                v.setBackgroundDrawable(v.getBackground());
            } else if (event.getAction() == MotionEvent.ACTION_UP) {
                v.getBackground().setColorFilter(new ColorMatrixColorFilter(Utils.BUTTON_RELEASED));
                v.setBackgroundDrawable(v.getBackground());
            }
            return false;
        }
    };
}
