use wfm_user;

insert into users (username,password,enabled) 
values('mani','test123',true);
insert into users (username,password,enabled) 
values('bala','test123',true);

insert into authorities(username,authority)
values('mani','ROLE_MANAGER');
insert into authorities(username,authority)
values('bala','ROLE_SUPERVISOR');
