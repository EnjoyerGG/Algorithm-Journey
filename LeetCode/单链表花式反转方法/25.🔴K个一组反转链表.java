//题目：给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
//k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
//你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。

//其实只要运用一下「分解问题」的思维，然后直接复用前面的 reverseN 函数就行了。

/*
输入：head = [1,2,3,4,5], k = 2
输出：[2,1,4,3,5]

输入：head = [1,2,3,4,5], k = 3
输出：[3,2,1,4,5]

提示：
链表中的节点数目为 n
1 <= k <= n <= 5000
0 <= Node.val <= 1000
进阶：你可以设计一个只用 O(1) 额外内存空间的算法解决此问题吗？
*/

class Solution{
  public ListNode reverseKGroup(ListNode head, int k){
    if(head==null) return null;
    //区间[a,b)包含k个待反转元素
    ListNode a,b;
    a = b = head;
    
    for(int i=0; i<k; i++){
      //不足k个，不需要反转了
      if(b==null) return head;
      b = b.next;
    }

    //反转前k个元素
    ListNode newHead = reverseN(a,k);
    //此时b指向下一组待反转的头结点
    //递归反转后续链表并连接起来
    a.next = reverseKGroup(b,k);
    return newHead;
  }

  //实现反转前N个节点的函数
  ListNode reverseN(ListNode head, int n){
    if(head==null || head.next==null）{ return head; }
    ListNode pre, cur, nxt;
    pre = null;
    cur = head;
    nxt = head.next;
    while(n>0){
      cur.next = pre;
      pre = cur;
      cur = nxt;
      if(nxt!=null){ nxt = nxt.next; }
      n--;
    }
    head.next = cur;
    return pre;
  }
}

    

  
