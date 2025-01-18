// 给定一个表达式，其中运算符仅包含 +,-,*,/（加 减 乘 整除），可能包含括号，请你求出表达式的最终值。

#include <iostream>
#include <cstring>
#include <algorithm>
#include <stack>
#include <unordered_map>

using namespace std;

stack<int> num;
stack<char> op;

void eval()
{
    auto b = num.top();
    num.pop();
    auto a = num.top();
    num.pop();
    auto c = op.top();
    op.pop();
    int x;
    if (c == '+')
        x = a + b;
    else if (c == '-')
        x = a - b;
    else if (c == '*')
        x = a * b;
    else
        x = a / b;
    num.push(x);
}

int main()
{
    unordered_map<char, int> pr{{'+', 1}, {'-', 1}, {'*', 2}, {'/', 2}};
    string str;
    cin >> str;
    for (int i = 0; i < str.size(); i++)
    {
        auto c = str[i];
        if (isdigit(c))
        {
            int x = 0, j = i;

            while (j < str.size() && isdigit(str[j]))
                x = x * 10 + str[j++] - '0'; // 将字符串转换为数字
            i = j - 1;
            num.push(x);
        }
        else if (c == '(')
            op.push(c);    // 左括号直接入栈
        else if (c == ')') // 右括号则将栈中的操作符和数字进行计算
        {
            while (op.top() != '(')
                eval();
            op.pop();
        }
        else
        {
            // 如果当前操作符的优先级小于等于栈顶操作符的优先级，就将栈顶操作符弹出并计算
            while (op.size() && op.top() != '(' && pr[op.top()] >= pr[c])
                eval();
            op.push(c);
        }
    }
    while (op.size())
        eval();
    cout << num.top() << endl;
    return 0;
}
