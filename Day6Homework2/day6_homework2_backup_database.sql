PGDMP                         y            hrms    13.2    13.2 A               0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                       1262    16892    hrms    DATABASE     a   CREATE DATABASE hrms WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Turkish_Turkey.1254';
    DROP DATABASE hrms;
                postgres    false            �            1259    16995 
   candidates    TABLE     "  CREATE TABLE public.candidates (
    id integer NOT NULL,
    first_name character varying(50) NOT NULL,
    last_name character varying(50) NOT NULL,
    turkish_identity_id character varying(11) NOT NULL,
    date_of_birth date NOT NULL,
    is_verified boolean DEFAULT false NOT NULL
);
    DROP TABLE public.candidates;
       public         heap    postgres    false            �            1259    16993    candidates_id_seq    SEQUENCE     �   ALTER TABLE public.candidates ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.candidates_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    205            �            1259    17023    employee    TABLE     �   CREATE TABLE public.employee (
    id integer NOT NULL,
    first_name character varying(50) NOT NULL,
    last_name character varying(50) NOT NULL
);
    DROP TABLE public.employee;
       public         heap    postgres    false            �            1259    17021    employee_id_seq    SEQUENCE     �   ALTER TABLE public.employee ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.employee_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    208            �            1259    16981 	   employers    TABLE     �   CREATE TABLE public.employers (
    id integer NOT NULL,
    company_name character varying(200) NOT NULL,
    web_site character varying(50) NOT NULL,
    telephone_number character varying(11) NOT NULL,
    is_verified boolean DEFAULT false NOT NULL
);
    DROP TABLE public.employers;
       public         heap    postgres    false            �            1259    16979    employers_id_seq    SEQUENCE     �   ALTER TABLE public.employers ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.employers_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    201            �            1259    17600    hibernate_sequence    SEQUENCE     {   CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.hibernate_sequence;
       public          postgres    false            �            1259    17002    job_positions    TABLE     i   CREATE TABLE public.job_positions (
    id smallint NOT NULL,
    name character varying(50) NOT NULL
);
 !   DROP TABLE public.job_positions;
       public         heap    postgres    false            �            1259    17602    job_positions_id_seq    SEQUENCE     �   ALTER TABLE public.job_positions ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.job_positions_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    206            �            1259    16988    users    TABLE     �   CREATE TABLE public.users (
    id integer NOT NULL,
    email character varying(50) NOT NULL,
    password character varying(25) NOT NULL
);
    DROP TABLE public.users;
       public         heap    postgres    false            �            1259    16986    users_id_seq    SEQUENCE     �   ALTER TABLE public.users ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.users_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    203            �            1259    17047    verification_system    TABLE     �   CREATE TABLE public.verification_system (
    id integer NOT NULL,
    is_verified_email boolean,
    user_id integer NOT NULL
);
 '   DROP TABLE public.verification_system;
       public         heap    postgres    false            �            1259    17054 !   verification_system_for_employers    TABLE     �   CREATE TABLE public.verification_system_for_employers (
    id integer NOT NULL,
    is_verified_by_employee boolean NOT NULL
);
 5   DROP TABLE public.verification_system_for_employers;
       public         heap    postgres    false            �            1259    17052 (   verification_system_for_employers_id_seq    SEQUENCE     �   ALTER TABLE public.verification_system_for_employers ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.verification_system_for_employers_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    212            �            1259    17045    verification_system_id_seq    SEQUENCE     �   ALTER TABLE public.verification_system ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.verification_system_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    210            �          0    16995 
   candidates 
   TABLE DATA           p   COPY public.candidates (id, first_name, last_name, turkish_identity_id, date_of_birth, is_verified) FROM stdin;
    public          postgres    false    205   S       �          0    17023    employee 
   TABLE DATA           =   COPY public.employee (id, first_name, last_name) FROM stdin;
    public          postgres    false    208   S       �          0    16981 	   employers 
   TABLE DATA           ^   COPY public.employers (id, company_name, web_site, telephone_number, is_verified) FROM stdin;
    public          postgres    false    201   ;S       �          0    17002    job_positions 
   TABLE DATA           1   COPY public.job_positions (id, name) FROM stdin;
    public          postgres    false    206   XS       �          0    16988    users 
   TABLE DATA           4   COPY public.users (id, email, password) FROM stdin;
    public          postgres    false    203   �S       �          0    17047    verification_system 
   TABLE DATA           M   COPY public.verification_system (id, is_verified_email, user_id) FROM stdin;
    public          postgres    false    210   �S                  0    17054 !   verification_system_for_employers 
   TABLE DATA           X   COPY public.verification_system_for_employers (id, is_verified_by_employee) FROM stdin;
    public          postgres    false    212   T       	           0    0    candidates_id_seq    SEQUENCE SET     @   SELECT pg_catalog.setval('public.candidates_id_seq', 1, false);
          public          postgres    false    204            
           0    0    employee_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.employee_id_seq', 1, false);
          public          postgres    false    207                       0    0    employers_id_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.employers_id_seq', 1, false);
          public          postgres    false    200                       0    0    hibernate_sequence    SEQUENCE SET     A   SELECT pg_catalog.setval('public.hibernate_sequence', 1, false);
          public          postgres    false    213                       0    0    job_positions_id_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public.job_positions_id_seq', 1, false);
          public          postgres    false    214                       0    0    users_id_seq    SEQUENCE SET     ;   SELECT pg_catalog.setval('public.users_id_seq', 1, false);
          public          postgres    false    202                       0    0 (   verification_system_for_employers_id_seq    SEQUENCE SET     W   SELECT pg_catalog.setval('public.verification_system_for_employers_id_seq', 1, false);
          public          postgres    false    211                       0    0    verification_system_id_seq    SEQUENCE SET     I   SELECT pg_catalog.setval('public.verification_system_id_seq', 1, false);
          public          postgres    false    209            O           2606    16999    candidates candidates_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY public.candidates
    ADD CONSTRAINT candidates_pkey PRIMARY KEY (id);
 D   ALTER TABLE ONLY public.candidates DROP CONSTRAINT candidates_pkey;
       public            postgres    false    205            U           2606    17027    employee employee_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.employee
    ADD CONSTRAINT employee_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.employee DROP CONSTRAINT employee_pkey;
       public            postgres    false    208            K           2606    16985    employers employers_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.employers
    ADD CONSTRAINT employers_pkey PRIMARY KEY (id);
 B   ALTER TABLE ONLY public.employers DROP CONSTRAINT employers_pkey;
       public            postgres    false    201            Q           2606    17605 $   job_positions job_positions_name_key 
   CONSTRAINT     _   ALTER TABLE ONLY public.job_positions
    ADD CONSTRAINT job_positions_name_key UNIQUE (name);
 N   ALTER TABLE ONLY public.job_positions DROP CONSTRAINT job_positions_name_key;
       public            postgres    false    206            S           2606    17595    job_positions pk_job_positions 
   CONSTRAINT     \   ALTER TABLE ONLY public.job_positions
    ADD CONSTRAINT pk_job_positions PRIMARY KEY (id);
 H   ALTER TABLE ONLY public.job_positions DROP CONSTRAINT pk_job_positions;
       public            postgres    false    206            M           2606    16992    users users_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.users DROP CONSTRAINT users_pkey;
       public            postgres    false    203            [           2606    17058 H   verification_system_for_employers verification_system_for_employers_pkey 
   CONSTRAINT     �   ALTER TABLE ONLY public.verification_system_for_employers
    ADD CONSTRAINT verification_system_for_employers_pkey PRIMARY KEY (id);
 r   ALTER TABLE ONLY public.verification_system_for_employers DROP CONSTRAINT verification_system_for_employers_pkey;
       public            postgres    false    212            W           2606    17051 ,   verification_system verification_system_pkey 
   CONSTRAINT     j   ALTER TABLE ONLY public.verification_system
    ADD CONSTRAINT verification_system_pkey PRIMARY KEY (id);
 V   ALTER TABLE ONLY public.verification_system DROP CONSTRAINT verification_system_pkey;
       public            postgres    false    210            Y           2606    17529 3   verification_system verification_system_user_id_key 
   CONSTRAINT     q   ALTER TABLE ONLY public.verification_system
    ADD CONSTRAINT verification_system_user_id_key UNIQUE (user_id);
 ]   ALTER TABLE ONLY public.verification_system DROP CONSTRAINT verification_system_user_id_key;
       public            postgres    false    210            a           2606    17059    candidates candidates_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.candidates
    ADD CONSTRAINT candidates_id_fkey FOREIGN KEY (id) REFERENCES public.users(id) NOT VALID;
 G   ALTER TABLE ONLY public.candidates DROP CONSTRAINT candidates_id_fkey;
       public          postgres    false    2893    203    205            b           2606    17443    candidates candidates_id_fkey1    FK CONSTRAINT     �   ALTER TABLE ONLY public.candidates
    ADD CONSTRAINT candidates_id_fkey1 FOREIGN KEY (id) REFERENCES public.users(id) NOT VALID;
 H   ALTER TABLE ONLY public.candidates DROP CONSTRAINT candidates_id_fkey1;
       public          postgres    false    2893    203    205            c           2606    17448    candidates candidates_id_fkey2    FK CONSTRAINT     �   ALTER TABLE ONLY public.candidates
    ADD CONSTRAINT candidates_id_fkey2 FOREIGN KEY (id) REFERENCES public.users(id) NOT VALID;
 H   ALTER TABLE ONLY public.candidates DROP CONSTRAINT candidates_id_fkey2;
       public          postgres    false    203    205    2893            d           2606    17458    candidates candidates_id_fkey3    FK CONSTRAINT     �   ALTER TABLE ONLY public.candidates
    ADD CONSTRAINT candidates_id_fkey3 FOREIGN KEY (id) REFERENCES public.users(id) NOT VALID;
 H   ALTER TABLE ONLY public.candidates DROP CONSTRAINT candidates_id_fkey3;
       public          postgres    false    203    2893    205            e           2606    17530    candidates candidates_id_fkey4    FK CONSTRAINT     �   ALTER TABLE ONLY public.candidates
    ADD CONSTRAINT candidates_id_fkey4 FOREIGN KEY (id) REFERENCES public.users(id) NOT VALID;
 H   ALTER TABLE ONLY public.candidates DROP CONSTRAINT candidates_id_fkey4;
       public          postgres    false    205    2893    203            f           2606    17535    candidates candidates_id_fkey5    FK CONSTRAINT     �   ALTER TABLE ONLY public.candidates
    ADD CONSTRAINT candidates_id_fkey5 FOREIGN KEY (id) REFERENCES public.users(id) NOT VALID;
 H   ALTER TABLE ONLY public.candidates DROP CONSTRAINT candidates_id_fkey5;
       public          postgres    false    203    2893    205            g           2606    17540    candidates candidates_id_fkey6    FK CONSTRAINT     �   ALTER TABLE ONLY public.candidates
    ADD CONSTRAINT candidates_id_fkey6 FOREIGN KEY (id) REFERENCES public.users(id) NOT VALID;
 H   ALTER TABLE ONLY public.candidates DROP CONSTRAINT candidates_id_fkey6;
       public          postgres    false    2893    205    203            h           2606    17545    candidates candidates_id_fkey7    FK CONSTRAINT     �   ALTER TABLE ONLY public.candidates
    ADD CONSTRAINT candidates_id_fkey7 FOREIGN KEY (id) REFERENCES public.users(id) NOT VALID;
 H   ALTER TABLE ONLY public.candidates DROP CONSTRAINT candidates_id_fkey7;
       public          postgres    false    205    203    2893            i           2606    17585    candidates candidates_id_fkey8    FK CONSTRAINT     �   ALTER TABLE ONLY public.candidates
    ADD CONSTRAINT candidates_id_fkey8 FOREIGN KEY (id) REFERENCES public.verification_system(user_id) NOT VALID;
 H   ALTER TABLE ONLY public.candidates DROP CONSTRAINT candidates_id_fkey8;
       public          postgres    false    205    210    2905            j           2606    17064    employee employee_id_fkey    FK CONSTRAINT     }   ALTER TABLE ONLY public.employee
    ADD CONSTRAINT employee_id_fkey FOREIGN KEY (id) REFERENCES public.users(id) NOT VALID;
 C   ALTER TABLE ONLY public.employee DROP CONSTRAINT employee_id_fkey;
       public          postgres    false    203    208    2893            k           2606    17453    employee employee_id_fkey1    FK CONSTRAINT     ~   ALTER TABLE ONLY public.employee
    ADD CONSTRAINT employee_id_fkey1 FOREIGN KEY (id) REFERENCES public.users(id) NOT VALID;
 D   ALTER TABLE ONLY public.employee DROP CONSTRAINT employee_id_fkey1;
       public          postgres    false    203    208    2893            l           2606    17463    employee employee_id_fkey2    FK CONSTRAINT     ~   ALTER TABLE ONLY public.employee
    ADD CONSTRAINT employee_id_fkey2 FOREIGN KEY (id) REFERENCES public.users(id) NOT VALID;
 D   ALTER TABLE ONLY public.employee DROP CONSTRAINT employee_id_fkey2;
       public          postgres    false    203    2893    208            m           2606    17550    employee employee_id_fkey3    FK CONSTRAINT     ~   ALTER TABLE ONLY public.employee
    ADD CONSTRAINT employee_id_fkey3 FOREIGN KEY (id) REFERENCES public.users(id) NOT VALID;
 D   ALTER TABLE ONLY public.employee DROP CONSTRAINT employee_id_fkey3;
       public          postgres    false    2893    208    203            n           2606    17555    employee employee_id_fkey4    FK CONSTRAINT     ~   ALTER TABLE ONLY public.employee
    ADD CONSTRAINT employee_id_fkey4 FOREIGN KEY (id) REFERENCES public.users(id) NOT VALID;
 D   ALTER TABLE ONLY public.employee DROP CONSTRAINT employee_id_fkey4;
       public          postgres    false    203    2893    208            o           2606    17560    employee employee_id_fkey5    FK CONSTRAINT     ~   ALTER TABLE ONLY public.employee
    ADD CONSTRAINT employee_id_fkey5 FOREIGN KEY (id) REFERENCES public.users(id) NOT VALID;
 D   ALTER TABLE ONLY public.employee DROP CONSTRAINT employee_id_fkey5;
       public          postgres    false    2893    208    203            \           2606    17069    employers employers_id_fkey    FK CONSTRAINT        ALTER TABLE ONLY public.employers
    ADD CONSTRAINT employers_id_fkey FOREIGN KEY (id) REFERENCES public.users(id) NOT VALID;
 E   ALTER TABLE ONLY public.employers DROP CONSTRAINT employers_id_fkey;
       public          postgres    false    203    201    2893            ]           2606    17468    employers employers_id_fkey1    FK CONSTRAINT     �   ALTER TABLE ONLY public.employers
    ADD CONSTRAINT employers_id_fkey1 FOREIGN KEY (id) REFERENCES public.users(id) NOT VALID;
 F   ALTER TABLE ONLY public.employers DROP CONSTRAINT employers_id_fkey1;
       public          postgres    false    2893    201    203            ^           2606    17565    employers employers_id_fkey2    FK CONSTRAINT     �   ALTER TABLE ONLY public.employers
    ADD CONSTRAINT employers_id_fkey2 FOREIGN KEY (id) REFERENCES public.users(id) NOT VALID;
 F   ALTER TABLE ONLY public.employers DROP CONSTRAINT employers_id_fkey2;
       public          postgres    false    203    201    2893            _           2606    17570    employers employers_id_fkey3    FK CONSTRAINT     �   ALTER TABLE ONLY public.employers
    ADD CONSTRAINT employers_id_fkey3 FOREIGN KEY (id) REFERENCES public.users(id) NOT VALID;
 F   ALTER TABLE ONLY public.employers DROP CONSTRAINT employers_id_fkey3;
       public          postgres    false    203    2893    201            `           2606    17580    employers employers_id_fkey4    FK CONSTRAINT     �   ALTER TABLE ONLY public.employers
    ADD CONSTRAINT employers_id_fkey4 FOREIGN KEY (id) REFERENCES public.verification_system(user_id) NOT VALID;
 F   ALTER TABLE ONLY public.employers DROP CONSTRAINT employers_id_fkey4;
       public          postgres    false    201    210    2905            p           2606    17473 K   verification_system_for_employers verification_system_for_employers_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.verification_system_for_employers
    ADD CONSTRAINT verification_system_for_employers_id_fkey FOREIGN KEY (id) REFERENCES public.verification_system(id) NOT VALID;
 u   ALTER TABLE ONLY public.verification_system_for_employers DROP CONSTRAINT verification_system_for_employers_id_fkey;
       public          postgres    false    210    2903    212            q           2606    17575 L   verification_system_for_employers verification_system_for_employers_id_fkey1    FK CONSTRAINT     �   ALTER TABLE ONLY public.verification_system_for_employers
    ADD CONSTRAINT verification_system_for_employers_id_fkey1 FOREIGN KEY (id) REFERENCES public.verification_system(id) NOT VALID;
 v   ALTER TABLE ONLY public.verification_system_for_employers DROP CONSTRAINT verification_system_for_employers_id_fkey1;
       public          postgres    false    212    210    2903            �      x������ � �      �      x������ � �      �      x������ � �      �   k   x�34��O+)O,JUpI-K��/H-�24�t+���.IL�F7�t��� �s���躢
�p��'e�*$�d&'�d��)��g��)��0�1z\\\ �.�      �      x������ � �      �      x������ � �             x������ � �     