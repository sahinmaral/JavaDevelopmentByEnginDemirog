PGDMP     )    *                y            hrms    13.2    13.2 0    ?           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            ?           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            ?           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            ?           1262    16892    hrms    DATABASE     a   CREATE DATABASE hrms WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Turkish_Turkey.1254';
    DROP DATABASE hrms;
                postgres    false            ?            1259    17694 
   candidates    TABLE     ?   CREATE TABLE public.candidates (
    user_id integer NOT NULL,
    first_name character varying(50) NOT NULL,
    last_name character varying(50) NOT NULL,
    identity_id character varying(11) NOT NULL,
    birth_year integer NOT NULL
);
    DROP TABLE public.candidates;
       public         heap    postgres    false            ?            1259    17699    employee_confirms    TABLE     ?   CREATE TABLE public.employee_confirms (
    id integer NOT NULL,
    employee_id integer NOT NULL,
    is_confirmed boolean NOT NULL,
    confirm_date date NOT NULL
);
 %   DROP TABLE public.employee_confirms;
       public         heap    postgres    false            ?            1259    17704    employee_confirms_employers    TABLE     ?   CREATE TABLE public.employee_confirms_employers (
    employee_confirm_id integer NOT NULL,
    employer_id integer NOT NULL
);
 /   DROP TABLE public.employee_confirms_employers;
       public         heap    postgres    false            ?            1259    17709 	   employees    TABLE     ?   CREATE TABLE public.employees (
    user_id integer NOT NULL,
    first_name character varying(50) NOT NULL,
    last_name character varying(50) NOT NULL
);
    DROP TABLE public.employees;
       public         heap    postgres    false            ?            1259    17714 	   employers    TABLE     ?   CREATE TABLE public.employers (
    user_id integer NOT NULL,
    company_name character varying(350) NOT NULL,
    web_site character varying(350) NOT NULL,
    phone_number integer NOT NULL
);
    DROP TABLE public.employers;
       public         heap    postgres    false            ?            1259    17600    hibernate_sequence    SEQUENCE     {   CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.hibernate_sequence;
       public          postgres    false            ?            1259    17722 
   job_titles    TABLE     ?   CREATE TABLE public.job_titles (
    id integer NOT NULL,
    title character varying(50) NOT NULL,
    titles character varying(255)
);
    DROP TABLE public.job_titles;
       public         heap    postgres    false            ?            1259    17781    job_titles_id_seq    SEQUENCE     ?   ALTER TABLE public.job_titles ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.job_titles_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    206            ?            1259    17729    users    TABLE     ?   CREATE TABLE public.users (
    email character varying(50) NOT NULL,
    password character varying(50) NOT NULL,
    id integer NOT NULL
);
    DROP TABLE public.users;
       public         heap    postgres    false            ?            1259    17727    users_id_seq    SEQUENCE     ?   ALTER TABLE public.users ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.users_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    208            ?            1259    17734    verification_code_candidates    TABLE     ?   CREATE TABLE public.verification_code_candidates (
    verification_code_id integer NOT NULL,
    candidate_id integer NOT NULL
);
 0   DROP TABLE public.verification_code_candidates;
       public         heap    postgres    false            ?            1259    17739    verification_code_employers    TABLE     ?   CREATE TABLE public.verification_code_employers (
    verification_code_id integer NOT NULL,
    employers_id integer NOT NULL
);
 /   DROP TABLE public.verification_code_employers;
       public         heap    postgres    false            ?            1259    17746    verification_codes    TABLE     ?   CREATE TABLE public.verification_codes (
    id integer NOT NULL,
    code character varying(350) NOT NULL,
    is_verified boolean NOT NULL,
    verified_date date NOT NULL
);
 &   DROP TABLE public.verification_codes;
       public         heap    postgres    false            ?            1259    17744    verification_codes_id_seq    SEQUENCE     ?   ALTER TABLE public.verification_codes ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.verification_codes_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    212            ?          0    17694 
   candidates 
   TABLE DATA           ]   COPY public.candidates (user_id, first_name, last_name, identity_id, birth_year) FROM stdin;
    public          postgres    false    201   X;       ?          0    17699    employee_confirms 
   TABLE DATA           X   COPY public.employee_confirms (id, employee_id, is_confirmed, confirm_date) FROM stdin;
    public          postgres    false    202   u;       ?          0    17704    employee_confirms_employers 
   TABLE DATA           W   COPY public.employee_confirms_employers (employee_confirm_id, employer_id) FROM stdin;
    public          postgres    false    203   ?;       ?          0    17709 	   employees 
   TABLE DATA           C   COPY public.employees (user_id, first_name, last_name) FROM stdin;
    public          postgres    false    204   ?;       ?          0    17714 	   employers 
   TABLE DATA           R   COPY public.employers (user_id, company_name, web_site, phone_number) FROM stdin;
    public          postgres    false    205   ?;       ?          0    17722 
   job_titles 
   TABLE DATA           7   COPY public.job_titles (id, title, titles) FROM stdin;
    public          postgres    false    206   ?;       ?          0    17729    users 
   TABLE DATA           4   COPY public.users (email, password, id) FROM stdin;
    public          postgres    false    208   G<       ?          0    17734    verification_code_candidates 
   TABLE DATA           Z   COPY public.verification_code_candidates (verification_code_id, candidate_id) FROM stdin;
    public          postgres    false    209   d<       ?          0    17739    verification_code_employers 
   TABLE DATA           Y   COPY public.verification_code_employers (verification_code_id, employers_id) FROM stdin;
    public          postgres    false    210   ?<       ?          0    17746    verification_codes 
   TABLE DATA           R   COPY public.verification_codes (id, code, is_verified, verified_date) FROM stdin;
    public          postgres    false    212   ?<       ?           0    0    hibernate_sequence    SEQUENCE SET     A   SELECT pg_catalog.setval('public.hibernate_sequence', 1, false);
          public          postgres    false    200            ?           0    0    job_titles_id_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.job_titles_id_seq', 5, true);
          public          postgres    false    213            ?           0    0    users_id_seq    SEQUENCE SET     ;   SELECT pg_catalog.setval('public.users_id_seq', 1, false);
          public          postgres    false    207                        0    0    verification_codes_id_seq    SEQUENCE SET     H   SELECT pg_catalog.setval('public.verification_codes_id_seq', 1, false);
          public          postgres    false    211            N           2606    17698    candidates candidates_pkey 
   CONSTRAINT     ]   ALTER TABLE ONLY public.candidates
    ADD CONSTRAINT candidates_pkey PRIMARY KEY (user_id);
 D   ALTER TABLE ONLY public.candidates DROP CONSTRAINT candidates_pkey;
       public            postgres    false    201            R           2606    17708 <   employee_confirms_employers employee_confirms_employers_pkey 
   CONSTRAINT     ?   ALTER TABLE ONLY public.employee_confirms_employers
    ADD CONSTRAINT employee_confirms_employers_pkey PRIMARY KEY (employee_confirm_id);
 f   ALTER TABLE ONLY public.employee_confirms_employers DROP CONSTRAINT employee_confirms_employers_pkey;
       public            postgres    false    203            P           2606    17703 (   employee_confirms employee_confirms_pkey 
   CONSTRAINT     f   ALTER TABLE ONLY public.employee_confirms
    ADD CONSTRAINT employee_confirms_pkey PRIMARY KEY (id);
 R   ALTER TABLE ONLY public.employee_confirms DROP CONSTRAINT employee_confirms_pkey;
       public            postgres    false    202            T           2606    17713    employees employees_pkey 
   CONSTRAINT     [   ALTER TABLE ONLY public.employees
    ADD CONSTRAINT employees_pkey PRIMARY KEY (user_id);
 B   ALTER TABLE ONLY public.employees DROP CONSTRAINT employees_pkey;
       public            postgres    false    204            V           2606    17721    employers employers_pkey 
   CONSTRAINT     [   ALTER TABLE ONLY public.employers
    ADD CONSTRAINT employers_pkey PRIMARY KEY (user_id);
 B   ALTER TABLE ONLY public.employers DROP CONSTRAINT employers_pkey;
       public            postgres    false    205            X           2606    17726    job_titles job_titles_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY public.job_titles
    ADD CONSTRAINT job_titles_pkey PRIMARY KEY (id);
 D   ALTER TABLE ONLY public.job_titles DROP CONSTRAINT job_titles_pkey;
       public            postgres    false    206            Z           2606    17733    users users_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.users DROP CONSTRAINT users_pkey;
       public            postgres    false    208            \           2606    17738 >   verification_code_candidates verification_code_candidates_pkey 
   CONSTRAINT     ?   ALTER TABLE ONLY public.verification_code_candidates
    ADD CONSTRAINT verification_code_candidates_pkey PRIMARY KEY (verification_code_id);
 h   ALTER TABLE ONLY public.verification_code_candidates DROP CONSTRAINT verification_code_candidates_pkey;
       public            postgres    false    209            ^           2606    17743 <   verification_code_employers verification_code_employers_pkey 
   CONSTRAINT     ?   ALTER TABLE ONLY public.verification_code_employers
    ADD CONSTRAINT verification_code_employers_pkey PRIMARY KEY (verification_code_id);
 f   ALTER TABLE ONLY public.verification_code_employers DROP CONSTRAINT verification_code_employers_pkey;
       public            postgres    false    210            `           2606    17750 *   verification_codes verification_codes_pkey 
   CONSTRAINT     h   ALTER TABLE ONLY public.verification_codes
    ADD CONSTRAINT verification_codes_pkey PRIMARY KEY (id);
 T   ALTER TABLE ONLY public.verification_codes DROP CONSTRAINT verification_codes_pkey;
       public            postgres    false    212            a           2606    17751 "   candidates candidates_user_id_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.candidates
    ADD CONSTRAINT candidates_user_id_fkey FOREIGN KEY (user_id) REFERENCES public.users(id) NOT VALID;
 L   ALTER TABLE ONLY public.candidates DROP CONSTRAINT candidates_user_id_fkey;
       public          postgres    false    2906    208    201            b           2606    17776 P   employee_confirms_employers employee_confirms_employers_employee_confirm_id_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.employee_confirms_employers
    ADD CONSTRAINT employee_confirms_employers_employee_confirm_id_fkey FOREIGN KEY (employee_confirm_id) REFERENCES public.employee_confirms(id) NOT VALID;
 z   ALTER TABLE ONLY public.employee_confirms_employers DROP CONSTRAINT employee_confirms_employers_employee_confirm_id_fkey;
       public          postgres    false    2896    202    203            c           2606    17756     employees employees_user_id_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.employees
    ADD CONSTRAINT employees_user_id_fkey FOREIGN KEY (user_id) REFERENCES public.users(id) NOT VALID;
 J   ALTER TABLE ONLY public.employees DROP CONSTRAINT employees_user_id_fkey;
       public          postgres    false    208    204    2906            d           2606    17766     employers employers_user_id_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.employers
    ADD CONSTRAINT employers_user_id_fkey FOREIGN KEY (user_id) REFERENCES public.users(id) NOT VALID;
 J   ALTER TABLE ONLY public.employers DROP CONSTRAINT employers_user_id_fkey;
       public          postgres    false    205    208    2906            e           2606    17761 S   verification_code_candidates verification_code_candidates_verification_code_id_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.verification_code_candidates
    ADD CONSTRAINT verification_code_candidates_verification_code_id_fkey FOREIGN KEY (verification_code_id) REFERENCES public.verification_codes(id) NOT VALID;
 }   ALTER TABLE ONLY public.verification_code_candidates DROP CONSTRAINT verification_code_candidates_verification_code_id_fkey;
       public          postgres    false    2912    212    209            f           2606    17771 Q   verification_code_employers verification_code_employers_verification_code_id_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.verification_code_employers
    ADD CONSTRAINT verification_code_employers_verification_code_id_fkey FOREIGN KEY (verification_code_id) REFERENCES public.verification_codes(id) NOT VALID;
 {   ALTER TABLE ONLY public.verification_code_employers DROP CONSTRAINT verification_code_employers_verification_code_id_fkey;
       public          postgres    false    212    210    2912            ?      x?????? ? ?      ?      x?????? ? ?      ?      x?????? ? ?      ?      x?????? ? ?      ?      x?????? ? ?      ?   N   x?3?t+???-.IL?VpI-K??/H-????2?t???楠?s??'e椢??p????躢+7?OMB????? Kq%?      ?      x?????? ? ?      ?      x?????? ? ?      ?      x?????? ? ?      ?      x?????? ? ?     