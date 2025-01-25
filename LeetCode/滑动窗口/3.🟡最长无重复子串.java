//题目：给定一个字符串 s ，请你找出其中不含有重复字符的 最长 子串 的长度。

/*
输入: s = "abcabcbb"
输出: 3 
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。

输入: s = "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。

输入: s = "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
*/

class Solution{
  public int lengthOfLongestSubstring(String s){
    Map<Character, Integer> window = new HashMap<>();
    int left = 0;
    int right = 0;
    //记录结果
    int res = 0;
    while(right<s.length()){
      char c = s.charAt(right);
      right++;
      //进行窗口内数据一系列更新
      window.put(c, window.getOrDefault(c,0)+1);
      
      //判断左侧窗口是否要收缩
      while(window.get(c)>1){ //当 window[c] 值大于 1 时，说明窗口中存在重复字符，不符合条件
        char d = s.charAt(left);
        left++;
        //进行窗口内数据的一系列更新
        window.put(d, window.get(d)-1);
      }
      //更新答案
      res = Math.max(res, right-left);
    }
    return res;
  }
}

//你只要能回答出来以下几个问题，就能运用滑动窗口算法：
//1、什么时候应该扩大窗口？
//2、什么时候应该缩小窗口？
//3、什么时候应该更新答案？
