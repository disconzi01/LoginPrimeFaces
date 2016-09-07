/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  JORGE E GANTIVA O
 * Created: 06-sep-2016
 */

create table usuarios(email varchar(50) not null, contrasena varchar(50) not null, constraint pk_usuarios primary key (email));

insert into usuarios values ('jegonet@gmail.com', '1234');
insert into usuarios values ('test@test.com', '123');