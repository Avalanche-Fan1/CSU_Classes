/*==============================================================================================
== Name        : main.cpp
== Author      : Dave Gray
== Version     : v1
== Description : Simple C++ Program that creates a function for counting Up 0-20 and another
                 function to count down 20 - 0.  Each function is run in a seperate thread. The 2nd
                 thread does not start until the 1st has completed it task.
================================================================================================
*/
#include <iostream>
#include <thread>

// Create Count Up Function //
void countUp() {
    std::cout << "Counting up:\n";
    for (int i = 0; i <= 20; ++i) {
        std::cout<<i<<" ";
    }
    std::cout << std::endl;
}

// Create Count Down Function //
void countDown() {
    std::cout << "Counting down:\n";
    for (int i = 20; i >= 0; --i) {
        std::cout<<i<<" ";
    }
    std::cout << std::endl;
}
// Create Main for calling functions in 2 different threads. Thread 2 runs After Thread1 completes. //
int main() {
    std::thread thread1(countUp);
    thread1.join();
    std::thread thread2(countDown);
    thread2.join();

    return 0;
}