/**
 * 第二题：两数相加
 *
 * 描述：
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/add-two-numbers

 *
 * 示例：

 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 输出：7 -> 0 -> 8
 原因：342 + 465 = 807

 *  答案参考大神github：https://github.com/qiyuangong/leetcode/tree/master/java
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);   //指向相加之和的链表指针
        ListNode p = l1;
        ListNode q = l2;
        ListNode curr = dummyHead;
        int carry = 0; //记录每个数位 进位的数值

        while (null != p || null != q){  //作为相加数的链表均为null时结束
            int x = (null != p) ? p.val : 0;
            int y = (null != q) ? q.val : 0;
            int digit = carry + x + y; //某一数位 = x + y + carry (carry为上一位的进位)

            carry = digit / 10; //获取下一位进位数值，'/'为向下整除
            curr.next = new ListNode(digit % 10);  //第三条新增一个NodeList节点
            curr = curr.next;

            if (null != p) p = p.next;
            if (null != q) q = q.next;
        }

        if(carry > 0) curr.next = new ListNode(carry);  //最后若进位还有数值，则将其作为最后的节点

        return dummyHead.next;    //返回
    }
}