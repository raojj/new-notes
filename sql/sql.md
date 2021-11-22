### mysql常用指令：

退出mysql：exit

查看mysql中有哪些数据库：show databases;（==以英文分号结尾==）默认自带四个数据库

创建数据库create databases 名字;

使用数据库：use 名字;

查看数据库里有哪些表：show tables;

导入SQL文件：source 路径（路径中不能有中文）

查看表中的数据：select * from 表名;

查看标的结构：desc 表名;

查看数据库版本：select version();

查看当前使用的数据库：select database();

终止数据库指令的执行：\c

字段可以加减乘除运算

### 数据库中最基本的单元是表：table

任何一张表都有行和列(表的数据形式比较直观)

行row：被称为数据/记录

列column：被称为字段（每一个字段都有字段名和数据类型以及约束等属性）



### SQL语句的分类

##### DQL：数据查询语言（凡是带有select关键字的都是查询语句）select

###### 简单查询：

1.查询一个字段：select 字段名 from 表名; select和from是关键字，字段名和表名是标识符

2.查询两个字段或多个字段：使用“,”隔开

3.查询所有字段：写上所有字段，或者用*代替（效率较低，可读性差）

4.给行起别名: 使用as来起别名（只是给显示出来的改名，原表不变，as可以省略）别名内含有空格时可以把别名用单/双引号括起来，在数据库中，单引号括字符串是标准，双引号在Oracle中不能使用

###### 条件查询

select 字段1,字段2... from 表名 where 条件（=、>=、<=、>、<、between... and...（闭区间，左小右大）、is null、and、or、in(not in)、not not、like like、%、\、!=(<>)）==在数据库中null不能用=，要用is (not) null==

==and 和 or同时出现and的优先级比or高== 

eg: select empno,ename from emp where sal = 800;(==等于号前后需要空格==)



##### DML：数据操作语言（凡是对表当中的数据进行增删改的语句）insert delete update

##### DDL：数据定义语言（凡是带有create drop alter的都是DDL）DDL主要操作是表的结构，不是表中的数据

##### TCL：事务控制语言（包括事务的提交commit和事务回滚rollback）

##### DCL：数据控制语言（授权grant、撤销权限revoke....）





