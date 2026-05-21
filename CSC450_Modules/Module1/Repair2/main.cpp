#include <iostream>
#include <string>
using namespace std;

int main() {
    string hockeyplayer;

    cout << "Enter Your Favorite Hockey Player: ";
    getline(cin, hockeyplayer);

    if (hockeyplayer.length() > 25) {
        cout << "Error: Players name cannot be more than 25 characters." << endl;
    } else {
        cout  << hockeyplayer << " is a great player!" << endl;
    }

    return 0;
}