PGDMP     ;                     v         
   artsok_sql    9.3.3    9.6.3 '    �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                       false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                       false            �           1262    49245 
   artsok_sql    DATABASE     �   CREATE DATABASE artsok_sql WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Russian_Russia.1251' LC_CTYPE = 'Russian_Russia.1251';
    DROP DATABASE artsok_sql;
             postgres    false                        2615    2200    public    SCHEMA        CREATE SCHEMA public;
    DROP SCHEMA public;
             postgres    false            �           0    0    SCHEMA public    COMMENT     6   COMMENT ON SCHEMA public IS 'standard public schema';
                  postgres    false    7            �           0    0    public    ACL     �   REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;
                  postgres    false    7                        3079    11750    plpgsql 	   EXTENSION     ?   CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;
    DROP EXTENSION plpgsql;
                  false            �           0    0    EXTENSION plpgsql    COMMENT     @   COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';
                       false    1            �            1259    49246    authorities    TABLE     �   CREATE TABLE authorities (
    id integer NOT NULL,
    username character varying(50) NOT NULL,
    authority character varying(50) NOT NULL
);
    DROP TABLE public.authorities;
       public         postgres    false    7            �            1259    49249    authorities_id_seq    SEQUENCE     t   CREATE SEQUENCE authorities_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.authorities_id_seq;
       public       postgres    false    7    171            �           0    0    authorities_id_seq    SEQUENCE OWNED BY     ;   ALTER SEQUENCE authorities_id_seq OWNED BY authorities.id;
            public       postgres    false    172            �            1259    49251    group_authorities    TABLE     �   CREATE TABLE group_authorities (
    group_id bigint NOT NULL,
    authority character varying(45) DEFAULT NULL::character varying NOT NULL
);
 %   DROP TABLE public.group_authorities;
       public         postgres    false    7            �            1259    49255    group_members    TABLE     �   CREATE TABLE group_members (
    id integer NOT NULL,
    username character varying(45) NOT NULL,
    group_id integer NOT NULL
);
 !   DROP TABLE public.group_members;
       public         postgres    false    7            �            1259    49258    group_members_id_seq    SEQUENCE     v   CREATE SEQUENCE group_members_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public.group_members_id_seq;
       public       postgres    false    174    7            �           0    0    group_members_id_seq    SEQUENCE OWNED BY     ?   ALTER SEQUENCE group_members_id_seq OWNED BY group_members.id;
            public       postgres    false    175            �            1259    49260    groups    TABLE     `   CREATE TABLE groups (
    id integer NOT NULL,
    group_name character varying(45) NOT NULL
);
    DROP TABLE public.groups;
       public         postgres    false    7            �            1259    49263    groups_id_seq    SEQUENCE     o   CREATE SEQUENCE groups_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 $   DROP SEQUENCE public.groups_id_seq;
       public       postgres    false    176    7            �           0    0    groups_id_seq    SEQUENCE OWNED BY     1   ALTER SEQUENCE groups_id_seq OWNED BY groups.id;
            public       postgres    false    177            �            1259    49265    persistent_logins    TABLE     �   CREATE TABLE persistent_logins (
    username character varying(64) NOT NULL,
    series character varying(64) NOT NULL,
    token character varying(64) NOT NULL,
    last_used timestamp without time zone NOT NULL
);
 %   DROP TABLE public.persistent_logins;
       public         postgres    false    7            �            1259    49268    users    TABLE     d  CREATE TABLE users (
    username character varying(50) NOT NULL,
    password character varying(50) NOT NULL,
    enabled boolean NOT NULL,
    first_name character varying(64) NOT NULL,
    last_name character varying(64) NOT NULL,
    phone integer NOT NULL,
    company character varying(64) NOT NULL,
    middle_name character varying(64) NOT NULL
);
    DROP TABLE public.users;
       public         postgres    false    7            7           2604    49294    authorities id    DEFAULT     b   ALTER TABLE ONLY authorities ALTER COLUMN id SET DEFAULT nextval('authorities_id_seq'::regclass);
 =   ALTER TABLE public.authorities ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    172    171            9           2604    49295    group_members id    DEFAULT     f   ALTER TABLE ONLY group_members ALTER COLUMN id SET DEFAULT nextval('group_members_id_seq'::regclass);
 ?   ALTER TABLE public.group_members ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    175    174            :           2604    49296 	   groups id    DEFAULT     X   ALTER TABLE ONLY groups ALTER COLUMN id SET DEFAULT nextval('groups_id_seq'::regclass);
 8   ALTER TABLE public.groups ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    177    176            �          0    49246    authorities 
   TABLE DATA               7   COPY authorities (id, username, authority) FROM stdin;
    public       postgres    false    171   �(       �           0    0    authorities_id_seq    SEQUENCE SET     9   SELECT pg_catalog.setval('authorities_id_seq', 4, true);
            public       postgres    false    172            �          0    49251    group_authorities 
   TABLE DATA               9   COPY group_authorities (group_id, authority) FROM stdin;
    public       postgres    false    173   �(       �          0    49255    group_members 
   TABLE DATA               8   COPY group_members (id, username, group_id) FROM stdin;
    public       postgres    false    174    )       �           0    0    group_members_id_seq    SEQUENCE SET     ;   SELECT pg_catalog.setval('group_members_id_seq', 2, true);
            public       postgres    false    175            �          0    49260    groups 
   TABLE DATA               )   COPY groups (id, group_name) FROM stdin;
    public       postgres    false    176   0)       �           0    0    groups_id_seq    SEQUENCE SET     4   SELECT pg_catalog.setval('groups_id_seq', 2, true);
            public       postgres    false    177            �          0    49265    persistent_logins 
   TABLE DATA               H   COPY persistent_logins (username, series, token, last_used) FROM stdin;
    public       postgres    false    178   e)       �          0    49268    users 
   TABLE DATA               i   COPY users (username, password, enabled, first_name, last_name, phone, company, middle_name) FROM stdin;
    public       postgres    false    179   �)       <           2606    49275    authorities authorities_pkey 
   CONSTRAINT     S   ALTER TABLE ONLY authorities
    ADD CONSTRAINT authorities_pkey PRIMARY KEY (id);
 F   ALTER TABLE ONLY public.authorities DROP CONSTRAINT authorities_pkey;
       public         postgres    false    171    171            >           2606    49277     group_members group_members_pkey 
   CONSTRAINT     W   ALTER TABLE ONLY group_members
    ADD CONSTRAINT group_members_pkey PRIMARY KEY (id);
 J   ALTER TABLE ONLY public.group_members DROP CONSTRAINT group_members_pkey;
       public         postgres    false    174    174            @           2606    49279    groups groups_pkey 
   CONSTRAINT     I   ALTER TABLE ONLY groups
    ADD CONSTRAINT groups_pkey PRIMARY KEY (id);
 <   ALTER TABLE ONLY public.groups DROP CONSTRAINT groups_pkey;
       public         postgres    false    176    176            B           2606    49281 (   persistent_logins persistent_logins_pkey 
   CONSTRAINT     c   ALTER TABLE ONLY persistent_logins
    ADD CONSTRAINT persistent_logins_pkey PRIMARY KEY (series);
 R   ALTER TABLE ONLY public.persistent_logins DROP CONSTRAINT persistent_logins_pkey;
       public         postgres    false    178    178            D           2606    49283    users users_pkey 
   CONSTRAINT     M   ALTER TABLE ONLY users
    ADD CONSTRAINT users_pkey PRIMARY KEY (username);
 :   ALTER TABLE ONLY public.users DROP CONSTRAINT users_pkey;
       public         postgres    false    179    179            E           2606    49284 1   group_authorities group_authorities_group_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY group_authorities
    ADD CONSTRAINT group_authorities_group_id_fkey FOREIGN KEY (group_id) REFERENCES groups(id);
 [   ALTER TABLE ONLY public.group_authorities DROP CONSTRAINT group_authorities_group_id_fkey;
       public       postgres    false    1856    173    176            F           2606    49289 )   group_members group_members_group_id_fkey    FK CONSTRAINT     |   ALTER TABLE ONLY group_members
    ADD CONSTRAINT group_members_group_id_fkey FOREIGN KEY (group_id) REFERENCES groups(id);
 S   ALTER TABLE ONLY public.group_members DROP CONSTRAINT group_members_group_id_fkey;
       public       postgres    false    176    174    1856            �      x������ � �      �   %   x�3���q�v�2��]|=��qI��qqq ��O      �       x�3�,-N-�4�2�LL����4����� L+o      �   %   x�3�,-N-*�2�LL����,.)J,�
��qqq �d	X      �   [   x�+-N-��u,J)q7��Kur���0�
��嬈�6��	,12+r�
s2uͳtJ��X�X(�[��Y陚[p��qqq b�      �   D   x�+-N-�442�,��L��9��9�SR�S�Sr3�8A�%���婜f�f@*��\1z\\\ ��Q     