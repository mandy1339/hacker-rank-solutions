/*
Enter your query here.
*/

/*
MySQL
*/

select distinct city
from station
where substring(city,1,1) not in ('a','e','i','o','u')
and substring(city,length(city),1) not in ('a','e','i','o','u')
