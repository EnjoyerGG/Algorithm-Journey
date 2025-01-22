//题目：给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。
//请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表。

/*
输入：head = [1,2,3,4,5], left = 2, right = 4
输出：[1,4,3,2,5]

输入：head = [5], left = 1, right = 1
输出：[5]

提示：
链表中节点数目为 n
1 <= n <= 500
-500 <= Node.val <= 500
1 <= left <= right <= n
进阶： 你可以使用一趟扫描完成反转吗？
*/

//迭代解法🟡
public ListNode reverseBetween(ListNode head, int m, int n){
  if(m==1){ return reverseN(head,n); }
  //找到第m个节点的前驱
  ListNode pre = head;
  for(int i=1; i<m-1; i++){
    pre = pre.next;
  }
  //从第m个节点开始反转
  pre.next = reverseN(pre.next, n-m+1);
  return head;
}

ListNode reverseN(ListNode head, int n){ //反转前N个节点的模板
  if(head==null || head.next==null){ return head; }
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
  //此时的cur是第n+1个节点，head是反转后的尾节点
  head.next = cur;
  //此时的pre是反转后的头结点
  return pre;
}

//递归解法🔴
public ListNode reverseBetween(ListNode head, int m, int n) {
    // base case
    if (m == 1) {
    return reverseN(head, n);
    }
    // 前进到反转的起点触发 base case
    head.next = reverseBetween(head.next, m - 1, n - 1);
    return head;
  }

  //后驱节点
  ListNode successor = null;

  //反转以head为起点的第n个节点，返回新的头结点
  ListNode reverseN(ListNode head, int n){
    if(n==1){
      //记录第n+1个节点
      successor = head.next;
      return head;
    }
    ListNode last = reverseN(head.next, n-1);
    head.next.next = head;
    head.next = successor;
    return last;
  }
}
