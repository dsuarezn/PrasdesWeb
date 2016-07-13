# PrasdesWeb
Código de herramientas de migración, exposición de servicios de datos y de configuración, modelo de datos

Siempre subir primero los servicios de datos y una vez arriba si subir el cliente web porque el gestor de las tareas del cliente web intenta
obtener una respuesta del servicio de condifuracion de tareas al inicio y si no responde no sube el cliente.

El stack de tecnologias es 
Jpa - Mapeo objeto relacional 
Springboot - Configuración rapida del proyecto web
Angular - Modelo Web Controladores en cliente
Quartz - Tareas Programadas
Dozer - Mapeo de objetos
Thymeleaf - Maquetación (Esto podria cambiarse si alguien se da la pela de meter otra como tiles o una en angular)

No tiene seguridad, tiene deshabilitadas las cabezeras cors porque tuve algunos problemas con el cliente web
