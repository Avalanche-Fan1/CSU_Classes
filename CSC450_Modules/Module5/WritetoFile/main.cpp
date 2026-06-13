/*==============================================================================================
== Name        : main.cpp
== Author      : Dave Gray
== Version     : v1
== Description : Simple C++ Program to ask for string from user(less than or equal to 100
==               characters and then append it to an existing file. After that, take the contents
==                 of that file and save it in reverse order to another file.
================================================================================================
*/

#include <iostream>
#include <fstream>

void reverseFile();

int main() {
    // Get input from user //
    std::string userInput;
    std::cout << "Enter a string that is under 100 characters: " << std::endl;
    std::getline(std::cin,userInput);

    // Check for length of string and append to file //
    if (userInput.length() <= 100) {
        std::ofstream outputFile("CSC450_CT5_mod5.txt", std::ios::app);
        outputFile << userInput << std::endl;
        outputFile.close();

        // Calls the reverseFile Method //
        reverseFile();
    }
    // end if string was too long //
    else {
        std::cout << "Input exceeds 100 characters." << std::endl;
    }

    return 0;
}
// Reversal method //
void reverseFile() {

    // open the file //
    std::ifstream file("CSC450_CT5_mod5.txt");
    std::string line;
    std::string file_content;

    // gather contents of file into a string //
    while (std::getline(file, line)) {
        file_content += line + "\n";
    }
    // open the reverse file //
    std::ofstream reverseFile("CSC450-mod5-reverse.txt");

    /* Itterate through the string in reverse order,
       writing each character to the reverse file (Including returns) */
    for (int i = file_content.length() - 1; i >= 0; i--) {
        reverseFile.put(file_content[i]);
    }
    reverseFile.close();
}
