-- Base de dades Universidad

-- 1-Retorna un llistat amb el primer cognom, segon cognom i el nom de tots els/les alumnes. El llistat haurà d'estar ordenat alfabèticament de menor a major pel primer cognom, segon cognom i nom.
SELECT apellido1, apellido2, nombre FROM persona WHERE tipo='alumno' ORDER BY apellido1, apellido2, nombre;

-- 2-Esbrina el nom i els dos cognoms dels alumnes que no han donat d'alta el seu número de telèfon en la base de dades.
SELECT nombre, apellido1, apellido2 FROM persona WHERE telefono IS NULL;

-- 3-Retorna el llistat dels alumnes que van néixer en 1999.
SELECT *FROM persona WHERE tipo="alumno" AND fecha_nacimiento LIKE "1999%";

-- 4-Retorna el llistat de professors/es que no han donat d'alta el seu número de telèfon en la base de dades i a més el seu NIF acaba en K.
SELECT * FROM persona WHERE tipo='profesor'AND  telefono IS NULL AND nif LIKE'%K';

-- 5-Retorna el llistat de les assignatures que s'imparteixen en el primer quadrimestre, en el tercer curs del grau que té l'identificador 7.
SELECT * FROM asignatura WHERE cuatrimestre = 1 AND curso = 3 AND id_grado = 7;

-- 6-Retorna un llistat dels professors/es juntament amb el nom del departament al qual estan vinculats. El llistat ha de retornar quatre columnes, primer cognom, segon cognom, nom i nom del departament. El resultat estarà ordenat alfabèticament de menor a major pels cognoms i el nom.
SELECT pe.apellido1, pe.apellido2, pe.nombre, de.nombre AS NombreDpto FROM persona pe JOIN profesor pr ON pe.id = pr.id_profesor JOIN departamento de ON pr.id_departamento = de.id ORDER BY pe.apellido1, pe.apellido2, pe.nombre;

-- 7-Retorna un llistat amb el nom de les assignatures, any d'inici i any de fi del curs escolar de l'alumne/a amb NIF 26902806M.
SELECT asi.nombre, ce.anyo_inicio, ce.anyo_fin FROM asignatura asi JOIN alumno_se_matricula_asignatura asm ON asi.id=asm.id_asignatura JOIN persona pe ON pe.id=asm.id_alumno JOIN curso_escolar ce ON ce.id= asm.id_curso_escolar WHERE nif ='26902806M';

-- 8-Retorna un llistat amb el nom de tots els departaments que tenen professors/es que imparteixen alguna assignatura en el Grau en Enginyeria Informàtica (Pla 2015).
SELECT DISTINCT dp.nombre, gr.nombre FROM departamento dp JOIN profesor pr ON dp.id=pr.id_departamento JOIN asignatura asi USING (id_profesor) JOIN grado gr ON asi.id_grado=gr.id WHERE gr.nombre = 'Grado en Ingeniería Informática (Plan 2015)';

-- 9-Retorna un llistat amb tots els alumnes que s'han matriculat en alguna assignatura durant el curs escolar 2018/2019.
SELECT DISTINCT pe.nombre, pe.apellido1, pe.apellido2 FROM persona pe JOIN alumno_se_matricula_asignatura asm ON pe.id=asm.id_alumno WHERE pe.tipo ='alumno' AND asm.id_curso_escolar =5;


-- Resol les 6 següents consultes utilitzant les clàusules LEFT JOIN i RIGHT JOIN.
-- 1-Retorna un llistat amb els noms de tots els professors/es i els departaments que tenen vinculats. El llistat també ha de mostrar aquells professors/es que no tenen cap departament associat. El llistat ha de retornar quatre columnes, nom del departament, primer cognom, segon cognom i nom del professor/a. El resultat estarà ordenat alfabèticament de menor a major pel nom del departament, cognoms i el nom.
SELECT dp.nombre AS departamento, pe.apellido1, pe.apellido2, pe.nombre FROM persona pe LEFT JOIN profesor pr ON pe.id=pr.id_profesor LEFT JOIN departamento dp ON pr.id_departamento=dp.id ORDER BY dp.nombre, pe.apellido1, pe.apellido2, pe.nombre;

-- 2-Retorna un llistat amb els professors/es que no estan associats a un departament.
SELECT pe.apellido1, pe.apellido2, pe.nombre FROM persona pe LEFT JOIN profesor pr ON pe.id=pr.id_profesor LEFT JOIN departamento dp ON pr.id_departamento=dp.id WHERE dp.nombre IS NULL ORDER BY pe.apellido1, pe.apellido2, pe.nombre;

-- 3-Retorna un llistat amb els departaments que no tenen professors/es associats.
SELECT dp.nombre AS departamento FROM persona pe JOIN profesor pr ON pe.id=pr.id_profesor RIGHT JOIN departamento dp ON pr.id_departamento=dp.id WHERE pe.apellido1 IS NULL;

-- 4-Retorna un llistat amb els professors/es que no imparteixen cap assignatura.
SELECT pe.apellido1, pe.apellido2, pe.nombre FROM persona pe LEFT JOIN profesor pr ON pe.id=pr.id_profesor LEFT JOIN asignatura asi USING (id_profesor) WHERE asi.id IS NULL ORDER BY pe.apellido1, pe.apellido2, pe.nombre;

