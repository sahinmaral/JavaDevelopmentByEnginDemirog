PGDMP         -                y            hrms    13.2    13.2 8               0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                       1262    16892    hrms    DATABASE     a   CREATE DATABASE hrms WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Turkish_Turkey.1254';
    DROP DATABASE hrms;
                postgres    false            ?            1259    17823 
   candidates    TABLE     ?   CREATE TABLE public.candidates (
    first_name character varying(50) NOT NULL,
    last_name character varying(50) NOT NULL,
    identity_id character varying(11) NOT NULL,
    birth_year integer NOT NULL,
    id integer NOT NULL
);
    DROP TABLE public.candidates;
       public         heap    postgres    false            ?            1259    18014    cities    TABLE     b   CREATE TABLE public.cities (
    id integer NOT NULL,
    name character varying(255) NOT NULL
);
    DROP TABLE public.cities;
       public         heap    postgres    false            ?            1259    18012    cities_city_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.cities_city_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.cities_city_id_seq;
       public          postgres    false    217                       0    0    cities_city_id_seq    SEQUENCE OWNED BY     D   ALTER SEQUENCE public.cities_city_id_seq OWNED BY public.cities.id;
          public          postgres    false    216            ?            1259    17699    employee_confirms    TABLE     ?   CREATE TABLE public.employee_confirms (
    id integer NOT NULL,
    employee_id integer NOT NULL,
    is_confirmed boolean NOT NULL,
    confirm_date date NOT NULL
);
 %   DROP TABLE public.employee_confirms;
       public         heap    postgres    false            ?            1259    17704    employee_confirms_employers    TABLE     o   CREATE TABLE public.employee_confirms_employers (
    id integer NOT NULL,
    employer_id integer NOT NULL
);
 /   DROP TABLE public.employee_confirms_employers;
       public         heap    postgres    false            ?            1259    17709 	   employees    TABLE     ?   CREATE TABLE public.employees (
    first_name character varying(50) NOT NULL,
    last_name character varying(50) NOT NULL,
    id integer NOT NULL
);
    DROP TABLE public.employees;
       public         heap    postgres    false            ?            1259    17714 	   employers    TABLE     ?   CREATE TABLE public.employers (
    company_name character varying(350) NOT NULL,
    web_site character varying(350) NOT NULL,
    phone_number character varying(11) NOT NULL,
    id integer NOT NULL
);
    DROP TABLE public.employers;
       public         heap    postgres    false            ?            1259    17600    hibernate_sequence    SEQUENCE     {   CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.hibernate_sequence;
       public          postgres    false            ?            1259    17976    job_adverts    TABLE     ?  CREATE TABLE public.job_adverts (
    id integer NOT NULL,
    max_salary smallint NOT NULL,
    min_salary smallint NOT NULL,
    deadline date NOT NULL,
    count_of_receivable_candidate smallint NOT NULL,
    job_requirements character varying(500) NOT NULL,
    job_position_id integer NOT NULL,
    is_active boolean DEFAULT true,
    city_id integer NOT NULL,
    employer_id integer NOT NULL,
    published_date date DEFAULT CURRENT_TIMESTAMP
);
    DROP TABLE public.job_adverts;
       public         heap    postgres    false            ?            1259    17974    job_adverts_advert_id_seq    SEQUENCE     ?   ALTER TABLE public.job_adverts ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.job_adverts_advert_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    215            ?            1259    17722    job_positions    TABLE     ?   CREATE TABLE public.job_positions (
    id integer NOT NULL,
    title character varying(50) NOT NULL,
    is_active boolean DEFAULT true NOT NULL
);
 !   DROP TABLE public.job_positions;
       public         heap    postgres    false            ?            1259    17781    job_titles_id_seq    SEQUENCE     ?   ALTER TABLE public.job_positions ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.job_titles_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    205            ?            1259    17729    users    TABLE     ?   CREATE TABLE public.users (
    email character varying(50) NOT NULL,
    password character varying(50) NOT NULL,
    id integer NOT NULL,
    password_repeat character varying(255)
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
            public          postgres    false    207            ?            1259    17734    verification_code_candidates    TABLE     q   CREATE TABLE public.verification_code_candidates (
    id integer NOT NULL,
    candidate_id integer NOT NULL
);
 0   DROP TABLE public.verification_code_candidates;
       public         heap    postgres    false            ?            1259    17739    verification_code_employers    TABLE     o   CREATE TABLE public.verification_code_employers (
    id integer NOT NULL,
    employer_id integer NOT NULL
);
 /   DROP TABLE public.verification_code_employers;
       public         heap    postgres    false            ?            1259    17746    verification_codes    TABLE     ?   CREATE TABLE public.verification_codes (
    id integer NOT NULL,
    code character varying(350) NOT NULL,
    is_verified boolean DEFAULT false NOT NULL,
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
            public          postgres    false    211            a           2604    18017 	   cities id    DEFAULT     k   ALTER TABLE ONLY public.cities ALTER COLUMN id SET DEFAULT nextval('public.cities_city_id_seq'::regclass);
 8   ALTER TABLE public.cities ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    216    217    217                      0    17823 
   candidates 
   TABLE DATA           X   COPY public.candidates (first_name, last_name, identity_id, birth_year, id) FROM stdin;
    public          postgres    false    213   9C       	          0    18014    cities 
   TABLE DATA           *   COPY public.cities (id, name) FROM stdin;
    public          postgres    false    217   wC       ?          0    17699    employee_confirms 
   TABLE DATA           X   COPY public.employee_confirms (id, employee_id, is_confirmed, confirm_date) FROM stdin;
    public          postgres    false    201   ?C       ?          0    17704    employee_confirms_employers 
   TABLE DATA           F   COPY public.employee_confirms_employers (id, employer_id) FROM stdin;
    public          postgres    false    202   D       ?          0    17709 	   employees 
   TABLE DATA           >   COPY public.employees (first_name, last_name, id) FROM stdin;
    public          postgres    false    203   +D       ?          0    17714 	   employers 
   TABLE DATA           M   COPY public.employers (company_name, web_site, phone_number, id) FROM stdin;
    public          postgres    false    204   VD                 0    17976    job_adverts 
   TABLE DATA           ?   COPY public.job_adverts (id, max_salary, min_salary, deadline, count_of_receivable_candidate, job_requirements, job_position_id, is_active, city_id, employer_id, published_date) FROM stdin;
    public          postgres    false    215   ?D       ?          0    17722    job_positions 
   TABLE DATA           =   COPY public.job_positions (id, title, is_active) FROM stdin;
    public          postgres    false    205   E       ?          0    17729    users 
   TABLE DATA           E   COPY public.users (email, password, id, password_repeat) FROM stdin;
    public          postgres    false    207   ?E                  0    17734    verification_code_candidates 
   TABLE DATA           H   COPY public.verification_code_candidates (id, candidate_id) FROM stdin;
    public          postgres    false    208   ?E                 0    17739    verification_code_employers 
   TABLE DATA           F   COPY public.verification_code_employers (id, employer_id) FROM stdin;
    public          postgres    false    209   F                 0    17746    verification_codes 
   TABLE DATA           R   COPY public.verification_codes (id, code, is_verified, verified_date) FROM stdin;
    public          postgres    false    211   6F                  0    0    cities_city_id_seq    SEQUENCE SET     A   SELECT pg_catalog.setval('public.cities_city_id_seq', 10, true);
          public          postgres    false    216                       0    0    hibernate_sequence    SEQUENCE SET     @   SELECT pg_catalog.setval('public.hibernate_sequence', 1, true);
          public          postgres    false    200                       0    0    job_adverts_advert_id_seq    SEQUENCE SET     H   SELECT pg_catalog.setval('public.job_adverts_advert_id_seq', 21, true);
          public          postgres    false    214                       0    0    job_titles_id_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.job_titles_id_seq', 8, true);
          public          postgres    false    212                       0    0    users_id_seq    SEQUENCE SET     ;   SELECT pg_catalog.setval('public.users_id_seq', 73, true);
          public          postgres    false    206                       0    0    verification_codes_id_seq    SEQUENCE SET     G   SELECT pg_catalog.setval('public.verification_codes_id_seq', 2, true);
          public          postgres    false    210            m           2606    18019    cities cities_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.cities
    ADD CONSTRAINT cities_pkey PRIMARY KEY (id);
 <   ALTER TABLE ONLY public.cities DROP CONSTRAINT cities_pkey;
       public            postgres    false    217            c           2606    17703 (   employee_confirms employee_confirms_pkey 
   CONSTRAINT     f   ALTER TABLE ONLY public.employee_confirms
    ADD CONSTRAINT employee_confirms_pkey PRIMARY KEY (id);
 R   ALTER TABLE ONLY public.employee_confirms DROP CONSTRAINT employee_confirms_pkey;
       public            postgres    false    201            e           2606    17726    job_positions job_titles_pkey 
   CONSTRAINT     [   ALTER TABLE ONLY public.job_positions
    ADD CONSTRAINT job_titles_pkey PRIMARY KEY (id);
 G   ALTER TABLE ONLY public.job_positions DROP CONSTRAINT job_titles_pkey;
       public            postgres    false    205            k           2606    17983    job_adverts pk_job_adverts 
   CONSTRAINT     X   ALTER TABLE ONLY public.job_adverts
    ADD CONSTRAINT pk_job_adverts PRIMARY KEY (id);
 D   ALTER TABLE ONLY public.job_adverts DROP CONSTRAINT pk_job_adverts;
       public            postgres    false    215            g           2606    17733    users users_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.users DROP CONSTRAINT users_pkey;
       public            postgres    false    207            i           2606    17750 *   verification_codes verification_codes_pkey 
   CONSTRAINT     h   ALTER TABLE ONLY public.verification_codes
    ADD CONSTRAINT verification_codes_pkey PRIMARY KEY (id);
 T   ALTER TABLE ONLY public.verification_codes DROP CONSTRAINT verification_codes_pkey;
       public            postgres    false    211            n           2606    17776 P   employee_confirms_employers employee_confirms_employers_employee_confirm_id_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.employee_confirms_employers
    ADD CONSTRAINT employee_confirms_employers_employee_confirm_id_fkey FOREIGN KEY (id) REFERENCES public.employee_confirms(id) NOT VALID;
 z   ALTER TABLE ONLY public.employee_confirms_employers DROP CONSTRAINT employee_confirms_employers_employee_confirm_id_fkey;
       public          postgres    false    201    202    2915            r           2606    17961 7   verification_code_employers fk5kdrbow8mn0elyg0xn4fri9b2    FK CONSTRAINT     ?   ALTER TABLE ONLY public.verification_code_employers
    ADD CONSTRAINT fk5kdrbow8mn0elyg0xn4fri9b2 FOREIGN KEY (id) REFERENCES public.verification_codes(id);
 a   ALTER TABLE ONLY public.verification_code_employers DROP CONSTRAINT fk5kdrbow8mn0elyg0xn4fri9b2;
       public          postgres    false    2921    211    209            t           2606    18006 (   job_adverts fk_job_adverts_job_positions    FK CONSTRAINT     ?   ALTER TABLE ONLY public.job_adverts
    ADD CONSTRAINT fk_job_adverts_job_positions FOREIGN KEY (job_position_id) REFERENCES public.job_positions(id) NOT VALID;
 R   ALTER TABLE ONLY public.job_adverts DROP CONSTRAINT fk_job_adverts_job_positions;
       public          postgres    false    215    2917    205            o           2606    17909 %   employees fkd6th9xowehhf1kmmq1dsseq28    FK CONSTRAINT        ALTER TABLE ONLY public.employees
    ADD CONSTRAINT fkd6th9xowehhf1kmmq1dsseq28 FOREIGN KEY (id) REFERENCES public.users(id);
 O   ALTER TABLE ONLY public.employees DROP CONSTRAINT fkd6th9xowehhf1kmmq1dsseq28;
       public          postgres    false    2919    203    207            u           2606    18053 '   job_adverts fkeshbhuv73peilh3ohw5wu4bfs    FK CONSTRAINT     ?   ALTER TABLE ONLY public.job_adverts
    ADD CONSTRAINT fkeshbhuv73peilh3ohw5wu4bfs FOREIGN KEY (city_id) REFERENCES public.cities(id);
 Q   ALTER TABLE ONLY public.job_adverts DROP CONSTRAINT fkeshbhuv73peilh3ohw5wu4bfs;
       public          postgres    false    217    215    2925            p           2606    17914 %   employers fknnl4ba0tc831e25ufip4ek2yq    FK CONSTRAINT        ALTER TABLE ONLY public.employers
    ADD CONSTRAINT fknnl4ba0tc831e25ufip4ek2yq FOREIGN KEY (id) REFERENCES public.users(id);
 O   ALTER TABLE ONLY public.employers DROP CONSTRAINT fknnl4ba0tc831e25ufip4ek2yq;
       public          postgres    false    207    204    2919            q           2606    17956 8   verification_code_candidates fko2l3qgfgck3lxbinoxknyc2sw    FK CONSTRAINT     ?   ALTER TABLE ONLY public.verification_code_candidates
    ADD CONSTRAINT fko2l3qgfgck3lxbinoxknyc2sw FOREIGN KEY (id) REFERENCES public.verification_codes(id);
 b   ALTER TABLE ONLY public.verification_code_candidates DROP CONSTRAINT fko2l3qgfgck3lxbinoxknyc2sw;
       public          postgres    false    211    2921    208            s           2606    17893 &   candidates fkpwx8qcbu3swnypnelf5b8db9j    FK CONSTRAINT     ?   ALTER TABLE ONLY public.candidates
    ADD CONSTRAINT fkpwx8qcbu3swnypnelf5b8db9j FOREIGN KEY (id) REFERENCES public.users(id);
 P   ALTER TABLE ONLY public.candidates DROP CONSTRAINT fkpwx8qcbu3swnypnelf5b8db9j;
       public          postgres    false    213    207    2919               .   x?;:/1#3???1?ч??????????????????܈+F??? ??      	   j   x?3?<???$1/?4??Ȯ??,?2?t??N,J?2?tLI?K?2??M?I,?L?2?t*-*N?2?t-??<:?5?ނ3?(1?*??˒38???Ѐ?;?Ȉ???? ?? w      ?      x?????? ? ?      ?      x?????? ? ?      ?      x?s?M??v????41?????? 3N1      ?   6   x?IM???K?Tp??-H̫?,?
$C?z@???????????Ԑ?ܘ+F??? Nij         a   x?32?4300?45FF??f??????^?e?
:
??@?18@??5??K/?I,?4?,)27??2?56?22??f?d??!?4N#?&#4=1z\\\ ??      ?   x   x?3?t+???-.IL?VpI-K??/H-?,?2?t
??楠s??'e椢?p????躢)6?OMB1??O+)O,JUp,J??,IM.
?#??U[p:????(??9+?????? ??=/      ?   M   x?K?M?)N???s??/?M???K???442?41Q\ŉ?yz??E?9J̍?J2?JR?32??R+r?`?=... tVm             x?3?47?????? WV            x?3?47?????? hX         >   x?3???,?,vI-.	K-?L?LN,???s?OI?,?4202?50?52?2«4Yi? IG.     