//题目：如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，短语正着读和反着读都一样。则可以认为该短语是一个 回文串 。
//字母和数字都属于字母数字字符。
//给你一个字符串 s，如果它是 回文串 ，返回 true ；否则，返回 false。

/*
输入: s = "A man, a plan, a canal: Panama"
输出：true
解释："amanaplanacanalpanama" 是回文串。

输入：s = "race a car"
输出：false
解释："raceacar" 不是回文串。

输入：s = " "
输出：true
解释：在移除非字母数字字符之后，s 是一个空字符串 "" 。
由于空字符串正着反着读都一样，所以是回文串。
*/

//只要先把所有字符转化成小写，并过滤掉空格和标点这类字符。
//然后对剩下的字符执行 数组双指针技巧汇总 中提到的两端向中心的双指针算法即可。

class Solution{
  public boolean isPalindrome(String s){
    //先把所有字符转为小写，并且过滤掉空格和标点
    StringBuilder sb = new StringBuilder();
    for(int i=0; i<s.length(); i++){
      char c = s.charAt(i);
      if(Character.isLetterOrDigit(c)){
        sb.append(Character.toLowerCase(c));
      }
    }

    //然后对剩下这些目标字符执行双指针算法，判断回文串
    s = sb.toString();
    //一左一右两个指针相向而行
    int left = 0;
    int right = s.length()-1;
    while(left<right){
      if(s.charAt(left)!=s.charAt(right)){
        return false;
      }
      left++;
      right--;
    }
    return true;
  }
}
