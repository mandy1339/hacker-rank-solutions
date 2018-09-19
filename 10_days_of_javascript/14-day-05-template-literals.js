/*
 * Determine the original side lengths and return an array:
 * - The first element is the length of the shorter side
 * - The second element is the length of the longer side
 * 
 * Parameter(s):
 * literals: The tagged template literal's array of strings.
 * expressions: The tagged template literal's array of expression values (i.e., [area, perimeter]).
 */
function sides(literals, ...expressions) {
    let area = expressions[0];
    let perim = expressions[1];
    for (let i = 1; i <= area; i++) {
        if (area % i != 0) {
            continue;
        }
        let comp = area / i;
        if (i * comp == area && (2 * (i + comp)) == perim) {
            return [i, comp];
        } 
    }
    
    return [-1, -1];
}
