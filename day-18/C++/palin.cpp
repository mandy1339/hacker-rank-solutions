#include <iostream>
#include <vector>
using namespace std;


class Solution {
    //Write your code here
    //instance data
  public:
    vector<char> queue;
    vector<char> stack;

  public:
    //functions
    void pushCharacter(char a) {
      stack.push_back(a);
    }
    
    char popCharacter() {
      char last = *(--stack.end());
      stack.pop_back();
      cout << "popping: " << last << endl;       //<<<<<<<<
      return last;              
    }

    void enqueueCharacter(char a) {
      queue.push_back(a);
    }
    
    char dequeueCharacter(){
      char first = queue.at(0);
      queue.erase(queue.begin());
      cout << "dequeueing: " << first << endl;      //<<<<<<<<
      return first;
    }
};



int main() {
    // read the string s.
    string s;
    getline(cin, s);
    
  	// create the Solution class object p.
    Solution obj;
    
    // push/enqueue all the characters of string s to stack.
    for (int i = 0; i < s.length(); i++) {
    
      obj.pushCharacter(s[i]);
      obj.enqueueCharacter(s[i]);
    }
    
    // for (int i = 0; i < s.length(); i++) {
    //     cout << obj.stack[i] << endl;
    //     cout << obj.queue[i] << endl;
    // }


    bool isPalindrome = true;
    
    // pop the top character from stack.
    // dequeue the first character from queue.
    // compare both the characters.
    for (int i = 0; i < s.length() / 2; i++) {
        cout << endl << endl <<"iteration: " << i << endl;
        if (obj.popCharacter() != obj.dequeueCharacter()) {
            isPalindrome = false;
    
            break;
        }
    }
    
    // finally print whether string s is palindrome or not.
    if (isPalindrome) {
        cout << "The word, " << s << ", is a palindrome.";
    } else {
        cout << "The word, " << s << ", is not a palindrome.";
    }

    return 0;
}
