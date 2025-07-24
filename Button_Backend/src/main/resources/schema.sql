create table User(
    id INTEGER auto_increment,
    email varchar not null,
    registration char(8) primary key,
    phone char(13)
);

create table Button(
    id INTEGER auto_increment,
    class varchar(100),
    id_campus INTEGER,
);

create table Alert(
    id INTEGER auto_increment,
    id_button INTEGER null,
    local varchar(250) null,
    type varchar(25),
    data datetime
);

create table Campus(
    id INTEGER auto_increment,
    nome varchar(250)
);

create table AdmCampus(
    id_user INTEGER auto_increment,
    id_campus INTEGER,
    primary key (id_campus, id_user)
);

alter table AdmCampus add constraint "fk_UserId" foreign key(id_user) references User(id);
alter table AdmCampus add constraint "fk_CampusId" foreign key (id_campus) references Campus(id);
alter table Alert add constraint "fk_ButtonId" foreign key (id_button) references Button(id);