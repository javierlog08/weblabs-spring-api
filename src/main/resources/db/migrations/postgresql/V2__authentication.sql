CREATE TABLE public.users
(
    user_id numeric,
    username text,
    password character varying(64),
    CONSTRAINT users_pkey PRIMARY KEY (user_id)
);

CREATE TABLE public.auths
(
    name character varying,
    auth_id numeric
);


CREATE TABLE public.users_auths
(
    user_id numeric,
    auth_id numeric
);