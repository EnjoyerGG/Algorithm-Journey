// Trie树用于快速存数和查找字符串，是一种树形结构，典型应用是用于统计和排序大量字符串（不仅限于字符串），所以经常被搜索引擎系统用于文本词频统计。

// 维护一个Trie字符串集合，支持两种操作：
// I x 向集合中插入一个字符串x；
// Q x 询问一个字符串在集合中出现了多少次。
// 共有N个操作，所有输入的字符串总长度不超过105，字符串仅包含小写英文字母。

// 输入样例：
// 5
// I abc
// Q abc
// Q ab
// I ab
// Q ab

// 输出样例：
// 1
// 0
// 1

#include <iostream>
using namespace std;
const int N = 100010;
// son[i][j]表示第i个节点的第j个儿子是谁, j=26是因为只有26个小写字母
// cnt[i]以当前节点结尾的字符串的数量
// idx表示当前节点的编号
// *0号节点是根节点，也是空节点
int son[N][26], cnt[N], idx;
char str[N];

void insert(char *str)
{
    int p = 0; // p表示当前节点
    for (int i = 0; str[i]; i++)
    {
        // u表示当前字符
        int u = str[i] - 'a'; // str[i] - 'a'表示当前字符的编号
        // 如果当前节点的第u个儿子不存在，就新建一个节点
        if (!son[p][u])
            son[p][u] = ++idx; // 新建一个节点
        p = son[p][u];         // p指向当前字符
    }
    cnt[p]++;
}

int query(char *str)
{
    int p = 0;
    for (int i = 0; str[i]; i++)
    {
        int u = str[i] - 'a';
        // 如果当前节点的第u个儿子不存在，说明字符串不存在
        if (!son[p][u])
            return 0;
        p = son[p][u];
    }
    return cnt[p];
}

int main()
{
    int n;
    scanf("%d", &n);
    while (n--)
    {
        char op[2];
        scanf("%s%s", op, str);
        if (*op == 'I')
            insert(str);
        else
            printf("%d\n", query(str));
    }

    return 0;
}