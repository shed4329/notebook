**MySQL数据类型**

int/bigint(java的long)

float/double

datetime/timestamp(可储存时间戳)

char(定长字符)/varchar(不定长字符)/text(大文本)

blob(字节数据类型，存储图片，音频等文件)

**语法**

--建表

create table 表名（

    字段名 类型 约束（主键，非空，唯一，默认值），

    字段名 类型 约束（主键，非空，唯一，默认值），

）编码，存储引擎

约束

NOT NULL:规定某一列不能存储null值

UNIQUE：保证某列的每行都有唯一的值

PRIMARY KEY：NOT NULL和UNIQUE的组合

FOREIGN KEY（尽量少用）：保证一个表中的数据匹配另一个表中的值的参照完全性

CHECK：保证列中的值符合条件

DEFAULT：规定没有列赋值时的默认值

```sql
DROP TABLE IF EXISTS `websites`;
CREATE TABLE `websites`(
    id int(11) NOT NULL AUTO_INCREMENT,
    name char(20) NOT NULL DEFAULT'' COMMENT'站点名称',
    url varchar(255) NOT NULL DEFAULT '',
    alexa int(11) NOT NULL DEFAULT '0' COMMENT'Alexa排名',
    sal double COMMENT'广告收入',
    country char(10) NOT NULL DEFAULT'' COMMENT'国家',
    PRIMARY KEY(id)
)ENGINE=INNODB DEFAULT CHARSET=utf8;
```

**插入**

```sql
INSERT INTO websites(name,url,alexa,sal,country) VALUES("腾讯","https://www.qq.com",18,1000,'CN');
```

**删除**

```sql
DELETE FROM websites WHERE id = 5;
```

更新

```sql
UPDATE websites SET sal = 2000 WHERE id = 3;
```

注释

```sql
-- 单行注释
-- UPDATE websites SET sal = 2000 WHERE id = 3;
/*多行注释*/
```

查询

```sql
DROP TABLE IF EXISTS `websites`;
CREATE TABLE `websites`(
    id int(11) NOT NULL AUTO_INCREMENT,
    name char(20) NOT NULL DEFAULT'' COMMENT'站点名称',
    url varchar(255) NOT NULL DEFAULT '',
    alexa int(11) NOT NULL DEFAULT '0' COMMENT'Alexa排名',
    sal double COMMENT'广告收入',
    country char(10) NOT NULL DEFAULT'' COMMENT'国家',
    PRIMARY KEY(id)
)ENGINE=INNODB DEFAULT CHARSET=utf8;


INSERT INTO `websites` VALUES
    (1,'Google', 'https://www.google.com/', '1',2000 , 'USA '),
    (2,'淘宝','https://www.taobao.com/','13',2050,'CN'),
    (3,'菜鸟教程', 'http://www.runoob.com/', '4689' ,0.0001,'CN'),
    (4,'微博', 'http://weibo.com/','20',50,'CN'),
    (5,'Facebook','https://www.facebook.com/','3',500, 'USA');
CREATE TABLE IF NOT EXISTS `access_log`(
    `aid` int(11) NOT NULL AUTO_INCREMENT,
    `site_id` int(11) NOT NULL DEFAULT '0' COMMENT '网站id',
    `count` int(11) NOT NULL DEFAULT '0' COMMENT '访问次数',
    `date` date NOT NULL,
    PRIMARY KEY (`aid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO `access_log` (`aid`,`site_id`,
`count`,`date`) VALUES
(1,1,45,'2016-05-10'),
(2,3,100,'2016-05-13'),
(3,1,230,'2016-05-14'),
(4,2,10,'2016-05-14'),
(5,5,205,'2016-05-14'),
(6,4,13,'2016-05-15'),
(7,3,220,'2016-05-15'),
(8,5,545,'2016-05-16'),
(9,3,201,'2016-05-17'),
(10,88,9999,'2016-09-09');
```

查询语句

实际开发中尽量不要使用*，数据太多了

```sql
select * from websites

