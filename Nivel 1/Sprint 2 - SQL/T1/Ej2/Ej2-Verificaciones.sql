-- VERIFICACÇIONES EJ2--

-- Lista cuántos productos de categoría 'Bebidas' se han vendido en una determinada localidad.
-- MUESTRA TOTAL BEBIDAS VENDIDAS EN BARCELONA
SELECT SUM(dp.cantidad) AS 'Total Bebidas vendidas en Barcelona'
FROM cliente c JOIN pedido p USING (cliente_id) JOIN detalle_pedido dp USING (pedido_id) JOIN producto pr USING (producto_id)
WHERE pr.tipo_producto_id = 3 AND c.localidad ='Barcelona';

-- LISTA PEDIDOS QUE CONTIENEN BEBIDAS VENDIDAS EN BARCELONA
SELECT 
	c.localidad,
    pr.tipo_producto_id,
    pr.nombre,
    dp.cantidad
FROM cliente c JOIN pedido p USING (cliente_id) JOIN detalle_pedido dp USING (pedido_id) JOIN producto pr USING (producto_id)
WHERE pr.tipo_producto_id = 3 AND c.localidad ='Barcelona';

-- Lista cuántos pedidos ha efectuado un determinado empleado/a.
-- MUESTRA TOTAL DE PEDIDOS
SELECT count(*) AS 'Pedidos hechos por Juan'
FROM empleado e JOIN pedido p USING (empleado_id)
WHERE e.nombre ='Juan';

-- LISTA PEDIDOS
SELECT 
	e.nombre,
    p.pedido_id
FROM empleado e JOIN pedido p USING (empleado_id)
WHERE e.nombre ='Juan';

