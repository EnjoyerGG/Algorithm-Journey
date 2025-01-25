//这里有 n 个航班，它们分别从 1 到 n 进行编号。
//有一份航班预订表 bookings ，表中第 i 条预订记录 bookings[i] = [firsti, lasti, seatsi] 意味着在从 firsti 到 lasti （包含 firsti 和 lasti ）的 每个航班 上预订了 seatsi 个座位。
//请你返回一个长度为 n 的数组 answer，里面的元素是每个航班预定的座位总数。

/*
输入：bookings = [[1,2,10],[2,3,20],[2,5,25]], n = 5
输出：[10,55,45,25,25]
解释：
航班编号        1   2   3   4   5
预订记录 1 ：   10  10
预订记录 2 ：       20  20
预订记录 3 ：       25  25  25  25
总座位数：      10  55  45  25  25
因此，answer = [10,55,45,25,25]

输入：bookings = [[1,2,10],[2,2,15]], n = 2
输出：[10,25]
解释：
航班编号        1   2
预订记录 1 ：   10  10
预订记录 2 ：       15
总座位数：      10  25
因此，answer = [10,25]
*/

//复用Difference的类
class Solution{
  public int[] corpFlightBookings(int[][] bookings, int n){
    //nums初始化为全0
    int[] nums = new int[n];
    //构造差分解法
    Difference df = new Difference(nums);

    for(int[] booking : bookings){
      //转成数组索引要-1
      int i = booking[0] - 1;
      int j = booking[1] - 1;
      int val = booking[2];
      //对区间nums[i...j]增加val
      df.increment(i, j, val);
    }
    //返回最终的结果数组
    return df.result();
  }
}












