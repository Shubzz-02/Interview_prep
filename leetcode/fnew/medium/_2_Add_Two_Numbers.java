package com.company.leetcode.fnew.medium;


import com.company.leetcode.fnew.model.ListNode;

public class _2_Add_Two_Numbers {

    public static void main(String[] args) {

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = null, pointer = null;

        int carry = 0;
        while (l1 != null || l2 != null) {
            int sum = 0;
            if (carry > 0) {
                sum += carry;
                carry = 0;
            }
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            if (sum > 9) {
                carry = sum / 10;
                sum %= 10;
            }

            ListNode temp = new ListNode(sum, null);

            if (res == null) {
                res = temp;
                pointer = res;
            } else {
                pointer.next = temp;
                pointer = pointer.next;
            }

        }
        if (carry > 0) {
            pointer.next = new ListNode(carry, null);
        }
        return res;
    }

}
