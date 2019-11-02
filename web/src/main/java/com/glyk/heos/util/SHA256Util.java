package com.glyk.heos.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by shuai on 2017/6/13.
 */
public class SHA256Util {


    public static String getSHA256(String text)
    {
        StringBuffer sb = new StringBuffer();
        try {
            MessageDigest mDigest = MessageDigest.getInstance("SHA-256");
            byte[] result = mDigest.digest(text.getBytes());

            for (int i = 0; i < result.length; i++) {
                sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
            }
        }catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }


        return sb.toString();
    }
}
