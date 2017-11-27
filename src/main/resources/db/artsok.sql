toc.dat                                                                                             0000600 0004000 0002000 00000023505 13156217564 0014456 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        PGDMP                           u            spring4    9.3.3    9.6.3 '    �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                       false         �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                       false         �           1262    32836    spring4    DATABASE     �   CREATE DATABASE spring4 WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Russian_Russia.1251' LC_CTYPE = 'Russian_Russia.1251';
    DROP DATABASE spring4;
             postgres    false                     2615    2200    public    SCHEMA        CREATE SCHEMA public;
    DROP SCHEMA public;
             postgres    false         �           0    0    SCHEMA public    COMMENT     6   COMMENT ON SCHEMA public IS 'standard public schema';
                  postgres    false    6         �           0    0    public    ACL     �   REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;
                  postgres    false    6                     3079    11750    plpgsql 	   EXTENSION     ?   CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;
    DROP EXTENSION plpgsql;
                  false         �           0    0    EXTENSION plpgsql    COMMENT     @   COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';
                       false    1         �            1259    32844    authorities    TABLE     �   CREATE TABLE authorities (
    id integer NOT NULL,
    username character varying(50) NOT NULL,
    authority character varying(50) NOT NULL
);
    DROP TABLE public.authorities;
       public         postgres    false    6         �            1259    32842    authorities_id_seq    SEQUENCE     t   CREATE SEQUENCE authorities_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.authorities_id_seq;
       public       postgres    false    6    173         �           0    0    authorities_id_seq    SEQUENCE OWNED BY     ;   ALTER SEQUENCE authorities_id_seq OWNED BY authorities.id;
            public       postgres    false    172         �            1259    32855    group_authorities    TABLE     �   CREATE TABLE group_authorities (
    group_id bigint NOT NULL,
    authority character varying(45) DEFAULT NULL::character varying NOT NULL
);
 %   DROP TABLE public.group_authorities;
       public         postgres    false    6         �            1259    32863    group_members    TABLE     �   CREATE TABLE group_members (
    id integer NOT NULL,
    username character varying(45) NOT NULL,
    group_id integer NOT NULL
);
 !   DROP TABLE public.group_members;
       public         postgres    false    6         �            1259    32861    group_members_id_seq    SEQUENCE     v   CREATE SEQUENCE group_members_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public.group_members_id_seq;
       public       postgres    false    177    6         �           0    0    group_members_id_seq    SEQUENCE OWNED BY     ?   ALTER SEQUENCE group_members_id_seq OWNED BY group_members.id;
            public       postgres    false    176         �            1259    32871    groups    TABLE     `   CREATE TABLE groups (
    id integer NOT NULL,
    group_name character varying(45) NOT NULL
);
    DROP TABLE public.groups;
       public         postgres    false    6         �            1259    32869    groups_id_seq    SEQUENCE     o   CREATE SEQUENCE groups_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 $   DROP SEQUENCE public.groups_id_seq;
       public       postgres    false    6    179         �           0    0    groups_id_seq    SEQUENCE OWNED BY     1   ALTER SEQUENCE groups_id_seq OWNED BY groups.id;
            public       postgres    false    178         �            1259    32850    persistent_logins    TABLE     �   CREATE TABLE persistent_logins (
    username character varying(64) NOT NULL,
    series character varying(64) NOT NULL,
    token character varying(64) NOT NULL,
    last_used timestamp without time zone NOT NULL
);
 %   DROP TABLE public.persistent_logins;
       public         postgres    false    6         �            1259    32837    users    TABLE     �   CREATE TABLE users (
    username character varying(50) NOT NULL,
    password character varying(50) NOT NULL,
    enabled boolean NOT NULL
);
    DROP TABLE public.users;
       public         postgres    false    6         7           2604    32847    authorities id    DEFAULT     b   ALTER TABLE ONLY authorities ALTER COLUMN id SET DEFAULT nextval('authorities_id_seq'::regclass);
 =   ALTER TABLE public.authorities ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    172    173    173         9           2604    32866    group_members id    DEFAULT     f   ALTER TABLE ONLY group_members ALTER COLUMN id SET DEFAULT nextval('group_members_id_seq'::regclass);
 ?   ALTER TABLE public.group_members ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    177    176    177         :           2604    32874 	   groups id    DEFAULT     X   ALTER TABLE ONLY groups ALTER COLUMN id SET DEFAULT nextval('groups_id_seq'::regclass);
 8   ALTER TABLE public.groups ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    178    179    179         �          0    32844    authorities 
   TABLE DATA               7   COPY authorities (id, username, authority) FROM stdin;
    public       postgres    false    173       1972.dat �           0    0    authorities_id_seq    SEQUENCE SET     9   SELECT pg_catalog.setval('authorities_id_seq', 4, true);
            public       postgres    false    172         �          0    32855    group_authorities 
   TABLE DATA               9   COPY group_authorities (group_id, authority) FROM stdin;
    public       postgres    false    175       1974.dat �          0    32863    group_members 
   TABLE DATA               8   COPY group_members (id, username, group_id) FROM stdin;
    public       postgres    false    177       1976.dat �           0    0    group_members_id_seq    SEQUENCE SET     ;   SELECT pg_catalog.setval('group_members_id_seq', 2, true);
            public       postgres    false    176         �          0    32871    groups 
   TABLE DATA               )   COPY groups (id, group_name) FROM stdin;
    public       postgres    false    179       1978.dat �           0    0    groups_id_seq    SEQUENCE SET     4   SELECT pg_catalog.setval('groups_id_seq', 2, true);
            public       postgres    false    178         �          0    32850    persistent_logins 
   TABLE DATA               H   COPY persistent_logins (username, series, token, last_used) FROM stdin;
    public       postgres    false    174       1973.dat �          0    32837    users 
   TABLE DATA               5   COPY users (username, password, enabled) FROM stdin;
    public       postgres    false    171       1970.dat >           2606    32849    authorities authorities_pkey 
   CONSTRAINT     S   ALTER TABLE ONLY authorities
    ADD CONSTRAINT authorities_pkey PRIMARY KEY (id);
 F   ALTER TABLE ONLY public.authorities DROP CONSTRAINT authorities_pkey;
       public         postgres    false    173    173         B           2606    32868     group_members group_members_pkey 
   CONSTRAINT     W   ALTER TABLE ONLY group_members
    ADD CONSTRAINT group_members_pkey PRIMARY KEY (id);
 J   ALTER TABLE ONLY public.group_members DROP CONSTRAINT group_members_pkey;
       public         postgres    false    177    177         D           2606    32876    groups groups_pkey 
   CONSTRAINT     I   ALTER TABLE ONLY groups
    ADD CONSTRAINT groups_pkey PRIMARY KEY (id);
 <   ALTER TABLE ONLY public.groups DROP CONSTRAINT groups_pkey;
       public         postgres    false    179    179         @           2606    32854 (   persistent_logins persistent_logins_pkey 
   CONSTRAINT     c   ALTER TABLE ONLY persistent_logins
    ADD CONSTRAINT persistent_logins_pkey PRIMARY KEY (series);
 R   ALTER TABLE ONLY public.persistent_logins DROP CONSTRAINT persistent_logins_pkey;
       public         postgres    false    174    174         <           2606    32841    users users_pkey 
   CONSTRAINT     M   ALTER TABLE ONLY users
    ADD CONSTRAINT users_pkey PRIMARY KEY (username);
 :   ALTER TABLE ONLY public.users DROP CONSTRAINT users_pkey;
       public         postgres    false    171    171         E           2606    32885 1   group_authorities group_authorities_group_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY group_authorities
    ADD CONSTRAINT group_authorities_group_id_fkey FOREIGN KEY (group_id) REFERENCES groups(id);
 [   ALTER TABLE ONLY public.group_authorities DROP CONSTRAINT group_authorities_group_id_fkey;
       public       postgres    false    179    175    1860         F           2606    32877 )   group_members group_members_group_id_fkey    FK CONSTRAINT     |   ALTER TABLE ONLY group_members
    ADD CONSTRAINT group_members_group_id_fkey FOREIGN KEY (group_id) REFERENCES groups(id);
 S   ALTER TABLE ONLY public.group_members DROP CONSTRAINT group_members_group_id_fkey;
       public       postgres    false    177    1860    179                                                                                                                                                                                                   1972.dat                                                                                            0000600 0004000 0002000 00000000005 13156217564 0014261 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        \.


                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           1974.dat                                                                                            0000600 0004000 0002000 00000000036 13156217564 0014267 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        1	ROLE_USER
2	ROLE_ADMIN
\.


                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  1976.dat                                                                                            0000600 0004000 0002000 00000000030 13156217564 0014263 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        1	user	1
2	admin	2
\.


                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        1978.dat                                                                                            0000600 0004000 0002000 00000000036 13156217564 0014273 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        1	users
2	administrators
\.


                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  1973.dat                                                                                            0000600 0004000 0002000 00000000124 13156217564 0014264 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        user	MArdtG7UIncUBCHHW82ZQQ==	xXoS1MLQt26VrCJVB5En9A==	2017-09-08 07:56:22.578
\.


                                                                                                                                                                                                                                                                                                                                                                                                                                            1970.dat                                                                                            0000600 0004000 0002000 00000000034 13156217564 0014261 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        user	123	t
admin	321	t
\.


                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    restore.sql                                                                                         0000600 0004000 0002000 00000021420 13156217564 0015375 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        --
-- NOTE:
--
-- File paths need to be edited. Search for $$PATH$$ and
-- replace it with the path to the directory containing
-- the extracted data files.
--
--
-- PostgreSQL database dump
--

-- Dumped from database version 9.3.3
-- Dumped by pg_dump version 9.6.3

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

SET search_path = public, pg_catalog;

ALTER TABLE ONLY public.group_members DROP CONSTRAINT group_members_group_id_fkey;
ALTER TABLE ONLY public.group_authorities DROP CONSTRAINT group_authorities_group_id_fkey;
ALTER TABLE ONLY public.users DROP CONSTRAINT users_pkey;
ALTER TABLE ONLY public.persistent_logins DROP CONSTRAINT persistent_logins_pkey;
ALTER TABLE ONLY public.groups DROP CONSTRAINT groups_pkey;
ALTER TABLE ONLY public.group_members DROP CONSTRAINT group_members_pkey;
ALTER TABLE ONLY public.authorities DROP CONSTRAINT authorities_pkey;
ALTER TABLE public.groups ALTER COLUMN id DROP DEFAULT;
ALTER TABLE public.group_members ALTER COLUMN id DROP DEFAULT;
ALTER TABLE public.authorities ALTER COLUMN id DROP DEFAULT;
DROP TABLE public.users;
DROP TABLE public.persistent_logins;
DROP SEQUENCE public.groups_id_seq;
DROP TABLE public.groups;
DROP SEQUENCE public.group_members_id_seq;
DROP TABLE public.group_members;
DROP TABLE public.group_authorities;
DROP SEQUENCE public.authorities_id_seq;
DROP TABLE public.authorities;
DROP EXTENSION plpgsql;
DROP SCHEMA public;
--
-- Name: public; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA public;


ALTER SCHEMA public OWNER TO postgres;

--
-- Name: SCHEMA public; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON SCHEMA public IS 'standard public schema';


--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: authorities; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE authorities (
    id integer NOT NULL,
    username character varying(50) NOT NULL,
    authority character varying(50) NOT NULL
);


ALTER TABLE authorities OWNER TO postgres;

--
-- Name: authorities_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE authorities_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE authorities_id_seq OWNER TO postgres;

--
-- Name: authorities_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE authorities_id_seq OWNED BY authorities.id;


--
-- Name: group_authorities; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE group_authorities (
    group_id bigint NOT NULL,
    authority character varying(45) DEFAULT NULL::character varying NOT NULL
);


ALTER TABLE group_authorities OWNER TO postgres;

--
-- Name: group_members; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE group_members (
    id integer NOT NULL,
    username character varying(45) NOT NULL,
    group_id integer NOT NULL
);


ALTER TABLE group_members OWNER TO postgres;

--
-- Name: group_members_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE group_members_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE group_members_id_seq OWNER TO postgres;

--
-- Name: group_members_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE group_members_id_seq OWNED BY group_members.id;


--
-- Name: groups; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE groups (
    id integer NOT NULL,
    group_name character varying(45) NOT NULL
);


ALTER TABLE groups OWNER TO postgres;

--
-- Name: groups_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE groups_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE groups_id_seq OWNER TO postgres;

--
-- Name: groups_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE groups_id_seq OWNED BY groups.id;


--
-- Name: persistent_logins; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE persistent_logins (
    username character varying(64) NOT NULL,
    series character varying(64) NOT NULL,
    token character varying(64) NOT NULL,
    last_used timestamp without time zone NOT NULL
);


ALTER TABLE persistent_logins OWNER TO postgres;

--
-- Name: users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE users (
    username character varying(50) NOT NULL,
    password character varying(50) NOT NULL,
    enabled boolean NOT NULL
);


ALTER TABLE users OWNER TO postgres;

--
-- Name: authorities id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY authorities ALTER COLUMN id SET DEFAULT nextval('authorities_id_seq'::regclass);


--
-- Name: group_members id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY group_members ALTER COLUMN id SET DEFAULT nextval('group_members_id_seq'::regclass);


--
-- Name: groups id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY groups ALTER COLUMN id SET DEFAULT nextval('groups_id_seq'::regclass);


--
-- Data for Name: authorities; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY authorities (id, username, authority) FROM stdin;
\.
COPY authorities (id, username, authority) FROM '$$PATH$$/1972.dat';

--
-- Name: authorities_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('authorities_id_seq', 4, true);


--
-- Data for Name: group_authorities; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY group_authorities (group_id, authority) FROM stdin;
\.
COPY group_authorities (group_id, authority) FROM '$$PATH$$/1974.dat';

--
-- Data for Name: group_members; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY group_members (id, username, group_id) FROM stdin;
\.
COPY group_members (id, username, group_id) FROM '$$PATH$$/1976.dat';

--
-- Name: group_members_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('group_members_id_seq', 2, true);


--
-- Data for Name: groups; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY groups (id, group_name) FROM stdin;
\.
COPY groups (id, group_name) FROM '$$PATH$$/1978.dat';

--
-- Name: groups_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('groups_id_seq', 2, true);


--
-- Data for Name: persistent_logins; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY persistent_logins (username, series, token, last_used) FROM stdin;
\.
COPY persistent_logins (username, series, token, last_used) FROM '$$PATH$$/1973.dat';

--
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY users (username, password, enabled) FROM stdin;
\.
COPY users (username, password, enabled) FROM '$$PATH$$/1970.dat';

--
-- Name: authorities authorities_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY authorities
    ADD CONSTRAINT authorities_pkey PRIMARY KEY (id);


--
-- Name: group_members group_members_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY group_members
    ADD CONSTRAINT group_members_pkey PRIMARY KEY (id);


--
-- Name: groups groups_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY groups
    ADD CONSTRAINT groups_pkey PRIMARY KEY (id);


--
-- Name: persistent_logins persistent_logins_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY persistent_logins
    ADD CONSTRAINT persistent_logins_pkey PRIMARY KEY (series);


--
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY users
    ADD CONSTRAINT users_pkey PRIMARY KEY (username);


--
-- Name: group_authorities group_authorities_group_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY group_authorities
    ADD CONSTRAINT group_authorities_group_id_fkey FOREIGN KEY (group_id) REFERENCES groups(id);


--
-- Name: group_members group_members_group_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY group_members
    ADD CONSTRAINT group_members_group_id_fkey FOREIGN KEY (group_id) REFERENCES groups(id);


--
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--

                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                