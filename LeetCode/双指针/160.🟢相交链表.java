//题目：给你两个单链表的头节点 headA 和 headB。
//请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
//题目数据保证整个链式结构中不存在环。
//注意，函数返回结果后，链表必须 保持其原始结构 。

//思路：双指针

/*
intersectVal - 相交的起始节点的值。如果不存在相交节点，这一值为 0
listA - 第一个链表
listB - 第二个链表
skipA - 在 listA 中（从头节点开始）跳到交叉节点的节点数
skipB - 在 listB 中（从头节点开始）跳到交叉节点的节点数

输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
输出：Intersected at '8'
解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。

输入：intersectVal = 2, listA = [1,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
输出：Intersected at '2'
解释：相交节点的值为 2 （注意，如果两个链表相交则不能为 0）。

输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
输出：No intersection
解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。
由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
这两个链表不相交，因此返回 null 。
*/

//进阶：你能否设计一个时间复杂度 O(m + n) 、仅用 O(1) 内存的解决方案？

/*
如果用两个指针 p1 和 p2 分别在两条链表上前进，并不能同时走到公共节点，也就无法得到相交节点 c1。
解决这个问题的关键是，通过某些方式，让 p1 和 p2 能够同时到达相交节点 c1。
所以，我们可以让 p1 遍历完链表 A 之后开始遍历链表 B，让 p2 遍历完链表 B 之后开始遍历链表 A，这样相当于「逻辑上」两条链表接在了一起。
如果这样进行拼接，就可以让 p1 和 p2 同时进入公共部分，也就是同时到达相交节点 c1：
*/

class Solution{
  public ListNode getIntersectionNode(ListNode headA, ListNode headB){
    //p1指向A链表头结点，p2指向B链表头结点
    ListNode p1 = headA;
    ListNode p2 = headB;

    while(p1!=p2){
      //p1走一步，如果走到A链表末尾，转到B链表
      if(p1==null){
        p1 = headB;
      }else{
        p1 = p1.next;
      }

      //p2走一步，如果走到B链表末尾，转到A链表
      if(p2==null){
        p2 = headA;
      }else{
        p2 = p2.next;
      }
    }
    
    return p1;
  }
}
