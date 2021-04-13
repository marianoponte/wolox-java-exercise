# wolox-java-exercise

Ejercicio WChallenge

Para este ejercicio opté por usar las siguientes tecnologías: Java 11, Gradle, Spring Boot (usando Spring Initializr), Spring Data JPA, PostgreSQL y Postman para hacer las pruebas a las API REST.
La API consumida de terceros: https://jsonplaceholder.typicode.com/

Para levantar el proyecto primero se debe crear una base de datos y linkearlo en el archivo de "application-dev.properties". Completando la url, username y passsword correspondientes. El proyecto crea la tabla y los campos correspondientes.
El puerto donde se levanta la aplicación también se puede modificar en el mismo archivo.

Para probar las soluciones a lo pedido:

Primera Parte:
1. Los usuarios: http://<host>:<puerto>/wolox-java-exercise/api/users GET
2. Las fotos: http://<host>:<puerto>/wolox-java-exercise/api/photos GET 
3. Los álbumes: http://<host>:<puerto>/wolox-java-exercise/api/albums, álbumes de cada usuario: http://<host>:<puerto>/wolox-java-exercise/api/users/{userId}/albums GET
4. Las fotos de un usuario: http://<host>:<puerto>/wolox-java-exercise/api/users/{userId}/photos GET

Segunda Parte:
1. Registrar un álbum compartido con un usuario y sus permisos: http://<host>:<puerto>/wolox-java-exercise/api/permission POST
Ejemplo: {
    "albumId": 1,
    "userId": 2,
    "write": false,
    "read": true
}
  
2. Cambiar los permisos de un usuario para un álbum determinado: http://<host>:<puerto>/wolox-java-exercise/api/albums/{albumId}/permissions PUT
Ejemplo: {
    "userId": 2,
    "write": false,
    "read": true
}
 
3. Traer todos los usuarios que tienen un permiso determinado respecto a un álbum específico: http://<host>:<puerto>/wolox-java-exercise/api/albums/{albumId}/users?write={boolean}&&read={boolean} GET. Se puede filtrar por cualquier permiso también u omitirlo.
  
4. Los comentarios filtrados por el campo name (opcional): http://<host>:<puerto>/wolox-java-exercise/api/comments?name={valor} GET

Los comentarios de un usuario: http://<host>:<puerto>/wolox-java-exercise/api/users/{userId}/comments GET
