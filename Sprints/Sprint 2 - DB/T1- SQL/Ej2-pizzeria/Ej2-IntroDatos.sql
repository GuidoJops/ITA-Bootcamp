USE pizzeria;
-- AGREGA TIENDAS
INSERT INTO tienda VALUES 
		(DEFAULT, 'Rosello 93', '08020', 'Barcelona', 'Barcelona'),
        (DEFAULT, 'Sant Marti 21', '08090', 'Badalona', 'Barcelona');
	
-- AGREGA TIPO EMPLEADOS
INSERT INTO tipo_empleado VALUES 
			(DEFAULT,'Cocinero'),
            (DEFAULT, 'Repartidor');
            
-- AGREGA EMPLEADOS
INSERT INTO empleado VALUES 
			(DEFAULT, 'Juan', 'Gomez', '26592045H', '663 983 758', 1, 1),
            (DEFAULT, 'María', 'Gutierrez', '46572049J', '633 587 773', 1, 2),
            (DEFAULT, 'Carlos', 'Smith', '56832541G', '645 587 543', 1, 2),
            (DEFAULT, 'Gonzalo', 'Torres', '27892044H', '601 933 557', 2, 1),
            (DEFAULT, 'Alejandra', 'Nuñez', '16973009J', '633 587 773', 2, 2),
            (DEFAULT, 'Sebastian', 'Conte', '34348741F', '665 042 098', 2, 2);
            
-- AGREGA TIPO PRODUCTO
INSERT INTO tipo_producto VALUES 
			(DEFAULT, 'Pizza'),
            (DEFAULT, 'Hamburguesa'),
            (DEFAULT, 'Bebida');
            
-- AGREGA CATEGORIAS PIZZAS
INSERT INTO categoria_pizza VALUES 
			(DEFAULT, 'Normal'),
            (DEFAULT, 'Especial'),
            (DEFAULT, 'Individual');
            
-- AGREGA PRODUCTOS
INSERT INTO producto VALUES
		(DEFAULT, 'Pizza Margarita', 'salsa tomate y muzzarela', 
        LOAD_FILE('C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\ITA\\S2t1-images\\p_margarita.jpg'), 8, 1, 1),
        (DEFAULT, 'Pizza Vegetal', 'tomate, cebolla, pimientos y  muzzarela', 
        LOAD_FILE('C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\ITA\\S2t1-images\\p_vegetal.jpg'), 10.5, 1, 2),
        (DEFAULT, 'Pizza Pollo', 'salsa tomate, pollo y muzzarela', 
        LOAD_FILE('C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\ITA\\S2t1-images\\p_pollo.jpg'), 12, 1, 2),
        (DEFAULT, 'Coca-Cola', 'gaseosa sabor cola', 
        LOAD_FILE('C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\ITA\\S2t1-images\\g_coca-cola.jpg'), 3.5, 3, DEFAULT),
        (DEFAULT, 'Agua mineral', NULL, 
        LOAD_FILE('C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\ITA\\S2t1-images\\g_agua.jpg'), 2, 3, DEFAULT),
        (DEFAULT, 'Jugo citrico', 'limón y naranja', 
        LOAD_FILE('C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\ITA\\S2t1-images\\g_jugo.jpg'), 3, 3, DEFAULT),
        (DEFAULT, 'Hamburguesa Completa', 'tomate, queso, lechuga', 
        LOAD_FILE('C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\ITA\\S2t1-images\\h_hamburguesa-comp.jpg'), 10.7, 2, DEFAULT),
        (DEFAULT, 'Hamburguesa Vegana', 'a base de lentejas', 
        LOAD_FILE('C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\ITA\\S2t1-images\\h_hamburguesa-veg.jpg'), 11, 2, DEFAULT);

-- AGREGA TIPO PEDIDO
INSERT INTO tipo_pedido VALUES 
			(DEFAULT, 'Delivery'),
            (DEFAULT, 'Tienda');
            
