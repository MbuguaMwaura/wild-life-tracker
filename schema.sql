--
-- PostgreSQL database dump
--

-- Dumped from database version 10.8 (Ubuntu 10.8-0ubuntu0.18.10.1)
-- Dumped by pg_dump version 10.8 (Ubuntu 10.8-0ubuntu0.18.10.1)

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: animals; Type: TABLE; Schema: public; Owner: mbugua
--

CREATE TABLE public.animals (
    id integer NOT NULL,
    name character varying,
    health character varying,
    age character varying,
    species_id integer
);


ALTER TABLE public.animals OWNER TO mbugua;

--
-- Name: animals_id_seq; Type: SEQUENCE; Schema: public; Owner: mbugua
--

CREATE SEQUENCE public.animals_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.animals_id_seq OWNER TO mbugua;

--
-- Name: animals_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: mbugua
--

ALTER SEQUENCE public.animals_id_seq OWNED BY public.animals.id;


--
-- Name: locations; Type: TABLE; Schema: public; Owner: mbugua
--

CREATE TABLE public.locations (
    id integer NOT NULL,
    name character varying
);


ALTER TABLE public.locations OWNER TO mbugua;

--
-- Name: locations_id_seq; Type: SEQUENCE; Schema: public; Owner: mbugua
--

CREATE SEQUENCE public.locations_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.locations_id_seq OWNER TO mbugua;

--
-- Name: locations_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: mbugua
--

ALTER SEQUENCE public.locations_id_seq OWNED BY public.locations.id;


--
-- Name: rangers; Type: TABLE; Schema: public; Owner: mbugua
--

CREATE TABLE public.rangers (
    id integer NOT NULL,
    name character varying,
    badge integer
);


ALTER TABLE public.rangers OWNER TO mbugua;

--
-- Name: rangers_id_seq; Type: SEQUENCE; Schema: public; Owner: mbugua
--

CREATE SEQUENCE public.rangers_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.rangers_id_seq OWNER TO mbugua;

--
-- Name: rangers_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: mbugua
--

ALTER SEQUENCE public.rangers_id_seq OWNED BY public.rangers.id;


--
-- Name: sightings; Type: TABLE; Schema: public; Owner: mbugua
--

CREATE TABLE public.sightings (
    id integer NOT NULL,
    animal_id integer,
    location_id integer,
    ranger_id integer,
    species_id integer,
    "time" timestamp without time zone
);


ALTER TABLE public.sightings OWNER TO mbugua;

--
-- Name: sightings_id_seq; Type: SEQUENCE; Schema: public; Owner: mbugua
--

CREATE SEQUENCE public.sightings_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.sightings_id_seq OWNER TO mbugua;

--
-- Name: sightings_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: mbugua
--

ALTER SEQUENCE public.sightings_id_seq OWNED BY public.sightings.id;


--
-- Name: species; Type: TABLE; Schema: public; Owner: mbugua
--

CREATE TABLE public.species (
    id integer NOT NULL,
    name character varying,
    population integer,
    endangered boolean
);


ALTER TABLE public.species OWNER TO mbugua;

--
-- Name: species_id_seq; Type: SEQUENCE; Schema: public; Owner: mbugua
--

CREATE SEQUENCE public.species_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.species_id_seq OWNER TO mbugua;

--
-- Name: species_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: mbugua
--

ALTER SEQUENCE public.species_id_seq OWNED BY public.species.id;


--
-- Name: animals id; Type: DEFAULT; Schema: public; Owner: mbugua
--

ALTER TABLE ONLY public.animals ALTER COLUMN id SET DEFAULT nextval('public.animals_id_seq'::regclass);


--
-- Name: locations id; Type: DEFAULT; Schema: public; Owner: mbugua
--

ALTER TABLE ONLY public.locations ALTER COLUMN id SET DEFAULT nextval('public.locations_id_seq'::regclass);


--
-- Name: rangers id; Type: DEFAULT; Schema: public; Owner: mbugua
--

ALTER TABLE ONLY public.rangers ALTER COLUMN id SET DEFAULT nextval('public.rangers_id_seq'::regclass);


--
-- Name: sightings id; Type: DEFAULT; Schema: public; Owner: mbugua
--

