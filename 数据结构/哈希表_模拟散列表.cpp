// 哈希表又称为散列表，由哈希函数和链表共同实现

/*
维护一个集合，支持如下几种操作：
I x，插入一个整数x；
Q x，询问整数x是否在集合中出现过；
现在要进行 N次操作，对于每个询问操作输出对应的结果。

输入样例：
5
I 1
I 2
I 3
Q 2
Q 5
输出样例：
Yes
No
*/

#include <iostream>
#include <cstring>
using namespace std;

// 开放寻址法
const int N = 200003, null = 0x3f3f3f; // 开两倍空间，防止冲突
int h[N];

int find(int x)
{
    int t = (x % N + N) % N; // 防止x为负数
    while (h[t] != null && h[t] != x)
    {
        t++;
        if (t == N)
            t = 0;
    }
    return t;
}

int main()
{
    memset(h, 0x3f, sizeof h); // 初始化为0x3f，表示空槽

    int n;
    scanf("%d", &n);

    while (n--)
    {
        char op[2];
        int x;
        scanf("%s%d", op, &x);
        if (*op == 'I')
        {
            h[find(x)] = x;
        }
        else
        {
            if (h[find(x)] == null)
                puts("No");
            else
                puts("Yes");
        }
    }
    return 0;
}

// 拉链法
const int N = 100003; // 模的长度取质数，离2的整数次幂越远越好，这样冲突概率最小
// h[i]存储第i个槽的头结点，e存储元素，ne存储下一个元素的下标
int h[N], e[N], ne[N], idx; // 开槽h，邻接表形式
void insert(int x)
{
    int k = (x % N + N) % N;
    e[idx] = x;
    ne[idx] = h[k];
    h[k] = idx++;
}

bool find(int x)
{
    int k = (x % N + N) % N;
    for (int i = h[k]; i != -1; i = ne[i])
    {
        if (e[i] == x)
        {
            return true;
        }
    }
    return false;
}

int main()
{
    memset(h, -1, sizeof h); // 清空槽，用-1表示空槽

    int n;
    scanf("%d", &n);

    while (n--)
    {
        char op[2];
        int x;
        scanf("%s%d", op, &x);
        if (*op == 'I')
        {
            insert(x);
        }
        else
        {
            if (find(x))
            {
                puts("Yes");
            }
            else
            {
                puts("No");
            }
        }
    }
    return 0;
}