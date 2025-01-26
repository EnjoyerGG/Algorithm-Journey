//题目：给你一个字符串 s 和一个整数 k ，请你找出 s 中的最长子串， 要求该子串中的每一字符出现次数都不少于 k 。返回这一子串的长度。
//如果不存在这样的子字符串，则返回 0。

/*
输入：s = "aaabb", k = 3
输出：3
解释：最长子串为 "aaa" ，其中 'a' 重复了 3 次。

输入：s = "ababbc", k = 2
输出：5
解释：最长子串为 "ababb" ，其中 'a' 重复了 2 次， 'b' 重复了 3 次。
*/

/*
我们想尽可能多地装字符，即扩大窗口，但不知道什么时候应该开始收缩窗口。
为什么呢？比如窗口中有些字符出现次数不满足 k，但有可能再扩大扩大窗口就能满足 k 了呀？但要这么说的话，你干脆一直扩大窗口算了，所以你说不准啥时候应该收缩窗口。
理论上讲，这种情况就不能用滑动窗口模板了，但有时候我们可以自己添加一些约束，来进行窗口的收缩。
题目说让我们求每个字符都出现至少 k 次的子串，我们可以再添加一个约束条件：求每个字符都出现至少 k 次，仅包含 count 种不同字符的最长子串。

添加了字符种类的限制，我们就可以回答滑动窗口算法的三个灵魂问题了：
1、什么时候应该扩大窗口？窗口中字符种类小于 count 时扩大窗口。
2、什么时候应该缩小窗口？窗口中字符种类大于 count 时扩大窗口。
3、什么时候得到一个合法的答案？窗口中所有字符出现的次数都大于等于 k 时，得到一个合法的子串。
*/

class Solution{
  public int longestSubstring(String s, int k){
    int len = 0;
    for(int i=1; i<=26; i++){
      //限制窗口中只能有i种不同字符
      len = Math.max(len, logestKLetterSubstr(s, k, i));
    }
    return len;
  }

  //寻找s中含有count种字符，且每种字符出现次数都大于k的子串
  int logestKLetterSubstr(String s, int k, int count){
    //记录答案
    int res = 0;
    //快慢指针维护滑动窗口，左闭右开区间
    int left = 0;
    int right = 0;
    //题目说s中只有小写字母，所以用大小26的数组记录窗口中字符出现的次数
    int[] windowCount = new int[26];
    //记录窗口中存在几种不同的字符（字符种类）
    int windowUniqueCount = 0;
    //记录窗口中有几种字符的出现次数达标（大于等于k）
    int windowValidCount = 0;

    //滑动窗口代码
    while(right<s.length()){
      //移动字符，扩大窗口
      char c = s.charAt(right);
      if(windowCount[c-'a']==0){
        //窗口中新增了一种字符
        windowUniqueCount++;
      }
      windowCount[c-'a']++;
      if(windowCount[c-'a']==k){
        //窗口中新增了一种达标的字符
        windowUniqueCount++;
      }
      right++;

      //当窗口中字符种类大于count时，缩小窗口
      while(windowUniqueCount>count){
        //移出字符，缩小窗口
        char d = s.charAt(left);
        if(windowCount[d-'a']==k){
          //窗口中减少一种达标的字符
          windowValidCount--;
        }
        windowCount[d-'a']--;
        if(windowCount[d-'a']==0){
          //窗口中减少一种字符
          windowUniqueCount--;
        }
        left++;
      }

      //当窗口中字符种类为count且每个字符出现次数都满足k时，更新答案
      if(windowValidCount==count){
        res = Math.max(res, right-left);
      }
    }
    return res;
  }
}
      






