//编写一个函数来查找字符串数组中的最长公共前缀。
//如果不存在公共前缀，返回空字符串 ""。

/*
输入：strs = ["flower","flow","flight"]
输出："fl"

输入：strs = ["dog","racecar","car"]
输出：""
解释：输入不存在公共前缀。
*/

class Solution{
  public String longestCommonPrefix(String[] strs){
    int m = strs.length;
    //以第一行的列数为基准
    int n = strs[0].length();

    for(int col=0; col<n; col++){
      for(int row=1; row<m; row++){
        String thisStr = strs[row];
        String prevStr = strs[row-1];
        //判断每个字符串的col索引是否都相同
        if(col>=thisStr.length() || col>=prevStr.legnth() || thisStr.charAt(col)!=prevStr.charAt(col)){
          //发现不匹配的字符，只有strs[row][0..col-1]是公共前缀
          return strs[row].substring(0, col);
        }
      }
    }
    return strs[0];
  }
}
