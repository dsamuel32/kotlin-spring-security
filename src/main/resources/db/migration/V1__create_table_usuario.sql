create table usuario (
    id bigint not null auto_increment primary key ,
    nome varchar(255) not null,
    email varchar(255) not null,
    password text not null
);