/*
MySQL
*/



select
    CASE
        WHEN (gr.grade > 7) then st.name
        WHEN (gr.grade < 8) then 'NULL'
    END as name,
    gr.grade, 
    st.marks
from students st
join grades gr on st.marks >= min_mark and st.marks <= max_mark

order by
gr.grade desc,
CASE
    WHEN (gr.grade > 7) then st.name 
    WHEN (gr.grade < 8) then st.marks 
END asc;

   


