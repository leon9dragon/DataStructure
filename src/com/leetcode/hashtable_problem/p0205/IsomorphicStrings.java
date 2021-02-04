package com.leetcode.hashtable_problem.p0205;

import java.util.HashMap;
import java.util.Map;


public class IsomorphicStrings {
    public static void main(String[] args) {
        System.out.println(new IsomorphicStrings().isIsomorphic("egg", "bee"));
    }

    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        return getOrder2(s, t);
    }

    public String getOrder(String str) {
        int len = str.length();
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();
        int index = 0;
        char c;
        while (index < len) {
            c = str.charAt(index);
            if (!map.containsKey(c)) {
                map.put(c, index);
                sb.append(index);
            } else sb.append(map.get(c));
            index++;
        }
        return sb.toString();
    }

    public boolean getOrder2(String str1, String str2) {
        int len = str1.length();
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        int index = 0;
        char c;
        int bit1, bit2;
        while (index < len) {
            c = str1.charAt(index);
            if (!map1.containsKey(c)) {
                map1.put(c, index);
                bit1 = index;
            } else bit1 = map1.get(c);

            c = str2.charAt(index);
            if (!map2.containsKey(c)) {
                map2.put(c, index);
                bit2 = index;
            } else bit2 = map2.get(c);

            if (bit1 != bit2) return false;
            index++;
        }
        return true;
    }
}
