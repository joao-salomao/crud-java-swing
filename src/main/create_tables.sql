/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  João Salomão
 * Created: 20/10/2019
 */

create table categories (
    id int auto_increment,
    name varchar(100),
    primary key(id)
);

create table products (
    id int auto_increment,
    description varchar(100) not null,
    code varchar(100),
    price double,
    state boolean,
    id_categorie int,
    primary key(id)
);

alter table products add constraint fk_categorie foreign key(id_categorie) references categories(id);