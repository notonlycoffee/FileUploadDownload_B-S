
		create database file;
		use file;
		create table upfile
		(
			id varchar(40) primary key,
			uuidname varchar(100) not null unique,
			filename varchar(100) not null,
			savepath varchar(255) not null,
			uptime datetime not null,
			description varchar(255),
			username varchar(40) not null
		);
	

	
	
	