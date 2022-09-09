use optica //CREA  BD OPTICA
// AGREGA EMPLEADOS
db.empleados.insertMany([{
        _id:1,
        nombre: "Juan",
        apellido: "Garcia",
        dni: "265920435H"
    },
    {
        _id:2,
        nombre: "Pablo",
        apellido: "Hernandez",
        dni: "48393493I"
    },
    {
        _id:3,
        nombre:"María",
        apellido:"Gonzales",
        dni: "693835328J"

}])
// AGREGA PROVEEDORES
db.proveedores.insertMany([{
        _id:1,
        nombre: "Bilbao Lens",
        telefono: "944 634 749",
        fax: "908 984 234",
        nif: "67593843C",
        direccion: {
                    calle: "Corsega", 
                    numero: 54, 
                    piso:"6", 
                    puerta:"B", 
                    ciudad: "Bilbao", 
                    cod_postal:"0390", 
                    pais: "España"
             }
    },
    {
        _id:2,
        nombre: "Gafa Spain",
        telefono: "434 543 434",
        nif: "37549384B",
        direccion: {
                    calle: "Sant Andria", 
                    numero: 43, 
                    piso:"2", 
                    ciudad: "Barcelona", 
                    cod_postal:"0830", 
                    pais: "España"
             }
    },
    {
        _id:3,
        nombre: "Engafado",
        telefono: "655 600 008",
        fax: "933 234 746",
        nif: "331893843C",
        direccion: {
                    calle: "Arago", 
                    numero: 78, 
                    piso:"4",
                    puerta: "3",
                    ciudad: "Madrid", 
                    cod_postal:"07034", 
                    pais: "España"
             }
}])
// AGREGA MARCAS
db.marcas.insertMany([{
    _id:"RAYBAN",
    proveedor_id: 2  
},
{
    _id:"OAKLEY",
    proveedor_id: 2  
},
{
    _id:"POLAROID",
    proveedor_id: 3  
},
{
    _id:"TOUS",
    proveedor_id: 2  
},
{
    _id:"NIKE",
    proveedor_id: 1  
}])
// AGREGA GAFAS
db.gafas.insertMany([{
        _id:1,
        marca_id: "RAYBAN",
        graduacion_izq: 0.5,
        graduacion_der: 1,
        montura: "Metálica",
        color:[{montura: "verde", cristal: "amarillo"}],
        precio: 190
        
    },
    {
        _id:2,
        marca_id: "OAKLEY",
        graduacion_izq: 1,
        graduacion_der: 1,
        montura: "Flotante",
        color:[{montura: "rojo", cristal: "gris"}],
        precio: 140   
    },
    {
        _id:3,
        marca_id: "POLAROID",
        graduacion_izq: 0,
        graduacion_der: 0,
        montura: "Pasta",
        color:[{montura: "blanco", cristal: "azul"}],
        precio: 99   
    },
    {
        _id:4,
        marca_id: "TOUS",
        graduacion_izq: 1.25,
        graduacion_der: 0,
        montura: "Flotante",
        color:[{montura: "crema", cristal: "rosa"}],
        precio: 70  
    },
    {
        _id:5,
        marca_id: "NIKE",
        graduacion_izq: 1.25,
        graduacion_der: 1.5,
        montura: "Flotante",
        color:[{montura: "rojo", cristal: "gris"}],
        precio: 170  
}])
// AGREGA CLIENTES
db.clientes.insertMany([{
    _id:1,
    nombre:"Pedro",
    apellido:"Martinez",
    cod_postal: "08020",
    telefono: "663 983 439",
    email: "pedro@gmail.com",
    fecha_reg: "2021-05-18",
    compras: [{vendedor: "Juan", gafas_id:1}]    
},
{
    _id:2,
    nombre:"Alejandra",
    apellido:"Nuñez",
    cod_postal: "08030",
    telefono: "634 983 645",
    email: "ale@gmail.com",
    fecha_reg: "2022-03-11",
    recomendado_cliente_id: 1,
    compras: [{vendedor: "Pablo", gafas_id:2}]    
},
{
    _id:3,
    nombre:"Carlos",
    apellido:"Sanchez",
    cod_postal: "07020",
    telefono: "666 987 289",
    fecha_reg: "2020-12-11",
    recomendado_cliente_id: 1,
    compras: [{vendedor: "Juan", gafas_id:3},
              {vendedor: "María", gafa_id:5}]    
},
{
    _id:4,
    nombre:"Irene",
    apellido:"De La Torre",
    cod_postal: "08030",
    telefono: "623 423 275",
    fecha_reg: "2022-08-24",
    recomendado_cliente_id: 2,
    compras: [{vendedor: "Pablo", gafas_id:1},
              {vendedor: "María", gafa_id:4}]    

}])
