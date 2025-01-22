//题目：给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点，采用一趟扫描完成。

//思路：双指针，快慢指针

/*
输入：head = [1,2,3,4,5], n = 2
输出：[1,2,3,5]

输入：head = [1], n = 1
输出：[]

输入：head = [1,2], n = 1
输出：[1]

提示：
链表中结点的数目为 sz
1 <= sz <= 30
0 <= Node.val <= 100
1 <= n <= sz
*/

class Solution{
  //返回链表倒数第k个结点
  ListNode findFromEnd(ListNode head, int k){
    ListNode p1 = head; 
    //p1先走k步
    for(int i=0; i<k; i++){
      p1 = p1.next;
    }

    ListNode p2 = head;
    //p1和p2同时走n-k步
    while(p1!=null){
      p2 = p2.next;
      p1 = p1.next;
    }
    //p2现在指向第 n-k+1 个结点，即倒数第k个结点
    return p2;
  }

  public ListNode removeNthFromEnd(ListNode head, int n){
    ListNode dummy = new ListNode(-1);
    dummy.next = head;
    //删除倒数第n个，先要找到倒数第n+1个结点
    ListNode x = findFromEnd(dummy, n+1);
    //删除倒数第n个结点
    x.next = x.next.next;
    return dummy.next;
  }
}
