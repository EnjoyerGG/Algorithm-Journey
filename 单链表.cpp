#include <iostream>
using namespace std;
const int N = 100010;

// head:头结点的下标
// e[i]:存储节点i的值
// ne[i]:存储节点i的next指针
// idx:当前用到了哪个点
int head, e[N], ne[N], idx;

// 初始化
void init()
{
    head = -1;
    idx = 0;
}

// 将x插到头结点
void add_to_head(int x)
{
    e[idx] = x;
    ne[idx] = head;
    head = idx++;
}

// 将x插到下标是k的点后面
void add(int k, int x)
{
    e[idx] = x;
    ne[idx] = ne[k];
    ne[k] = idx++;
}

// 将下标是k的点后面的点删掉
void remove(int k)
{
    ne[k] = ne[ne[k]];
}

int main()
{
    int m;
    scanf("%d", &m);
    init();

    while (m--)
    {
        int k, x;
        char op;

        cin >> op;
        if (op == 'H')
        {
            cin >> x;
            add_to_head(x);
        }
        else if (op == 'D')
        {
            cin >> k;
            if (!k)
            {
                // 删除头结点
                head = ne[head];
            }
            else
            {
                remove(k - 1);
            }
        }
        else
        {
            cin >> k >> x;
            add(k - 1, x);
        }
    }
    for (int i = head; i != -1; i = ne[i])
    {
        cout << e[i] << ' ';
    }
    printf("\n");
    return 0;
}