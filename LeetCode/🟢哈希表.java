//哈希表是一个加强版的数组

//哈希表底层逻辑
class MyHashMap{
  private Object[] table;

  //增/改，复杂度O(1)
  public void put(K key, V value){
    int index = hash(key);
    table[index] = value;
  }

  //查，复杂度O(1)
  public V get(K key){
    int index = hash(key);
    return table[index];
  }

  //删，复杂度O(1)
  public void remove(K key){
    int index = hash(key);
    table[index] = null;
  }

  //哈希函数，把key转化成table中的合法索引
  //时间复杂度必须是O(1)，才能保证上述方法的复杂度都是O(1)
  private int hash(K key){
    //...
  }


//关键概念：
//1. key是唯一的，value可以重复，类比数组，索引是唯一的。
//2. 哈希函数：把任意长度的输入(key)转化为固定长度的输出(索引)。
//3. 保证索引非负数，并且落于合理区间内。
//4. key必须是不变的。
int hash(K key){
  int h = key.hashCode(); 
  //保证非负数
  h = h & 0x7fffffff;
  //映射到table数组的合法索引
  return h % table.length;
}


//利用拉链法解决哈希冲突
import java.util.LinkedList;
import java.util.List;

public class MyChainingHashMap<K, V>{
  //拉链法使用单链表节点，存储key-value对
  private static class KVNode<K, V>{
    K key;
    V value;
    //因为使用了内置的linkedlist类，故不用next指针
    KVNode(K key, V value){
      this.key = key;
      this.value = val;
    }
  }

  //哈希表的底层数组，每个数组元素是一个链表，链表中的每个节点是KVnode存储键值对
  private LinkedList<KVNode<K, V>>[] table;

  //哈希表中存入的键值对个数
  private int size;
  //底层数组的初始容量
  private static final int INIT_CAP = 4;

  public MyChainingHashMap(){
    this(INIT_CAP);
  }

  public MyChainingHashMap(int initCapacity){
    size = 0;
    //保证底层数组的容量至少为1，因为hash函数中有求余运算，避免出现除以0的情况
    initCapacity = Math.max(initCapacity, 1);
    //初始化哈希表
    table = (LinkedList<KVNode<K, V>>[]) new LinkedList[initCapacity];
    for(int i=0; i<table.length; i++){
      table[i] = new LinkedList<>();
    }
  }

  //**删**
  //删除key和对应val
  public void remove(K key){
    if(key==null) throw new IllegalArgumentException("Key is null");

    LinkedList<KVNode<K, V>> list = table[hash(key)];
    //如果key存在，则删除，size减少
    for(KVNode<K, V> node : list){
      if(node.key.equals(key)){
        list.remove(node);
        size--;

        //缩容，当负载因子小于0.125时，缩容
        if(size<=table.length/8){
          resize(table.length/4);
        }
        return;
      }
    }
  }

  //**查**
  //返回key对于的val，如果key不存在，则返回
  public V get(K key){
    if(key==null){
      throw new IllegalArgumentException("key is null");
    }
    LinkedList<KVNode<K, V>> list = table[hash(key)];
    for(KVNode<K, V> node : list){
      if(node.key.equals(key)){
        return node.value;
      }
    }
    return null;
  }
  //返回所有key
  public List<K> keys(){
    List<K> keys = new LinkedList<>();
    for(LinkedList<KVNode<K, V>> list : table){
      keys.add(node.key);
    }
    return keys;
  }

  //**其他工具函数**
  public int size(){
    return size;
  }

  //哈希函数
  private int hash(K key){
    return (key.hashCode() & 0x7fffffff) % table.length;
  }

  private void resize(int size){
    //构建一个新的HashMap
    //避免newCap为0，造成求模运算产生除以0的异常
    newCap = Math.max(newCap, 1);
    MyChainingHashMap<k, V> newMap = new MyChainingHashing<>(newCap);
    //穷举当前HashMap中所有键值对
    for(LinkedList<KVNode<K, V>>list : table){
      for(KVNode<K, V> node : list){
        //将键值对转移到新的HashMap中
        newMap.put(node.key, node.value);
      }
    }
    // 将当前 HashMap 的底层 table 换掉
    this.table = newMap.table;
  }

  public static void main(String[] args) {
        MyChainingHashMap<Integer, Integer> map = new MyChainingHashMap<>();
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);
        System.out.println(map.get(1)); // 1
        System.out.println(map.get(2)); // 2

        map.put(1, 100);
        System.out.println(map.get(1)); // 100

        map.remove(2);
        System.out.println(map.get(2)); // null
        // [1, 3]（顺序可能不同）
        System.out.println(map.keys());

        map.remove(1);
        map.remove(2);
        map.remove(3);
        System.out.println(map.get(1)); // null
    }
}








  







