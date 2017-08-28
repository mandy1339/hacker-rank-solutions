var readline = require('readline');
var userInput = '';
var stack = [];
var queue = [];


var rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
})

function main() {
    
}

rl.question("", function(input) {
    userInput = input;
    process.stdout.write(userInput + '\n');
    rl.close();

    //main
    var charArray = userInput.split('');
    var forVar;
    for(forVar of charArray) {
        stack.push(forVar);
        queue.push(forVar);
    }
    var palindrome = true;
    //pop and compare
    for(i = 0; i < charArray.length / 2; i++) {
        if(stackPop(stack) != dequeue(queue)) {
            palindrome = false;
        }
    }
    //give answer
    if(palindrome) {
        console.log(`The word, ${userInput}, is a palindrome`);
    }
    else {
        console.log(`The word, ${userInput}, is not a palindrome`);
    }
})

function stackPop(myStack) {
    return myStack.pop();
}

function dequeue(myQueue) {
    return myQueue.shift();
}