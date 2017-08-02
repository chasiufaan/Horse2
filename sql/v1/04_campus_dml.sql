merge into campus.look_campus as tgt
using(values
	(1, 'ST_GEORGE', 'St. George Campus', '27 King''s College Cir, Toronto, ON M5S')
) as src(id, cd, name, address) 
	on src.id = tgt.id
when matched then update set
	tgt.cd = src.cd,
	tgt.name = src.name,
	tgt.address = src.address
when not matched then
	insert(id, cd, name, address)
	values(id, cd, name, address)
;