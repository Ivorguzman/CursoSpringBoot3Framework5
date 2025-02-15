USE empleosdb;
SELECT 
    a_v.id,  a_v.nombre, a_c.nombre
FROM
    vacantes  a_v
        INNER JOIN
    categorias a_c ON a_c.id =  a_v.id