-- 5-Retorna un llistat amb les assignatures que no tenen un professor/a assignat.
SELECT nombre FROM asignatura WHERE id_profesor IS NULL;

-- 6-Retorna un llistat amb tots els departaments que no han impartit assignatures en cap curs escolar.
SELECT DISTINCT departamento.nombre FROM departamento LEFT JOIN profesor ON departamento.id= profesor.id_departamento LEFT JOIN asignatura ON profesor.id_profesor= asignatura.id_profesor WHERE curso IS NULL;


-- Consultes resum:
-- 1-Retorna el nombre total d'alumnes que hi ha.
SELECT COUNT(*) FROM persona WHERE tipo='alumno';

-- 2-Calcula quants alumnes van néixer en 1999.
SELECT COUNT(*) AS 'Alumnos nacidos en 1999' FROM persona WHERE tipo='alumno' AND fecha_nacimiento LIKE '1999%';

-- 3-Calcula quants professors/es hi ha en cada departament. El resultat només ha de mostrar dues columnes, una amb el nom del departament i una altra amb el nombre de professors/es que hi ha en aquest departament. El resultat només ha d'incloure els departaments que tenen professors/es associats i haurà d'estar ordenat de major a menor pel nombre de professors/es.
SELECT dp.nombre, COUNT(pr.id_profesor) AS total_profesores FROM departamento dp JOIN profesor pr ON pr.id_departamento=dp.id GROUP BY dp.nombre ORDER BY total_profesores DESC;

-- 4- Retorna un llistat amb tots els departaments i el nombre de professors/es que hi ha en cadascun d'ells. Tingui en compte que poden existir departaments que no tenen professors/es associats. Aquests departaments també han d'aparèixer en el llistat.
SELECT dp.nombre, COUNT(pr.id_profesor) AS total_profesores FROM departamento dp LEFT JOIN profesor pr ON pr.id_departamento=dp.id GROUP BY dp.nombre;

-- 5-Retorna un llistat amb el nom de tots els graus existents en la base de dades i el nombre d'assignatures que té cadascun. Tingues en compte que poden existir graus que no tenen assignatures associades. Aquests graus també han d'aparèixer en el llistat. El resultat haurà d'estar ordenat de major a menor pel nombre d'assignatures.
SELECT gr.nombre, COUNT(asi.id_grado) AS numero_asignaturas FROM grado gr LEFT JOIN asignatura asi ON gr.id=asi.id_grado GROUP BY gr.nombre ORDER BY numero_asignaturas DESC;

-- 6-Retorna un llistat amb el nom de tots els graus existents en la base de dades i el nombre d'assignatures que té cadascun, dels graus que tinguin més de 40 assignatures associades.
SELECT gr.nombre, COUNT(asi.id_grado) AS numero_asignaturas FROM grado gr LEFT JOIN asignatura asi ON gr.id=asi.id_grado GROUP BY gr.nombre HAVING numero_asignaturas>40;

-- 7-Retorna un llistat que mostri el nom dels graus i la suma del nombre total de crèdits que hi ha per a cada tipus d'assignatura. El resultat ha de tenir tres columnes: nom del grau, tipus d'assignatura i la suma dels crèdits de totes les assignatures que hi ha d'aquest tipus.
SELECT gr.nombre, asi.tipo, SUM(asi.creditos ) AS total_creditos FROM grado gr JOIN asignatura asi ON gr.id=asi.id_grado GROUP BY gr.nombre;

-- 8-Retorna un llistat que mostri quants alumnes s'han matriculat d'alguna assignatura en cadascun dels cursos escolars. El resultat haurà de mostrar dues columnes, una columna amb l'any d'inici del curs escolar i una altra amb el nombre d'alumnes matriculats.
SELECT ce.anyo_inicio, COUNT(asm.id_asignatura) AS total_alumnos_matriculados FROM curso_escolar ce LEFT JOIN alumno_se_matricula_asignatura asm ON ce.id=asm.id_curso_escolar GROUP BY ce.anyo_inicio;

-- 9-Retorna un llistat amb el nombre d'assignatures que imparteix cada professor/a. El llistat ha de tenir en compte aquells professors/es que no imparteixen cap assignatura. El resultat mostrarà cinc columnes: id, nom, primer cognom, segon cognom i nombre d'assignatures. El resultat estarà ordenat de major a menor pel nombre d'assignatures.
SELECT persona.id, persona.nombre, apellido1, apellido2, COUNT(asignatura.nombre) AS numero_asignaturas FROM persona JOIN profesor ON persona.id = profesor.id_profesor LEFT JOIN asignatura ON profesor.id_profesor= asignatura.id_profesor GROUP BY persona.id ORDER BY numero_asignaturas DESC;

-- 10-Retorna totes les dades de l'alumne/a més jove.
SELECT * FROM persona WHERE tipo="alumno" ORDER BY fecha_nacimiento ASC LIMIT 1;

-- 11-Retorna un llistat amb els professors/es que tenen un departament associat i que no imparteixen cap assignatura.
SELECT pe.nombre, pe.apellido1, pe.apellido2 FROM profesor pr LEFT JOIN asignatura asi USING (id_profesor) JOIN persona pe ON pe.id=pr.id_profesor WHERE asi.id_profesor IS NULL AND pr.id_departamento IS NOT NULL;