--
-- PostgreSQL database dump
--

-- Dumped from database version 12.3
-- Dumped by pg_dump version 12.3

-- Started on 2021-07-03 09:51:45

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

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 202 (class 1259 OID 16655)
-- Name: achat_article; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.achat_article (
    id_achatartice bigint NOT NULL,
    id_achat bigint NOT NULL,
    id_operation bigint,
    qte integer,
    id_article bigint
);


ALTER TABLE public.achat_article OWNER TO postgres;

--
-- TOC entry 203 (class 1259 OID 16658)
-- Name: achats; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.achats (
    id_achat bigint NOT NULL,
    id_operation integer,
    num_facture character varying(254),
    date_achat date,
    nom_client character varying(254)
);


ALTER TABLE public.achats OWNER TO postgres;

--
-- TOC entry 204 (class 1259 OID 16664)
-- Name: adresse; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.adresse (
    idadresse integer NOT NULL,
    idquartier integer,
    autredescription character varying(254)
);


ALTER TABLE public.adresse OWNER TO postgres;

--
-- TOC entry 205 (class 1259 OID 16667)
-- Name: article; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.article (
    id_article bigint NOT NULL,
    id_societe integer,
    id_type integer NOT NULL,
    code_article character varying(254),
    nom character varying(254),
    carateristiques character varying(254),
    prix_vente double precision,
    qte_alert integer,
    prix_achat double precision
);


ALTER TABLE public.article OWNER TO postgres;

--
-- TOC entry 206 (class 1259 OID 16673)
-- Name: article_commande; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.article_commande (
    id_article_commande bigint NOT NULL,
    id_article bigint NOT NULL,
    id_commande integer NOT NULL,
    qte integer
);


ALTER TABLE public.article_commande OWNER TO postgres;

--
-- TOC entry 207 (class 1259 OID 16676)
-- Name: article_liv; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.article_liv (
    id_article_liv bigint NOT NULL,
    id_operation bigint,
    id_livraison integer,
    qte integer,
    pu_achat double precision,
    endomage boolean,
    id_article bigint NOT NULL
);


ALTER TABLE public.article_liv OWNER TO postgres;

--
-- TOC entry 208 (class 1259 OID 16679)
-- Name: articles_commande_client; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.articles_commande_client (
    id_article_commandeclient bigint NOT NULL,
    id_operation bigint,
    id_commande bigint,
    qte integer,
    montant double precision,
    id_article bigint
);


ALTER TABLE public.articles_commande_client OWNER TO postgres;

--
-- TOC entry 209 (class 1259 OID 16682)
-- Name: categorie_article; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.categorie_article (
    id_categorie integer NOT NULL,
    nom character varying(254),
    description character varying(254)
);


ALTER TABLE public.categorie_article OWNER TO postgres;

--
-- TOC entry 210 (class 1259 OID 16688)
-- Name: client; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.client (
    id_client integer NOT NULL,
    id_type integer,
    idadresse integer,
    id_societe integer NOT NULL,
    nom character varying(254),
    prenom character varying(254),
    tel character varying(254),
    email character varying(254)
);


ALTER TABLE public.client OWNER TO postgres;

--
-- TOC entry 211 (class 1259 OID 16694)
-- Name: commande; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.commande (
    id_commande integer NOT NULL,
    id_operation integer NOT NULL,
    id_fournisseur integer,
    numero_ref character varying(254),
    date_enregistrement date,
    date_livraison date,
    libelle character varying(254)
);


ALTER TABLE public.commande OWNER TO postgres;

--
-- TOC entry 212 (class 1259 OID 16700)
-- Name: commande_client; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.commande_client (
    id_commande bigint NOT NULL,
    id_client integer NOT NULL,
    id_operation integer,
    date_commande date,
    intitule character varying(254),
    description character varying(254),
    date_liv date,
    supprime boolean DEFAULT false,
    livree boolean DEFAULT false,
    numcmd character varying(254)
);


ALTER TABLE public.commande_client OWNER TO postgres;

--
-- TOC entry 213 (class 1259 OID 16708)
-- Name: employes; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.employes (
    id_employe integer NOT NULL,
    id_societe integer NOT NULL,
    id_role_employe integer,
    idadresse integer,
    matricule character varying(254),
    nom character varying(254),
    prenom character varying(254),
    tel character varying(254),
    email character varying(254),
    date_enregistrement date
);


ALTER TABLE public.employes OWNER TO postgres;

--
-- TOC entry 214 (class 1259 OID 16714)
-- Name: etagere; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.etagere (
    id_etagere integer NOT NULL,
    id_magasin integer NOT NULL,
    nom character varying(254),
    descrption character varying(254),
    num_range integer
);


ALTER TABLE public.etagere OWNER TO postgres;

--
-- TOC entry 215 (class 1259 OID 16720)
-- Name: fournisseur; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.fournisseur (
    id_fournisseur integer NOT NULL,
    idadresse integer,
    niu character varying(254),
    raison_sociale character varying(254),
    tel character varying(254),
    bp character varying(254),
    email character varying(254),
    site_web character varying(254),
    id_societe integer NOT NULL
);


ALTER TABLE public.fournisseur OWNER TO postgres;

--
-- TOC entry 216 (class 1259 OID 16726)
-- Name: livraison; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.livraison (
    id_livraison integer NOT NULL,
    id_commande integer,
    id_operation integer,
    id_fournisseur integer,
    numero_ref character varying(254),
    date_enregistrement date,
    libelle character varying(254),
    cout_total double precision,
    livree boolean DEFAULT false,
    supprime boolean DEFAULT false,
    date_livraison date,
    heure_livraison time with time zone,
    id_session integer
);


ALTER TABLE public.livraison OWNER TO postgres;

--
-- TOC entry 217 (class 1259 OID 16732)
-- Name: magasin; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.magasin (
    id_magasin integer NOT NULL,
    id_societe integer NOT NULL,
    code character varying(254),
    intitule character varying(254),
    description character varying(254)
);


ALTER TABLE public.magasin OWNER TO postgres;

--
-- TOC entry 218 (class 1259 OID 16738)
-- Name: menu; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.menu (
    idmenu integer NOT NULL,
    men_idmenu integer,
    nom character varying(254),
    ressource character varying(254)
);


