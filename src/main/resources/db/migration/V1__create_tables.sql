create table users (
    id bigint not null auto_increment primary key ,
    name varchar(255) not null,
    email varchar(255) not null,
    password text not null
);

insert into users(name, email, password) values('Diego', 'diego@teste.com', '$2a$12$Ed70zR/w5b8H.opERkAW9OUqOlPto3OLEy9eavaRmTEvhRbRndA5K');

create table pemissions (
   `id` bigint not null auto_increment primary key ,
   `name` varchar(255) not null
);

create table users_pemissions (
    `id` bigint not null auto_increment primary key ,
    `user_id` bigint not null,
    `permission_id` bigint not null,
    FOREIGN KEY(`user_id`) REFERENCES `users`(`id`),
    FOREIGN KEY(`permission_id`) REFERENCES `pemissions`(`id`)
);

insert into pemissions(name) values('READ');
insert into pemissions(name) values('ADM');

insert into users_pemissions(user_id, permission_id) values(1, 1);
insert into users_pemissions(user_id, permission_id) values(1, 2);