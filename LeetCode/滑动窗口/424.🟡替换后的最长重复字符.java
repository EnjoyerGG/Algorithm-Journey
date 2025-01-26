//题目：给你一个字符串 s 和一个整数 k 。你可以选择字符串中的任一字符，并将其更改为任何其他大写英文字符。该操作最多可执行 k 次。
//在执行上述操作后，返回 包含相同字母的最长子字符串的长度。

/*
输入：s = "ABAB", k = 2
输出：4
解释：用两个'A'替换为两个'B',反之亦然。

输入：s = "AABABBA", k = 1
输出：4
解释：
将中间的一个'A'替换为'B',字符串变为 "AABBBBA"。
子串 "BBBB" 有最长重复字母, 答案为 4。
可能存在其他的方法来得到同样的结果。
*/

class Solution{
  public int characterReplacement(String s, int k){
    int left = 0;
    int right = 0;
    //统计窗口中每个字符的出现次数
    int[] windowCharCount = new int[26];

    //记录窗口中字符发最多重复次数
    //记录这个值的意义在于，最划算的替换方法肯定时把其他字符题替换为出现次数最多的那个字符
    int windowMaxCount = 0;
    //记录结果长度
    int res = 0;

    //模板
    while(right<s.length){
      //扩大窗口
      int c = s.charAt(right) - 'A';
      windowCharCount[c]++;
      windowMaxCount = Math.max(windowMaxCount, windowCharCount[c]);
      right++;

      while(right-left-windowMaxCount>k){
        // 杂牌字符数量 right - left - windowMaxCount 多于 k
        // 此时，k 次替换已经无法把窗口内的字符都替换成相同字符了
        // 必须缩小窗口
        windowCharCount[s.charAt(left) - 'A']--;
        left--;
      }
      //经过收缩后，此时一定是一个合法的窗口
      res = Math.max(res, right-left);
    }
    return res;
  }
}









      
