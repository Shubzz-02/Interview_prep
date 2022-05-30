package com.company.leetcode.fnew.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Subdomain_Visit_Count_811 {

    public static void main(String[] args) {
        String[] s = {"900 google.mail.com"};
        List<String> l = new Subdomain_Visit_Count_811().subdomainVisits(s);
        System.out.println(l);
    }

    public List<String> subdomainVisits(String[] cpdomains) {

        Map<String, Integer> map = new HashMap<>();
        for (String i : cpdomains) {
            int ct = Integer.parseInt(i.substring(0, i.indexOf(' ')));
            i = i.substring(i.indexOf(' '));
            String[] dom = i.trim().split("\\.");

            String curr= "";
            for (int j = dom.length-1; j >=0  ; j--) {
                curr = dom[j] + (j < dom.length - 1 ? "." : "") + curr;
                map.put(curr, map.getOrDefault(curr, 0) + ct);

            }
        }
        List<String> ans = new ArrayList<>();
        for (String dom: map.keySet())
            ans.add("" + map.get(dom) + " " + dom);
        return ans;
    }
}
