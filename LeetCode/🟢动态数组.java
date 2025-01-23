//创建动态数组
ArrayList<Integer> arr = new ArrayList<>();

for(int i=0; i<10; i++){
  //在末尾填入元素，时间复杂度为O(1)
  arr.add();
}

//在2位置插入元素66，时间复杂度O(N)
arr.add(2, 66);

//在头部插入元素，时间复杂度O(N)
arr.add(0, -1);

//删除末尾元素，时间复杂度O(1)
arr.remove(arr.size()-1);

//删除中间元素，时间复杂读O(N)
arr.remove(2);

//根据索引查询元素，时间复杂度O(1)
int a = arr.get(0);

//根据索引修改元素，时间复杂度O(1)
arr.set(0, 100);

//根据元素值找索引，时间复杂度O(N)
int index = arr.indexOf(66);
