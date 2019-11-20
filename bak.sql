PGDMP     5                
    w            GestorPuente    10.10    12.0                0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                       1262    16393    GestorPuente    DATABASE     �   CREATE DATABASE "GestorPuente" WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Spanish_Argentina.1252' LC_CTYPE = 'Spanish_Argentina.1252';
    DROP DATABASE "GestorPuente";
                postgres    false            �            1259    16433    computadoras    TABLE     N  CREATE TABLE public.computadoras (
    serialcomputadora integer NOT NULL,
    id character varying NOT NULL,
    estado character varying NOT NULL,
    placabase character varying,
    procesador character varying,
    disco character varying,
    ram character varying,
    lectora character varying,
    notas character varying
);
     DROP TABLE public.computadoras;
       public            postgres    false            �            1259    16431 "   computadoras_serialComputadora_seq    SEQUENCE     �   CREATE SEQUENCE public."computadoras_serialComputadora_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ;   DROP SEQUENCE public."computadoras_serialComputadora_seq";
       public          postgres    false    199                       0    0 "   computadoras_serialComputadora_seq    SEQUENCE OWNED BY     k   ALTER SEQUENCE public."computadoras_serialComputadora_seq" OWNED BY public.computadoras.serialcomputadora;
          public          postgres    false    198            �            1259    16410    integrantes    TABLE       CREATE TABLE public.integrantes (
    dni character varying NOT NULL,
    apellido character varying,
    nombre character varying,
    fechanacimiento date,
    direccion character varying,
    telefono character varying,
    telefono2 character varying,
    correo character varying,
    "contraseña" character varying,
    legajo smallint NOT NULL,
    tipo character varying
);
    DROP TABLE public.integrantes;
       public            postgres    false            �            1259    16444    integrantes_computadoras    TABLE     �   CREATE TABLE public.integrantes_computadoras (
    idcomputadora character varying,
    idintegrante character varying,
    serial integer NOT NULL
);
 ,   DROP TABLE public.integrantes_computadoras;
       public            postgres    false            �            1259    16478 #   integrantes_computadoras_serial_seq    SEQUENCE     �   CREATE SEQUENCE public.integrantes_computadoras_serial_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 :   DROP SEQUENCE public.integrantes_computadoras_serial_seq;
       public          postgres    false    200                       0    0 #   integrantes_computadoras_serial_seq    SEQUENCE OWNED BY     k   ALTER SEQUENCE public.integrantes_computadoras_serial_seq OWNED BY public.integrantes_computadoras.serial;
          public          postgres    false    201            �            1259    16422    integrantes_legajo_seq    SEQUENCE     �   CREATE SEQUENCE public.integrantes_legajo_seq
    AS smallint
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 -   DROP SEQUENCE public.integrantes_legajo_seq;
       public          postgres    false    196                       0    0    integrantes_legajo_seq    SEQUENCE OWNED BY     Q   ALTER SEQUENCE public.integrantes_legajo_seq OWNED BY public.integrantes.legajo;
          public          postgres    false    197            ~
           2604    16436    computadoras serialcomputadora    DEFAULT     �   ALTER TABLE ONLY public.computadoras ALTER COLUMN serialcomputadora SET DEFAULT nextval('public."computadoras_serialComputadora_seq"'::regclass);
 M   ALTER TABLE public.computadoras ALTER COLUMN serialcomputadora DROP DEFAULT;
       public          postgres    false    198    199    199            }
           2604    16424    integrantes legajo    DEFAULT     x   ALTER TABLE ONLY public.integrantes ALTER COLUMN legajo SET DEFAULT nextval('public.integrantes_legajo_seq'::regclass);
 A   ALTER TABLE public.integrantes ALTER COLUMN legajo DROP DEFAULT;
       public          postgres    false    197    196            
           2604    16480    integrantes_computadoras serial    DEFAULT     �   ALTER TABLE ONLY public.integrantes_computadoras ALTER COLUMN serial SET DEFAULT nextval('public.integrantes_computadoras_serial_seq'::regclass);
 N   ALTER TABLE public.integrantes_computadoras ALTER COLUMN serial DROP DEFAULT;
       public          postgres    false    201    200                      0    16433    computadoras 
   TABLE DATA           x   COPY public.computadoras (serialcomputadora, id, estado, placabase, procesador, disco, ram, lectora, notas) FROM stdin;
    public          postgres    false    199   b#                 0    16410    integrantes 
   TABLE DATA           �   COPY public.integrantes (dni, apellido, nombre, fechanacimiento, direccion, telefono, telefono2, correo, "contraseña", legajo, tipo) FROM stdin;
    public          postgres    false    196   {$                 0    16444    integrantes_computadoras 
   TABLE DATA           W   COPY public.integrantes_computadoras (idcomputadora, idintegrante, serial) FROM stdin;
    public          postgres    false    200   E%                  0    0 "   computadoras_serialComputadora_seq    SEQUENCE SET     S   SELECT pg_catalog.setval('public."computadoras_serialComputadora_seq"', 11, true);
          public          postgres    false    198                       0    0 #   integrantes_computadoras_serial_seq    SEQUENCE SET     R   SELECT pg_catalog.setval('public.integrantes_computadoras_serial_seq', 12, true);
          public          postgres    false    201                       0    0    integrantes_legajo_seq    SEQUENCE SET     D   SELECT pg_catalog.setval('public.integrantes_legajo_seq', 9, true);
          public          postgres    false    197            �
           2606    16465 +   computadoras computadoras_idComputadora_key 
   CONSTRAINT     f   ALTER TABLE ONLY public.computadoras
    ADD CONSTRAINT "computadoras_idComputadora_key" UNIQUE (id);
 W   ALTER TABLE ONLY public.computadoras DROP CONSTRAINT "computadoras_idComputadora_key";
       public            postgres    false    199            �
           2606    16441    computadoras computadoras_pkey 
   CONSTRAINT     o   ALTER TABLE ONLY public.computadoras
    ADD CONSTRAINT computadoras_pkey PRIMARY KEY (id, serialcomputadora);
 H   ALTER TABLE ONLY public.computadoras DROP CONSTRAINT computadoras_pkey;
       public            postgres    false    199    199            �
           2606    16472    integrantes integrantes_dni_key 
   CONSTRAINT     Y   ALTER TABLE ONLY public.integrantes
    ADD CONSTRAINT integrantes_dni_key UNIQUE (dni);
 I   ALTER TABLE ONLY public.integrantes DROP CONSTRAINT integrantes_dni_key;
       public            postgres    false    196            �
           2606    16455    integrantes integrantes_pkey 
   CONSTRAINT     c   ALTER TABLE ONLY public.integrantes
    ADD CONSTRAINT integrantes_pkey PRIMARY KEY (legajo, dni);
 F   ALTER TABLE ONLY public.integrantes DROP CONSTRAINT integrantes_pkey;
       public            postgres    false    196    196            �
           2606    16466 '   integrantes_computadoras fk_computadora    FK CONSTRAINT     �   ALTER TABLE ONLY public.integrantes_computadoras
    ADD CONSTRAINT fk_computadora FOREIGN KEY (idcomputadora) REFERENCES public.computadoras(id) NOT VALID;
 Q   ALTER TABLE ONLY public.integrantes_computadoras DROP CONSTRAINT fk_computadora;
       public          postgres    false    199    2693    200            �
           2606    16473 &   integrantes_computadoras fk_integrante    FK CONSTRAINT     �   ALTER TABLE ONLY public.integrantes_computadoras
    ADD CONSTRAINT fk_integrante FOREIGN KEY (idintegrante) REFERENCES public.integrantes(dni) NOT VALID;
 P   ALTER TABLE ONLY public.integrantes_computadoras DROP CONSTRAINT fk_integrante;
       public          postgres    false    196    200    2689               	  x��ұn�0��x
?�Ua�vL��6�T����Y"8����AӸi���?��aJ��F�e�
�#zMi�?�GGS
��J{���] �W�Tfkj;&A���:������eOZ�C*�d0/t6/	�����g�m��m_W��(_�Q"��d0�k��l�-�}?�S������fiz[�W�ʳ1ͻsq���.@��;��\��9; O��M��2����<�#������8h�?��������_�Q� ����]�$�W>`         �   x�]��j�0Dϫ��8t%'�n1顽�B���-�Y���$����y��7c=�����'��)�1M�4��tO��$�"z@�'��m?X0���q� �Н��t\Vⴛe�7��0��3�V(HQ_�[�<l�r�'��0^cJ��Y֩l��C�K�g�-��)YC?�����R�A��SJ}#3G,         %   x�3�4637�441�4�2Ap��C#cNs�=... ��     