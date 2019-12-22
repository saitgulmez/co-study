#include<iostream>
#include <algorithm>

using namespace std;

bool equilizingTwoString(string str1, string str2) {

	int diffStart = -1;
	int diffEnd = -1;
	int diffStart1 = -1;
	int diffEnd1 = -1;
	int diffStart2 = -1;
	int diffEnd2 = -1;

	for (int i = 0; i < str1.size(); i++) {
		if (str1[i] != str2[i]) {
			diffStart = i;

			while (i < str1.size() && str1[i] != str2[i]) {
				i++;
			}

			diffEnd = i;
		}

		if (diffStart != -1) {
			if (diffStart1 == -1) {
				diffStart1 = diffStart;
			}
			else {
				diffStart2 = diffStart;
			}
		}

		if (diffEnd != -1) {
			if (diffEnd1 == -1) {
				diffEnd1 = diffEnd;
			}
			else {
				diffEnd2 = diffEnd;
			}
		}
	}

	cout << diffStart1 << " " << diffEnd1;
	cout << diffStart2 << " " << diffEnd2;

	return true;
}

int main(){


	equilizingTwoString("hasan", "kakan");

	return 0;
}
