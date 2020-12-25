--insert into Blogger (age, name) VALUES (21, 'Gyula');
--insert into Blogger (age, name) VALUES (26, 'Krisz');

--insert into STORY (title, content, posted, blogger_id) VALUES('Teszt cím', 'Teszt tartalom', '2020-11-4', 1);

--insert into STORY (title, content, posted, blogger_id) VALUES('Teszt cím', 'Teszt tartalom', CURRENT_DATE(), (select id FROM BLOGGER where name='Gyula'));
--insert into STORY (title, content, posted, blogger_id) VALUES('Teszt cím2', 'Teszt tartalom2', CURRENT_DATE(), (select id FROM BLOGGER where name='Gyula'));
--insert into STORY (title, content, posted, blogger_id) VALUES('Teszt cím', 'Teszt tartalom', CURRENT_DATE(), (select id FROM BLOGGER where name='Krisz'));
--insert into STORY (title, content, posted, blogger_id) VALUES('Teszt cím2', 'Teszt tartalom2', CURRENT_DATE(), (select id FROM BLOGGER where name='Krisz'));
--insert into STORY (title, content, posted, blogger_id) VALUES('szia', 'Szia tartalom', CURRENT_DATE(), (select id FROM BLOGGER where name='Krisz'));



--JDBC-hez
insert into Blogger (id, age, name) VALUES (1, 21, 'Gyula');
insert into Blogger (id, age, name) VALUES (2, 26, 'Krisz');

insert into STORY (id, title, content, posted, blogger_id) VALUES(1, 'Teszt cím', 'Teszt tartalom', CURRENT_DATE(), (select id FROM BLOGGER where name='Gyula'));
insert into STORY (id, title, content, posted, blogger_id) VALUES(2, 'szia', 'Teszt tartalom2', CURRENT_DATE(), (select id FROM BLOGGER where name='Gyula'));




--postgre távoli heoreku ab
--insert into Blogger (id,age, name) VALUES (1, 21, 'Gyula');
--insert into Blogger (id, age, name) VALUES (2, 26, 'Krisz');
--insert into STORY (id, title, content, posted, blogger_id) VALUES(1, 'Teszt cím', 'Teszt tartalom', '2019-07-22', (select id FROM BLOGGER where name='Krisz'));