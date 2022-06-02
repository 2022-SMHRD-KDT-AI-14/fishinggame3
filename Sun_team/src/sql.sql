
creat table rank
(id varchar2(20),
score number(10)not null,
constraint rank_id_fk foreign key(id) references user_info(id)
)

create table fish
(fish_name varchar2(10)not null,
f_score number(4)not null,
price number(6)not null,
grade number(2) not null,
fno number(2) not null,
constraint user_fish_name_uk unique(fish_name)
constraint user_fish_fno_uk unique(fno)
)

select * from rank

create table user_info
(id varchar2(20),
pw varchar2(20)not null,
item number(2),
a_price number(6),
money number(6),
constraint user_id_pk primary key(id),
)
