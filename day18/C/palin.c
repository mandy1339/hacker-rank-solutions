#include <stdio.h>
#include <string.h>
#include <stdlib.h>
typedef enum { false, true } bool;

//PUSH_BACK()
//increase memory by 1 byte and attach to end of STACK
void push_back(char * stack, char new_char) {
  int stack_length = strlen(stack);
  realloc(stack, stack_length + 2);  //+2 to account for \0
  //insert new char at the end and replace the \0 
  stack[stack_length] = new_char;
  stack[stack_length + 1] = '\0';
}

//ENQUEUE()
//increase memory by 1 byte and attach to front
void enqueue(char * queue, char new_char) {
    int queue_length = strlen(queue);
    realloc(queue, queue_length + 2);
    //temp holder
    char * temp = malloc(queue_length + 1);
    strcpy(temp, queue);
    //shift
    strcpy(queue + 1, temp);
    //insert new char at front
    queue[0] = new_char;  
}


//POP_BACK()
//reduce memory of the stack by 1 byte, reassign \0
char pop_back(char * stack) {
    int stack_length = strlen(stack);
    char ret_char = stack[stack_length - 1];    //store last char before removed
    realloc(stack, stack_length);       //decrease memory by 1 byte
    stack[stack_length - 1] = '\0';     //cut the str 1 byte shorter
    return ret_char;
}


//DEQUEUE()
//same as pop_back;
char dequeue(char * stack) {
    int stack_length = strlen(stack);
    char ret_char = stack[stack_length - 1];    //store last char before removed
    realloc(stack, stack_length);       //decrease memory by 1 byte
    stack[stack_length - 1] = '\0';     //cut the str 1 byte shorter
    return ret_char;
}

//MAIN()
int main() {
    bool palindrome = true;
    char * stack = (char *)malloc(1);
    char * queue = (char *)malloc(1);
    stack[0] = '\0';
    queue[0] = '\0';

    char * uinput = (char * ) malloc(32);
    scanf("%s", uinput);
    
    int i = 0;
    for(i; i < strlen(uinput); i++) {
        enqueue(queue, uinput[i]);
        push_back(stack, uinput[i]);
    }
    
    //compare each dequeue to each pop_back
    for(i = 0; i < strlen(uinput) / 2; i++) {
        if(pop_back(stack) != dequeue(queue)) {
            palindrome = false;
            break;
        }
    }

    //print result
    if(palindrome) {
        printf("the word %s is a palindrome\n", uinput);
    }
    else {
        printf("the word %s is a not palindrome\n", uinput);
    }

    return 0;
}
