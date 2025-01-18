// 在给定的N个整数 A1，A2……AN中选出两个进行 xor（异或）运算，得到的结果最大是多少？
// 字典树不单单可以高效存储和查找字符串集合,还可以存储二进制数字。
// 输入样例：
// 3
// 1 2 3
// 输出样例：
// 3

#include <iostream>
#include <algorithm>
using namespace std;
const int N = 100010, M = 31 * N; // M表示一个数字串二进制可以到多长

/**
 * 暴力解法：
 * int n, a[N];
 * int main(){
 *   cin >> n;
 *   for(int i = 0; i < n; i++) cin >> a[i];
 *
 *   int res = 0;
 *   for(int i = 0; i < n; i++){
 *     for(int j = i + 1; j < n; j++){
 *          res = max(res, a[i] ^ a[j]);
 *     }
 *   }
 *   cout << res << endl;
 *   return 0;
 * }
 **/

int n;
int a[N], son[M][2], idx; // son[i][j]表示第i个节点的第j个儿子是谁

void insert(int x)
{
    int p = 0;                    // p表示根节点
    for (int i = 30; i >= 0; i--) // i>=0可以等于-i
    {
        int u = x >> i & 1; // 取x的第i位二进制数
        if (!son[p][u])
        {
            son[p][u] = ++idx; // 如果插入中发现没有该子节点,开出这条路
        }
        p = son[p][u]; // 指针指向下一层
    }
}

int search(int x)
{
    int p = 0, res = 0;
    for (int i = 30; i >= 0; i--)
    {
        // 从最大位开始找
        int u = x >> i & 1;
        if (son[p][!u])
        {
            // 如果当前层有对应的不相同的数，p指针就指到不同数的地址
            res += 1 << i;
            p = son[p][!u];
        }
        else
        {
            // res += 0 << i;
            p = son[p][u];
        }
    }
    return res;
}

int main()
{
    scanf("%d", &n);
    for (int i = 0; i < n; i++)
    {
        scanf("%d", &a[i]);
        insert(a[i]);
    }

    int res = 0;
    for (int i = 0; i < n; i++)
    {
        res = max(res, search(a[i]));
    }
    printf("%d\n", res);
    return 0;
}