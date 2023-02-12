package com.company.leetcode.fnew.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class _535_Encode_and_Decode_TinyURL {

    public static void main(String[] args) {
        Codec codec = new Codec();

        String tinyUrl = codec.encode("https://leetcode.com/problems/design-tinyurl");
        System.out.println(tinyUrl);
        System.out.println(codec.decode(tinyUrl));
    }


}


class Codec {

    Map<String, String> map = new HashMap<>();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String random = getSalt();
        while (map.containsKey(random)) {
            random = getSalt();
        }
        map.put(random, longUrl);
        return "http://tinyurl.com/" + random;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String salt = shortUrl.substring(shortUrl.lastIndexOf("/")+1);
        return map.get(salt);
    }

    protected String getSalt() {
        String saltChar = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 8) {
            int index = (int) (rnd.nextFloat() * saltChar.length());
            salt.append(saltChar.charAt(index));
        }
        return salt.toString();
    }
}