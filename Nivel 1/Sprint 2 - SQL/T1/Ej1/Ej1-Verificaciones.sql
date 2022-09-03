-- Lista el total de facturas de un cliente/a en un período determinado.
USE optica;
SELECT *
FROM facturas
WHERE fecha <'2022-01-01' AND clientes_id = 3;

-- Lista los diferentes modelos de gafas que ha vendido un empleado durante un año.
USE optica;
SELECT 
	e.empleado_nombre,
	m.descripcion AS 'marca-modelo',
    f.fecha AS fecha_venta
FROM gafas g
JOIN marca m
	USING (marca_id)
JOIN detalle_factura df
	USING (gafas_id)
JOIN facturas f
	USING (facturas_id)
JOIN empleados e
	USING (empleado_id)
WHERE f.empleado_id=1 AND (f.fecha BETWEEN '2019-01-01' AND '2020-01-01' );

-- Lista a los diferentes proveedores que han suministrado gafas vendidas con éxito por la óptica.
USE optica;
SELECT
	fa.facturas_id,
	pr.proveedor_nombre,
    pr.proveedor_nif,
    ga.gafas_id AS 'id de gafa vendida',
    m.descripcion AS 'marca-modelo'
FROM facturas fa
JOIN detalle_factura df
	USING (facturas_id)
JOIN gafas ga
	USING (gafas_id)
JOIN marca m
	USING (marca_id)
JOIN proveedores pr
	USING (proveedor_id);
