
create table food_details
(
id number(10),name varchar(10),category varchar(20),price number(20),availability number(20)
);

create sequence food_details_id_seq start with 1 increment by 1;
select * from food_details;

insert into  food_details(id,name,category,price,availability) values ( food_details_id_seq.NEXTVAL,'Idly','Veg',230,20);

insert into food_details values(food_details_id_seq.nextval,'Dosa','Veg','20',50);
insert into food_details values(food_details_id_seq.nextval,'Chappathi','Veg','20',100);
insert into food_details values(food_details_id_seq.nextval,'Poori','Veg','20',100);
insert into food_details values(food_details_id_seq.nextval,'Pongal','Veg','30',70);
insert into food_details values(food_details_id_seq.nextval,'Briyani','NonVeg','100',150);
insert into food_details values(food_details_id_seq.nextval,'Chicken 65','NonVeg','50',100);
insert into food_details values(food_details_id_seq.nextval,'Mutton','NonVeg','160',100);

commit;
drop table food_details;

drop sequence food_details_id_seq;

truncate table food_details;









