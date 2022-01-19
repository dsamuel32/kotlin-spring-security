create table pemissoes (
    `id` bigint not null auto_increment primary key ,
    `nome` varchar(255) not null
);

create table usuarios_pemissoes (
       `id` bigint not null auto_increment primary key ,
       `usuario_id` bigint not null,
       `permissao_id` bigint not null,
       FOREIGN KEY(`usuario_id`) REFERENCES `usuario`(`id`),
       FOREIGN KEY(`permissao_id`) REFERENCES `permissoes`(`id`)
);

insert into pemissoes(nome) values('LEITURA');
insert into pemissoes(nome) values('ADM');

insert into usuarios_pemissoes(usuario_id, permissao_id) values(1, 1);
insert into usuarios_pemissoes(usuario_id, permissao_id) values(1, 2);