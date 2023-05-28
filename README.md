Proyecto API REST --> Devsu

JDK 11
Spring Boot 2.7.12

Base de datos hecha en MySQL 8.0.33

Credenciales Database:

User: root
Password: password

Cambiar credenciales en: src/resourcer/application.yml

Swagger API: localhost:8081/swagger-ui/index.html

Ejemplo de path para reporte: localhost:8081/api/reportes?usuario=1004808530&fecha=20/05/2023&fecha=27/05/2023

usuario = { Documento usuario }
fecha = { Fecha inicio del reporte }
fecha = { Fecha final del reporte }

Las fechas deben estar en formato dd/MM-yyyy y deben respectivamente ser menor que la otra.

En src/resources/test-postman se encuentran las pruebas en formato JSON para Postman.

En src/resources/database-MySQL se encuentra la base de datos BaseDatos.sql

Se deberá importar esta base de datos en MySQL para el reconocmiento del puerto.