create user jsp identified by jsp;
--select * from role_sys_privs where role='RESOURCE';
grant connect,resource,create view,debug any procedure, debug connect session to jsp;

--drop user jsp cascade;

--t4注册用户
create table t_user
(
     userId integer primary key,
     loginName varchar2(20),
     loginPwd varchar2(20),
     sex number(1),
     birthday date,
     email varchar2(30)
);

create sequence seq_user
start with 1
increment by 1;
select * from t_user;

insert into t_user values(seq_user.nextval,'小新','123',1,to_date('1991-12-21','YYYY-MM-DD'),'xiaoxin@yy.com');
insert into t_user values(seq_user.nextval,'小强','ww',1,to_date('1932-12-01','YYYY-MM-DD'),'xiaoqing@yy.com');
insert into t_user values(seq_user.nextval,'小新2','124443',1,to_date('1992-11-21','YYYY-MM-DD'),'xiaoxin@yy.com');
insert into t_user values(seq_user.nextval,'小新3','123246',1,to_date('1991-12-21','YYYY-MM-DD'),'xiaoxin@yy.com');
commit;
select * from t_user where loginName='小新' and loginPwd='123'


--部门表
create table dept(
  id varchar2(50),--编号
  deptname varchar(500),--部门名称
  fid varchar2(50),--父id
  deptlevel number(10),--
  memo varchar2(50),
  depttype varchar2(50),
  adress varchar2(100),
  adresstype varchar2(50),
  postcode varchar2(50),
  organcode varchar2(50),
  isdel number(2)--是否删除
);
select * from dept;


--delete from dept ;
----------------部门信息数据----------------------
insert into dept (ID, DEPTNAME, FID, DEPTLEVEL, MEMO, DEPTTYPE, ADRESS, ADRESSTYPE, POSTCODE, ORGANCODE, ISDEL)
values ('20d66c870da14697821239dab1cd3a6e', '计划提报部门', '4a29c7324a3c4954b06689af367dacaa', 5, '计划提包部门', '部室', '', '', '', '0007001', 1);

insert into dept (ID, DEPTNAME, FID, DEPTLEVEL, MEMO, DEPTTYPE, ADRESS, ADRESSTYPE, POSTCODE, ORGANCODE, ISDEL)
values ('0a358396ff5d4e5abc954ab31ced1b12', '安全保卫室', '89f9a66521114bd6b91c27da0b0d67b4', 2, '其他部门', '部室', '', '', '', '', 1);

insert into dept (ID, DEPTNAME, FID, DEPTLEVEL, MEMO, DEPTTYPE, ADRESS, ADRESSTYPE, POSTCODE, ORGANCODE, ISDEL)
values ('4a29c7324a3c4954b06689af367dacaa', '调度监控室', '89f9a66521114bd6b91c27da0b0d67b4', 2, '机关部室', '部室', '', '', '', 'pyddjks', 1);

insert into dept (ID, DEPTNAME, FID, DEPTLEVEL, MEMO, DEPTTYPE, ADRESS, ADRESSTYPE, POSTCODE, ORGANCODE, ISDEL)
values ('eeb66e9465da44eeb0226021d89528a8', '制成车间', '89f9a66521114bd6b91c27da0b0d67b4', 3, '生产车间', '部室', '', '', '', 'pyzccj', 1);

insert into dept (ID, DEPTNAME, FID, DEPTLEVEL, MEMO, DEPTTYPE, ADRESS, ADRESSTYPE, POSTCODE, ORGANCODE, ISDEL)
values ('06a6375f5b184c9387de42b73480bd7c', '烧成车间', '89f9a66521114bd6b91c27da0b0d67b4', 3, '生产车间', '部室', '', '', '', 'pysccj', 1);

insert into dept (ID, DEPTNAME, FID, DEPTLEVEL, MEMO, DEPTTYPE, ADRESS, ADRESSTYPE, POSTCODE, ORGANCODE, ISDEL)
values ('51f4a9e2a9cd4054a0534eac0e17c1b1', '供料车间', '89f9a66521114bd6b91c27da0b0d67b4', 3, '生产车间', '部室', '', '', '', '1231234', 1);

insert into dept (ID, DEPTNAME, FID, DEPTLEVEL, MEMO, DEPTTYPE, ADRESS, ADRESSTYPE, POSTCODE, ORGANCODE, ISDEL)
values ('5b395e9e13624a718f273c86fe265228', '公司领导', '89f9a66521114bd6b91c27da0b0d67b4', 1, '机关部室', '部室', '', '', '', '', 1);

