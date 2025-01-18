// 给定一个长度为n的数列，请你求出数列中每个数的二进制表示中1的个数。

#include <iostream>
using namespace std;

int main()
{
    int n;
    scanf("%d", &n);
    while (n--)
    {
        int x, s = 0;
        scanf("%d", &x);

        // x & -x表示x的二进制表示中最低位的1
        // x -= x & -x表示将x的二进制表示中最低位的1置为0
        // 重复上述操作，直到x为0
        for (int i = x; i; i -= i & -i)
        {
            s++;
        }

        printf("%d ", s);
    }

    return 0;
}