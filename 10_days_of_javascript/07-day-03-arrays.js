/**
*   Return the second largest number in the array.
*   @param {Number[]} nums - An array of numbers.
*   @return {Number} The second largest number in the array.
**/
function getSecondLargest(nums) {
    // Complete the function
    nums.sort((x,y) => x<y);
    
    var first = nums[0];
    
    var second = first;
    
    for(let n of nums) {
        if(n < first) {
            second = n;
            break;
        }
    }
    return second;
}
