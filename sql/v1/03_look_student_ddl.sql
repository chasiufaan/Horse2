if not exists (select 1 from INFORMATION_SCHEMA.TABLES t where t.TABLE_NAME = 'look_student')
begin
	create table look_student(
		id int not null,
		number varchar(20) not null,
		name_first varchar(20) not null,
		name_last varchar(20) not null,
		college_id int not null,
		constraint PK_student_id primary key(id),
		constraint UC_student_number unique(number),
		constraint FK_college_id_look_college_Id foreign key(college_id) references look_college(id)
	)
end
;