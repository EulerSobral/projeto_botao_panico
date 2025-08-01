-- Criação das tabelas
create table users (
                       id INTEGER auto_increment unique,
                       email varchar(100) not null,
                       registration varchar(8) primary key,
                       phone varchar(13),
                       id_campus INTEGER null,
                       type varchar(10) default 'User' not null CHECK (type IN ('User', 'Admin')),
                       password text not null
);

create table buttons (
                         id INTEGER auto_increment primary key,
                         class varchar(100),
                         id_campus INTEGER
);

create table alerts (
                        id INTEGER auto_increment primary key,
                        id_button INTEGER null,
                        local varchar(250),
                        type varchar(25),
                        date date,
                        id_user INTEGER null
);

create table campus (
                        id INTEGER auto_increment primary key,
                        name varchar(250)
);

-- Tabela opcional de relacionamento muitos-para-muitos (descomente se necessário)
-- create table adm_campus (
--     id_user INTEGER,
--     id_campus INTEGER,
--     primary key (id_campus, id_user)
-- );

-- Constraints (corretas agora com nomes em minúsculo e nomes válidos de tabela)
alter table alerts add constraint fk_button foreign key (id_button) references buttons(id);
alter table alerts add constraint fk_user foreign key (id_user) references users(registration);
alter table users add constraint fk_user_campus foreign key (id_campus) references campus(id);
-- alter table adm_campus add constraint fk_adm_user foreign key (id_user) references users(id);
-- alter table adm_campus add constraint fk_adm_campus foreign key (id_campus) references campus(id);
