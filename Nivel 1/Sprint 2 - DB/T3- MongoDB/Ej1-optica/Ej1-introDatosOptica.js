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
                    codPostal:"0390", 
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
                    codPostal:"0830", 
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
                    codPostal:"07034", 
                    pais: "España"
             }
}])
// AGREGA MARCAS
db.marcas.insertMany([{
    _id:"RAYBAN",
    proveedorId: 2  
},
{
    _id:"OAKLEY",
    proveedorId: 2  
},
{
    _id:"POLAROID",
    proveedorId: 3  
},
{
    _id:"TOUS",
    proveedorId: 2  
},
{
    _id:"NIKE",
    proveedorId: 1  
}])
// AGREGA GAFAS
db.gafas.insertMany([{
        _id:1,
        marcaId: "RAYBAN",
        graduacionIzq: 0.5,
        graduacionDer: 1,
        montura: "Metálica",
        color:[{montura: "verde", cristal: "amarillo"}],
        precio: 190
        
    },
    {
        _id:2,
        marcaId: "OAKLEY",
        graduacionIzq: 1,
        graduacionDer: 1,
        montura: "Flotante",
        color:[{montura: "rojo", cristal: "gris"}],
        precio: 140   
    },
    {
        _id:3,
        marcaId: "POLAROID",
        graduacionIzq: 0,
        graduacionDer: 0,
        montura: "Pasta",
        color:[{montura: "blanco", cristal: "azul"}],
        precio: 99   
    },
    {
        _id:4,
        marcaId: "TOUS",
        graduacionIzq: 1.25,
        graduacionDer: 0,
        montura: "Flotante",
        color:[{montura: "crema", cristal: "rosa"}],
        precio: 70  
    },
    {
        _id:5,
        marcaIid: "NIKE",
        graduacionIzq: 1.25,
        graduacionDer: 1.5,
        montura: "Flotante",
        color:[{montura: "rojo", cristal: "gris"}],
        precio: 170  
}])
// AGREGA CLIENTES
db.clientes.insertMany([{
    _id:1,
    nombre:"Pedro",
    apellido:"Martinez",
    codPostal: "08020",
    telefono: "663 983 439",
    email: "pedro@gmail.com",
    fechaReg: new ISODate("2022-05-18T14:10:30Z"),
    compras: [{vendedor: "Juan", gafasId:1}]    
},
{
    _id:2,
    nombre:"Alejandra",
    apellido:"Nuñez",
    codPostal: "08030",
    telefono: "634 983 645",
    email: "ale@gmail.com",
    fechaReg: new ISODate("2022-07-20T12:46:38Z"),
    recomendadoClienteId: 1,
    compras: [{vendedor: "Pablo", gafasId:2}]    
},
{
    _id:3,
    nombre:"Carlos",
    apellido:"Sanchez",
    codPostal: "07020",
    telefono: "666 987 289",
    fechaReg: new ISODate("2022-11-14T20:50:22Z"),
    recomendadoClienteId: 1,
    compras: [{vendedor: "Juan", gafasId:3},
              {vendedor: "María", gafasId:5}]    
},
{
    _id:4,
    nombre:"Irene",
    apellido:"De La Torre",
    codPostal: "08030",
    telefono: "623 423 275",
    fechaReg: new ISODate("2021-12-22T12:23:45Z"),
    recomendadoClienteId: 2,
    compras: [{vendedor: "Pablo", gafasId:1},
              {vendedor: "María", gafasId:4}]    

}])
