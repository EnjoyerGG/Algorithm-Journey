//题目：给定字符串 s 和字符串数组 words, 返回  words[i] 中是s的子序列的单词个数 。
//字符串的 子序列 是从原始字符串中生成的新字符串，可以从中删去一些字符(可以是none)，而不改变其余字符的相对顺序。
//例如， “ace” 是 “abcde” 的子序列。

/*
输入: s = "abcde", words = ["a","bb","acd","ace"]
输出: 3
解释: 有三个是 s 的子序列的单词: "a", "acd", "ace"。

输入: s = "dsahjpjauf", words = ["ahjpjau","ja","ahbwzgqnuk","tnmlanowax"]
输出: 2
*/

//思路：二分，先把 s 中的字符预处理一下，把每个字符出现的的索引列表算出来

class Solution{
  public int numMatchingSubseq(String s, String[] words){
    //对s进行预处理，记录char->该char的索引列表
    ArrayList<Integer>[] charToIndexes = new ArrayList[256];
    for(int i=0; i<s.length; i++){
      char c = s.charAt(i);
      if(charToIndexes[c]==null){
        charToIndexes[c] = new ArrayList<>();
      }
      charToIndexes[c].add(i);
    }

    int res = 0;
    for(String word : words){
      //字符串word上的指针i
      int i = 0;
      //字符串s上的指针j
      int j = 0;
      //现在判断word是否是s的子序列
      //借助charToIndexes查找word中每个字符串在s中的索引
      while(i<word.length()){
        char c = word.charAt(i);
        //整个s压根没有字符word[i]
        if(chatToIndexes[c]==null){
          break;
        }
        
        //二分搜索大于等于 j 的最小索引
        //即在 s[j..] 中搜索等于 word[i] 的最小索引
        int pos = left_bound(charToIndexes[c], j);
        if(pos==charToIndexes[c].size()){
          break;
        }
        j = charToIndexes[c].get(pos);
        //如果找到，即 word[i] == s[j]，继续往后匹配
        j++;
        i++;
      }
      //如果word完成匹配，则是s的子序列
      if(i==word.length()){
        res++;
      }
    }
    return res;
  }

  //查找左侧边界的二分查找
  int left_bound(ArrayList<Integer> arr, int target){
    int left = 0;
    int right = arr.size();
    while (left < right) {
        int mid = left + (right - left) / 2;
        if (target > arr.get(mid)) {
            left = mid + 1;
        } else {
            right = mid;
        }
    }
    return left;
  }
}
















  
