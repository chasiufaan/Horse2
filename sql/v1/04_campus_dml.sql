merge into campus.look_campus as tgt
using(values
	(1, 'ST_GEORGE', 'St. George Campus', '27 King''s College Cir, Toronto, ON M5S'),
	(2, 'SCARBO', 'Scarborough Campus', '1265 Military Trail, Scarborough, ON M1C 1A4'),
	(3, 'SAUGA', 'Mississauga Campus', '3359 Mississauga Rd, Mississauga, ON L5L 1C6')
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