package com.company.codechef.longchallenge;

import java.util.*;

public class Test {
    public Test() {

    }

    public static void main(String[] args) {
//        long x, y, z;
//        x = 1;
//        y = 1000;
//        z = 500000;
//        long sum = (Math.abs(x - y) + Math.abs(y - z) + Math.abs(z - x));
//        System.out.println(Math.abs(x - y));
//        System.out.println(Math.abs(y - z));
//        System.out.println(Math.abs(z - x));
//        System.out.println(499972 + 499999 + 99);
//        System.out.println(sum);
        // int i = 2 * (int) Math.pow(10, 4);
        // System.out.println(equilibriumPoint(new long[]{20, 17, 42, 25, 32, 32, 30, 32, 37, 9, 2, 33, 31, 17, 14, 40, 9, 12, 36, 21, 8, 33, 6, 6, 10, 37, 12, 26, 21, 3}, 30));


        // System.out.println(new Test().guessNumber(2126753390));

    }


    public static int equilibriumPoint(long arr[], int n) {
        long sum = 0L;
        long lsum = 0L;
        for (long i : arr) {
            sum += i;
        }
        for (int i = 0; i < n; i++) {
            sum -= arr[i];
            if (lsum == sum)
                return i;
            lsum += arr[i];
        }
        return -1;
    }

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int len = nums.length;
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Integer num : map.keySet()) {
            if (map.get(num) > (len / 2))
                return num;
        }
        return -1;
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        int len = magazine.length();
        for (int i = 0; i < len; i++) {
            char ch = magazine.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int rlen = ransomNote.length();
        for (int i = 0; i < rlen; i++) {
            char ch = ransomNote.charAt(i);
            if (map.containsKey(ch)) {
                int tc = map.get(ch);
                if (tc > 0)
                    tc--;
                else
                    return false;
                map.put(ch, tc);
            } else
                return false;
        }
        return true;
    }

//    public int[] intersectionI(int[] nums1, int[] nums2) {
//        Set<Integer> n1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
//        Set<Integer> n2 = Arrays.stream(nums2).boxed().collect(Collectors.toSet());
//        n1.retainAll(n2);
//        return n1.stream().mapToInt(i -> i).toArray();
//    }

    public int[] intersect(int[] nums1, int[] nums2) {
        int i = 0, j = 0;
        int len1 = nums1.length;
        int len2 = nums2.length;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int[] result = new int[len1 + len2];
        int index = 0;
        while (i < len1 && j < len2) {
            if (nums1[i] == nums2[j]) {
                result[index++] = nums1[i];
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) i++;
            else if (nums1[i] > nums2[j]) j++;
        }
        int[] results = new int[index];
        int index1 = 0;
        for (int k = 0; k < index; k++) {
            results[index1++] = result[k];
        }
        return results;
    }

    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        set.add(n);
        while (true) {
            n = square(n);
            if (n == 1)
                return true;
            if (!set.contains(n))
                set.add(n);
            else
                return false;
        }
    }

    public int square(int n) {
        int sum = 0;
        while (n > 0) {
            int ld = n % 10;
            sum += Math.pow(ld, 2);
            n = n / 10;
        }
        return sum;
    }

    public boolean isPerfectSquare(int num) {
        if (num == 1 || num == 0)
            return true;
        long i = 1;
        long j = num / 2;
        while (i <= j) {
            long mid = (i + j) / 2;
            if ((mid * mid) == num)
                return true;
            if ((mid * mid) > num)
                j = mid - 1;
            else if ((mid * mid) < num)
                i = mid + 1;
        }
        return false;
    }

    public int guessNumber(int n) {
        int l = 1;
        int r = n;
        while (l <= r) {
            int mid = l + ((r - l) / 2);
            if (guess(mid) == 0)
                return mid;
            if (guess(mid) == -1)
                r = mid - 1;
            else
                l = mid + 1;
        }
        return -1;
    }

    public int guess(int n) {
        //PRE DEFINED
        int ch = 1702766719;
        return Integer.compare(ch, n);
    }

    public String reverseVowels(String s) {
        Queue<Character> vowel = new LinkedList<>();
        Stack<Integer> index = new Stack<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (isVowel(ch)) {
                vowel.add(ch);
                index.push(i);
            }
        }
        StringBuilder revWord = new StringBuilder(s);
        while (!index.isEmpty()) {
            revWord.setCharAt(index.pop(), vowel.remove());
        }
        return revWord.toString();
    }

    private boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U';
    }

    private int[] nums;

    public Test(int[] nums) {
        this.nums = nums;
    }

    public int SumRange(int i, int j) {
        int sum = 0;
        for (int l = i; l <= j; i++) {
            sum += nums[i];
        }
        return sum;
    }

    public ListNode removeElements(ListNode head, int val) {
        return null;
    }

    public boolean isIsomorphic(String s, String t) {
        int slen = s.length();
        int tlen = t.length();
        if (slen != tlen)
            return false;
        return false;
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
