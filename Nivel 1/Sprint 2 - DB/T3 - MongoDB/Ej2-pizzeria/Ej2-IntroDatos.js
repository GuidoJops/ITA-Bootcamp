use pizzeria //CREA  BD OPTICA
// AGREGA PROVINCIAS
db.provincia.insertMany([
    {
        _id:1,
        nombre: "Barcelona",
    },
    {
        _id:2,
        nombre: "Madrid",
    },
    {
        _id:3,
        nombre: "Girona",
    }
])
// AGREGA LOCALIDADES
db.localidad.insertMany([
    {
        _id:1,
        nombre: "Barcelona",
        provincia_id: 1
    },
    {
        _id:2,
        nombre: "Terrasa",
        provincia_id: 1
    },
    {
        _id:3,
        nombre: "Salinas",
        provincia_id: 2
    },
    {
        _id:4,
        nombre: "Valgrande",
        provincia_id: 2
    },
    {
        _id:5,
        nombre: "Mieras",
        provincia_id: 3
    },
    {
        _id:6,
        nombre: "Olot",
        provincia_id: 3
    }

])
// AGREGA TIENDAS
db.tienda.insertMany([
    {
        _id:1,
        direccion: {
            calle:"Corsega",
            numero: 54,
            cod_postal:"08016", 
            localidad_id: 1,
        },        
        empleados:[{
            _id:1,
            nombre: "Juan",
            apellido: "Garcia",
            dni: "32395738F",
            telefono: "654 282 273",
            puesto: "cocinero"
        },
        {
            _id:2,
            nombre: "María",
            apellido: "Perez",
            dni: "57383949H",
            telefono: "652 328 223",
            puesto: "repartidor"
        }]
    },
    {
        _id:2,
        direccion: {
            calle:"Valencia",
            numero: 82,
            cod_postal:"58017", 
            localidad_id: 2,
        },        
        empleados:[{
            _id:1,
            nombre: "Martin",
            apellido: "Lopez",
            dni: "5395756J",
            telefono: "754 282 723",
            puesto: "repartidor"
        },
        {
            _id:2,
            nombre: "Jose",
            apellido: "Sorto",
            dni: "98383948H",
            telefono: "658 849 230",
            puesto: "cocinero"
        }]
    }
 
])
// AGREGA CLIENTES
db.cliente.insertMany([
    {
        _id:1,
        nombre:"Pedro",
        apellido:"Martinez",
        telefono: "663 983 439",
        direccion: {
            calle: "Barri Vermell",
            numero: 9,
            piso: "Atico",
            cod_postal: "08020",
            localidad_id: 1
        }
        
    },
    {
        _id:2,
        nombre:"Alejandra",
        apellido:"Rodriguez",
        telefono: "665 946 432",
        direccion: {
            calle: "Rocafort",
            numero: 234,
            piso: "Entresuelo",
            cod_postal: "08022",
            localidad_id: 1
        }   
    },
    {
        _id:3,
        nombre:"Agustina",
        apellido:"Gonzales",
        telefono: "689 123 438",
        direccion: {
            calle: "Sant Adria",
            numero: 21,
            cod_postal: "08030",
            localidad_id: 1
        }
    }
])
// AGREGA PEDIDOS
db.pedido.insertMany([
    {
        _id: 1,
        fecha: new ISODate("2022-05-18T14:10:30Z"),
        tipo: "Delivery",
        cant_prod: 2,
        precio: 20,
        cliente_id: 1,
        tienda_id: 1,
        fecha_entrega: new ISODate("2022-05-18T14:40:00Z"),
        repartidor: "María",
        detalle_pedido: [
            {
                producto_id: 1,
                cantidad: 1
            },
            {
                producto_id: 2,
                cantidad: 1
            }

        ]
    },
    {
        _id: 2,
        fecha: new ISODate("2022-05-20T12:10:30Z"),
        tipo: "Tienda",
        cant_prod: 1,
        precio: 15,
        cliente_id: 2,
        tienda_id: 2,
        detalle_pedido: [
            {
                producto_id: 3,
                cantidad: 1
            }

        ]
    }
])
// AGREGA PRODUCTOS
db.producto.insertMany([
    {
        _id:1,
        nombre: "Pizza",
        descripcion: "Pizza al horno de leña",
        imagen: null,
        precio: 10,
        categoria: "pizza Margarita"
        
    },
    {
        _id:2,
        nombre: "Pizza",
        descripcion: "Pizza al horno de leña",
        imagen: null,
        precio: 10,
        categoria: "pizza Napolitana"
    },
    {
        _id:3,
        nombre: "Hamburguesa",
        descripcion: "Hamburguesa con tomate y queso",
        imagen: null,
        precio: 15,
    },
    {
        _id:4,
        nombre: "Bebida",
        descripcion: "Coca-cola",
        imagen: null,
        precio: 2,
    }
])