insert into dept (ID, DEPTNAME, FID, DEPTLEVEL, MEMO, DEPTTYPE, ADRESS, ADRESSTYPE, POSTCODE, ORGANCODE, ISDEL)
values ('5f9888afb442422d806e0405c5944d34', '综合办公室', '89f9a66521114bd6b91c27da0b0d67b4', 2, '机关部室', '办公室', '', '', '', 'pyzhbgs', 1);

insert into dept (ID, DEPTNAME, FID, DEPTLEVEL, MEMO, DEPTTYPE, ADRESS, ADRESSTYPE, POSTCODE, ORGANCODE, ISDEL)
values ('70bcd1beba664feaaff6f18df50a7b95', '机电车间', '89f9a66521114bd6b91c27da0b0d67b4', 3, '生产车间', '部室', '', '', '', 'pyjdcj', 1);

insert into dept (ID, DEPTNAME, FID, DEPTLEVEL, MEMO, DEPTTYPE, ADRESS, ADRESSTYPE, POSTCODE, ORGANCODE, ISDEL)
values ('780036ab3b6b441aaf21db5fb73e0032', '安全保卫部', '89f9a66521114bd6b91c27da0b0d67b4', 6, '其他部门', '部室', '', '', '', '', 1);

insert into dept (ID, DEPTNAME, FID, DEPTLEVEL, MEMO, DEPTTYPE, ADRESS, ADRESSTYPE, POSTCODE, ORGANCODE, ISDEL)
values ('83986ecde3a9470caa7412551f1944e7', '财务管理部', '89f9a66521114bd6b91c27da0b0d67b4', 2, '机关部室', '部室', '', '', '', 'pycwglb', 1);

insert into dept (ID, DEPTNAME, FID, DEPTLEVEL, MEMO, DEPTTYPE, ADRESS, ADRESSTYPE, POSTCODE, ORGANCODE, ISDEL)
values ('aa2a78151fe84a65b5067bc433295ce9', '采供管理部', '89f9a66521114bd6b91c27da0b0d67b4', 2, '机关部室', '部室', '', '', '', 'pycgglb', 1);

insert into dept (ID, DEPTNAME, FID, DEPTLEVEL, MEMO, DEPTTYPE, ADRESS, ADRESSTYPE, POSTCODE, ORGANCODE, ISDEL)
values ('be4572bc959842b88ccb81a46e807662', '质量控制室', '89f9a66521114bd6b91c27da0b0d67b4', 2, '机关部室', '部室', '', '', '', 'pyzlkzs', 1);

insert into dept (ID, DEPTNAME, FID, DEPTLEVEL, MEMO, DEPTTYPE, ADRESS, ADRESSTYPE, POSTCODE, ORGANCODE, ISDEL)
values ('d6262e17d27040efa3ed27f8f6bc8fc6', '水泥分厂', '89f9a66521114bd6b91c27da0b0d67b4', 5, '水泥分厂', '分厂', '', '', '', '0100115', 1);

insert into dept (ID, DEPTNAME, FID, DEPTLEVEL, MEMO, DEPTTYPE, ADRESS, ADRESSTYPE, POSTCODE, ORGANCODE, ISDEL)
values ('d9b45a3738e141139371530bcbcc48e9', '市场营销部', '89f9a66521114bd6b91c27da0b0d67b4', 2, '', '部室', '', '', '', 'pyscyxb', 1);

insert into dept (ID, DEPTNAME, FID, DEPTLEVEL, MEMO, DEPTTYPE, ADRESS, ADRESSTYPE, POSTCODE, ORGANCODE, ISDEL)
values ('89f9a66521114bd6b91c27da0b0d67b4', '平阴山水水泥有限公司', '4268b320e2c94ffbae81e2f0ff59770c', 1, '', '公司', '', '', '', '01001', 1);


--学生表
create table student
(
id int primary key,
name nvarchar2(50) not null,
score number not null
);

insert into student values(1,'Aaron',78);
insert into student values(2,'Bill',76);
insert into student values(3,'Cindy',89);
insert into student values(4,'Damon',90);
insert into student values(5,'Ella',73);
insert into student values(6,'Frado',61);
insert into student values(7,'Gill',99);
insert into student values(8,'Hellen',56);
insert into student values(9,'Ivan',93);
insert into student values(10,'Jay',90);

--union ，并集，没有重复
select score,id,name from student s1 where s1.id<4
union 
select  score,id,name from student s2 where s2.id>2 and s2.id<6;

