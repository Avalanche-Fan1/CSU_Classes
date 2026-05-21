#include <iostream>
#include <string>
#include <cstring>
using namespace std;

int main() {
    string string1, string2, result;

    for (int i = 0; i < 3; i++) {
        cout << "Enter First String: ";
        getline(cin, string1);

        cout << "Enter Second String: ";
        getline(cin, string2);

        result = string1 + string2;

        cout << result << endl;
    }
    return 0;
}