ALTER TABLE public.menu OWNER TO postgres;

--
-- TOC entry 219 (class 1259 OID 16744)
-- Name: mouchard; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.mouchard (
    id_mouchard bigint NOT NULL,
    idutilisateur integer NOT NULL,
    description character varying(254),
    date_operation date,
    heure_operation date
);


ALTER TABLE public.mouchard OWNER TO postgres;

--
-- TOC entry 220 (class 1259 OID 16747)
-- Name: operation_caisse; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.operation_caisse (
    id_operation bigint NOT NULL,
    id_type integer NOT NULL,
    id_employe integer,
    id_session integer NOT NULL,
    intitule character varying(254),
    date_operation date,
    montant double precision
);


ALTER TABLE public.operation_caisse OWNER TO postgres;

--
-- TOC entry 221 (class 1259 OID 16750)
-- Name: operation_stock; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.operation_stock (
    id_operation bigint NOT NULL,
    id_article bigint,
    description character varying(254),
    qte integer,
    entree boolean,
    id_session integer NOT NULL,
    id_type integer NOT NULL,
    date_operation date
);


ALTER TABLE public.operation_stock OWNER TO postgres;

--
-- TOC entry 222 (class 1259 OID 16753)
-- Name: pays; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.pays (
    idpays integer NOT NULL,
    nom character varying(254)
);


ALTER TABLE public.pays OWNER TO postgres;

--
-- TOC entry 223 (class 1259 OID 16756)
-- Name: privilegesutilisateur; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.privilegesutilisateur (
    idprivilege integer NOT NULL,
    idmenu integer NOT NULL,
    nom character varying(254),
    description character varying(254),
    niveau integer
);


ALTER TABLE public.privilegesutilisateur OWNER TO postgres;

--
-- TOC entry 224 (class 1259 OID 16762)
-- Name: quartier; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.quartier (
    idquartier integer NOT NULL,
    idville integer,
    nom character varying(254)
);


ALTER TABLE public.quartier OWNER TO postgres;

--
-- TOC entry 225 (class 1259 OID 16765)
-- Name: region; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.region (
    idregion integer NOT NULL,
    nom character varying(254)
);


ALTER TABLE public.region OWNER TO postgres;

--
-- TOC entry 226 (class 1259 OID 16768)
-- Name: restrictionprivilege; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.restrictionprivilege (
    idrestriction integer NOT NULL,
    idprivilege integer NOT NULL,
    idutilisateur integer NOT NULL,
    restrictup boolean,
    cancreate boolean,
    canupdate boolean,
    candelete boolean
);


ALTER TABLE public.restrictionprivilege OWNER TO postgres;

--
-- TOC entry 227 (class 1259 OID 16771)
-- Name: retour_article_liv; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.retour_article_liv (
    id_retour integer NOT NULL,
    id_article_liv bigint,
    motif character varying(254),
    retourne boolean
);


ALTER TABLE public.retour_article_liv OWNER TO postgres;

--
-- TOC entry 228 (class 1259 OID 16774)
-- Name: role_employe; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.role_employe (
    id_role_employe integer NOT NULL,
    nom integer
);


ALTER TABLE public.role_employe OWNER TO postgres;

--
-- TOC entry 229 (class 1259 OID 16777)
-- Name: roleprivilege; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.roleprivilege (
    idroleprivilege integer NOT NULL,
    idrole integer NOT NULL,
    idprivilege integer NOT NULL,
    cancreate boolean,
    canupdate boolean,
    candelete boolean
);


ALTER TABLE public.roleprivilege OWNER TO postgres;

--
-- TOC entry 230 (class 1259 OID 16780)
-- Name: roleutilisateur; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.roleutilisateur (
    idrole integer NOT NULL,
    nomrole character varying(254),
    coderole character varying(254)
);


ALTER TABLE public.roleutilisateur OWNER TO postgres;

--
-- TOC entry 231 (class 1259 OID 16786)
-- Name: session; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.session (
    id_session integer NOT NULL,
    id_societe integer NOT NULL,
    nom character varying(254),
    date_debut date,
    date_fin date
);


ALTER TABLE public.session OWNER TO postgres;

--
-- TOC entry 232 (class 1259 OID 16789)
-- Name: societe; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.societe (
    id_societe integer NOT NULL,
    idadresse integer,
    nom character varying(254),
    code character varying(254),
    description character varying(254),
    telephone character varying(254),
    siteweb character varying(254),
    email character varying(254),
    date_creation date,
    date_enregistrement date
);


ALTER TABLE public.societe OWNER TO postgres;

--
-- TOC entry 233 (class 1259 OID 16795)
-- Name: stock_article; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.stock_article (
    id_articlestock bigint NOT NULL,
    id_etagere integer,
    id_article bigint,
    qte_stock integer
);


ALTER TABLE public.stock_article OWNER TO postgres;

--
-- TOC entry 234 (class 1259 OID 16798)
-- Name: type_article; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.type_article (
    id_type integer NOT NULL,
    id_categorie integer NOT NULL,
    nom character varying(254),
    description character varying(254)
);


ALTER TABLE public.type_article OWNER TO postgres;

--
-- TOC entry 235 (class 1259 OID 16804)
-- Name: type_client; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.type_client (
    id_type integer NOT NULL,
    nom character varying(254)
);


ALTER TABLE public.type_client OWNER TO postgres;

--
-- TOC entry 236 (class 1259 OID 16807)
-- Name: type_operation; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.type_operation (
    id_type integer NOT NULL,
    nom character varying(254),
    code character varying(254)
);


ALTER TABLE public.type_operation OWNER TO postgres;

--
-- TOC entry 237 (class 1259 OID 16813)
-- Name: type_operation_stock; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.type_operation_stock (
    id_type integer NOT NULL,
    nom character varying(254)
);


ALTER TABLE public.type_operation_stock OWNER TO postgres;

--
-- TOC entry 238 (class 1259 OID 16816)
-- Name: utilisateur; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.utilisateur (
    idutilisateur integer NOT NULL,
    idrole integer NOT NULL,
    id_employe integer,
    login character varying(254),
    password character varying(254),
    nom character varying(254),
    description character varying(254),
    actif boolean,
    deleted boolean,
    photo character varying(254),
    datecreation date,
    datedelete date,
    datedesactivation date,
    dateactivation date
);


