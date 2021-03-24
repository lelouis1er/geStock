
/* ------------- 18-03-2021 ------------------------------------------------------------------- */

ALTER TABLE public.fournisseur
	ADD COLUMN  id_societe           INT4                 not null;

ALTER TABLE public.fournisseur
	ADD CONSTRAINT FK_FOURNISS_ASSOCIATI_SOCIETE foreign key (id_societe)
      references Societe (id_societe)
      on delete restrict on update restrict;




/*==============================================================*/
/* Table: Type_operation_stock                                  */
/*==============================================================*/
create table Type_operation_stock (
   id_type              INT4                 not null,
   nom                  VARCHAR(254)         null,
   constraint PK_TYPE_OPERATION_STOCK primary key (id_type)
);

/*==============================================================*/
/* Index: TYPE_OPERATION_STOCK_PK                               */
/*==============================================================*/
create unique index TYPE_OPERATION_STOCK_PK on Type_operation_stock (
id_type
);




ALTER TABLE public.operation_stock
	ADD COLUMN id_session           INT4                 not null,
	ADD COLUMN id_type              INT4                 not null;
	

alter table public.operation_stock
   add constraint FK_OPERATIO_ASSOCIATI_SESSION foreign key (id_session)
      references Session (id_session)
      on delete restrict on update restrict;
	  

alter table Operation_stock
   add constraint FK_OPERATIO_ASSOCIATI_TYPE_OPE foreign key (id_type)
      references Type_operation_stock (id_type)
      on delete restrict on update restrict;
	  
	  
	  
	 
ALTER TABLE public.article_liv
	ADD COLUMN  id_article         INT8                 not null;

alter table public.article_liv
   add constraint FK_ARTICLE__ASSOCIATI_ARTICLE foreign key (id_article)
      references Article (id_article)
      on delete restrict on update restrict;




/* ======================= 24-03-2021 ======================================= */

ALTER TABLE public.operation_stock
    ADD COLUMN date_operation date;

ALTER TABLE public.operation_caisse
    ADD COLUMN date_operation date;
