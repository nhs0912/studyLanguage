#include<vector>
#include<iostream>
using namespace std;

int gcd(int a, int b) {
	int remain = a%b;
	if (remain == 0) {
		return b;
	}
	return gcd(b, remain);	
}


vector<int> gcdlcm(int a, int b)
{
	vector<int> answer;
	
	int g = gcd(a, b);
	answer.push_back(g);
	answer.push_back((a*b) / g);	
	return answer;
}

int main()
{
	//4169, 8338
	int a = 2, b = 12;
	vector<int> testAnswer = gcdlcm(a, b);
	cout << testAnswer[0] << " " << testAnswer[1];
}
