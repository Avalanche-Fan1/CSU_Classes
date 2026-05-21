/*==============================================================================================
== Name        : main.cpp
== Author      : Dave Gray
== Version     : v1
== Description : Simple C++ Program to ask for 2 strings from user and concatenate them. Ask
==               3 times from user (in a loop) to test varying lenghts.
== Notable     : Used std::string for safer string handling instead of C-style character arrays
==               This prevents buffer overflow. Out of bounds.  strcat is not safe.
================================================================================================
*/

#include <iostream>
#include <string>
using namespace std;

int main() {
    string string1, string2, result;
    // loop to ask user 3 times for 2 strings. //
    for (int i = 0; i < 3; i++) {
        // ask for first string //
        cout << "Enter First String: ";
        getline(cin, string1);

        // ask for second string //
        cout << "Enter Second String: ";
        getline(cin, string2);

        // concatenate the strings into a new string //
        result = string1 + string2;

        // print concatenated string //
        cout << result << endl;
    }
    return 0;
}