ALTER TABLE public.utilisateur OWNER TO postgres;

--
-- TOC entry 239 (class 1259 OID 16822)
-- Name: ville; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.ville (
    idville integer NOT NULL,
    idregion integer,
    idpays integer,
    nom character varying(254)
);


ALTER TABLE public.ville OWNER TO postgres;

--
-- TOC entry 2859 (class 2606 OID 16826)
-- Name: achat_article pk_achat_article; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.achat_article
    ADD CONSTRAINT pk_achat_article PRIMARY KEY (id_achatartice);


--
-- TOC entry 2863 (class 2606 OID 16828)
-- Name: achats pk_achats; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.achats
    ADD CONSTRAINT pk_achats PRIMARY KEY (id_achat);


--
-- TOC entry 2867 (class 2606 OID 16830)
-- Name: adresse pk_adresse; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.adresse
    ADD CONSTRAINT pk_adresse PRIMARY KEY (idadresse);


--
-- TOC entry 2872 (class 2606 OID 16832)
-- Name: article pk_article; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.article
    ADD CONSTRAINT pk_article PRIMARY KEY (id_article);


--
-- TOC entry 2876 (class 2606 OID 16834)
-- Name: article_commande pk_article_commande; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.article_commande
    ADD CONSTRAINT pk_article_commande PRIMARY KEY (id_article_commande);


--
-- TOC entry 2881 (class 2606 OID 16836)
-- Name: article_liv pk_article_liv; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.article_liv
    ADD CONSTRAINT pk_article_liv PRIMARY KEY (id_article_liv);


--
-- TOC entry 2886 (class 2606 OID 16838)
-- Name: articles_commande_client pk_articles_commande_client; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.articles_commande_client
    ADD CONSTRAINT pk_articles_commande_client PRIMARY KEY (id_article_commandeclient);


--
-- TOC entry 2889 (class 2606 OID 16840)
-- Name: categorie_article pk_categorie_article; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.categorie_article
    ADD CONSTRAINT pk_categorie_article PRIMARY KEY (id_categorie);


--
-- TOC entry 2895 (class 2606 OID 16842)
-- Name: client pk_client; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.client
    ADD CONSTRAINT pk_client PRIMARY KEY (id_client);


--
-- TOC entry 2900 (class 2606 OID 16844)
-- Name: commande pk_commande; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.commande
    ADD CONSTRAINT pk_commande PRIMARY KEY (id_commande);


--
-- TOC entry 2905 (class 2606 OID 16846)
-- Name: commande_client pk_commande_client; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.commande_client
    ADD CONSTRAINT pk_commande_client PRIMARY KEY (id_commande);


--
-- TOC entry 2911 (class 2606 OID 16848)
-- Name: employes pk_employes; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employes
    ADD CONSTRAINT pk_employes PRIMARY KEY (id_employe);


--
-- TOC entry 2915 (class 2606 OID 16850)
-- Name: etagere pk_etagere; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.etagere
    ADD CONSTRAINT pk_etagere PRIMARY KEY (id_etagere);


--
-- TOC entry 2919 (class 2606 OID 16852)
-- Name: fournisseur pk_fournisseur; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.fournisseur
    ADD CONSTRAINT pk_fournisseur PRIMARY KEY (id_fournisseur);


--
-- TOC entry 2925 (class 2606 OID 16854)
-- Name: livraison pk_livraison; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.livraison
    ADD CONSTRAINT pk_livraison PRIMARY KEY (id_livraison);


--
-- TOC entry 2929 (class 2606 OID 16856)
-- Name: magasin pk_magasin; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.magasin
    ADD CONSTRAINT pk_magasin PRIMARY KEY (id_magasin);


--
-- TOC entry 2933 (class 2606 OID 16858)
-- Name: menu pk_menu; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.menu
    ADD CONSTRAINT pk_menu PRIMARY KEY (idmenu);


--
-- TOC entry 2937 (class 2606 OID 16860)
-- Name: mouchard pk_mouchard; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.mouchard
    ADD CONSTRAINT pk_mouchard PRIMARY KEY (id_mouchard);


--
-- TOC entry 2943 (class 2606 OID 16862)
-- Name: operation_caisse pk_operation; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.operation_caisse
    ADD CONSTRAINT pk_operation PRIMARY KEY (id_operation);


--
-- TOC entry 2947 (class 2606 OID 16864)
-- Name: operation_stock pk_operation_stock; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.operation_stock
    ADD CONSTRAINT pk_operation_stock PRIMARY KEY (id_operation);


--
-- TOC entry 2950 (class 2606 OID 16866)
-- Name: pays pk_pays; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pays
    ADD CONSTRAINT pk_pays PRIMARY KEY (idpays);


--
-- TOC entry 2953 (class 2606 OID 16868)
-- Name: privilegesutilisateur pk_privilegesutilisateur; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.privilegesutilisateur
    ADD CONSTRAINT pk_privilegesutilisateur PRIMARY KEY (idprivilege);


--
-- TOC entry 2957 (class 2606 OID 16870)
-- Name: quartier pk_quartier; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.quartier
    ADD CONSTRAINT pk_quartier PRIMARY KEY (idquartier);


--
-- TOC entry 2960 (class 2606 OID 16872)
-- Name: region pk_region; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.region
    ADD CONSTRAINT pk_region PRIMARY KEY (idregion);


--
-- TOC entry 2965 (class 2606 OID 16874)
-- Name: restrictionprivilege pk_restrictionprivilege; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.restrictionprivilege
    ADD CONSTRAINT pk_restrictionprivilege PRIMARY KEY (idrestriction);


--
-- TOC entry 2969 (class 2606 OID 16876)
-- Name: retour_article_liv pk_retour_article_liv; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.retour_article_liv
    ADD CONSTRAINT pk_retour_article_liv PRIMARY KEY (id_retour);


--
-- TOC entry 2972 (class 2606 OID 16878)
-- Name: role_employe pk_role_employe; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.role_employe
    ADD CONSTRAINT pk_role_employe PRIMARY KEY (id_role_employe);


--
-- TOC entry 2977 (class 2606 OID 16880)
-- Name: roleprivilege pk_roleprivilege; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.roleprivilege
    ADD CONSTRAINT pk_roleprivilege PRIMARY KEY (idroleprivilege);


