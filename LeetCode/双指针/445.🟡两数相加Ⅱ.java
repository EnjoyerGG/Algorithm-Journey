//题目：给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
//你可以假设除了数字 0 之外，这两个数字都不会以零开头。
//这是正向加减，相对于Ⅰ困难一些

//思路：双指针

/*
输入：l1 = [7,2,4,3], l2 = [5,6,4]
输出：[7,8,0,7]

输入：l1 = [2,4,3], l2 = [5,6,4]
输出：[8,0,7]

输入：l1 = [0], l2 = [0]
输出：[0]

提示：
链表的长度范围为 [1, 100]
0 <= node.val <= 9
输入数据保证链表代表的数字无前导 0

进阶：如果输入链表不能翻转该如何解决？
*/

//不进行链表反转
class Solution{
  public ListNode addTwoNumbers(ListNode l1, ListNode l2){
    //把链表元素转入栈中
    Stack<Integer> stk1 = new Stack<>();
    while(l1!=null){
      stk1.push(l1.val);
      l1 = l1.next;
    }

  Stack<Integer> stk2 = new Stack<>();
  while(l2!=null){
    stk2.push(l2.val);
    l2 = l2.next;
  }

  //接下来就是沿用第2题的逻辑
  //虚拟头结点
  ListNode dummy = new ListNode(-1);
  //记录进位
  int carry = 0;
  //开始执行加法，两条链表走完且没有进位时才能结束循环
  while(!stk1.isEmpty() || !stk2.isEmpty() || carry>0){
    //先加上上次的进位
    int val = carry;
    if(!stk1.isEmpty()){
      val += stk1.pop();
    }
    if(!stk2.isEmpty()){
      val += stk2.pop();
    }
    //处理进位情况
    carry = val/10;
    val = val%10;
    //构建新结点，直接接在dummy后
    ListNode newNode = new ListNode(val);
    newNode.next = dummy.next;
    dummy.next = newNode;
  }
  return dummy.next;
  }
}
