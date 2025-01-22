//题目：给你一个整数n，请你找出并返回第n个丑数。
//丑数就是质因子只包含 2、3 和 5 的正整数。

//思路：双指针，链表合并

/*
输入：n = 10
输出：12
解释：[1, 2, 3, 4, 5, 6, 8, 9, 10, 12] 是由前 10 个丑数组成的序列。

输入：n = 1
输出：1
解释：1 通常被视为丑数。
*/

//其实就是想把这三条「有序链表」合并在一起并去重，合并的结果就是丑数的序列。
//然后求合并后的这条有序链表中第 n 个元素是什么。

class Solution{
  public int nthUglyNumber(int n){
    //可以理解为三个指向有序链表头结点的指针
    int p2 = 1;
    int p3 = 1;
    int p5 = 1;
    //可以理解为三个有序链表的头结点的值
    int product2 = 1;
    int product3 = 1;
    int product5 = 1;
    //最终合并的有序链表(结果链表)
    int[] ugly = new int[n+1];
    //可以理解为结果链表上的指针
    int p = 1;

    //开始合并三个有序链表
    while(p<=n){
      //取三个链表的最小结点
      int min = Math.min(Math.min(product2, product3), product5);
      //接到结果链表上
      ugly[p] = min;
      p++;

      //前进对于有序链表上的指针
      if(min==product2){
        product2 = 2*ugly[p2];
        p2++;
      }
      if(min==product3){
        product3 = 3*ugly[p3];
        p3++;
      }
      if(min==product5){
        product5 = 5*ugly[p5];
        p5++;
      }
    }
    //返回第n个丑数
    return ugly[n];
  }
}





  
