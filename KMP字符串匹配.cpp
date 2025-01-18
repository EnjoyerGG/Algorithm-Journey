// 字符串匹配算法
//  给定一个字符串S，以及一个模式串P，所有字符串中只包含大小写英文字母以及阿拉伯数字。
//  模式串P在字符串S中多次作为子串出现。
//  求出模式串P在字符串S中所有出现的位置的起始下标。

// 输入样例：
// 3
// aba
// 5
// ababa
// 输出样例：
// 0 2

#include <iostream>
using namespace std;
const int N = 100010, M = 1000010;

int n, m;
int ne[N];       // next数组
char s[M], p[N]; // s是字符串，p是模式串

int main()
{
    cin >> n >> p + 1 >> m >> s + 1;
    for (int i = 2, j = 0; i <= n; i++)
    {
        // 匹配不成功，j回退
        // j=0时，表示模式串的第一个字符和当前字符不匹配
        while (j && p[i] != p[j + 1])
        {
            j = ne[j];
        }
        // 匹配成功，j++
        if (p[i] == p[j + 1])
        {
            j++;
        }
        // 更新next数组
        ne[i] = j;
    }

    for (int i = 1, j = 0; i <= m; i++)
    {
        // 匹配不成功，j回退
        while (j && s[i] != p[j + 1])
        {
            j = ne[j];
        }
        // 匹配成功，j++
        if (s[i] == p[j + 1])
        {
            j++;
        }
        if (j == n)
        {
            printf("%d ", i - n);
            j = ne[j];
        }
    }
    return 0;
}