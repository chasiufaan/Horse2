
if not exists (select 1 from INFORMATION_SCHEMA.TABLES t where t.TABLE_NAME = 'look_college')
begin
	create table college(
		id int not null,
		cd varchar(10) not null,
		name varchar(20) not null,
		address varchar(50) not null,
		campus_id int not null,
		constraint PK_college_id primary key(id),
		constraint UC_college_cd unique(cd),
		constraint FK_college_campus_id_look_campus_id foreign key (campus_id) references look_campus(id)
	)
end
;