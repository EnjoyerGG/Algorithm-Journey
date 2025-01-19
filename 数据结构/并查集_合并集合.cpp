// 并查集用于快速：近乎O(1)
// 1.合并集合
// 2.查询元素所在集合
// 基本原理，每个集合用一棵树来表示，树根的编号就是整个集合的编号
// 每个节点存储父节点的编号，p[x]表示x的父节点

// 一共有n个数，编号是1∼n，最开始每个数各自在一个集合中。
// 现在要进行m个操作，操作共有两种：
// M a b，将编号为a和b的两个数所在的集合合并，如果两个数已经在同一个集合中，则忽略这个操作；
// Q a b，询问编号为a和b的两个数是否在同一个集合中。

// 输入样例：
// 4 5
// M 1 2
// M 3 4
// Q 1 2
// Q 1 3
// Q 3 4
// 输出样例：
// Yes
// No
// Yes

// 容易考察，面试
// 问题1：如何判断树根？ if(p[x] == x)
// 问题2：如何求x的集合编号？ while(p[x] != x) x = p[x];
// 问题3：如何合并两个集合？ px是下的集合编号，py是y的集合编号，p[x] = y;
#include <iostream>
using namespace std;
const int N = 100010;
int p[N];

// 返回x的根节点+路径压缩
int find(int x)
{
    if (p[x] != x) // 表明x不是根节点，因此需要继续向上找
    {
        p[x] = find(p[x]);
    }
    return p[x]; // 返回父节点
}

int main()
{
    int n, m;
    scanf("%d%d", &n, &m);
    // 初始化，每个数各自在一个集合中
    for (int i = 1; i <= n; i++)
    {
        p[i] = i;
    }

    while (m--)
    {
        char op[2];
        int a, b;
        scanf("%s%d%d", op, &a, &b);
        if (*op == 'M')
        {
            p[find(a)] = find(b); // 合并a和b所在的集合，直接连接两集合
        }
        else
        {
            if (find(a) == find(b))
            {
                printf("Yes\n");
            }
            else
            {
                printf("No\n");
            }
        }
    }
    return 0;
}