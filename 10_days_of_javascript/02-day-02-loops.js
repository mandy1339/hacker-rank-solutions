/*
 * Complete the vowelsAndConsonants function.
 * Print your output using 'console.log()'.
 */
function vowelsAndConsonants(s) {
    var vowels = {a:true, e:true, i:true, o:true, u:true};
    for (let letter of s) {
        if (letter in vowels) { console.log(letter); }
    }
    for (let letter of s) {
        if (!(letter in vowels)) { console.log(letter); }
    }
}