ALTER TABLE ONLY public.sightings ALTER COLUMN id SET DEFAULT nextval('public.sightings_id_seq'::regclass);


--
-- Name: species id; Type: DEFAULT; Schema: public; Owner: mbugua
--

ALTER TABLE ONLY public.species ALTER COLUMN id SET DEFAULT nextval('public.species_id_seq'::regclass);


--
-- Data for Name: animals; Type: TABLE DATA; Schema: public; Owner: mbugua
--

COPY public.animals (id, name, health, age, species_id) FROM stdin;
1	Buffalo	healthy	newborn	2
2	Lion	okay	young	1
3	Tiger	ill	adult	3
4	Hippo	healthy	newborn	4
\.


--
-- Data for Name: locations; Type: TABLE DATA; Schema: public; Owner: mbugua
--

COPY public.locations (id, name) FROM stdin;
1	NE hiking region
2	SW Zambini River
\.


--
-- Data for Name: rangers; Type: TABLE DATA; Schema: public; Owner: mbugua
--

COPY public.rangers (id, name, badge) FROM stdin;
1	Joey Sanders	21
2	Mary Poppins	112
3	Jon Snow	81
4	Marcus	31
\.


--
-- Data for Name: sightings; Type: TABLE DATA; Schema: public; Owner: mbugua
--

COPY public.sightings (id, animal_id, location_id, ranger_id, species_id, "time") FROM stdin;
1	1	1	2	2	2019-06-03 16:00:43.07929
2	1	1	2	2	2019-06-03 17:47:26.481105
3	2	1	1	1	2019-06-03 18:38:39.654307
4	1	1	1	1	2019-06-03 19:00:56.422416
5	3	1	2	3	2019-06-03 19:24:08.599511
\.


--
-- Data for Name: species; Type: TABLE DATA; Schema: public; Owner: mbugua
--

COPY public.species (id, name, population, endangered) FROM stdin;
1	Panthera Leo	241	f
2	Water Buffalo	210281	f
3	Panthera Tigris	21	t
4	Hippopotamus amphibius	192	f
\.


--
-- Name: animals_id_seq; Type: SEQUENCE SET; Schema: public; Owner: mbugua
--

SELECT pg_catalog.setval('public.animals_id_seq', 4, true);


--
-- Name: locations_id_seq; Type: SEQUENCE SET; Schema: public; Owner: mbugua
--

SELECT pg_catalog.setval('public.locations_id_seq', 2, true);


--
-- Name: rangers_id_seq; Type: SEQUENCE SET; Schema: public; Owner: mbugua
--

SELECT pg_catalog.setval('public.rangers_id_seq', 4, true);


--
-- Name: sightings_id_seq; Type: SEQUENCE SET; Schema: public; Owner: mbugua
--

SELECT pg_catalog.setval('public.sightings_id_seq', 5, true);


--
-- Name: species_id_seq; Type: SEQUENCE SET; Schema: public; Owner: mbugua
--

SELECT pg_catalog.setval('public.species_id_seq', 4, true);


--
-- Name: animals animals_pkey; Type: CONSTRAINT; Schema: public; Owner: mbugua
--

ALTER TABLE ONLY public.animals
    ADD CONSTRAINT animals_pkey PRIMARY KEY (id);


--
-- Name: locations locations_pkey; Type: CONSTRAINT; Schema: public; Owner: mbugua
--

ALTER TABLE ONLY public.locations
    ADD CONSTRAINT locations_pkey PRIMARY KEY (id);


--
-- Name: rangers rangers_pkey; Type: CONSTRAINT; Schema: public; Owner: mbugua
--

ALTER TABLE ONLY public.rangers
    ADD CONSTRAINT rangers_pkey PRIMARY KEY (id);


--
-- Name: sightings sightings_pkey; Type: CONSTRAINT; Schema: public; Owner: mbugua
--

ALTER TABLE ONLY public.sightings
    ADD CONSTRAINT sightings_pkey PRIMARY KEY (id);


--
-- Name: species species_pkey; Type: CONSTRAINT; Schema: public; Owner: mbugua
--

ALTER TABLE ONLY public.species
    ADD CONSTRAINT species_pkey PRIMARY KEY (id);


--
-- PostgreSQL database dump complete
--