--union all 所有的并集，有重复
select id,name,score from student s2 where s2.id>2 and s2.id<6
union  all
select id,name,score from student s1 where s1.id<4;


--intersect,取出两者都相同的部分

select * from student where id<4
intersect
select * from student where id<3


--minus,与instersect相反，取两者不相等的部分
select * from student where id<4
minus
select * from student where id<3

select * from student stu order by score,id
--展示部门树特有的sql

select LEVEL,t.*
      	  from dept t
		  where isdel='1'
		  start with id = '89f9a66521114bd6b91c27da0b0d67b4'
		  connect by prior id = fid 
     		ORDER BY LEVEL DESC


 select t.*
      	  from dept t
		  where isdel='1' and fid='4a29c7324a3c4954b06689af367dacaa'




select count(*) from t_user where loginName='小新' and loginPwd='123'

select t.*,rownum rn from t_user t order by userid asc


--分页查询
SELECT *
  FROM (SELECT A.*, ROWNUM RN
          FROM (select t.*,
                       (select equipName
                          From TBL_EMS_EQUIP
                         where id = t.sectionid) sectionName,
                       (select equipName
                          From TBL_EMS_EQUIP
                         where id = t.productlineid) productLineName,
                       e.equipName,
                       e.equipNo,
                       u.realNamef
                  from TBL_EMS_HIDDENDANGER t, TBL_EMS_EQUIP e, USERINFO u
                 where t.equipId = e.id
                   and t.addMan = u.id
                   and t.comId = ?
                 order by t.addTime DESC) A
         WHERE ROWNUM <=12)
 WHERE RN >= 11
 89f9a66521114bd6b91c27da0b0d67b4(String), 12(Long), 11(Long)
 
 select count(*) from t_user where loginName='小新'and loginPwd='123' 
 
 
--
create table USERFY
(
  userid VARCHAR2(50),
  fid    VARCHAR2(50),
  fyje   VARCHAR2(50)
);

insert into USERFY (userid, fid, fyje)
values ('6000', 'gl', '1200');
insert into USERFY (userid, fid, fyje)
values ('1000', '8888', '1000');
insert into USERFY (userid, fid, fyje)
values ('2000', '6666', '2000');
insert into USERFY (userid, fid, fyje)
values ('2000', '7777', '5000');
commit;




declare
   pro_userid userfy.userid%type;
   pro_fyje userfy.fyje%type;
   cursor cur_userfyInfo is select userid,fyje from userfy where userid='2000';
 begin 
   open cur_userfyInfo;
   loop
     fetch cur_userfyInfo into pro_userid,pro_fyje;
       
       update userfy uf set uf.fyje=pro_fyje+1000 ;
           dbms_output.put_line(pro_userid); 
       Exit When cur_userfyInfo%NotFound;
         dbms_output.put_line(pro_userid||'的资金为'||pro_fyje); 
     end loop;
    close cur_userfyInfo;
end;


--ok给编号为2000的人都加1000元
declare 
   cursor cur_userfyInfo is
    select userid,fyje from userfy  where userid='2000' ORDER BY userid  DESC FOR UPDATE;
   v_new_sal NUMBER;    --新工资
BEGIN
   FOR r_userfyInfo IN cur_userfyInfo LOOP
     v_new_sal:=1000;
     UPDATE userfy SET fyje=fyje+v_new_sal WHERE CURRENT OF cur_userfyInfo ;

   END LOOP;
END;

select * from userfy ORDER BY userid DESC;


--查询树结构
select LEVEL,t.*
      	  from dept t
		  where isdel='1'
		  start with id = '89f9a66521114bd6b91c27da0b0d67b4'
		  connect by prior id = fid 
     		ORDER BY LEVEL DESC
        
select * from dept;

select * from  dept cross join t_user;
select * from  dept,t_user;

select sum(deptlevel) d,depttype from dept  group by depttype having sum(deptlevel)>2

--sql部分数据类型
select length('student') from dual;
select TO_NUMBER(TO_CHAR(sysdate,'YYYY')) year from dual ;
select * from t_user where to_char(birthday,'yyyymm')='199112';

--instr和substr Oracle函数用法
 select instr('aaa_1','_') from dual;--获得指定字符的位置
 select substr('aaa_1',4) from dual;
 select substr('aaa_1',（instr('aaa_1','_')+1）) from dual;--截取字符‘_’后面的数字
    
 select nvl(max(to_number(substr('aaa_1',(instr('aaa_1','_')+1)))),0) a from dual;--获得字符'_'之后最大的那个数字

select deptname,row_number() from dept;
