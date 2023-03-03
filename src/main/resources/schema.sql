create table if not exists Bookstore (
  id serial primary key,
  name varchar(255) not null, 
  address varchar(255), 
  city varchar(255), 
  state varchar(255), 
  status varchar(255) not null, 
  type varchar(255) not null, 
  created_at timestamp not null default CURRENT_TIMESTAMP, 
  updated_at timestamp
);

insert into Bookstore (name, address, city, state, status, type, created_at, updated_at) values ('Bookstore 5', 'Address 5', 'City 5', 'State 5', 'IN_PROGRESS', 'MEDIUM', '2020-01-01 00:00:00', '2020-01-01 00:00:00');
insert into Bookstore (name, address, city, state, status, type, created_at, updated_at) values ('Bookstore 6', 'Address 6', 'City 6', 'State 6', 'COMPLETED', 'BIG', '2020-01-01 00:00:00', '2020-01-01 00:00:00');
insert into Bookstore (name, address, city, state, status, type, created_at, updated_at) values ('Bookstore 7', 'Address 7', 'City 7', 'State 7', 'OPEN', 'SMALL', '2020-01-01 00:00:00', '2020-01-01 00:00:00');
insert into Bookstore (name, address, city, state, status, type, created_at, updated_at) values ('Bookstore 8', 'Address 8', 'City 8', 'State 8', 'COMPLETED', 'MEDIUM', '2020-01-01 00:00:00', '2020-01-01 00:00:00');