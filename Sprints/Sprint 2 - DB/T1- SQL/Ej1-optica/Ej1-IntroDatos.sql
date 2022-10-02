USE optica;
-- AGREGA EMPLEADOS
INSERT INTO empleados VALUES 
		(DEFAULT, 'Juan', 'Garcia', '26502837H'),
		(DEFAULT, 'Pablo', 'Hernandez', '48375837I'),
		(DEFAULT, 'Maria', 'Gonzales', '69387569J');

-- AGREGO PROVEEDORES
INSERT INTO proveedores VALUES 
			(DEFAULT,'Gafa Spain','434 543 434', NULL, '37549384B', 'Sant Andria', 43, 2, NULL, 'Barcelona', '08030','España'),
            (DEFAULT,'Bilbao Lens','944 634 749', '908 984 234', '67593843C', 'Corsega', 54, 6, 'B', 'Bilbao', '03090','España'),
            (DEFAULT,'Engafado','655 600 008', '933 234 746', '31893843C', 'Arago', 78, 4, '3', 'Madrid', '07034','España'),
            (DEFAULT,'Opticus','654 432 049', NULL, '24665823A', 'Independencia', 782, NULL, NULL, 'Valencia', '07053','España');
            
-- AGREGA MARCA-GAFAS
INSERT INTO marca VALUES
		(DEFAULT, 'RAYBAN', 1),
        (DEFAULT, 'OAKLEY', 2),
        (DEFAULT, 'POLAROID', 2),
        (DEFAULT, 'TOUS', 2),
        (DEFAULT, 'NIKE', 3),
        (DEFAULT, 'PRADA', 3),
        (DEFAULT, 'ADIDAS', 4);
        
-- AGREGA GAFAS
INSERT INTO gafas VALUES 
		(DEFAULT, DEFAULT, 0.50, 'M','rojo','gris', 99.99, 1),
        (DEFAULT, 0.25, DEFAULT,'M','verde','amarillo', 190, 2),
        (DEFAULT, 1.50, 0.50, 'F','azul','verde', 125.39, 3),
        (DEFAULT, DEFAULT, DEFAULT,'F','gris','marron', 98, 4),
        (DEFAULT, DEFAULT, 1, 'P','blanco','azul', 107.99, 5),
        (DEFAULT, DEFAULT, 0.75,'P','crema','rosa', 120.59, 5),
        (DEFAULT, DEFAULT, DEFAULT,'M','rojo','gris', 189.99, 7);
        
        
-- AGREGA CLIENTES
INSERT INTO clientes VALUES
		(DEFAULT, 'Pedro', 'Martinez', '08020', '663 983 758', 'pedro@gmail.com', DEFAULT, DEFAULT),
        (DEFAULT, 'Alejandra', 'Nuñez', '08030', '634 983 645', 'ale@gmail.com', DEFAULT, 1),
        (DEFAULT, 'Carlos', 'Sanchez', '07020', NULL, NULL, DEFAULT, 2),
        (DEFAULT, 'Irene', 'De La Torre', NULL, '663 983 786', 'irenedlt@gmail.com', DEFAULT, 3);

-- AGREGA FACTURAS
-- FACTURA 1
INSERT INTO facturas VALUES 
		(DEFAULT, '2020-06-28', 3, 1, NULL);
        -- AGREGA DETALLE FACTURA
INSERT INTO detalle_factura VALUES
		(1,2,1),
        (1,4,1);
        -- ACTUALIZA TABLA FACTURA
UPDATE facturas SET
		total_importe= (SELECT SUM(df.cantidad * g.precio) FROM detalle_factura df JOIN gafas g USING (gafas_id) 
        WHERE facturas_id=1) WHERE facturas_id=1;
        
-- FACTURA 2
INSERT INTO facturas VALUES 
		(DEFAULT, DEFAULT, 1, 1, NULL);
        -- AGREGA DETALLE FACTURA
INSERT INTO detalle_factura VALUES
		(2,4,2);
        -- ACTUALIZA TABLA FACTURA
UPDATE facturas SET
		total_importe= (SELECT SUM(df.cantidad * g.precio) FROM detalle_factura df JOIN gafas g USING (gafas_id) 
        WHERE facturas_id=2) WHERE facturas_id=2;
        
-- FACTURA 3
INSERT INTO facturas VALUES 
		(DEFAULT, '2022-04-10', 2, 1, NULL);
        -- AGREGA DETALLE FACTURA
INSERT INTO detalle_factura VALUES
		(3,5,1),
        (3,1,2);
        -- ACTUALIZA TABLA FACTURA
UPDATE facturas SET
		total_importe= (SELECT SUM(df.cantidad * g.precio) FROM detalle_factura df JOIN gafas g USING (gafas_id) 
        WHERE facturas_id=3) WHERE facturas_id=3;
        
-- FACTURA 4
INSERT INTO facturas VALUES 
		(DEFAULT, '2019-06-19', 3, 1, NULL);
        -- AGREGA DETALLE FACTURA
INSERT INTO detalle_factura VALUES
		(4,3,1);
        
        -- ACTUALIZA TABLA FACTURA
UPDATE facturas SET
		total_importe= (SELECT SUM(df.cantidad * g.precio) FROM detalle_factura df JOIN gafas g USING (gafas_id) 
        WHERE facturas_id=4) WHERE facturas_id=4;
        
-- FACTURA 5
INSERT INTO facturas VALUES 
		(DEFAULT, '2022-07-20', 4, 2, NULL);
        -- AGREGA DETALLE FACTURA
INSERT INTO detalle_factura VALUES
		(5,7,1),
        (5,6,1),
        (5,2,1);
        
        -- ACTUALIZA TABLA FACTURA
UPDATE facturas SET
		total_importe= (SELECT SUM(df.cantidad * g.precio) FROM detalle_factura df JOIN gafas g USING (gafas_id) 
        WHERE facturas_id=5) WHERE facturas_id=5;
        
-- FACTURA 6
INSERT INTO facturas VALUES 
		(DEFAULT, '2021-12-13', 3, 3, NULL);
        -- AGREGA DETALLE FACTURA
INSERT INTO detalle_factura VALUES
		(6,6,1);
        
        -- ACTUALIZA TABLA FACTURA
UPDATE facturas SET
		total_importe= (SELECT SUM(df.cantidad * g.precio) FROM detalle_factura df JOIN gafas g USING (gafas_id) 
        WHERE facturas_id=6) WHERE facturas_id=6;
        




