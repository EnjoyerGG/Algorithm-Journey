//题目：给你单链表的头结点 head ，请你找出并返回链表的中间结点。
//如果有两个中间结点，则返回第二个中间结点。

//思路：双指针，快慢指针

/*
输入：head = [1,2,3,4,5]
输出：[3,4,5]
解释：链表只有一个中间结点，值为 3 。

输入：head = [1,2,3,4,5,6]
输出：[4,5,6]
解释：该链表有两个中间结点，值分别为 3 和 4 ，返回第二个结点。

提示：
链表的结点数范围是 [1, 100]
1 <= Node.val <= 100
*/

class Solution{
  public ListNode middleNode(ListNode head){
    //快慢指针初始化指向head
    ListNode slow = head, fast = head;

  //快指针走到末尾时停止
  while(fast!=null && fast.next!=null){
    //慢指针走一步，快指针走两步
    slow = slow.next;
    fast = fast.next.next;
  }
  //慢指针走到中点
  return slow;
  }
}
