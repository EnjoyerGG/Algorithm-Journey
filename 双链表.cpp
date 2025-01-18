#include <iostream>
using namespace std;
const int N = 100010;
int m;
int e[N], l[N], r[N], idx;

// 在节点k的右边插入一个数x
void insert(int k, int x)
{
    e[idx] = x;    // 数组中第idx个元素的值为x
    l[idx] = k;    // 第idx个元素的左边是k
    r[idx] = r[k]; // 第idx个元素的右边是k的右边
    l[r[k]] = idx; // k的右边的左边是idx
    r[k] = idx++;  // k的右边是idx
}

void remove(int k)
{
    r[l[k]] = r[k]; // k的左边的右边是k的右边
    l[r[k]] = l[k]; // k的右边的左边是k的左边
}

int main()
{
    cin >> m;

    // 0表示左端点，1表示右端点
    r[0] = 1, l[1] = 0;
    idx = 2;

    while (m--)
    {
        string op;
        cin >> op;
        int k, x;
        if (op == "L")
        {
            cin >> x;
            insert(0, x);
        }
        else if (op == "R")
        {
            cin >> x;
            insert(l[1], x);
        }
        else if (op == "D")
        {
            cin >> k;
            remove(k + 1);
        }
        else if (op == "IL")
        {
            cin >> k >> x;
            insert(l[k + 1], x);
        }
        else
        {
            cin >> k >> x;
            insert(k + 1, x);
        }
    }

    for (int i = r[0]; i != 1; i = r[i])
    {
        cout << e[i] << ' ';
    }
    cout << endl;

    return 0;
}