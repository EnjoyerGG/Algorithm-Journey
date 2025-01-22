//单元
class ListNode{
  int val;
  ListNode next;
  ListNode(int x){ val=x; }
}

/*
实际是这样：
class Node<E> {
    E val;
    Node<E> next;
    Node<E> prev;

    Node(Node<E> prev, E element, Node<E> next) {
        this.val = element;
        this.next = next;
        this.prev = prev;
    }
}
*/

//将数组转换为单链表
ListNode createLinkedList(int[] arr){
  if(arr==null || arr.length==0){ return null; }
  ListNode head = new ListNode(arr[0]);
  ListNode cur = head;
  for(int i=1; i<arr.length; i++){
    cur.next = new ListNode(arr[i]);
    cur = cur.next;
  }
  return head;
}

//创建新链表
ListNode head = createLinkedList(new int[]{1,2,3,4,5}); //1->2->3->4->5
//遍历单链表
for(ListNode p=head; p!=null; p=p.next){
  System.out.println(p.val);
}

//**增**
//在头部插入新节点0
ListNode newHead = new ListNode(0);
newHead.next = head;
head = newHead; //0->1->2->3->4->5

//在尾部插入新节点6
ListNode p = head;
while(p.next!=null){
  p = p.next; //走到最后一个节点
}
p.next = new ListNode(6); //0->1->2->3->4->5->6

//在第3个节点后插入新节点66
ListNode p = head;
for(int i=0; i<2; i++){
  p = p.next;
 } //此时指向第3个节点
ListNode newNode = new ListNode(66);
newNode.next = p.next;
p.next = newNode; //0->1->2->3->66->4->5->6


//**删**
ListNode head = createLinkedList(new int[]{1, 2, 3, 4, 5});
//删除第4个节点
ListNode p = head;
for(int i=0; i<2; i++){
  p = p.next;
} //此时p指向第3个节点
p.next = p.next.next; //把第4个节点从链表中摘除，此时为1->2->3->5

//删除最后一个元素
ListNode p = head;
while(p.next.next!=null){
  p = p.next;
} //找到倒数第二个节点
p.next = null; //1->2->3

//删除头节点
head = head.next; //2->3

//查改的操作和增删类似，就是走到指定的位置改变值
