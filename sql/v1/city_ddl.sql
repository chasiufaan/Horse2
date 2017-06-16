if not exists (select 1 from INFORMATION_SCHEMA.TABLES t where t.TABLE_NAME = 'city')
begin
	create table city(
		id int not null,
		cd varchar(10) not null,
		name varchar(20) not null,
		province_cd varchar(20) not null,
		constraint PK_city primary key(id),
		constraint UC_city_cd unique (cd)
	)
end