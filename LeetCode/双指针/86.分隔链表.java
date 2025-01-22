//题目：给你一个链表的头节点head和一个特定值x，请你对链表进行分隔，使得所有小于x的节点都出现在大于或等于x的节点之前。
//你应当保留两个分区中每个节点的初始相对位置。

//难度：中等
//思路：双指针

/*
输入：head = [1,4,3,2,5,2], x = 3
输出：[1,2,2,4,3,5]

输入：head = [2,1], x = 2
输出：[1,2]

提示：
链表中节点的数目在范围 [0, 200] 内
-100 <= Node.val <= 100
-200 <= x <= 200
*/

class Solution{
  public ListNode partition(ListNode head, int x){
    //存放小于x的链表的虚拟头结点
    ListNode dummy1 = new ListNode(-1);
    //存放大于等于x的链表的虚拟头结点
    ListNode dummy2 = new ListNode(-1);
    //p1和p2指针负责生成结果链表
    ListNode p1 = dummy1;
    ListNode p2 = dummy2;
    ListNode p = head; //p负责遍历链表

    while(p!=null){
      if(p.val>=x){
        p2.next = p;
        p2 = p2.next;
      }else{
        p1.next = p;
        p1 = p1.next;
      }

      //不能让p直接前进，必须断开原链表每个节点的next指针，避免成环
      ListNode temp = p.next;
      p.next = null;
      p = temp;
    }

    //链接两个链表
    p1.next = dummy2.next;

    return dummy1.next;
  }
}
      
