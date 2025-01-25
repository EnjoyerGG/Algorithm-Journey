//题目：给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
//异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。

/*
输入: s = "cbaebabacd", p = "abc"
输出: [0,6]
解释:
起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。

输入: s = "abab", p = "ab"
输出: [0,1,2]
解释:
起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
*/

//解说：相当于，输入一个串 S，一个串 T，找到 S 中所有 T 的排列，返回它们的起始索引。

class Solution{
  public List<Integer> findAnagrams(String s, String t){
    //默写模板
    Map<Character, Integer> need = new HashMap<>();
    Map<Character, Integer> window = new HashMap<>();
    for(char c : t.toCharArray()){
      need.put(c, need.getOrDefault(c, 0)+1);
    }

    int left = 0;
    int right = 0;
    int valid = 0;
    //记录结果
    List<Integer> res = new ArrayList<>();
    while(right<s.length()){
      char c = s.charAt(right);
      right++;
      //进行窗口内数据的一系列更新
      if(need.containsKey(c)){
        window.put(c, window.getOrDefault(c,0)+1);
        if(window.get(c).equals(need.get(c))) valid++;
      }
      //判断左侧窗口是否要收缩
      while(right-left>=t.length()){
        //当窗口符合条件，把起始索引加入res
        if(valid==need.size()) res.add(left);
        char d = s.charAt(left);
        left++;
        //进行窗口内数据的一系列更新
        if(need.containsKey(d)){
          if(window.get(d).equals(need.get(d))) valid--;
          window.put(d, window.get(d)-1);
        }
      }
    }
    return res;
  }
}

//与寻找字符串的排列一样，只是找到一个合法异位词（排列）之后将起始索引加入 res 即可。
