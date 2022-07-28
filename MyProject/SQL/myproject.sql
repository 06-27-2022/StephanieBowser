CREATE TABLE public.users (
	id serial NOT NULL,
	firstname varchar NOT NULL,
	lastname varchar NOT NULL,
	username varchar NOT NULL,
	"password" varchar NOT NULL,
	manager boolean NOT NULL
);

ALTER TABLE public.reimburse ADD CONSTRAINT reimburse_pk PRIMARY KEY (username);

CREATE TABLE public.reimburse (
	username varchar NULL,
	amount varchar NULL,
	description varchar NULL
);

ALTER TABLE public.users ADD manager bit NULL;

ALTER TABLE public.users ADD CONSTRAINT users_un UNIQUE (username);

ALTER TABLE public.users ADD CONSTRAINT users_fk FOREIGN KEY (username) REFERENCES public.users(username);

ALTER TABLE public.users DROP CONSTRAINT users_un CASCADE;