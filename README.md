# springbootTecnicalTest

# para ejecutar este proyecto abrir la carpeta del mismo y ejecutar el comando:

docker compose up


# esto creara una base de datos mongo y levantara un seridor tomcat en el puerto 8080

# una vez levantados se puede ejecutar los siguientes metodos desde postman(todos los metodos requieren un token nuevo valido a excepcion del metodo "generateToken")

# 1) generar token:

  curl --location --request GET 'http://localhost:8080/project/generateToken'
  
# 2) obetener todos los archivos:

curl --location --request GET 'http://localhost:8080/project/getAllDocuments' \
--header 'token: eyJhbGciOiJIUzUxMiJ9.eyJleHAiOjE2NzIwMzM2MDV9.pPtp1C5mfBaa99dDcDvbytS8VzIjHIQkZ77sv3VSJBBYwSXnfSFTa9c6QFHoVUa2UNP8XMO4TkQABaY2r_B-sg'

# 3) obtener un unico archivo por objectId:

curl --location --request GET 'http://localhost:8080/project/findDocument?id=63a89bda64254d649ef55eb5' \
--header 'token: eyJhbGciOiJIUzUxMiJ9.eyJleHAiOjE2NzE5OTgxMjN9.ZiPKmu65-VxN0zL2bzpWtadlGCKQn5-Zww3h2kJbACO5z3OrhGk-jzrkED0211_btfKAk0QKpHwHgWaJSOUj0Q'

# 4) crear un nuevo documento:

curl --location --request POST 'http://localhost:8080/project/newDocument' \
--header 'token: eyJhbGciOiJIUzUxMiJ9.eyJleHAiOjE2NzIwMzM2MDV9.pPtp1C5mfBaa99dDcDvbytS8VzIjHIQkZ77sv3VSJBBYwSXnfSFTa9c6QFHoVUa2UNP8XMO4TkQABaY2r_B-sg' \
--header 'Content-Type: application/json' \
--data-raw ' {
"number":"555",
"expiryDate":"5/56",
"emissionDate":"31/12/2019",
"documentName": "Carol",
"documentCode":"2054"
 }
 '
 
 # 5) editar un documento por object id:
 
 curl --location --request PUT 'http://localhost:8080/project/updateDocument' \
--header 'token: eyJhbGciOiJIUzUxMiJ9.eyJleHAiOjE2NzE5OTgyODN9.gQDy_SzzJroXZPaGw6dZh3Tk68q5h2CTdeEcrDRKOIFGU60PJVV_A695Jh197KyzIMQSG-GA_N7Kq_2Bzm5kpA' \
--header 'Content-Type: application/json' \
--data-raw ' {
"objectId": "63a8aae850e86829b1b91192",
"number":"4444",
"expiryDate":"5/99",
"emissionDate":"31/12/2005",
"documentName": "Cris",
"documentCode":"1010"
 }
 '
 
 # 6) eliminar un documento en base a un object id:
 
 curl --location --request DELETE 'http://localhost:8080/project/deleteDocument?id=63a8aae850e86829b1b91192' \
--header 'token: eyJhbGciOiJIUzUxMiJ9.eyJleHAiOjE2NzE5OTgzMjV9.vx6AectFIOtip25jRIRf-qhPrjrssGvTdrdF1K7LP6ItptIUYaf2Z_N31tQU_Bl7zPGpFOr-HH9de-_MOF8U9Q'
  
 