-- AGREGA CLIENTES
INSERT INTO cliente VALUES
			(DEFAULT, 'Jose', 'Brunetti', 'Barri Vermell 12', '08030','Barcelona','Barcelona','987 098 320'),
            (DEFAULT, 'Pedro', 'Gomez', 'Estadella 45', '08030','Barcelona','Barcelona','687 093 321'),
            (DEFAULT, 'Magdalena', 'Vazques', 'Palomar 12', '08016','Barcelona','Badalona','657 198 328'),
            (DEFAULT, 'Belen', 'Barreiro', 'Independencia 57', '08010','Barcelona','Hospitalet','601 398 425');
            
-- AGREGA PEDIDOS
-- PEDIDO 1
INSERT INTO pedido VALUES
		(DEFAULT, DEFAULT, 1, 1, 2, 1, NULL, NULL, NULL, NULL);
        -- AGREGA DETALLE PEDIDO
INSERT INTO detalle_pedido VALUES
		(1,2,1),
        (1,5,2),
        (1,7,1);
		-- ACTUALIZA TABLA PEDIDO
UPDATE pedido SET
		cantidad_productos = (SELECT SUM(cantidad) FROM detalle_pedido WHERE pedido_id =1),
        precio_total= (SELECT SUM(dp.cantidad * p.precio) FROM detalle_pedido dp JOIN producto p USING (producto_id) 
        WHERE pedido_id=1) WHERE pedido_id=1;

-- PEDIDO 2
INSERT INTO pedido VALUES
		(DEFAULT, DEFAULT, 2, 2, 1, 1, NULL, NULL, NULL, NULL);
        -- AGREGA DETALLE PEDIDO
INSERT INTO detalle_pedido VALUES
		(2,1,1),
        (2,4,4),
        (2,8,3);
		-- ACTUALIZA TABLA PEDIDO
UPDATE pedido SET
		cantidad_productos = (SELECT SUM(cantidad) FROM detalle_pedido WHERE pedido_id =2),
        precio_total= (SELECT SUM(dp.cantidad * p.precio) FROM detalle_pedido dp JOIN producto p USING (producto_id) WHERE pedido_id=2),
        repartidor_id = 2,
        fecha_entrega = (SELECT CURRENT_TIMESTAMP + INTERVAL 30 MINUTE)
        WHERE pedido_id=2;
        
-- PEDIDO 3
INSERT INTO pedido VALUES
		(DEFAULT, DEFAULT, 3, 2, 1, 5, NULL, NULL, NULL, NULL);
        -- AGREGA DETALLE PEDIDO
INSERT INTO detalle_pedido VALUES
		(3,2,2),
        (3,6,1);
		-- ACTUALIZA TABLA PEDIDO
UPDATE pedido SET
		cantidad_productos = (SELECT SUM(cantidad) FROM detalle_pedido WHERE pedido_id =3),
        precio_total= (SELECT SUM(dp.cantidad * p.precio) FROM detalle_pedido dp JOIN producto p USING (producto_id) WHERE pedido_id=3),
        repartidor_id = 3,
        fecha_entrega = (SELECT CURRENT_TIMESTAMP + INTERVAL 30 MINUTE)
        WHERE pedido_id=3;
        
-- PEDIDO 4
INSERT INTO pedido VALUES
		(DEFAULT, DEFAULT, 4, 1, 2, 5, NULL, NULL, NULL, NULL);
        -- AGREGA DETALLE PEDIDO
INSERT INTO detalle_pedido VALUES
		(4,4,2),
        (4,7,2);
		-- ACTUALIZA TABLA PEDIDO
UPDATE pedido SET
		cantidad_productos = (SELECT SUM(cantidad) FROM detalle_pedido WHERE pedido_id =4),
        precio_total= (SELECT SUM(dp.cantidad * p.precio) FROM detalle_pedido dp JOIN producto p USING (producto_id) WHERE pedido_id=4)
        WHERE pedido_id=4;


    
        

				
        
            


      
        




