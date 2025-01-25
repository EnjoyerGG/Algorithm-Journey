//滑动窗口算法技巧的思路也不难，就是维护一个窗口，不断滑动，然后更新答案
int left = 0;
int right = 0;

//指针 left, right 不会回退（它们的值只增不减）,，所以字符串/数组中的每个元素都只会进入窗口一次，然后被移出窗口一次，不会说有某些元素多次进入和离开窗口.
//所以算法的时间复杂度就和字符串/数组的长度成正比。
//反观嵌套 for 循环的暴力解法，那个 j 会回退，所以某些元素会进入和离开窗口多次，所以时间复杂度就是 O(N^2)了。
while(right < nums.size()){
  //增大窗口
  window.addLast(nums[right]);
  right++;

  while(window needs shrink){
    //缩小窗口
    window.removeFirst(nums[left]);
    left++;
  }
}