select id,name,url,alexa from websites
```

分页查询

```sql
select id,name,url,alexa from websites limit 2,3
-- 从第二条开始查，查三条
```

distinct去重

```sql
select distinct country from websites
```

where语句

运算符>   <   >=    <=    <>    !=    =     is null   is not   null like in

在sql语句中 null值和任何东西比较 都为false，包括null

```sql
SELECT * FROM websites WHERE sal IS NOT NULL 
```

逻辑条件:and or

```sql
select * from websites where sal<=0 and sal>=2000;
select * from websites where sal between 2000 and 0;/*和上面效果一样*/
select * from websites where sal<5 or sal is null;
```

排序 order by

```sql
select * from websites order by sal asc,alexa desc;-- 先按sal升序，再按alexa降序
```

like 通配符

```sql
select * from websites where name like '%O%'
select * from websites where name like '_O%'-- 匹配一个字符
```

in 匹配多个条件

```sql
select * from websites where country in ('USA','鸟国','CN');
```

别名

```sql
select tt.name '网站名字' from websites tt -- tt是表的别名
```

group by 分组查询

```sql
select avg(sal) '平均值' ,country from websites group by country;


select avg(sal) '平均值' ,country from websites group by country HAVING 平均值 > 1200;-- 不能用where，只能用having;
```

子查询

把查询结果当做一个表来使用

连接查询

```sql
/*过时写法*/
/*不加where的话会随意乱连*/
/*内连接*/
select name,a.count,a.date from websites w,access_log a where w.id=a.site_id

/*outer可以省*/
/*左外连接*/
select * from websites w left outer join access_log a
on w.id=a.site_id
union/*实现*/
select * from websites w right join access_log a
on w.id=a.site_id
```

ifnull

```sql
select name,ifnull(count,0),ifnull(a.date,'无日期') from websites w left outer join access_log a
on w.id=a.site_id

```



练习题

```sql
CREATE TABLE dept(
	deptno		INT,
	dname		varchar(14),
	loc		varchar(13)
);
INSERT INTO dept values(10, 'ACCOUNTING', 'NEW YORK');
INSERT INTO dept values(20, 'RESEARCH', 'DALLAS');
INSERT INTO dept values(30, 'SALES', 'CHICAGO');
INSERT INTO dept values(40, 'OPERATIONS', 'BOSTON');

CREATE TABLE emp(
	empno INT,
	ename VARCHAR(50),
	job VARCHAR(50),
	mgr	INT,
	hiredate DATE,
	sal	DECIMAL(7,2),
	comm DECIMAL(7,2),
	deptno INT
) ;
INSERT INTO emp values(7369,'SMITH','CLERK',7902,'1980-12-17',800,NULL,20);
INSERT INTO emp values(7499,'ALLEN','SALESMAN',7698,'1981-02-20',1600,300,30);
INSERT INTO emp values(7521,'WARD','SALESMAN',7698,'1981-02-22',1250,500,30);
INSERT INTO emp values(7566,'JONES','MANAGER',7839,'1981-04-02',2975,NULL,20);
INSERT INTO emp values(7654,'MARTIN','SALESMAN',7698,'1981-09-28',1250,1400,30);
INSERT INTO emp values(7698,'BLAKE','MANAGER',7839,'1981-05-01',2850,NULL,30);
INSERT INTO emp values(7782,'CLARK','MANAGER',7839,'1981-06-09',2450,NULL,10);
INSERT INTO emp values(7788,'SCOTT','ANALYST',7566,'1987-04-19',3000,NULL,20);
INSERT INTO emp values(7839,'KING','PRESIDENT',NULL,'1981-11-17',5000,NULL,10);
INSERT INTO emp values(7844,'TURNER','SALESMAN',7698,'1981-09-08',1500,0,30);
INSERT INTO emp values(7876,'ADAMS','CLERK',7788,'1987-05-23',1100,NULL,20);
INSERT INTO emp values(7900,'JAMES','CLERK',7698,'1981-12-03',950,NULL,30);
INSERT INTO emp values(7902,'FORD','ANALYST',7566,'1981-12-03',3000,NULL,20);
INSERT INTO emp values(7934,'MILLER','CLERK',7782,'1982-01-23',1300,NULL,10);
INSERT INTO emp values(7981,'MILLER','CLERK',7788,'1992-01-23',2600,500,20);

```
