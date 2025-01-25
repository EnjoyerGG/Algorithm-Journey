//题目：请你实现一个「数字乘积类」ProductOfNumbers，要求支持下述两种方法：
//1. add(int num) 将数字 num 添加到当前数字列表的最后面。
//2. getProduct(int k) 返回当前数字列表中，最后 k 个数字的乘积。
//你可以假设当前列表中始终 至少 包含 k 个数字。
//题目数据保证：任何时候，任一连续数字序列的乘积都在 32-bit 整数范围内，不会溢出。

/*
输入：
["ProductOfNumbers","add","add","add","add","add","getProduct","getProduct","getProduct","add","getProduct"]
[[],[3],[0],[2],[5],[4],[2],[3],[4],[8],[2]]

输出：
[null,null,null,null,null,null,20,40,0,null,32]

解释：
ProductOfNumbers productOfNumbers = new ProductOfNumbers();
productOfNumbers.add(3);        // [3]
productOfNumbers.add(0);        // [3,0]
productOfNumbers.add(2);        // [3,0,2]
productOfNumbers.add(5);        // [3,0,2,5]
productOfNumbers.add(4);        // [3,0,2,5,4]
productOfNumbers.getProduct(2); // 返回 20 。最后 2 个数字的乘积是 5 * 4 = 20
productOfNumbers.getProduct(3); // 返回 40 。最后 3 个数字的乘积是 2 * 5 * 4 = 40
productOfNumbers.getProduct(4); // 返回  0 。最后 4 个数字的乘积是 0 * 2 * 5 * 4 = 0
productOfNumbers.add(8);        // [3,0,2,5,4,8]
productOfNumbers.getProduct(2); // 返回 32 。最后 2 个数字的乘积是 4 * 8 = 32 
*/

//关键：前缀和和前缀积很类似，只不过乘积中如果有 0 需要特殊处理。

class ProductOfNumbers{
  //前缀积数组
  //preProduct[i]/preProduct[j]就是[i, j]之间的元素积
  ArrayList<Integer> preProduct = new ArrayList<>();

  public ProductOfNumbers(){
    //初始化放一个1，便于计算后续添加元素的乘积
    preProduct.add(1);
  }

  public void add(int num){
    if(num==0){
      //如果添加的元素是0，则前面的元素积都废了
      preProduct.clear();
      preProduct.add(1);
      return;
    }

    int n = preProduct.size();
    //前缀积数组中的每个元素
    preProduct.add(preProduct.get(n-1)*num);
  }

  public int getProduct(int k){
    int n = preProduct.size();
    if(k>n-1){
      //不足k个元素，是因为最后k个元素存在0
      return 0;
    }
    //计算最后k个元素积
    return preProduct.get(n-1)/preProduct.get(n-k-1);
  }
}











      
      
