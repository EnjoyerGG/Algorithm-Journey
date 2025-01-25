//题目：给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。
//换句话说，s1 的排列之一是 s2 的 子串。

/*
输入：s1 = "ab" s2 = "eidbaooo"
输出：true
解释：s2 包含 s1 的排列之一 ("ba").

输入：s1= "ab" s2 = "eidboaoo"
输出：false
//输入的 s1 是可以包含重复字符的，所以这个题难度不小。
*/

class Solution{
  //判断s中是否存在t的排列
  public boolean checkInclusion(String t, String s){
    Map<Character, Integer> need = new HashMap<>();
    Map<Character, Integer> window = new HashMap<>();
    for(char c : t.toCharArray()){
      need.put(c, need.getOrDefault(c,0)+1);
    }

    int left = 0;
    int right = 0;
    int valid = 0;
    while(right<s.length()){
      char c = s.charAt(right);
      right++;
      //进行窗口内数据的一系列更新
      if(need.containsKey(c)){
        window.put(c, window.getOrDefault(c,0)+1);
        if(window.get(c).intValue() == need.get(c).intValue()) valid++;
      }

      //判断左侧窗口是否要收缩
      while(right-left>=t.length()){
        //在这里判断是否找到了合法的子串
        if(valid==need.size()) return true;
        char d = s.charAt(left);
        left++;
        //进行窗口内数据的一系列更新
        if(need.containsKey(d)){
          if(window.get(d).intValue() == need.get(d).intValue()) valid--;
          window.put(d, window.get(d)-1);
        }
      }
    }
    return false; //未找到符合条件的子串
  }
}











    
