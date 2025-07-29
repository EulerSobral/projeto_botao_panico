create table User(
    id INTEGER auto_increment unique,
    email varchar(100) not null,
    registration varchar(8) primary key,
    phone varchar(13),
    id_Campus INTEGER null,
    type varchar(10) default 'User' not null CHECK (type IN ('User', 'Admin')),
    password text not null
);

create table Button(
    id INTEGER auto_increment primary key ,
    class varchar(100),
    id_campus INTEGER,
);

create table Alert(
    id INTEGER auto_increment primary key ,
    id_button INTEGER null,
    local varchar(250) null,
    type varchar(25),
    data datetime,
    id_user INTEGER null
);

create table Campus(
    id INTEGER auto_increment primary key ,
    name varchar(250)
);

//create table AdmCampus(
//    id_user INTEGER auto_increment,
//    id_campus INTEGER,
//    primary key (id_campus, id_user)
//);

//alter table AdmCampus add constraint "fk_UserId" foreign key(id_user) references User(id);
//alter table AdmCampus add constraint "fk_CampusId" foreign key (id_campus) references Campus(id);
alter table Alert add constraint "fk_ButtonId" foreign key (id_button) references Button(id);
alter table User add constraint "fk_CampusId" foreign key (id_campus) references Button(id);
alter table Alert add constraint "fk_UserId" foreign key (id_button) references User(id);