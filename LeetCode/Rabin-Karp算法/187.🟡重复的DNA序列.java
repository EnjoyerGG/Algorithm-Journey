//题目：DNA序列 由一系列核苷酸组成，缩写为 'A', 'C', 'G' 和 'T'.。
//例如，"ACGAATTCCG" 是一个 DNA序列 。
//在研究 DNA 时，识别 DNA 中的重复序列非常有用。
//给定一个表示 DNA序列 的字符串 s ，返回所有在 DNA 分子中出现不止一次的 长度为 10 的序列(子字符串)。你可以按 任意顺序 返回答案。

/*
输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
输出：["AAAAACCCCC","CCCCCAAAAA"]

输入：s = "AAAAAAAAAAAAA"
输出：["AAAAAAAAAA"]
*/

//滑动窗口框架进行解题
//数字最高位和最低位处理框架：
/*
// ****** 在最低位添加一个数字 ******
int number = 8264;
// number 的进制
int R = 10;
// 想在 number 的最低位添加的数字
int appendVal = 3;
// 运算，在最低位添加一位
number = R * number + appendVal;
// 此时 number = 82643

// ****** 在最高位删除一个数字 ******
int number = 8264;
// number 的进制
int R = 10;
// number 最高位的数字
int removeVal = 8;
// 此时 number 的位数
int L = 4;
// 运算，删除最高位数字
number = number - removeVal * Math.pow(R, L-1);
// 此时 number = 264
*/

class Solution{
  public List<String> findRepeatedDnaSequences(String s){
    //先把字符串转化成四进制的数字数组
    int[] nums = new int[s.length()];
    for(int i=0; i<nums.length; i++){
      switch(s.charAt(i)){
        case 'A':
          nums[i] = 0;
          break;
        case 'G':
          nums[i] = 1;
          break;
        case 'C':
          nums[i] = 2;
          break;
        case 'T':
          nums[i] = 3;
          break;
      }
    }

    //记录重复出现的哈希值
    HashSet<Integer> seen = new HashSet<>();
    //记录重复出现的字符串结果
    HashSet<String> res = new HashSet<>();

    //数字位数
    int L = 10;
    //进制
    int R = 4;
    //存储R^(L-1)的结果
    int RL = (int)Math.pow(R, L-1);
    //维护滑动窗口中字符串的哈希值
    int windowHash = 0;

    //滑动窗口代码，时间O(N)
    int left = 0;
    int right = 0;
    while(right<nums.length){
      //扩大窗口，移入字符，并维护窗口哈希值（在最低位添加数字）
      windowHash = R*windowHash + nums[right];
      right++;

      //当字串长度达到要求
      if(right-left==L){
        //根据哈希值判断是否曾经出现过相同的子串
        if(seen.contains(windowHash)){
          //当窗口中的子串是重复出现的
          res.add(s.substring(left, right));
        }else{
          //当前窗口中的子串之前没有出现过，记下来
          seen.add(windowHash);
        }
        //缩小窗口，移出字符，并维护窗口的哈希值（删除最高位数字）
        windowHash = windowHash - nums[left]*RL;
        left++;
      }
    }

    //转化成题目要求的List类型
    return new LinkedList<>(res);
  }
}

















  