--
-- TOC entry 2980 (class 2606 OID 16882)
-- Name: roleutilisateur pk_roleutilisateur; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.roleutilisateur
    ADD CONSTRAINT pk_roleutilisateur PRIMARY KEY (idrole);


--
-- TOC entry 2984 (class 2606 OID 16884)
-- Name: session pk_session; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.session
    ADD CONSTRAINT pk_session PRIMARY KEY (id_session);


--
-- TOC entry 2988 (class 2606 OID 16886)
-- Name: societe pk_societe; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.societe
    ADD CONSTRAINT pk_societe PRIMARY KEY (id_societe);


--
-- TOC entry 2994 (class 2606 OID 16888)
-- Name: stock_article pk_stock_article; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.stock_article
    ADD CONSTRAINT pk_stock_article PRIMARY KEY (id_articlestock);


--
-- TOC entry 2997 (class 2606 OID 16890)
-- Name: type_article pk_type_article; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.type_article
    ADD CONSTRAINT pk_type_article PRIMARY KEY (id_type);


--
-- TOC entry 3000 (class 2606 OID 16892)
-- Name: type_client pk_type_client; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.type_client
    ADD CONSTRAINT pk_type_client PRIMARY KEY (id_type);


--
-- TOC entry 3003 (class 2606 OID 16894)
-- Name: type_operation pk_type_operation; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.type_operation
    ADD CONSTRAINT pk_type_operation PRIMARY KEY (id_type);


--
-- TOC entry 3006 (class 2606 OID 16896)
-- Name: type_operation_stock pk_type_operation_stock; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.type_operation_stock
    ADD CONSTRAINT pk_type_operation_stock PRIMARY KEY (id_type);


--
-- TOC entry 3011 (class 2606 OID 16898)
-- Name: utilisateur pk_utilisateur; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.utilisateur
    ADD CONSTRAINT pk_utilisateur PRIMARY KEY (idutilisateur);


--
-- TOC entry 3016 (class 2606 OID 16900)
-- Name: ville pk_ville; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ville
    ADD CONSTRAINT pk_ville PRIMARY KEY (idville);


--
-- TOC entry 2855 (class 1259 OID 16901)
-- Name: achat_article_pk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX achat_article_pk ON public.achat_article USING btree (id_achatartice);


--
-- TOC entry 2860 (class 1259 OID 16902)
-- Name: achats_pk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX achats_pk ON public.achats USING btree (id_achat);


--
-- TOC entry 2864 (class 1259 OID 16903)
-- Name: adresse_pk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX adresse_pk ON public.adresse USING btree (idadresse);


--
-- TOC entry 2882 (class 1259 OID 16904)
-- Name: arcticles_commande_client_pk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX arcticles_commande_client_pk ON public.articles_commande_client USING btree (id_article_commandeclient);


--
-- TOC entry 2877 (class 1259 OID 16905)
-- Name: article_liv_pk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX article_liv_pk ON public.article_liv USING btree (id_article_liv);


--
-- TOC entry 2868 (class 1259 OID 16906)
-- Name: article_pk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX article_pk ON public.article USING btree (id_article);


--
-- TOC entry 2990 (class 1259 OID 16907)
-- Name: article_stock_pk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX article_stock_pk ON public.stock_article USING btree (id_articlestock);


--
-- TOC entry 3008 (class 1259 OID 16908)
-- Name: association1_fk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX association1_fk ON public.utilisateur USING btree (idrole);


--
-- TOC entry 3013 (class 1259 OID 16909)
-- Name: association32_fk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX association32_fk ON public.ville USING btree (idpays);


--
-- TOC entry 3014 (class 1259 OID 16910)
-- Name: association33_fk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX association33_fk ON public.ville USING btree (idregion);


--
-- TOC entry 2955 (class 1259 OID 16911)
-- Name: association34_fk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX association34_fk ON public.quartier USING btree (idville);


--
-- TOC entry 2865 (class 1259 OID 16912)
-- Name: association35_fk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX association35_fk ON public.adresse USING btree (idquartier);


--
-- TOC entry 2951 (class 1259 OID 16913)
-- Name: association3_fk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX association3_fk ON public.privilegesutilisateur USING btree (idmenu);


--
-- TOC entry 2962 (class 1259 OID 16914)
-- Name: association4_fk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX association4_fk ON public.restrictionprivilege USING btree (idutilisateur);


--
-- TOC entry 2930 (class 1259 OID 16915)
-- Name: association56_fk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX association56_fk ON public.menu USING btree (men_idmenu);


--
-- TOC entry 2963 (class 1259 OID 16916)
-- Name: association5_fk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX association5_fk ON public.restrictionprivilege USING btree (idprivilege);


--
-- TOC entry 2974 (class 1259 OID 16917)
-- Name: association6_fk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX association6_fk ON public.roleprivilege USING btree (idrole);


--
-- TOC entry 2975 (class 1259 OID 16918)
-- Name: association7_fk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX association7_fk ON public.roleprivilege USING btree (idprivilege);


--
-- TOC entry 2920 (class 1259 OID 16919)
-- Name: association_11_fk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX association_11_fk ON public.livraison USING btree (id_commande);


--
-- TOC entry 2873 (class 1259 OID 16920)
-- Name: association_12_fk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX association_12_fk ON public.article_commande USING btree (id_article);


--
-- TOC entry 2874 (class 1259 OID 16921)
-- Name: association_13_fk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX association_13_fk ON public.article_commande USING btree (id_commande);


--
-- TOC entry 2896 (class 1259 OID 16922)
-- Name: association_14_fk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX association_14_fk ON public.commande USING btree (id_fournisseur);


--
-- TOC entry 2906 (class 1259 OID 16923)
-- Name: association_15_fk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX association_15_fk ON public.employes USING btree (id_societe);


--
-- TOC entry 2926 (class 1259 OID 16924)
-- Name: association_16_fk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX association_16_fk ON public.magasin USING btree (id_societe);


--
-- TOC entry 2982 (class 1259 OID 16925)
-- Name: association_17_fk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX association_17_fk ON public.session USING btree (id_societe);


--
-- TOC entry 2897 (class 1259 OID 16926)
-- Name: association_19_fk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX association_19_fk ON public.commande USING btree (id_operation);


