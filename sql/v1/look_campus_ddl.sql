if not exists (select 1 from INFORMATION_SCHEMA.TABLES t where t.TABLE_NAME = 'look_campus' and t.TABLE_SCHEMA = 'horse')
begin
	create table horse.look_campus(
		id int not null,
		cd varchar(10) not null,
		name varchar(20) not null,
		address varchar(50) not null,
		constraint PK_campus_id primary key(id),
		constraint UC_campus_cd unique(cd)
	)
end
;