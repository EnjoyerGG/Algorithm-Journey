//题目：给定一个已排序的链表的头head， 删除原始链表中所有重复数字的节点，只留下不同的数字。
//返回已排序的链表。

//思路：双指针，链表分解

/*
输入：head = [1,2,3,3,4,4,5]
输出：[1,2,5]

输入：head = [1,1,1,2,3]
输出：[2,3]

提示：
链表中节点数目在范围 [0, 300] 内
-100 <= Node.val <= 100
题目数据保证链表已经按升序 排列
*/

class Solution{
  public ListNode deleteDuplicates(ListNode head){
    //将原链表分解为两条链表
    //一条链表存放不重复的结点，另一条链表存放重复的结点
    //运用虚拟头结点技巧，题目说node.val<=100，用101作为虚拟头结点
    ListNode dummyUniq = new ListNode(101);
    ListNode dummyDup = new ListNode(101);

    ListNode pUniq = dummyUniq;
    ListNode pDup = dummyDup;
    ListNode p = head;

    while(p!=null){
      if((p.next!=null && p.val==p.next.val) || p.val==pDup.val){
        //发现重复结点，接到重复链表后面
        pDup.next = p;
        pDup = pDup.next;
      }else{
        //不是重复结点，接到不重复链表后面
        pUniq.next = p;
        pUniq = pUniq.next;
      }
      p = p.next;

      //将原链表和新链表断开
      pUniq.next = null;
      pDup.next = null;
    }
    return dummyUniq.next;
  }
}
