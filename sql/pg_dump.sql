--
-- PostgreSQL database dump
--

-- Dumped from database version 9.4.1
-- Dumped by pg_dump version 9.4.1
-- Started on 2018-02-26 13:38:03

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 176 (class 3079 OID 11855)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2022 (class 0 OID 0)
-- Dependencies: 176
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 172 (class 1259 OID 84715)
-- Name: car; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE car (
    id integer NOT NULL,
    model character(50),
    nomer character(9),
    marka character varying(50)
);


ALTER TABLE car OWNER TO postgres;

--
-- TOC entry 173 (class 1259 OID 84720)
-- Name: city; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE city (
    id integer NOT NULL,
    name character(150)
);


ALTER TABLE city OWNER TO postgres;

--
-- TOC entry 174 (class 1259 OID 84725)
-- Name: fio; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE fio (
    id integer NOT NULL,
    family character(100),
    name character(100),
    lastname character(100),
    idcity integer NOT NULL
);


ALTER TABLE fio OWNER TO postgres;

--
-- TOC entry 175 (class 1259 OID 84735)
-- Name: fiocar; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE fiocar (
    id integer NOT NULL,
    idfio integer NOT NULL,
    idcar integer NOT NULL
);


ALTER TABLE fiocar OWNER TO postgres;

--
-- TOC entry 2011 (class 0 OID 84715)
-- Dependencies: 172
-- Data for Name: car; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY car (id, model, nomer, marka) FROM stdin;
1	логан                                             	а100аа196	рено
2	лачетти                                           	а200аа196	шевролет
3	бенз                                              	а300аа196	мерседес
4	рио                                               	а400аа196	киа
5	цивик                                             	а500аа196	хонда
6	2109                                              	а600аа196	ваз
7	2107                                              	а700аа196	ваз
8	волга                                             	а800аа196	газ
9	дастер                                            	а900аа196	рено
10	патриот                                           	а999аа196	уаз
11	хантер                                            	к001кк123	уаз
\.


--
-- TOC entry 2012 (class 0 OID 84720)
-- Dependencies: 173
-- Data for Name: city; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY city (id, name) FROM stdin;
1	екатеринбург                                                                                                                                          
2	москва                                                                                                                                                
3	санкт-петербург                                                                                                                                       
4	воронеж                                                                                                                                               
5	сочи                                                                                                                                                  
6	пермь                                                                                                                                                 
7	краснодар                                                                                                                                             
8	смоленск                                                                                                                                              
9	новосибирск                                                                                                                                           
10	владимир                                                                                                                                              
\.


--
-- TOC entry 2013 (class 0 OID 84725)
-- Dependencies: 174
-- Data for Name: fio; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY fio (id, family, name, lastname, idcity) FROM stdin;
1	коновалов                                                                                           	вадим                                                                                               	анфисович                                                                                           	1
2	иванов                                                                                              	иван                                                                                                	иванович                                                                                            	1
3	коновалов                                                                                           	петр                                                                                                	петрович                                                                                            	2
4	соломин                                                                                             	никита                                                                                              	станиславович                                                                                       	3
5	снежин                                                                                              	артем                                                                                               	алексеевич                                                                                          	4
6	тверитина                                                                                           	анна                                                                                                	владимировна                                                                                        	5
7	суханов                                                                                             	валерий                                                                                             	андреевич                                                                                           	6
8	неустроев                                                                                           	александр                                                                                           	сергеевич                                                                                           	7
9	луканин                                                                                             	виктор                                                                                              	викторович                                                                                          	8
10	попков                                                                                              	дмитрий                                                                                             	юрьевич                                                                                             	10
\.


--
-- TOC entry 2014 (class 0 OID 84735)
-- Dependencies: 175
-- Data for Name: fiocar; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY fiocar (id, idfio, idcar) FROM stdin;
1	1	1
2	1	2
3	2	3
4	3	4
5	4	5
6	5	6
7	6	7
8	7	8
9	8	9
10	9	10
11	10	11
\.


--
-- TOC entry 1892 (class 2606 OID 84719)
-- Name: car_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY car
    ADD CONSTRAINT car_pkey PRIMARY KEY (id);


--
-- TOC entry 1894 (class 2606 OID 84724)
-- Name: city_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY city
    ADD CONSTRAINT city_pkey PRIMARY KEY (id);


--
-- TOC entry 1896 (class 2606 OID 84729)
-- Name: fio_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY fio
    ADD CONSTRAINT fio_pkey PRIMARY KEY (id);


--
-- TOC entry 1898 (class 2606 OID 84739)
-- Name: fiocar_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY fiocar
    ADD CONSTRAINT fiocar_pkey PRIMARY KEY (id);


--
-- TOC entry 1899 (class 2606 OID 84730)
-- Name: fio_city_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY fio
    ADD CONSTRAINT fio_city_fkey FOREIGN KEY (idcity) REFERENCES city(id);


--
-- TOC entry 1900 (class 2606 OID 84740)
-- Name: fiocar_idcar_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY fiocar
    ADD CONSTRAINT fiocar_idcar_fkey FOREIGN KEY (idcar) REFERENCES car(id);


--
-- TOC entry 1901 (class 2606 OID 84745)
-- Name: fiocar_idfio_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY fiocar
    ADD CONSTRAINT fiocar_idfio_fkey FOREIGN KEY (idfio) REFERENCES fio(id);


--
-- TOC entry 2021 (class 0 OID 0)
-- Dependencies: 5
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2018-02-26 13:38:08

--
-- PostgreSQL database dump complete
--

