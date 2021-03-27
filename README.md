# web-page-university

Technical Challenge

Pagina Web para una facultad con manejo de profesores y materias.


Instalación 🔧


1.Hacer un maven update-install para tener las dependencias.


2.fijarse en el archivo yml (/web-page-university/src/main/resources) la localizacion de la Base de Datos.


3.Si se utiliza Eclipse recomiendo usar Spring tools del marketplace para poder arrancar la aplicacion y tener la consola.


4.Realize estas Querys para tener los users Activados una vez ya este arrancada la aplicadion y creadas las tablas:


insert into users(username,enabled,password)

values ('40395741',1,'$2a$10$hO38Ml.y6AKR4ejFe/p2ieE3B8cHPUFEu/z6.pjM1jThjzoOn1.l2');

insert into users(username,enabled,password)

values ('38587423',1,'$2a$10$BQehwXqFJzx1mbv.zZ64..BqzEiqa82rkaFrZsYK1QC7fuawCGtOi');

insert into users(username,enabled,password)

values ('admin',1,'$2a$10$kh.Js2mKcH6c54qzF3d.r.RhE77SHyHyaPFQJczGP1dFdtvrOsvRC');

insert into user_roles(user_role_id,username,role)

values (1,'40395741','ROLE_STUDENT');

insert into user_roles(user_role_id,username,role)

values (2,'38587423','ROLE_STUDENT');

insert into user_roles(user_role_id,username,role)

values (3,'admin','ROLE_ADMIN');

Esto va a generar los siguientes Usuarios:



student1:

user= 40395741

password= 40395741

password= $2a$10$hO38Ml.y6AKR4ejFe/p2ieE3B8cHPUFEu/z6.pjM1jThjzoOn1.l2


student2:

user= 38587423

password= 38587423

password= $2a$10$BQehwXqFJzx1mbv.zZ64..BqzEiqa82rkaFrZsYK1QC7fuawCGtOi


admin:

user= admin

password= admin

password= $2a$10$kh.Js2mKcH6c54qzF3d.r.RhE77SHyHyaPFQJczGP1dFdtvrOsvRC


Construido con 🛠️


Spring  - El framework web usado

Maven - Manejador de dependencias

JavaScript - Usado para Validacion

Hibernate - El framework ORM utilizado

MySQL - Base de datos Utilizado utilizado


Autor ✒️

Casas Facundo - Trabajo Inicial 


Expresiones de Gratitud 🎁
Muchas Gracias por darme la oportunidad de participar en este challenge.

