/*
    MySQL
*/

select sum(ci.population)
from country co join city ci on co.code = ci.countrycode
where co.continent = 'asia';
