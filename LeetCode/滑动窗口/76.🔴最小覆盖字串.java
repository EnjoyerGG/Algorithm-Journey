//题目：给你一个字符串 s 、一个字符串 t 。
//返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
/*
注意：
对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
如果 s 中存在这样的子串，我们保证它是唯一的答案。
*/

/*
输入：s = "ADOBECODEBANC", t = "ABC"
输出："BANC"
解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。

输入：s = "a", t = "a"
输出："a"
解释：整个字符串 s 是最小覆盖子串。

输入: s = "a", t = "aa"
输出: ""
解释: t 中两个字符 'a' 均应包含在 s 的子串中，
因此没有符合条件的子字符串，返回空字符串。

提示：
m == s.length
n == t.length
1 <= m, n <= 105
s 和 t 由英文字母组成

进阶：你能设计一个在 o(m+n) 时间内解决此问题的算法吗？
*/


//关键：开窗口，左闭右开
//我们先不断地增加 right 指针扩大窗口 [left, right)，直到窗口中的字符串符合要求（包含了 T 中的所有字符）。
//此时，我们停止增加 right，转而不断增加 left 指针缩小窗口 [left, right)，直到窗口中的字符串不再符合要求（不包含 T 中的所有字符了）。同时，每次增加 left，我们都要更新一轮结果。
//重复第 2 和第 3 步，直到 right 到达字符串 S 的尽头。

class Solution{
  public String minWindow(String s, String t){
    //记录所需字符出现次数
    Map<Character, Integer> need = new HashMap<>();
    //记录window中的字符出现次数
    Map<Character, Integer> window = new HashMap<>();
    for(char c : t.toCharArray()){
      need.put(c, need.getOrDefault(c, 0)+1);
    }

    int left = 0;
    int right = 0;
    int valid = 0;
    //记录最小覆盖子串的起始索引以及长度
    int start = 0;
    int len = Integer.MAX_VALUE;
    while(right<s.length){
      //c是将移入窗口的字符
      char c = s.charAt(right);
      //扩大窗口
      right++;
      //进行窗口内数据的一系列更新
      if(need.containsKey(c)){
        window.put(c, window.getOrDefault(c, 0)+1);
        if(window.get(c).equals(need.get(c))) valid++; //对 Java 包装类进行比较时要尤为小心，Integer，String 等类型应该用 equals 方法判定相等，而不能直接用等号 ==，否则会出错。
      }

      //判断左侧窗口是否要收缩
      while(valid==need.size()){
        //在这里更新最小覆盖子串
        if(right-left<len){
          start = left;
          len = right - left;
        }
        //d是将移出窗口的字符
        char d = s.charAt(left);
        //缩小窗口
        left++;
        //进行窗口内数据的一系列更新
        if(need.containsKey(d)){
          if(window.get(d).equals(need.get(d))) valid--;
          window.put(d, window.get(d)-1);
        }
      }
    }
    //返回最下覆盖子串
    return len == Integer.MAX_VALUE ? "" : s.substring(start, start+len);
  }
}
    

















