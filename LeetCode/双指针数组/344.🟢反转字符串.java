//题目：编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
//不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。

//思路：双指针，反转数组

/*
输入：s = ["h","e","l","l","o"]
输出：["o","l","l","e","h"]

输入：s = ["H","a","n","n","a","h"]
输出：["h","a","n","n","a","H"]

提示：
1 <= s.length <= 105
s[i] 都是 ASCII 码表中的可打印字符
*/

class Solution{
  public void reverseString(char[] s){
    //一左一右两个指针相向而行
    int left = 0;
    int right = s.length-1;
    while(left<right){
      //交换s[left]和s[right]
      char tenp = s[left];
      s[left] = s[right];
      s[right] = temp;
      left++;
      right--;
    }
  }
