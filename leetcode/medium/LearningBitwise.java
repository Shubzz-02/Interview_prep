package com.company.leetcode.medium;


import java.util.*;

public class LearningBitwise {
    public static void main(String[] args) {
        //new LearningBitwise().calcPower(12);
        new LearningBitwise().mid(Integer.MAX_VALUE - 1, Integer.MAX_VALUE);
    }


    public void mid(int a, int b) {
        System.out.println("Max Value " + b);
        System.out.println(8 >>> 4);
        System.out.println((a + b));
        System.out.println(-1 >>> 27);
        System.out.println((a + b) >>> 1);
    }


    public void calcPower(int x) {
        int i = (int) Math.pow(10, 9);
        System.out.println(i);
        System.out.println(Math.pow(2, x));
        System.out.println((1 << x));
    }

    public int climbStairs(int n) {
        double sqrt = Math.sqrt(5);
        return (int) ((1 / sqrt) * (Math.pow(((1 + sqrt) / 2), n + 1) - Math.pow(((1 - sqrt) / 2), n + 1)));
    }

    public boolean search(int[] nums, int target) {
//        int pv = findPivotLS(nums, l, r);
        int len = nums.length;
        int l = 0;
        int r = len - 1;
        while (l <= r) {
            int pv = findPivotLS(nums, l, r);
            int bs = Arrays.binarySearch(Arrays.copyOfRange(nums, l, pv), target);
            if (bs < 0) {
                l = pv;
            } else
                return true;
        }
        return false;

//        if (pv == -1 || pv == nums.length) {
//            return Arrays.binarySearch(nums, target) >= 0;
//        } else {
//
//            return Arrays.binarySearch(Arrays.copyOfRange(nums, 0, pv + 1), target) >= 0 || Arrays.binarySearch(Arrays.copyOfRange(nums, pv + 1, nums.length), target) >= 0;
//            int a = Arrays.binarySearch(Arrays.copyOfRange(nums, 0, pv + 1), target);
//            if (a < 0) {
//                return Arrays.binarySearch(Arrays.copyOfRange(nums, pv + 1, nums.length), target) >= 0;
//            }
//            return true;
//        }
    }

    public int findPivotLS(int[] arr, int l, int r) {
        int pivot = -1;
        if (arr != null && arr.length > 0) {
            pivot = 0;
            for (int i = l; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    pivot = i;
                    break;
                }
            }
        }
        return pivot;
    }

    public int search2(int[] nums, int target) {
        int pv = findPivot(nums, 0, nums.length);
        if (pv == -1 || pv == nums.length) {
            int ret = Arrays.binarySearch(nums, target);
            if (ret < 0) {
                return -1;
            } else
                return ret;
        } else {
            int a = Arrays.binarySearch(Arrays.copyOfRange(nums, 0, pv + 1), target);
            if (a < 0) {
                int b = Arrays.binarySearch(Arrays.copyOfRange(nums, pv + 1, nums.length), target);
                if (b < 0) {
                    return -1;
                } else {
                    return pv + b + 1;
                }
            }
            return a;
        }
    }

    static int findPivot(int[] arr, int low, int high) {
        if (high < low)
            return -1;
        if (high == low)
            return low;
        int mid = (low + high) / 2;
        if (mid != arr.length - 1 && mid < high && arr[mid] > arr[mid + 1])
            return mid;
        if (mid > low && arr[mid] < arr[mid - 1])
            return (mid - 1);
        if (arr[low] >= arr[mid])
            return findPivot(arr, low, mid - 1);
        return findPivot(arr, mid + 1, high);
    }

    public int search1(int[] nums, int target) {
        int n = nums.length;
        if (nums[n - 1] == target)
            return n - 1;

        int backup = nums[n - 1];
        nums[n - 1] = target;
        for (int i = 0; ; i++) {
            if (nums[i] == target) {
                nums[n - 1] = backup;
                if (i < n - 1)
                    return i;
                return -1;
            }
        }
    }

    public boolean isPowerOfTwo(int x) {
        return x > 0 && ((x & (x - 1)) == 0);
    }

    public int[] sortByBits(int[] arr) {
        Map<Integer, List<Integer>> map = new TreeMap<>();
        Arrays.sort(arr);
        for (int i : arr) {
            int sb = Integer.bitCount(i);
            List<Integer> temp;
            if (map.containsKey(sb)) {
                temp = map.get(sb);
            } else {
                temp = new ArrayList<>();
            }
            temp.add(i);
            map.put(sb, temp);
        }
        int[] result = new int[arr.length];
        int index = 0;
        for (int key : map.keySet()) {
            int[] temp = map.get(key).stream().mapToInt(i -> i).toArray();
            System.arraycopy(temp, 0, result, index, temp.length);
            index += temp.length;
        }
        return result;
    }


    public int hammingWeight(int n) {
        int bits = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) {
                bits++;
            }
            mask = mask << 1;
        }
        return bits;
    }

    public List<String> findRepeatedDnaSequences(String s) {
        Map<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        int len = s.length();
        for (int i = 0; i <= len - 10; i++) {
            String ss = s.substring(i, i + 10);
            map.put(ss, map.getOrDefault(ss, 0) + 1);
        }
        for (String keys : map.keySet()) {
            if (map.get(keys) >= 2) {
                list.add(keys);
            }
        }
        return list;
    }


    public int singleNumber(int[] nums) {
        int one = 0;
        int two = 0;
        for (int num : nums) {
            int calc = (one ^ num);
            int nt = ~two;
            one = nt & calc;
            two = ~one & (two ^ num);
        }
        return one;
    }
}



