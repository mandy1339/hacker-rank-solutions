/*
MySQL
*/


select distinct city
from station
where substring(city,length(city),1) not in ('a','e','i','o','u');

