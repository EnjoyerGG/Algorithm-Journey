//题目：给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true；否则，返回 false。
//关键：单链表无法倒着遍历，无法使用双指针技巧。

/*
输入：head = [1,2,2,1]
输出：true

输入：head = [1,2]
输出：false

提示：
链表中节点数目在范围[1, 105] 内
0 <= Node.val <= 9
进阶：你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
*/

//图片显示：https://labuladong.online/algo/images/palindrome-list/1.jpg
//https://labuladong.online/algo/images/palindrome-list/2.jpg
//https://labuladong.online/algo/images/kgroup/8.gif

class Solution{
  public boolean isPalindrome(ListNode head){
    //先找到链表的中点，slow所在位置
    ListNode slow, fast;
    slow = fast = head;
    while(fast!=null && fast.next!=null){
      slow = slow.next;
      fast = fast.next.next;
    }

    //可要可不要
    if(fast!=null){
      slow = slow.next;
    }

    //从slow开始反转后面的链表，开始比较回文串
    ListNode left = head;
    ListNode reversedHalf = reverse(slow); //反转链表后半部分
    ListNode right = reversedHalf;

    boolean isPalindrome = true; //检查是否为回文链表
    while(right!=null){
      if(left.val!=right.val){
        isPalindrome = false;
        break;
      }
      left = left.next;
      right = right.next;
    }
    //恢复链表原始结构
    reverse(reversedHalf);
    return isPalindrome;
  }

  //反转链表的方法
  ListNode reverse(ListNode head){
    ListNode pre = null;
    ListNode cur = head;
    while(cur!=null){
      ListNode next = cur.next;
      cur.next = pre;
      pre = cur;
      cur = next;
    }
    return pre;
  }
}




  
