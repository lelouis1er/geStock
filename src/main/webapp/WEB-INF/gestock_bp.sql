--
-- PostgreSQL database dump
--

-- Dumped from database version 12.3
-- Dumped by pg_dump version 12.3

-- Started on 2021-02-21 18:54:50

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
-- TOC entry 3201 (class 0 OID 233443)
-- Dependencies: 229
-- Data for Name: roleutilisateur; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.roleutilisateur (idrole, nomrole, coderole) VALUES (1, 'Super admin', 'su');
INSERT INTO public.roleutilisateur (idrole, nomrole, coderole) VALUES (2, 'Admin', 'admin');

--
-- TOC entry 3191 (class 0 OID 233365)
-- Dependencies: 219
-- Data for Name: menu; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.menu (idmenu, men_idmenu, nom, ressource) VALUES (1, NULL, 'Parametres', '/geStock/parametres/general/index.xhtml');
INSERT INTO public.menu (idmenu, men_idmenu, nom, ressource) VALUES (2, NULL, 'utilisateur', '/geStock/parametres/securite/utilisateurs/utilisateurs.xhtml');

--
-- TOC entry 3195 (class 0 OID 233397)
-- Dependencies: 223
-- Data for Name: privilegesutilisateur; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.privilegesutilisateur (idprivilege, idmenu, nom, description, niveau) VALUES (1, 1, 'Privilege parametre', 'permet l''acces au parametres', NULL);
INSERT INTO public.privilegesutilisateur (idprivilege, idmenu, nom, description, niveau) VALUES (2, 2, 'Privilege utilisateur', '', NULL);


--
-- TOC entry 3200 (class 0 OID 233435)
-- Dependencies: 228
-- Data for Name: roleprivilege; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.roleprivilege (idroleprivilege, idrole, idprivilege, cancreate, canupdate, candelete) VALUES (1, 2, 1, true, true, true);
INSERT INTO public.roleprivilege (idroleprivilege, idrole, idprivilege, cancreate, canupdate, candelete) VALUES (2, 2, 2, true, true, false);


--
-- TOC entry 3204 (class 0 OID 233465)
-- Dependencies: 232
-- Data for Name: societe; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.societe (id_societe, idadresse, nom, code, description, telephone, siteweb, email, date_creation, date_enregistrement) VALUES (1, NULL, 'ETS Eric ', 'ETS', 'AH', '0650807929', 'WWW', 'postgres@localhost.com', NULL, '2021-02-21');


--
-- TOC entry 3208 (class 0 OID 233500)
-- Dependencies: 236
-- Data for Name: utilisateur; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.utilisateur (idutilisateur, idrole, id_employe, login, password, nom, description, actif, deleted, photo, datecreation, datedelete, datedesactivation, dateactivation) VALUES (1, 1, NULL, 'superadmin', '$2a$12$hPX.X5gfFPKGySicqt.hk.wyIrnFX1EZBgyY/3v0zRrsAM5wFFiM.', 'Lafortune Kadjo', 'super utilisateur du système', true, false, 'su.png', NULL, NULL, NULL, NULL);
INSERT INTO public.utilisateur (idutilisateur, idrole, id_employe, login, password, nom, description, actif, deleted, photo, datecreation, datedelete, datedesactivation, dateactivation) VALUES (2, 2, NULL, 'admin', '$2a$12$r2FPXyXxS/WyBFhrWWaC0.Xa/Q9lVKhMkkDHfKyO8Ptw9bIKjHKm.', 'Louis Stark', NULL, true, false, NULL, '2021-02-21', NULL, NULL, NULL);


-- Completed on 2021-02-21 18:54:52

--
-- PostgreSQL database dump complete
--

