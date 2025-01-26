//题目：给你一个字符串 s 和一个整数 k ，请你找出 至多 包含 k 个 不同 字符的最长子串，并返回该子串的长度。

/*
输入：s = "eceba", k = 2
输出：3
解释：满足题目要求的子串是 "ece" ，长度为 3 。

输入：s = "aa", k = 1
输出：2
解释：满足题目要求的子串是 "aa" ，长度为 2 。
*/

class Solution{
  public int lengthOfLongestSubstringKDistinct(String s, int k){
    int left = 0;
    int right = 0;
    //用于记录窗口内不同字符的个数
    HashMap<Character, Integer> windowCount = new HashMap<>();
    int res = 0;

    while(right<s.length()){
      //扩大窗口，更行窗口数据
      char c = s.charAt(right);
      windowCount.put(c, windowCount.getOrDefault(c,0)+1);
      right++;

      while(left<right && windowCount.size()>k){
        //缩小窗口，更新窗口数据
        char d = s.charAt(left);
        windowCount.put(d, windowCount.get(d)-1);
        if(windowCount.get(d)==0){
          //注意要把键remove掉，因为我们以靠键的数量判断窗口内不同字符的个数
          windowCount.remove(d);
        }
        left++;
      }
      //此处windowCount.size()<=k, 更新答案
      res = Math.max(res, right-left);
    }
    return res;
  }
