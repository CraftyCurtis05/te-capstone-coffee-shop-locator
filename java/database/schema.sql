BEGIN TRANSACTION;

DROP TABLE IF EXISTS users, favorites, likes, dislikes;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);
CREATE TABLE favorites (
	favorites_id SERIAL,
	user_id int(10) NOT NULL,
	business_id varchar(50) NOT NULL,
	business_name varchar(50) NOT NULL,
	business_address varchar(50),
	CONSTRAINT pk_favorites PRIMARY KEY (favorites_id),
	CONSTRAINT fk_favorites_users FOREIGN KEY (user_id) REFERENCES users (user_id)
);
CREATE TABLE likes (
	likes_id SERIAL,
	user_id int(10) NOT NULL,
	business_id varchar(50) NOT NULL,
	CONSTRAINT pk_likes PRIMARY KEY (likes_id),
	CONSTRAINT fk_likes_users FOREIGN KEY (user_id) REFERENCES users (user_id)
);
CREATE TABLE dislikes (
	dislikes_id SERIAL,
	user_id int(10) NOT NULL,
	business_id varchar(50) NOT NULL,
	CONSTRAINT pk_dislikes PRIMARY KEY (dislikes_id),
	CONSTRAINT fk_dislikes_users FOREIGN KEY (user_id) REFERENCES users (user_id)
);

COMMIT TRANSACTION;
