//题目：给你一个链表数组，每个链表都已经按升序排列。
//请你将所有链表合并到一个升序链表中，返回合并后的链表。

//思路：双指针

/*
输入：lists = [[1,4,5],[1,3,4],[2,6]]
输出：[1,1,2,3,4,4,5,6]
解释：链表数组如下：
[
  1->4->5,
  1->3->4,
  2->6
]
将它们合并到一个有序链表中得到。
1->1->2->3->4->4->5->6

输入：lists = []
输出：[]

输入：lists = [[]]
输出：[]

提示：
k == lists.length
0 <= k <= 10^4
0 <= lists[i].length <= 500
-10^4 <= lists[i][j] <= 10^4
lists[i] 按 升序 排列
lists[i].length 的总和不超过 10^4
*/

//难点在于，如何快速得到 k 个节点中的最小节点接到结果链表上
class Solution{
  public ListNode mergeKLists(ListNode[] lists){
    if(lists.length==0) return null;

    ListNode dummy = new ListNode(-1);
    ListNode p = dummy;

    //优先级队列，最小堆
    PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, (a,b)->(a.val, b.val));
    //将k个链表的头结点加入最小堆
    for(ListNode head : lists){
      if(head!=null){
        pq.add(head);
      }
    }

    while(!pq.isEmpty()){
      //获取最小节点，接到结果链表中
      ListNode node = pq.poll();
      p.next = node;
      if(node.next!=null){
        pq.add(node.next);
      }
      //p指针前进
      p = p.next;
    }
    return dummy.next;
  }
}

/*
优先队列pq中的元素个数最多是k，所以一次poll或者add方法的时间复杂度是O(logk)；
所有的链表节点都会被加入和弹出pq，所以算法整体的时间复杂度是 O(Nlogk)，其中 k是链表的条数，N是这些链表的节点总数。
*/
