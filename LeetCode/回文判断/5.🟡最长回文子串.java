//题目：给你一个字符串 s，找到 s 中最长的 回文 子串。

//思路：双指针

/*
输入：s = "babad"
输出："bab"
解释："aba" 同样是符合题意的答案。

输入：s = "cbbd"
输出："bb"

提示：
1 <= s.length <= 1000
s 仅由数字和英文字母组成
*/

//难点在于，回文串的的长度可能是奇数也可能是偶数，解决该问题的核心是从中心向两端扩散的双指针技巧。
//如果回文串的长度为奇数，则它有一个中心字符；如果回文串的长度为偶数，则可以认为它有两个中心字符。

class Solution{
  //在s中寻找以s[l]和s[r]为中序的最长回文串
  public String palindrome(String s, int l, int r){
    //防止索引越界
    while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
      //双指针，两边展开
      l--;
      r++;
    }
    //返回以s[l]和s[r]为中心的最长回文串
    return s.substring(l+1, r);
  }

  public String longestPalindrome(String s){
    String res = "";
    for(int i=0; i<s.length(); i++){
      //以s[i]为中心的最长回文字符串
      String s1 = palindrome(s, i, j);
      //以s[i]和s[i+1]为中心的最长回文串
      String s2 = palindrome(s, i, j+1);
      
      res = res.length() > s1.length() ? res : s1;
      res = res.length() > s2.length() ? res : s2;
    }
    return res;
  }
}

//最长回文子串使用的左右指针和之前题目的左右指针有一些不同：
//之前的左右指针都是从两端向中间相向而行，而回文子串问题则是让左右指针从中心向两端扩展。
//不过这种情况也就回文串这类问题会遇到，所以我也把它归为左右指针了。
  
