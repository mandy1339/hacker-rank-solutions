// The days of the week are: "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"
function getDayName(dateString) {
    let dayName;
    // Write your code here
    let date = new Date(dateString);
    return intToDow(date.getDay());
}

function intToDow(day) {
    switch (day) {
        case 0: return "Sunday";
                break;
        case 1: return "Monday";
                break;
        case 2: return "Tueday";
                break;
        case 3: return "Wednesday";
                break;
        case 4: return "Thursday";
                break;
        case 5: return "Friday";
                break;
        case 6: return "Saturday";
                break;
    }
}