--
-- TOC entry 2995 (class 1259 OID 16927)
-- Name: association_1_fk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX association_1_fk ON public.type_article USING btree (id_categorie);


--
-- TOC entry 2938 (class 1259 OID 16928)
-- Name: association_20_fk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX association_20_fk ON public.operation_caisse USING btree (id_session);


--
-- TOC entry 2939 (class 1259 OID 16929)
-- Name: association_21_fk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX association_21_fk ON public.operation_caisse USING btree (id_type);


--
-- TOC entry 2921 (class 1259 OID 16930)
-- Name: association_22_fk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX association_22_fk ON public.livraison USING btree (id_operation);


--
-- TOC entry 2940 (class 1259 OID 16931)
-- Name: association_23_fk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX association_23_fk ON public.operation_caisse USING btree (id_employe);


--
-- TOC entry 2856 (class 1259 OID 16932)
-- Name: association_24_fk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX association_24_fk ON public.achat_article USING btree (id_achat);


--
-- TOC entry 2861 (class 1259 OID 16933)
-- Name: association_25_fk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX association_25_fk ON public.achats USING btree (id_operation);


--
-- TOC entry 2901 (class 1259 OID 16934)
-- Name: association_26_fk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX association_26_fk ON public.commande_client USING btree (id_operation);


--
-- TOC entry 2883 (class 1259 OID 16935)
-- Name: association_27_fk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX association_27_fk ON public.articles_commande_client USING btree (id_commande);


--
-- TOC entry 2869 (class 1259 OID 16936)
-- Name: association_2_fk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX association_2_fk ON public.article USING btree (id_type);


--
-- TOC entry 2902 (class 1259 OID 16937)
-- Name: association_30_fk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX association_30_fk ON public.commande_client USING btree (id_client);


--
-- TOC entry 2890 (class 1259 OID 16938)
-- Name: association_31_fk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX association_31_fk ON public.client USING btree (id_societe);


--
-- TOC entry 2891 (class 1259 OID 16939)
-- Name: association_34_fk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX association_34_fk ON public.client USING btree (idadresse);


--
-- TOC entry 2986 (class 1259 OID 16940)
-- Name: association_35_fk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX association_35_fk ON public.societe USING btree (idadresse);


--
-- TOC entry 2907 (class 1259 OID 16941)
-- Name: association_36_fk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX association_36_fk ON public.employes USING btree (idadresse);


--
-- TOC entry 2908 (class 1259 OID 16942)
-- Name: association_37_fk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX association_37_fk ON public.employes USING btree (id_role_employe);


--
-- TOC entry 2991 (class 1259 OID 16943)
-- Name: association_3_fk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX association_3_fk ON public.stock_article USING btree (id_article);


--
-- TOC entry 3009 (class 1259 OID 16944)
-- Name: association_45_fk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX association_45_fk ON public.utilisateur USING btree (id_employe);


--
-- TOC entry 2916 (class 1259 OID 16945)
-- Name: association_46_fk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX association_46_fk ON public.fournisseur USING btree (idadresse);


--
-- TOC entry 2892 (class 1259 OID 16946)
-- Name: association_47_fk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX association_47_fk ON public.client USING btree (id_type);


--
-- TOC entry 2922 (class 1259 OID 16947)
-- Name: association_48_fk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX association_48_fk ON public.livraison USING btree (id_fournisseur);


--
-- TOC entry 2934 (class 1259 OID 16948)
-- Name: association_49_fk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX association_49_fk ON public.mouchard USING btree (idutilisateur);


--
-- TOC entry 2870 (class 1259 OID 16949)
-- Name: association_50_fk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX association_50_fk ON public.article USING btree (id_societe);


--
-- TOC entry 2878 (class 1259 OID 16950)
-- Name: association_51_fk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX association_51_fk ON public.article_liv USING btree (id_operation);


--
-- TOC entry 2884 (class 1259 OID 16951)
-- Name: association_52_fk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX association_52_fk ON public.articles_commande_client USING btree (id_operation);


--
-- TOC entry 2944 (class 1259 OID 16952)
-- Name: association_55_fk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX association_55_fk ON public.operation_stock USING btree (id_article);


--
-- TOC entry 2857 (class 1259 OID 16953)
-- Name: association_56_fk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX association_56_fk ON public.achat_article USING btree (id_operation);


--
-- TOC entry 2912 (class 1259 OID 16954)
-- Name: association_5_fk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX association_5_fk ON public.etagere USING btree (id_magasin);


--
-- TOC entry 2992 (class 1259 OID 16955)
-- Name: association_6_fk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX association_6_fk ON public.stock_article USING btree (id_etagere);


--
-- TOC entry 2967 (class 1259 OID 16956)
-- Name: association_7_fk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX association_7_fk ON public.retour_article_liv USING btree (id_article_liv);


--
-- TOC entry 2879 (class 1259 OID 16957)
-- Name: association_8_fk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX association_8_fk ON public.article_liv USING btree (id_livraison);


--
-- TOC entry 2887 (class 1259 OID 16958)
-- Name: categorie_article_pk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX categorie_article_pk ON public.categorie_article USING btree (id_categorie);


--
-- TOC entry 2893 (class 1259 OID 16959)
-- Name: client_pk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX client_pk ON public.client USING btree (id_client);


--
-- TOC entry 2903 (class 1259 OID 16960)
-- Name: commande_client_pk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX commande_client_pk ON public.commande_client USING btree (id_commande);


--
-- TOC entry 2898 (class 1259 OID 16961)
-- Name: commande_pk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX commande_pk ON public.commande USING btree (id_commande);


--
-- TOC entry 2909 (class 1259 OID 16962)
-- Name: employes_pk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX employes_pk ON public.employes USING btree (id_employe);


--
-- TOC entry 2913 (class 1259 OID 16963)
-- Name: etagere_pk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX etagere_pk ON public.etagere USING btree (id_etagere);


--
-- TOC entry 2917 (class 1259 OID 16964)
-- Name: fournisseur_pk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX fournisseur_pk ON public.fournisseur USING btree (id_fournisseur);


--
-- TOC entry 2923 (class 1259 OID 16965)
-- Name: livraison_pk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX livraison_pk ON public.livraison USING btree (id_livraison);


