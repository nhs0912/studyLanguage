#include<iostream>
using namespace std;
long memo[10000];
long long fibonacci(int n)
{
	if (n<= 1)
	{
		return n;
	}	
	else {
		if (memo[n] > 0)
		{
			return memo[n];
		}
		else {
			memo[n]=fibonacci(n - 1) + fibonacci(n - 2);
			return memo[n];
		}
	}	
}

int main()
{
	int testCase = 10;
	long long testAnswer = fibonacci(testCase);

	cout << testAnswer << endl;
}
