//给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。

/*
输入：head = [1,2,3,4,5]
输出：[5,4,3,2,1]

输入：head = [1,2]
输出：[2,1]

输入：head = []
输出：[]

提示：
链表中节点的数目范围是 [0, 5000]
-5000 <= Node.val <= 5000
*/

// 单链表节点的结构
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

//迭代做法🟢
public ListNode reverseList(ListNode head){
  if(head==null || head.next==null){ return head; }

  //对于单链表，至少要用三个指针才能完成迭代反转
  //cur是当前遍历的节点，pre是cur的前驱节点，nxt是cur的后继节点
  ListNode pre, cur, nxt;
  pre = null, cur = head, nxt = head.next;

  while(cur!=null){
    //逐个点反转
    cur.next = pre;
    //更新指针
    pre = cur;
    cur = nxt;
    if(nxt!=null){ nxt = nxt.next; }
  }
  return pre;
}

//递归做法🟡
/*
递归反转单链表的关键在于，这个问题本身是存在子问题结构的。
比方说，现在给你输入一个以 1 为头结点单链表 1->2->3->4，那么如果我忽略这个头结点 1，只拿出 2->3->4 这个子链表，它也是个单链表对吧？
那么你这个 reverseList 函数，只要输入一个单链表，就能给我反转对吧？那么你能不能用这个函数先来反转 2->3->4 这个子链表呢，然后再想办法把 1 接到反转后的 4->3->2 的最后面，是不是就完成了整个链表的反转？
//reverseList(1->2->3->4) = reverseList(2->3->4) -> 1
*/
public ListNode reverseList(ListNode head){
  if(head==null || head.next==null){ return head; }
  ListNode last = reverseList(head.next);
  head.next.next = head;
  head.next = null;
  return last;
}

//不建议陷入递归细节。
//值得一提的是，递归操作链表并不高效。
//递归解法和迭代解法相比，时间复杂度都是 O(N)，但是迭代解法的空间复杂度是 O(1)，而递归解法需要堆栈，空间复杂度是 O(N)。
//所以递归操作链表可以用来练习递归思维，但是考虑效率的话还是使用迭代算法更好。

