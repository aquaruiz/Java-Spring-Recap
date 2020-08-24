create table students (
   id bigint not null auto_increment,
    age integer default 25,
    first_name varchar(50),
    last_name varchar(50),
    user_id bigint,
    primary key (id)
) engine=InnoDB;

create table teachers (
   id bigint not null auto_increment,
    fullname varchar(255),
    subject varchar(255),
    user_id bigint,
    primary key (id)
) engine=InnoDB;

create table teachers_students (
   students_id bigint not null,
    teachers_id bigint not null,
    primary key (students_id, teachers_id)
) engine=InnoDB;

create table users (
   id bigint not null auto_increment,
    password varchar(20) not null,
    user_type integer,
    username varchar(40) not null,
    primary key (id)
) engine=InnoDB;

alter table users 
   add constraint UK_r43af9ap4edm43mmtq01oddj6 unique (username);

alter table students 
   add constraint FKdt1cjx5ve5bdabmuuf3ibrwaq 
   foreign key (user_id) 
   references users (id);

alter table teachers 
   add constraint FKb8dct7w2j1vl1r2bpstw5isc0 
   foreign key (user_id) 
   references users (id);

alter table teachers_students 
   add constraint FK8oyy0mstwh9f9qgsedldsdcji 
   foreign key (teachers_id) 
   references teachers (id);

alter table teachers_students 
   add constraint FKtltfdvm0002nwfe2p12gltgb 
   foreign key (students_id) 
   references students (id);