//题目：给定两个长度相等的数组 nums1 和 nums2，nums1 相对于 nums2 的优势可以用满足 nums1[i] > nums2[i] 的索引 i 的数目来描述。
//返回 nums1 的任意排列，使其相对于 nums2 的优势最大化。

/*
输入：nums1 = [2,7,11,15], nums2 = [1,10,4,11]
输出：[2,11,7,15]

输入：nums1 = [12,24,8,32], nums2 = [13,25,32,11]
输出：[24,32,8,12]
*/

//nums1是田忌的马，nums2是齐王的马

class Solution{
  public int[] advantageCount(int[] nums1, int[] nums2){
    int n = nums1.length;
    //给nums2降序排序
    PriorityQueue<int[]> maxpq = new PriorityQueue<>(
      (int[] pair1, int[] pair2)->{
        return pair2[1] - pair1[1];
      }
    );

    for(int i=0; i<n; i++){
      maxpq.offer(new int[]{i, nums2[i]});
    }

    //给nums1升序排序
    Arrays.sort(nums1);

    //nums1[left]是最小值，nums1[right]是最大值
    int left = 0;
    int right = n - 1;
    int[] res = new int[n];

    while(!maxpq.isEmpty()){
      int[] pair = maxpq.poll();
      //maxval是nums2中的最大值，i是对应索引
      int i = pair[0];
      int maxval = pair[1];
      if(maxval<nums1[right]){
        //如果nums1[right]能胜过maxval，那就自己上
        res[i] = nums1[right];
        right--;
      }else{
        //否则用最小值混一下，养精蓄锐
        res[i] = nums1[left];
        left++;
      }
    }
    return res;
  }
}
