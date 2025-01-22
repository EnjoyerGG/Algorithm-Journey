//题目：给你两个非空的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
//请你将两个数相加，并以相同形式返回一个表示和的链表。
//你可以假设除了数字 0 之外，这两个数都不会以 0 开头。

思路：双指针，链表运算

/*
输入：l1 = [2,4,3], l2 = [5,6,4]
输出：[7,0,8]
解释：342 + 465 = 807.

输入：l1 = [0], l2 = [0]
输出：[0]

输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
输出：[8,9,9,9,0,0,0,1]

提示：
每个链表中的节点数在范围 [1, 100] 内
0 <= Node.val <= 9
题目数据保证列表表示的数字不含前导零
*/

/*
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */

class Solution{
  public ListNode addTwoNumbers(ListNode l1, ListNode l2){
    //在两条链表上的指针
    ListNode p1 = l1;
    ListNode p2 = l2;
    //虚拟头节点，构建新链表时的常用技巧
    ListNode dummy = new ListNode(-1);
    //指针p负责构建新链表
    ListNode p = dummy;
    //记录进位
    int carry = 0;

    //开始执行加法，两条链表走完并且没有进位时才能结束循环
    while(p1!=null || p2!=null || carry>0){
      //加上上次的进位
      int val = carry;
      if(p1!=null){
        val += p1.val;
        p1 = p1.next;
      }
      if(p2!=null){
        val += p2.val;
        p2 = p2.next;
      }

      //处理进位情况
      carry = val/10;
      val = val%10;
      //构建新节点
      p.next = new ListNode(val);
      p = p.next;
    }
    return dummy.next;
  }
}
    
