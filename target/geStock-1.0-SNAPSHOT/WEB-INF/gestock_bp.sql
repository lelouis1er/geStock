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
-- TOC entry 3174 (class 0 OID 233201)
-- Dependencies: 202
-- Data for Name: achat_article; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3175 (class 0 OID 233209)
-- Dependencies: 203
-- Data for Name: achats; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3176 (class 0 OID 233219)
-- Dependencies: 204
-- Data for Name: adresse; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3178 (class 0 OID 233234)
-- Dependencies: 206
-- Data for Name: article; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3180 (class 0 OID 233252)
-- Dependencies: 208
-- Data for Name: article_commade; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3179 (class 0 OID 233244)
-- Dependencies: 207
-- Data for Name: article_liv; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3181 (class 0 OID 233259)
-- Dependencies: 209
-- Data for Name: article_stock; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3177 (class 0 OID 233226)
-- Dependencies: 205
-- Data for Name: articles_commande_client; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3182 (class 0 OID 233268)
-- Dependencies: 210
-- Data for Name: categorie_article; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3183 (class 0 OID 233277)
-- Dependencies: 211
-- Data for Name: client; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3184 (class 0 OID 233289)
-- Dependencies: 212
-- Data for Name: commande; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3185 (class 0 OID 233300)
-- Dependencies: 213
-- Data for Name: commande_client; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3186 (class 0 OID 233311)
-- Dependencies: 214
-- Data for Name: employes; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3187 (class 0 OID 233323)
-- Dependencies: 215
-- Data for Name: etagere; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3188 (class 0 OID 233333)
-- Dependencies: 216
-- Data for Name: fournisseur; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3189 (class 0 OID 233343)
-- Dependencies: 217
-- Data for Name: livraison; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3190 (class 0 OID 233355)
-- Dependencies: 218
-- Data for Name: magasin; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3191 (class 0 OID 233365)
-- Dependencies: 219
-- Data for Name: menu; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.menu (idmenu, men_idmenu, nom, ressource) VALUES (1, NULL, 'Parametres', '/geStock/parametres/general/index.xhtml');
INSERT INTO public.menu (idmenu, men_idmenu, nom, ressource) VALUES (2, NULL, 'utilisateur', '/geStock/parametres/securite/utilisateurs/utilisateurs.xhtml');


--
-- TOC entry 3192 (class 0 OID 233375)
-- Dependencies: 220
-- Data for Name: mouchard; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3193 (class 0 OID 233382)
-- Dependencies: 221
-- Data for Name: operation; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3194 (class 0 OID 233391)
-- Dependencies: 222
-- Data for Name: pays; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3195 (class 0 OID 233397)
-- Dependencies: 223
-- Data for Name: privilegesutilisateur; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.privilegesutilisateur (idprivilege, idmenu, nom, description, niveau) VALUES (1, 1, 'Privilege parametre', 'permet l''acces au parametres', NULL);
INSERT INTO public.privilegesutilisateur (idprivilege, idmenu, nom, description, niveau) VALUES (2, 2, 'Privilege utilisateur', '', NULL);


--
-- TOC entry 3196 (class 0 OID 233407)
-- Dependencies: 224
-- Data for Name: quartier; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3197 (class 0 OID 233414)
-- Dependencies: 225
-- Data for Name: region; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3198 (class 0 OID 233420)
-- Dependencies: 226
-- Data for Name: restrictionprivilege; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3199 (class 0 OID 233428)
-- Dependencies: 227
-- Data for Name: retour_article_liv; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3202 (class 0 OID 233452)
-- Dependencies: 230
-- Data for Name: role_employe; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3200 (class 0 OID 233435)
-- Dependencies: 228
-- Data for Name: roleprivilege; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.roleprivilege (idroleprivilege, idrole, idprivilege, cancreate, canupdate, candelete) VALUES (1, 2, 1, true, true, true);
INSERT INTO public.roleprivilege (idroleprivilege, idrole, idprivilege, cancreate, canupdate, candelete) VALUES (2, 2, 2, true, true, false);


--
-- TOC entry 3201 (class 0 OID 233443)
-- Dependencies: 229
-- Data for Name: roleutilisateur; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.roleutilisateur (idrole, nomrole, coderole) VALUES (1, 'Super admin', 'su');
INSERT INTO public.roleutilisateur (idrole, nomrole, coderole) VALUES (2, 'Admin', 'admin');


--
-- TOC entry 3203 (class 0 OID 233458)
-- Dependencies: 231
-- Data for Name: session; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3204 (class 0 OID 233465)
-- Dependencies: 232
-- Data for Name: societe; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.societe (id_societe, idadresse, nom, code, description, telephone, siteweb, email, date_creation, date_enregistrement) VALUES (1, NULL, 'ETS Eric ', 'ETS', 'AH', '0650807929', 'WWW', 'postgres@localhost.com', NULL, '2021-02-21');


--
-- TOC entry 3206 (class 0 OID 233484)
-- Dependencies: 234
-- Data for Name: type_article; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3207 (class 0 OID 233494)
-- Dependencies: 235
-- Data for Name: type_client; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3205 (class 0 OID 233475)
-- Dependencies: 233
-- Data for Name: type_operation; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3208 (class 0 OID 233500)
-- Dependencies: 236
-- Data for Name: utilisateur; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.utilisateur (idutilisateur, idrole, id_employe, login, password, nom, description, actif, deleted, photo, datecreation, datedelete, datedesactivation, dateactivation) VALUES (1, 1, NULL, 'superadmin', '$2a$12$hPX.X5gfFPKGySicqt.hk.wyIrnFX1EZBgyY/3v0zRrsAM5wFFiM.', 'Lafortune Kadjo', 'super utilisateur du système', true, false, 'su.png', NULL, NULL, NULL, NULL);
INSERT INTO public.utilisateur (idutilisateur, idrole, id_employe, login, password, nom, description, actif, deleted, photo, datecreation, datedelete, datedesactivation, dateactivation) VALUES (2, 2, NULL, 'admin', '$2a$12$r2FPXyXxS/WyBFhrWWaC0.Xa/Q9lVKhMkkDHfKyO8Ptw9bIKjHKm.', 'Louis Stark', NULL, true, false, NULL, '2021-02-21', NULL, NULL, NULL);


--
-- TOC entry 3209 (class 0 OID 233511)
-- Dependencies: 237
-- Data for Name: ville; Type: TABLE DATA; Schema: public; Owner: postgres
--



-- Completed on 2021-02-21 18:54:52

--
-- PostgreSQL database dump complete
--