--
-- TOC entry 2927 (class 1259 OID 16966)
-- Name: magasin_pk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX magasin_pk ON public.magasin USING btree (id_magasin);


--
-- TOC entry 2931 (class 1259 OID 16967)
-- Name: menu_pk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX menu_pk ON public.menu USING btree (idmenu);


--
-- TOC entry 2935 (class 1259 OID 16968)
-- Name: mouchard_pk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX mouchard_pk ON public.mouchard USING btree (id_mouchard);


--
-- TOC entry 2941 (class 1259 OID 16969)
-- Name: operation_pk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX operation_pk ON public.operation_caisse USING btree (id_operation);


--
-- TOC entry 2945 (class 1259 OID 16970)
-- Name: operation_stock_pk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX operation_stock_pk ON public.operation_stock USING btree (id_operation);


--
-- TOC entry 2948 (class 1259 OID 16971)
-- Name: pays_pk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX pays_pk ON public.pays USING btree (idpays);


--
-- TOC entry 2954 (class 1259 OID 16972)
-- Name: privilegesutilisateur_pk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX privilegesutilisateur_pk ON public.privilegesutilisateur USING btree (idprivilege);


--
-- TOC entry 2958 (class 1259 OID 16973)
-- Name: quartier_pk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX quartier_pk ON public.quartier USING btree (idquartier);


--
-- TOC entry 2961 (class 1259 OID 16974)
-- Name: region_pk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX region_pk ON public.region USING btree (idregion);


--
-- TOC entry 2966 (class 1259 OID 16975)
-- Name: restrictionprivilege_pk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX restrictionprivilege_pk ON public.restrictionprivilege USING btree (idrestriction);


--
-- TOC entry 2970 (class 1259 OID 16976)
-- Name: retour_article_liv_pk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX retour_article_liv_pk ON public.retour_article_liv USING btree (id_retour);


--
-- TOC entry 2973 (class 1259 OID 16977)
-- Name: role_employe_pk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX role_employe_pk ON public.role_employe USING btree (id_role_employe);


--
-- TOC entry 2978 (class 1259 OID 16978)
-- Name: roleprivilege_pk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX roleprivilege_pk ON public.roleprivilege USING btree (idroleprivilege);


--
-- TOC entry 2981 (class 1259 OID 16979)
-- Name: roleutilisateur_pk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX roleutilisateur_pk ON public.roleutilisateur USING btree (idrole);


--
-- TOC entry 2985 (class 1259 OID 16980)
-- Name: session_pk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX session_pk ON public.session USING btree (id_session);


--
-- TOC entry 2989 (class 1259 OID 16981)
-- Name: societe_pk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX societe_pk ON public.societe USING btree (id_societe);


--
-- TOC entry 2998 (class 1259 OID 16982)
-- Name: type_article_pk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX type_article_pk ON public.type_article USING btree (id_type);


--
-- TOC entry 3001 (class 1259 OID 16983)
-- Name: type_client_pk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX type_client_pk ON public.type_client USING btree (id_type);


--
-- TOC entry 3004 (class 1259 OID 16984)
-- Name: type_operation_pk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX type_operation_pk ON public.type_operation USING btree (id_type);


--
-- TOC entry 3007 (class 1259 OID 16985)
-- Name: type_operation_stock_pk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX type_operation_stock_pk ON public.type_operation_stock USING btree (id_type);


--
-- TOC entry 3012 (class 1259 OID 16986)
-- Name: utilisateur_pk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX utilisateur_pk ON public.utilisateur USING btree (idutilisateur);


--
-- TOC entry 3017 (class 1259 OID 16987)
-- Name: ville_pk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX ville_pk ON public.ville USING btree (idville);


--
-- TOC entry 3018 (class 2606 OID 16988)
-- Name: achat_article fk_achat_ar_associati_achats; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.achat_article
    ADD CONSTRAINT fk_achat_ar_associati_achats FOREIGN KEY (id_achat) REFERENCES public.achats(id_achat) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 3019 (class 2606 OID 16993)
-- Name: achat_article fk_achat_ar_associati_article; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.achat_article
    ADD CONSTRAINT fk_achat_ar_associati_article FOREIGN KEY (id_article) REFERENCES public.article(id_article) NOT VALID;


--
-- TOC entry 3020 (class 2606 OID 16998)
-- Name: achat_article fk_achat_ar_associati_operatio; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.achat_article
    ADD CONSTRAINT fk_achat_ar_associati_operatio FOREIGN KEY (id_operation) REFERENCES public.operation_stock(id_operation) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 3021 (class 2606 OID 17003)
-- Name: achats fk_achats_associati_operatio; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.achats
    ADD CONSTRAINT fk_achats_associati_operatio FOREIGN KEY (id_operation) REFERENCES public.operation_caisse(id_operation) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 3022 (class 2606 OID 17008)
-- Name: adresse fk_adresse_associati_quartier; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.adresse
    ADD CONSTRAINT fk_adresse_associati_quartier FOREIGN KEY (idquartier) REFERENCES public.quartier(idquartier) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 3025 (class 2606 OID 17013)
-- Name: article_commande fk_article__associati_article; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.article_commande
    ADD CONSTRAINT fk_article__associati_article FOREIGN KEY (id_article) REFERENCES public.article(id_article) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 3027 (class 2606 OID 17018)
-- Name: article_liv fk_article__associati_article; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.article_liv
    ADD CONSTRAINT fk_article__associati_article FOREIGN KEY (id_article) REFERENCES public.article(id_article) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 3026 (class 2606 OID 17023)
-- Name: article_commande fk_article__associati_commande; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.article_commande
    ADD CONSTRAINT fk_article__associati_commande FOREIGN KEY (id_commande) REFERENCES public.commande(id_commande) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 3028 (class 2606 OID 17028)
-- Name: article_liv fk_article__associati_livraiso; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.article_liv
    ADD CONSTRAINT fk_article__associati_livraiso FOREIGN KEY (id_livraison) REFERENCES public.livraison(id_livraison) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 3029 (class 2606 OID 17033)
-- Name: article_liv fk_article__associati_operatio; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.article_liv
    ADD CONSTRAINT fk_article__associati_operatio FOREIGN KEY (id_operation) REFERENCES public.operation_stock(id_operation) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 3023 (class 2606 OID 17038)
