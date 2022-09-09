-- Consultes resum:
-- 1-Retorna el nombre total d'alumnes que hi ha.
SELECT COUNT(*) FROM persona WHERE tipo='alumno';

-- 2-Calcula quants alumnes van néixer en 1999.
SELECT COUNT(*) AS 'Alumnos nacidos en 1999' FROM persona WHERE tipo='alumno' AND fecha_nacimiento LIKE '1999%';

-- 3-Calcula quants professors/es hi ha en cada departament. El resultat només ha de mostrar dues columnes, una amb el nom del departament i una altra amb el nombre de professors/es que hi ha en aquest departament. El resultat només ha d'incloure els departaments que tenen professors/es associats i haurà d'estar ordenat de major a menor pel nombre de professors/es.
SELECT dp.nombre, COUNT(pr.id_profesor) AS total_profesores FROM departamento dp JOIN profesor pr ON pr.id_departamento=dp.id GROUP BY dp.nombre ORDER BY total_profesores DESC;

-- 4- Retorna un llistat amb tots els departaments i el nombre de professors/es que hi ha en cadascun d'ells. Tingui en compte que poden existir departaments que no tenen professors/es associats. Aquests departaments també han d'aparèixer en el llistat.
-- CHEQUEAR
SELECT dp.nombre, COUNT(pr.id_profesor) AS total_profesores FROM departamento dp LEFT JOIN profesor pr ON pr.id_departamento=dp.id GROUP BY dp.nombre;

-- 5-Retorna un llistat amb el nom de tots els graus existents en la base de dades i el nombre d'assignatures que té cadascun. Tingues en compte que poden existir graus que no tenen assignatures associades. Aquests graus també han d'aparèixer en el llistat. El resultat haurà d'estar ordenat de major a menor pel nombre d'assignatures.
SELECT gr.nombre, COUNT(asi.id_grado) AS numero_asignaturas FROM grado gr LEFT JOIN asignatura asi ON gr.id=asi.id_grado GROUP BY gr.nombre ORDER BY numero_asignaturas DESC;

-- 6-Retorna un llistat amb el nom de tots els graus existents en la base de dades i el nombre d'assignatures que té cadascun, dels graus que tinguin més de 40 assignatures associades.
SELECT gr.nombre, COUNT(asi.id_grado) AS numero_asignaturas FROM grado gr LEFT JOIN asignatura asi ON gr.id=asi.id_grado GROUP BY gr.nombre HAVING numero_asignaturas>40;

-- 7-Retorna un llistat que mostri el nom dels graus i la suma del nombre total de crèdits que hi ha per a cada tipus d'assignatura. El resultat ha de tenir tres columnes: nom del grau, tipus d'assignatura i la suma dels crèdits de totes les assignatures que hi ha d'aquest tipus.
SELECT gr.nombre, asi.tipo, SUM(asi.creditos ) AS total_creditos FROM grado gr JOIN asignatura asi ON gr.id=asi.id_grado GROUP BY gr.nombre;

-- 8-Retorna un llistat que mostri quants alumnes s'han matriculat d'alguna assignatura en cadascun dels cursos escolars. El resultat haurà de mostrar dues columnes, una columna amb l'any d'inici del curs escolar i una altra amb el nombre d'alumnes matriculats.
SELECT ce.anyo_inicio, COUNT(asm.id_asignatura) AS total_alumnos_matriculados FROM curso_escolar ce JOIN alumno_se_matricula_asignatura asm ON ce.id=asm.id_curso_escolar GROUP BY ce.anyo_inicio;

-- 9-Retorna un llistat amb el nombre d'assignatures que imparteix cada professor/a. El llistat ha de tenir en compte aquells professors/es que no imparteixen cap assignatura. El resultat mostrarà cinc columnes: id, nom, primer cognom, segon cognom i nombre d'assignatures. El resultat estarà ordenat de major a menor pel nombre d'assignatures.
SELECT pe.id, pe.nombre, pe.apellido1, pe.apellido2, COUNT(pr.id_profesor) AS numero_de_asignaturas FROM asignatura asi JOIN profesor pr USING (id_profesor) JOIN persona pe ON pe.id=pr.id_profesor GROUP BY asi.id_profesor;

-- 10-Retorna totes les dades de l'alumne/a més jove.
SELECT * FROM persona WHERE fecha_nacimiento = (SELECT MIN(fecha_nacimiento) FROM persona WHERE tipo='alumno');

-- 11-Retorna un llistat amb els professors/es que tenen un departament associat i que no imparteixen cap assignatura.
SELECT pe.nombre, pe.apellido1, pe.apellido2 FROM profesor pr LEFT JOIN asignatura asi USING (id_profesor) JOIN persona pe ON pe.id=pr.id_profesor WHERE asi.id_profesor IS NULL AND pr.id_departamento IS NOT NULL;


