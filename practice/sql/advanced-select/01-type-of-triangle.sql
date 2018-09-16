/*
MySQL
*/

select case
            when (a + b <= c) then 'Not A Triangle'
            when (b + c <= a) then 'Not A Triangle'
            when (c + a <= b) then 'Not A Triangle'
            when (t.A = t.B AND t.B = t.C) then 'Equilateral'
            when (a != b AND b = c) then 'Isosceles'
            when (b != c AND a = c) then 'Isosceles'
            when (c != b AND a = b) then 'Isosceles'
            when (a != b AND b != c AND a != c) then 'Scalene'
        end as typeoftriangle
from triangles t;
