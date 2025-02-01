//题目：输入一棵二叉树的根节点 root，要求你实现如下一个类
//可以用 serialize 方法将二叉树序列化成字符串，用 deserialize 方法将序列化的字符串反序列化成二叉树，至于以什么格式序列化和反序列化，这个完全由你决定。

/*
输入：root = [1,2,3,null,null,4,5]
输出：[1,2,3,null,null,4,5]

输入：root = []
输出：[]

输入：root = [1,2]
输出：[1,2]
*/

//所谓的序列化不过就是把结构化的数据「打平」，本质就是在考察二叉树的遍历方式。
//1.利用前序遍历解决（在递归遍历两棵子树之前写的代码就是前序遍历代码）
//框架：
void traverse(TreeNode root){
  if(root==null) return;
  //前序位置代码
  traverse(root.left);
  traverse(root.right);
}
//解答
class Codec{
  String SEP = ",";
  String NULL = "#";

  //主函数，将二叉树序列转化为字符串
  public String serialize(TreeNode root){
    StringBuilder sb = new StringBuilder();
    _serialize(root, sb);
    return sb.toString();
  }
  //辅助函数，将二叉树存入StringBuilder
  void _serialize(TreeNode root, StringBuilder sb){
    if(root==null){
      sb.append(NULL).append(SEP);
      return;
    }
    //***前序位置***
    sb.append(root.val).append(SEP);
    //*************

    _serialize(root.left, sb);
    _serialize(root.right, sb);
  }
}

class Codec{
  String SEP = ",";
  String NULL = ".";

  //主函数，将字符串反序列化为二叉树结构
  public TreeNode deserialize(String data){
    //将字符串转化为列表
    LinkedList<String> nodes = new LinkedList<>();
    for(String s : data.split(SEP)){
      nodes.addLast(s);
    }
    return _deserialize(nodes);
  }
  //辅助函数，通过nodes列表构建二叉树
  TreeNode _deserialize(LinkedList<String> nodes){
    if(nodes.isEmpty()) return null;
    //***前序位置***
    //列表最左侧就是根节点
    String first = nodes.romoveFirst();
    if(first.equals(NULL)) return null;
    TreeNode root = new TreeNode(Integer.parseInt(first));
    //*************

    root.left = _deserialize(nodes);
    root.right = _deserialize(nodes);

    return root;
  }
}

//后序遍历解法
//框架：
void traverse(TreeNode root){
  if(root==null) return;
  traverse(root.left);
  traverse(root.right);
  //后序位置代码
}

//对于序列化只需要修改辅助函数
//对于反序列化：root 的值是列表的最后一个元素。我们应该从后往前取出列表元素，先用最后一个元素构造 root，然后递归调用生成 root 的左右子树。
class Codec{
  String SEP = ",";
  String NULL = "#";
  //主函数，将二叉树序列转化为字符串
  public String serialize(TreeNode root){
    StringBuilder sb = new StringBuilder();
    _serialize(root, sb);
    return sb.toString();
  }
  void _serialize(TreeNode root, StringBuilder sb){
    if(root==null){
      sb.append(NULL).append(SEP);
      return;
    }
    _serialize(root.left, sb);
    )serialize(root.right, sb);
    //***后序位置***
    sb.append(root.val).append(SEP);
    //*************
  }
  //主函数，将字符串反序列化为二叉树结构
  public TreeNode deserialize(String data){
    LinkedList<String> nodes = new LinkedList<>();
    for(String s : data.split(SEP)){
      nodes.addLast(s);
    }
    return _deserialize(nodes);
  }
  //辅助函数，通过nodes列表构造二叉树
  TreeNode _deserialize(LinkedList<String> nodes){
    if(nodes.isEmpty()) return null;
    //从后往前取出元素
    String last = nodes.removeLast();
    if(last.equals(NULL)) return null;
    TreeNode root = new TreeNode(Integer.parseInt(last));
    //先构造右子树，再构造左子树
    root.right = _deserialize(nodes);
    root.left = _deserialize(nodes);

    return root;
  }
}















