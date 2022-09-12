// 1-Escriu una consulta per mostrar tots els documents en la col·lecció Restaurants.
db.restaurantes.find().pretty()

// 2-Escriu una consulta per mostrar el restaurant_id, name, borough i cuisine per tots els documents en la col·lecció Restaurants.
db.restaurantes.find({},{restaurant_id:1, name:1, borough:1, cuisine:1,}).pretty()

// 3-Escriu una consulta per mostrar el restaurant_id, name, borough i cuisine, però exclou el camp _id per tots els documents en la col·lecció Restaurants.
db.restaurantes.find({},{restaurant_id:1, name:1, borough:1, cuisine:1, _id:0}).pretty()

// 4-Escriu una consulta per mostrar restaurant_id, name, borough i zip code, però exclou el camp _id per tots els documents en la col·lecció Restaurants.
db.restaurantes.find({},{restaurant_id:1, name:1, borough:1, "address.zipcode":1, _id:0}).pretty()
db.restaurantes.find({},{restaurant_id:1, name:1, borough:1, address: {zipcode:1}, _id:0}).pretty()

// 5-Escriu una consulta per mostrar tots els restaurants que estan en el Bronx.
db.restaurantes.find({ borough: "Bronx"}).pretty()

// 6- Escriu una consulta per mostrar els primers 5 restaurants que estan en el Bronx.
db.restaurantes.find({ borough: "Bronx"}).limit(5).pretty()

// 7-Escriu una consulta per mostrar el pròxim 5 restaurants després de saltar els primers 5 del Bronx.
db.restaurantes.find({ borough: "Bronx"}).limit(5).skip(5).pretty()

// 8-Escriu una consulta per trobar els restaurants que tenen un score de més de 90.
db.restaurantes.find({"grades.score":{$gt:90}}).pretty();

// 9-Escriu una consulta per trobar els restaurants que tenen un score de més de 80 però menys que 100.
db.restaurantes.find({"grades.score": {$gt:80, $lt:100} }).pretty()

// 10-Escriu una consulta per trobar els restaurants que es localitzen en valor de latitud menys de -95.754168.
db.restaurantes.find({"address.coord": {$lt: -95.754168}}).pretty()

// 11-Escriu una consulta de MongoDB per a trobar els restaurants que no preparen cap cuisine de 'American' i la seva qualificació és superior a 70 i latitud inferior a -65.754168.
db.restaurantes.find({$and: [ {cuisine: {$nin: ["American "]}}, {"grades.score": {$gt:70}}, {"address.coord": {$lt: -65.754168}} ]}).pretty()

// 12-Escriu una consulta per trobar els restaurants que no preparen cap cuisine de 'American' i van aconseguir un marcador més de 70 i localitzat en la longitud menys que -65.754168. Nota: Fes aquesta consulta sense utilitzar $and operador.
db.restaurantes.find({cuisine: {$nin: ["American "]}, "grades.score": {$gt:70}, "address.coord": {$lt: -65.754168}}).pretty()

// 13-Escriu una consulta per trobar els restaurants que no preparen cap cuisine de 'American' i van obtenir un punt de grau 'A' no pertany a Brooklyn. S'ha de mostrar el document segons la cuisine en ordre descendent.
db.restaurantes.find({cuisine: {$nin: ["American "]}, "grades.grade": "A", borough: {$nin: ["Brooklyn"]}}).sort({cuisine:1}).pretty()

// 14-Escriu una consulta per trobar el restaurant_id, name, borough i cuisine per a aquells restaurants que contenen 'Wil' com les tres primeres lletres en el seu nom.
db.restaurantes.find({name: /^Wil/},{restaurant_id:1, name:1, borough:1, cuisine:1,}).pretty()

// 15- Escriu una consulta per trobar el restaurant_id, name, borough i cuisine per a aquells restaurants que contenen 'ces' com les últimes tres lletres en el seu nom.
db.restaurantes.find({name: /ces$/},{restaurant_id:1, name:1, borough:1, cuisine:1,}).pretty()