-- Name: article fk_article_associati_societe; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.article
    ADD CONSTRAINT fk_article_associati_societe FOREIGN KEY (id_societe) REFERENCES public.societe(id_societe) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 3024 (class 2606 OID 17043)
-- Name: article fk_article_associati_type_art; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.article
    ADD CONSTRAINT fk_article_associati_type_art FOREIGN KEY (id_type) REFERENCES public.type_article(id_type) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 3030 (class 2606 OID 17048)
-- Name: articles_commande_client fk_articles_associati_article; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.articles_commande_client
    ADD CONSTRAINT fk_articles_associati_article FOREIGN KEY (id_article) REFERENCES public.article(id_article) NOT VALID;


--
-- TOC entry 3031 (class 2606 OID 17053)
-- Name: articles_commande_client fk_articles_associati_commande; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.articles_commande_client
    ADD CONSTRAINT fk_articles_associati_commande FOREIGN KEY (id_commande) REFERENCES public.commande_client(id_commande) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 3032 (class 2606 OID 17058)
-- Name: articles_commande_client fk_articles_associati_operatio; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.articles_commande_client
    ADD CONSTRAINT fk_articles_associati_operatio FOREIGN KEY (id_operation) REFERENCES public.operation_stock(id_operation) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 3033 (class 2606 OID 17063)
-- Name: client fk_client_associati_adresse; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.client
    ADD CONSTRAINT fk_client_associati_adresse FOREIGN KEY (idadresse) REFERENCES public.adresse(idadresse) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 3034 (class 2606 OID 17068)
-- Name: client fk_client_associati_societe; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.client
    ADD CONSTRAINT fk_client_associati_societe FOREIGN KEY (id_societe) REFERENCES public.societe(id_societe) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 3035 (class 2606 OID 17073)
-- Name: client fk_client_associati_type_cli; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.client
    ADD CONSTRAINT fk_client_associati_type_cli FOREIGN KEY (id_type) REFERENCES public.type_client(id_type) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 3038 (class 2606 OID 17078)
-- Name: commande_client fk_commande_associati_client; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.commande_client
    ADD CONSTRAINT fk_commande_associati_client FOREIGN KEY (id_client) REFERENCES public.client(id_client) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 3036 (class 2606 OID 17083)
-- Name: commande fk_commande_associati_fourniss; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.commande
    ADD CONSTRAINT fk_commande_associati_fourniss FOREIGN KEY (id_fournisseur) REFERENCES public.fournisseur(id_fournisseur) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 3037 (class 2606 OID 17088)
-- Name: commande fk_commande_associati_operatio; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.commande
    ADD CONSTRAINT fk_commande_associati_operatio FOREIGN KEY (id_operation) REFERENCES public.operation_caisse(id_operation) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 3039 (class 2606 OID 17093)
-- Name: commande_client fk_commande_associati_operatio; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.commande_client
    ADD CONSTRAINT fk_commande_associati_operatio FOREIGN KEY (id_operation) REFERENCES public.operation_caisse(id_operation) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 3040 (class 2606 OID 17098)
-- Name: employes fk_employes_associati_adresse; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employes
    ADD CONSTRAINT fk_employes_associati_adresse FOREIGN KEY (idadresse) REFERENCES public.adresse(idadresse) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 3041 (class 2606 OID 17103)
-- Name: employes fk_employes_associati_role_emp; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employes
    ADD CONSTRAINT fk_employes_associati_role_emp FOREIGN KEY (id_role_employe) REFERENCES public.role_employe(id_role_employe) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 3042 (class 2606 OID 17108)
-- Name: employes fk_employes_associati_societe; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employes
    ADD CONSTRAINT fk_employes_associati_societe FOREIGN KEY (id_societe) REFERENCES public.societe(id_societe) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 3043 (class 2606 OID 17113)
-- Name: etagere fk_etagere_associati_magasin; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.etagere
    ADD CONSTRAINT fk_etagere_associati_magasin FOREIGN KEY (id_magasin) REFERENCES public.magasin(id_magasin) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 3044 (class 2606 OID 17118)
-- Name: fournisseur fk_fourniss_associati_adresse; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.fournisseur
    ADD CONSTRAINT fk_fourniss_associati_adresse FOREIGN KEY (idadresse) REFERENCES public.adresse(idadresse) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 3045 (class 2606 OID 17123)
-- Name: fournisseur fk_fourniss_associati_societe; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.fournisseur
    ADD CONSTRAINT fk_fourniss_associati_societe FOREIGN KEY (id_societe) REFERENCES public.societe(id_societe) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 3046 (class 2606 OID 17128)
-- Name: livraison fk_livraiso_associati_commande; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.livraison
    ADD CONSTRAINT fk_livraiso_associati_commande FOREIGN KEY (id_commande) REFERENCES public.commande(id_commande) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 3047 (class 2606 OID 17133)
-- Name: livraison fk_livraiso_associati_fourniss; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.livraison
    ADD CONSTRAINT fk_livraiso_associati_fourniss FOREIGN KEY (id_fournisseur) REFERENCES public.fournisseur(id_fournisseur) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 3048 (class 2606 OID 17138)
-- Name: livraison fk_livraiso_associati_operatio; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.livraison
    ADD CONSTRAINT fk_livraiso_associati_operatio FOREIGN KEY (id_operation) REFERENCES public.operation_caisse(id_operation) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 3049 (class 2606 OID 24853)
-- Name: livraison fk_livraisà_associati_cycle; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.livraison
    ADD CONSTRAINT "fk_livraisà_associati_cycle" FOREIGN KEY (id_session) REFERENCES public.session(id_session) NOT VALID;


--
-- TOC entry 3050 (class 2606 OID 17143)
-- Name: magasin fk_magasin_associati_societe; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.magasin
    ADD CONSTRAINT fk_magasin_associati_societe FOREIGN KEY (id_societe) REFERENCES public.societe(id_societe) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 3051 (class 2606 OID 17148)
-- Name: menu fk_menu_associati_menu; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.menu
    ADD CONSTRAINT fk_menu_associati_menu FOREIGN KEY (men_idmenu) REFERENCES public.menu(idmenu) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 3052 (class 2606 OID 17153)
