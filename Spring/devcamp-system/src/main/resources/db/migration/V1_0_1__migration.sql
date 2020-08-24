-- devcamp_db.`user` definition
    
create table IF NOT EXISTS users (
   id bigint not null auto_increment,
    name varchar(255),
    primary key (id)
) engine=InnoDB;