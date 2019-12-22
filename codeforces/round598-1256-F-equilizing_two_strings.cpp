#include<iostream>
#include <vector>
#include <algorithm>

using namespace std;

bool equilizingTwoString(string str1, string str2) {

	int diffStart = -1;
	int diffEnd = -1;
	vector <int> diffStartVec;
	vector <int> diffEndVec;
	for (int i = 0; i < str1.size(); i++) {
		if (str1[i] != str2[i]) {
			diffStart = i;
			while (i < str1.size() && str1[i] != str2[i]) {
				i++;
			}

			diffEnd = i;
		}

		if (diffStart != -1) {
			diffStartVec.push_back(diffStart);
			diffStart = -1;
		}

		if (diffEnd != -1) {
			diffEndVec.push_back(diffEnd);
			diffEnd = -1;
		}
	}



	cout << diffStartVec[0] << " ";
	cout << diffEndVec[0] << " ";

	return true;
}

int main(){

    int number_of_test_case;
    int length;
    string string1;
    string string2;
    cin >> number_of_test_case >> length;
    cin >> string1;
    cin >> string2;
	equilizingTwoString("hasan", "kakan");

	return 0;
}
