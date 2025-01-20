/**
维护一个集合，初始时集合为空，支持如下几种操作：
I x，插入一个数 x；
PM，输出当前集合中的最小值；
DM，删除当前集合中的最小值（数据保证此时的最小值唯一）；
D k，删除第k个插入的数；
C k x，修改第k个插入的数，将其变为 x；

现在要进行N次操作，对于所有第2个操作，输出当前集合的最小值。

输入样例：
8
I -10
PM
I -10
D 1
C 2 8
I 6
PM
DM
输出样例：
-10
6
 **/

#include <iostream>
#include <algorithm>
#include <string.h>
using namespace std;
const int N = 100010;

// h[i]只能存储数据，不能存储是第几个数字，需要ph[k]=i来指明第k个数字在h[]中对应的i是多少
// 执行交换操作时，可以直接交换数字swap(h[a], h[b])。但是对于ph[k_1]=a和ph[k_2]=b，a和b是它们存放的值，不能通过值来找下标，也就是找不到k_1和k_2是多少。
// 因此引入hp[a]=k_1和hp[b]=k_2进行反向操作。
/*形象理解：
h[]：房间号无直接实际意义，里边住着犯人
ph[]：花名册，狱警所有，写明了几号犯人住在哪个房间号里，用于抓某些人
（但是狱警无权过问每个号里住的是谁）
hp[]：住户册，监狱所有，写明了哪个房间号里住的是几号，用于管理监狱
（但是监狱没必要知道哪个犯人住在哪里）
heap_swap：已知两个犯人住的地方，交换它们住的地方，并且让狱警和管理 处都知道这件事情
swap(h[a], h[b])：两个人换地方住
swap(hp[a], hp[b])：监狱管理处翻房间号，把里边存放的犯人号交换
swap(ph[hp[a]], ph[hp[b]])：狱警：先申请查住户册，看这两个地方住的谁，再在花名册下写下来，这两个人位置换了
h[a] = 10, h[b] = 20 swap: h[a] = 20,h [b] = 10
hp[a] = 1 ,hp[b] = 2 swap:hp[a] = 2 ,hp[b] = 1
ph[1] = a ,ph[2] = b swap:ph[1] = b ,ph[2] = a
*/
int h[N], ph[N], hp[N], cnt;

void heap_swap(int a, int b)
{
    swap(ph[hp[a]], ph[hp[b]]);
    swap(hp[a], hp[b]);
    swap(h[a], h[b]);
}

void down(int u)
{
    int t = u;
    if (u * 2 <= cnt && h[u * 2] < h[t])
        t = u * 2;
    if (u * 2 + 1 <= cnt && h[u * 2 + 1] < h[t])
        t = u * 2 + 1;
    if (u != t)
    {
        heap_swap(u, t);
        down(t);
    }
}

void up(int u)
{
    while (u / 2 && h[u] < h[u / 2]) // u/2是u的父节点
    {
        heap_swap(u, u / 2); // 交换u和u/2
        u /= 2;              // 更新u
    }
}

int main()
{
    int n, m = 0;
    scanf("%d", &n);
    while (n--)
    {
        char op[5];
        int k, x;
        scanf("%s", op);

        // 插入
        if (!strcmp(op, "I"))
        {
            scanf("%d", &x);
            cnt++;                    // 插入一个数，堆中元素个数+1
            m++;                      // 记录第几次插入，设置新的idx
            ph[m] = cnt, hp[cnt] = m; // 每次插入都是在堆为尾插入（设置ph和hp）
            h[cnt] = x;               // 记录插入的值
            up(cnt);
        }
        // 输出最小值
        else if (!strcmp(op, "PM"))
        {
            printf("%d\n", h[1]);
        }
        // 删除最小值
        else if (!strcmp(op, "DM"))
        {
            heap_swap(1, cnt);
            cnt--;
            down(1);
        }
        // 删除第k个插入的数
        else if (!strcmp(op, "D"))
        {
            scanf("%d", &k);
            k = ph[k];         // 保存当前被删除节点的下标
            heap_swap(k, cnt); // 第k个插入的元素移动到堆尾，此时ph[idx]指向堆尾
            cnt--;             // 删除堆尾
            down(k);           // k为之前被记录的节点的下标
            up(k);
        }
        else
        {
            scanf("%d%d", &k, &x);
            h[ph[k]] = x; // 修改第k个插入的数
            down(ph[k]);
            up(ph[k]);
        }
    }

    return 0;
}