//核心逻辑：不要每次都去一个字符一个字符地比较子串和模式串，而是维护一个滑动窗口，运用滑动哈希算法一边滑动一边计算窗口中字符串的哈希值，拿这个哈希值去和模式串的哈希值比较。
//这样就可以避免截取子串，从而把匹配算法降低为O(N)

//字符本质上就是编码，而编码其实就是数字。

//Rabin-Karp字符串查找算法
int rabinKarp(String txt, String pat){
  int L = pat.length(); //位数
  int R = 256; //进制
  long Q = 1658598167; //取一个大素数作为求模的除数
  int RL = 1; //存储R^(L-1)的结果
  for(int i=1; i<=L-1; i++){
    RL = (RL*R) % Q; //计算过程中不断取模，避免溢出
  }
  
  //计算模式串的哈希值，时间O(L)
  long patHash = 0; //计算模式串的哈希值
  for(int i=0; i<pat.length(); i++){
    patHash = (R*patHash + pat.charAt(i)) % Q;
}
  int windowHash = 0; //维护滑动窗口中字符串的哈希值


  //滑动窗口框架，时间O(N)
  int left = 0;
  int right = 0;
  while(right<txt.length()){
    //扩大窗口，移入字符，在最低位添加
    windowHash = ((R*windowHash) % Q + txt.charAt(right)) % Q;
    right++;

    //当子串长度达到要求
    if(right-left==L){
      //根据哈希值判断窗口中的子串是否匹配模式串pat
      if(patHash==windowHash){
          // 当前窗口中的子串哈希值等于模式串的哈希值
          // 还需进一步确认窗口子串是否真的和模式串相同，避免哈希冲突
          if (pat.equals(txt.substring(left, right))) {
          return left;
          }
      }

    //缩小窗口，移出字符，删除最高位数字
    windowHash = (windowHash - (txt.charAt(left) * RL) % Q + Q) % Q;
    // X % Q == (X + Q) % Q 是一个模运算法则
    // 因为 windowHash - (txt[left] * RL) % Q 可能是负数
    // 所以额外再加一个 Q，保证 windowHash 不会是负数
    left++;
  }
}
return -1; //未找到字符串
}
