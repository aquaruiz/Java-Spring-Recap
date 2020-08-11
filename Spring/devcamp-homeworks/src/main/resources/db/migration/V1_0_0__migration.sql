--CREATE TABLE IF NOT EXISTS `employee` (
--	 
--	    `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
--	    `name` varchar(20),
--	    `email` varchar(50),
--	    `date_of_birth` timestamp
--	 
--	)ENGINE=InnoDB DEFAULT CHARSET=UTF8;
--	
create TABLE IF NOT EXISTS roles (
       id bigint not null auto_increment,
        role varchar(255),
        primary key (id)
    ) engine=InnoDB;
    
create TABLE IF NOT EXISTS students (
   id bigint not null auto_increment,
    age integer not null,
    first_name varchar(50),
    last_name varchar(50),
    primary key (id)
) engine=InnoDB;
    
create TABLE IF NOT EXISTS teachers (
   id bigint not null auto_increment,
    fullname varchar(255),
    subject varchar(255),
    primary key (id)
) engine=InnoDB;

create table IF NOT EXISTS teachers_students (
   student_id bigint not null,
    teacher_id bigint not null,
    primary key (student_id, teacher_id)
) engine=InnoDB;
    
 alter table teachers_students 
   add constraint FKs9qt95drbmg1yu66e24njnxl0 
   foreign key (teacher_id) 
   references teachers (id)
       
 alter table teachers_students 
   add constraint FKr2jjh7fdvijix8q8hervypaes 
   foreign key (student_id) 
   references students (id)