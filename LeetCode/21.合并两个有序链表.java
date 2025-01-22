//题目：将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
//简单
//思路：双指针

/*
输入：l1 = [1,2,4], l2 = [1,3,4]
输出：[1,1,2,3,4,4]
示例 2：

输入：l1 = [], l2 = []
输出：[]
示例 3：

输入：l1 = [], l2 = [0]
输出：[0]

提示：
两个链表的节点数目范围是 [0, 50]
-100 <= Node.val <= 100
l1 和 l2 均按 非递减顺序 排列
*/


//定义单个链表单元而不是用数组来存储链表的值和next指针
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */

//函数签名
ListNode mergeTwoLists(ListNode l1, ListNode l2);

class Solution{
  public ListNode mergeTwoLists(ListNode l1, ListNode l2){
    //创建虚拟头结点
    ListNode dummy = new ListNode(-1);
    ListNode p = dummy; //用于存储排列后的链表
    ListNode p1 = l1, p2 = l2;

    while(p1 != null && p2 != null){
      //比较p1和p2两个指针
      //将值较小的节点放到p指针
      if(p1.val > p2.val){
        p.next = p2;
        p2 = p2.next;
      }else{
        p.next = p1;
        p1 = p1.next;
      }
      //p指针前进
      p = p.next;
    }

    if(p1 != null){
      p.next = p1;
    }
    if(p2 != null){
      p.next = p2;
    }

    return dummy.next; //dummy.next才是第一个有效节点，dummy本身是虚拟节点
  }
}

