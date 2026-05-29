/*==============================================================================================
== Name        : pointers.cpp
== Author      : Dave Gray
== Version     : v1
== Description : Simple C++ Program to ask for 3 integers from a user using 3 variables and then
==               creating pointer for each variable.
================================================================================================
*/

#include <iostream>
using namespace std;

int main() {
    int userNum1, userNum2, userNum3;

    // Ask the user to enter three integer values.
    cout << "Enter First Whole Number: ";
    cin >> userNum1;

    cout << "Enter Second Whole Number: ";
    cin >> userNum2;

    cout << "Enter Third Whole Number: ";
    cin >> userNum3;

    // Create pointers and allocate dynamic memory for each integer //
    int* ptr1 = new int;
    int* ptr2 = new int;
    int* ptr3 = new int;

    *ptr1 = userNum1;
    *ptr2 = userNum2;
    *ptr3 = userNum3;

    // Display the memory address stored in each pointer and its corresponding value //

    cout << "Address: " << ptr1 << endl;
    cout << "Value:   " << *ptr1 << endl;
    cout << "Address: " << ptr2 << endl;
    cout << "Value:   " << *ptr2 << endl;
    cout << "Address: " << ptr3 << endl;
    cout << "Value:   " << *ptr3 << endl;

    // delete dynamic memory allocation //
    delete ptr1;
    delete ptr2;
    delete ptr3;

    return 0;
}
