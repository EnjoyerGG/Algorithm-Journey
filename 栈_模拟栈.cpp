#include <iostream>
using namespace std;
const int N = 100010;

int m;
int stk[N], tt;

int main()
{
    cin >> m;

    while (m--)
    {
        string op;
        int x;
        cin >> op;
        if (op == "push")
        {
            cin >> x;
            stk[++tt] = x;
        }
        else if (op == "pop")
        {
            tt--;
        }
        else if (op == "empty")
        {
            cout << (tt ? "NO" : "YES") << endl; // tt==0时输出YES，否则输出NO
        }
        else
        {
            cout << stk[tt] << endl;
        }
    }

    return 0;
}