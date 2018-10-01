/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * <p/>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p/>
 * Example:
 * <p/>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */
public class AddTwoNumbers {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode head = new ListNode(0);
        ListNode node = head;

        boolean isFlag = false;
        int sum;
        while (l1 != null && l2 != null) {
            if (isFlag) {
                sum = l1.val + l2.val + 1;
            } else {
                sum = l1.val + l2.val;
            }
            if (sum >= 10) {
                isFlag = true;
                sum = sum - 10;
            } else {
                isFlag = false;
            }
            ListNode nextNode = new ListNode(sum);
            node.next = nextNode;
            node = nextNode;

            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            if (isFlag) {
                sum = l1.val + 1;
            } else {
                sum = l1.val;
            }
            if (sum >= 10) {
                isFlag = true;
                sum = sum - 10;
            } else {
                isFlag = false;
            }

            ListNode nextNode = new ListNode(sum);
            node.next = nextNode;
            node = nextNode;
            l1 = l1.next;
        }

        while (l2 != null) {
            if (isFlag) {
                sum = l2.val + 1;
            } else {
                sum = l2.val;
            }
            if (sum >= 10) {
                isFlag = true;
                sum = sum - 10;
            } else {
                isFlag = false;
            }

            ListNode nextNode = new ListNode(sum);
            node.next = nextNode;
            node = nextNode;
            l2 = l2.next;
        }

        if (isFlag) node.next = new ListNode(1);

        return head.next;
    }



    public static void main(String[] args) {

        ListNode l1 = new ListNode(9);

        ListNode l2 = new ListNode(1);
        ListNode l21 = new ListNode(9);
        ListNode l22 = new ListNode(9);
        ListNode l23 = new ListNode(9);
        ListNode l24 = new ListNode(9);
        ListNode l25 = new ListNode(9);
        ListNode l26 = new ListNode(9);
        ListNode l27 = new ListNode(9);
        ListNode l28 = new ListNode(9);
        ListNode l29 = new ListNode(9);
        l2.next = l21;
        l21.next = l22;
        l22.next = l23;
        l23.next = l24;
        l24.next = l25;
        l25.next = l26;
        l26.next = l27;
        l27.next = l28;
        l28.next = l29;
        addTwoNumbers2(l1, l2);
    }

    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode p, dummy = new ListNode(0);
        p = dummy;
        while (l1 != null || l2 != null || carry != 0) {
            if (l1 != null) {
                carry += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                carry += l2.val;
                l2 = l2.next;
            }
            p.next = new ListNode(carry%10);
            carry /= 10;
            p = p.next;
        }
        return dummy.next;
    }
}
