//题目：珂珂喜欢吃香蕉。这里有 n 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，将在 h 小时后回来。
//珂珂可以决定她吃香蕉的速度 k （单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 k 根。如果这堆香蕉少于 k 根，她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉。  
//珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。
//返回她可以在 h 小时内吃掉所有香蕉的最小速度 k（k 为整数）

/*
输入：piles = [3,6,7,11], h = 8
输出：4

输入：piles = [30,11,23,4,20], h = 5
输出：30

输入：piles = [30,11,23,4,20], h = 6
输出：23
*/

//1. f(x) 函数就可以这样定义：若吃香蕉的速度为 x 根/小时，则需要 f(x) 小时吃完所有香蕉。
//f(x)随着x的增加单调递减
long f(int[] piles, int x){
  long hours = 0;
  for(int i=0; i<piles.length; i++){
    hours += piles[i]/x;
    if(piles[i] % x > 0){ hours++; }
  }
  return hours;
}

//2. 找到 x 的取值范围作为二分搜索的搜索区间，初始化 left 和 right 变量。
//最小速度应该是 1，最大速度是 piles 数组中元素的最大值，因为每小时最多吃一堆香蕉，胃口再大也白搭嘛。
public int minEatingSpeed(int[] piles, int H){
  int left = 1;
  int right = 1000000000+1;
  //...
}

//3. 根据题目的要求，确定应该使用搜索左侧还是搜索右侧的二分搜索算法，写出解法代码
//也就是 x 要尽可能小, 就是搜索左侧边界的二分搜索
class Solution{
  public int minEatingSpeed(int[] piles, int H){
    int left = 1;
    int right = 100000000+1;
    while(left<right){
      int mid = left + (right-left)/2;
      if(f(piles, mid)==H){
        right = mid; //搜索左侧边界，需要收缩右侧边界
      }else if(f(piles, mid)<H){
        right = mid; //让f(x)返回值大一些
      }else if(f(piles, mid)>H){
        left = mid + 1; //让f(x)的返回值小一些
      }
    }
    return left;
  }
}


//完整代码
class Solution{
  public int minEatingSpeed(int[] piles, int H){
    int left = 1;
    int right = 1000000000 + 1;

    while(left<right){
      int mid = left + (right-left)/2;
      if(f(piles, mid) <= H){
        right = mid;
      }
      else{
        left = mid + 1;
      }
    }
    return left;
  }

  //f(x)随着x的增肌单调递减
  long f(int[] piles, int x){
    long hours = 0;
    for(int i=0; i<piles.length; i++){
      hours += piles[i]/x;
      if(piles[i] % x > 0){
        hours++;
      }
    }
    return hours;
  }
}
    
