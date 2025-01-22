//给定一个链表的第一个节点head，找到链表中所有出现多于一次的元素，并删除这些元素所在的节点。
//返回删除后的链表。

//思路：双指针，链表分解

/*
输入: head = [1,2,3,2]
输出: [1,3]
解释: 2 在链表中出现了两次，所以所有的 2 都需要被删除。删除了所有的 2 之后，我们还剩下 [1,3]。

输入: head = [2,1,1,2]
输出: []
解释: 2 和 1 都出现了两次。所有元素都需要被删除。

输入: head = [3,2,2,1,3,2,4]
输出: [1,4]
解释: 3 出现了两次，且 2 出现了三次。移除了所有的 3 和 2 后，我们还剩下 [1,4]。

提示：
链表中节点个数的范围是 [1, 105]
1 <= Node.val <= 105
*/

class Solution{
  public ListNode deleteDuplicatesUnsorted(ListNode head){
    HashMap<Integer, Integer> count = new HashMap<>();

    //先遍历一遍链表，记录每个值出现的次数
    ListNode p = head;
    while(p!=null){
      count.put(p.val, count.getOrDefault(p.val, 0)+1);
      p = p.next;
    }

    //将原链表分解为重复节点和无重节点
    ListNode dummyDup = new ListNode(-1);
    ListNode dummyUnique = new ListNode(-1);
    ListNode pDup = dummyDup;
    ListNode pUnique = dummyUnique;
    p = head;

    //开始分解链表
    while(p!=null){
      if(count.get(p.val)>1){
        pDup.next = p;
        pDup = pDup.next;
      }else{
        pUnique.next = p;
        pUnique = pUnique.next;
      }
      p = p.next;
      pDup.next = null;
      pUnique.next = null;
    }

  return dummyUnique.next;
  }
}