-- Name: mouchard fk_mouchard_associati_utilisat; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.mouchard
    ADD CONSTRAINT fk_mouchard_associati_utilisat FOREIGN KEY (idutilisateur) REFERENCES public.utilisateur(idutilisateur) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 3056 (class 2606 OID 17158)
-- Name: operation_stock fk_operatio_associati_article; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.operation_stock
    ADD CONSTRAINT fk_operatio_associati_article FOREIGN KEY (id_article) REFERENCES public.article(id_article) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 3053 (class 2606 OID 17163)
-- Name: operation_caisse fk_operatio_associati_employes; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.operation_caisse
    ADD CONSTRAINT fk_operatio_associati_employes FOREIGN KEY (id_employe) REFERENCES public.employes(id_employe) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 3054 (class 2606 OID 17168)
-- Name: operation_caisse fk_operatio_associati_session; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.operation_caisse
    ADD CONSTRAINT fk_operatio_associati_session FOREIGN KEY (id_session) REFERENCES public.session(id_session) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 3057 (class 2606 OID 17173)
-- Name: operation_stock fk_operatio_associati_session; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.operation_stock
    ADD CONSTRAINT fk_operatio_associati_session FOREIGN KEY (id_session) REFERENCES public.session(id_session) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 3055 (class 2606 OID 17178)
-- Name: operation_caisse fk_operatio_associati_type_ope; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.operation_caisse
    ADD CONSTRAINT fk_operatio_associati_type_ope FOREIGN KEY (id_type) REFERENCES public.type_operation(id_type) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 3058 (class 2606 OID 17183)
-- Name: operation_stock fk_operatio_associati_type_ope; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.operation_stock
    ADD CONSTRAINT fk_operatio_associati_type_ope FOREIGN KEY (id_type) REFERENCES public.type_operation_stock(id_type) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 3059 (class 2606 OID 17188)
-- Name: privilegesutilisateur fk_privileg_associati_menu; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.privilegesutilisateur
    ADD CONSTRAINT fk_privileg_associati_menu FOREIGN KEY (idmenu) REFERENCES public.menu(idmenu) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 3060 (class 2606 OID 17193)
-- Name: quartier fk_quartier_associati_ville; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.quartier
    ADD CONSTRAINT fk_quartier_associati_ville FOREIGN KEY (idville) REFERENCES public.ville(idville) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 3061 (class 2606 OID 17198)
-- Name: restrictionprivilege fk_restrict_associati_privileg; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.restrictionprivilege
    ADD CONSTRAINT fk_restrict_associati_privileg FOREIGN KEY (idprivilege) REFERENCES public.privilegesutilisateur(idprivilege) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 3062 (class 2606 OID 17203)
-- Name: restrictionprivilege fk_restrict_associati_utilisat; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.restrictionprivilege
    ADD CONSTRAINT fk_restrict_associati_utilisat FOREIGN KEY (idutilisateur) REFERENCES public.utilisateur(idutilisateur) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 3063 (class 2606 OID 17208)
-- Name: retour_article_liv fk_retour_a_associati_article_; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.retour_article_liv
    ADD CONSTRAINT fk_retour_a_associati_article_ FOREIGN KEY (id_article_liv) REFERENCES public.article_liv(id_article_liv) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 3064 (class 2606 OID 17213)
-- Name: roleprivilege fk_rolepriv_associati_privileg; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.roleprivilege
    ADD CONSTRAINT fk_rolepriv_associati_privileg FOREIGN KEY (idprivilege) REFERENCES public.privilegesutilisateur(idprivilege) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 3065 (class 2606 OID 17218)
-- Name: roleprivilege fk_rolepriv_associati_roleutil; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.roleprivilege
    ADD CONSTRAINT fk_rolepriv_associati_roleutil FOREIGN KEY (idrole) REFERENCES public.roleutilisateur(idrole) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 3066 (class 2606 OID 17223)
-- Name: session fk_session_associati_societe; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.session
    ADD CONSTRAINT fk_session_associati_societe FOREIGN KEY (id_societe) REFERENCES public.societe(id_societe) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 3067 (class 2606 OID 17228)
-- Name: societe fk_societe_associati_adresse; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.societe
    ADD CONSTRAINT fk_societe_associati_adresse FOREIGN KEY (idadresse) REFERENCES public.adresse(idadresse) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 3068 (class 2606 OID 17233)
-- Name: stock_article fk_stock_ar_associati_article; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.stock_article
    ADD CONSTRAINT fk_stock_ar_associati_article FOREIGN KEY (id_article) REFERENCES public.article(id_article) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 3069 (class 2606 OID 17238)
-- Name: stock_article fk_stock_ar_associati_etagere; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.stock_article
    ADD CONSTRAINT fk_stock_ar_associati_etagere FOREIGN KEY (id_etagere) REFERENCES public.etagere(id_etagere) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 3070 (class 2606 OID 17243)
-- Name: type_article fk_type_art_associati_categori; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.type_article
    ADD CONSTRAINT fk_type_art_associati_categori FOREIGN KEY (id_categorie) REFERENCES public.categorie_article(id_categorie) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 3071 (class 2606 OID 17248)
-- Name: utilisateur fk_utilisat_associati_employes; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.utilisateur
    ADD CONSTRAINT fk_utilisat_associati_employes FOREIGN KEY (id_employe) REFERENCES public.employes(id_employe) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 3072 (class 2606 OID 17253)
-- Name: utilisateur fk_utilisat_associati_roleutil; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.utilisateur
    ADD CONSTRAINT fk_utilisat_associati_roleutil FOREIGN KEY (idrole) REFERENCES public.roleutilisateur(idrole) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 3073 (class 2606 OID 17258)
-- Name: ville fk_ville_associati_pays; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ville
    ADD CONSTRAINT fk_ville_associati_pays FOREIGN KEY (idpays) REFERENCES public.pays(idpays) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 3074 (class 2606 OID 17263)
-- Name: ville fk_ville_associati_region; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ville
    ADD CONSTRAINT fk_ville_associati_region FOREIGN KEY (idregion) REFERENCES public.region(idregion) ON UPDATE RESTRICT ON DELETE RESTRICT;


-- Completed on 2021-07-03 09:51:46

--
-- PostgreSQL database dump complete
--

