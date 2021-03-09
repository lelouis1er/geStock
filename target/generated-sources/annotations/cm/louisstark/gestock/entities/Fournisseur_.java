package cm.louisstark.gestock.entities;

import cm.louisstark.gestock.entities.Adresse;
import cm.louisstark.gestock.entities.Commande;
import cm.louisstark.gestock.entities.Livraison;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-03-04T16:15:08")
@StaticMetamodel(Fournisseur.class)
public class Fournisseur_ { 

    public static volatile SingularAttribute<Fournisseur, Integer> idFournisseur;
    public static volatile SingularAttribute<Fournisseur, String> raisonSociale;
    public static volatile ListAttribute<Fournisseur, Commande> commandeList;
    public static volatile SingularAttribute<Fournisseur, String> siteWeb;
    public static volatile SingularAttribute<Fournisseur, String> tel;
    public static volatile SingularAttribute<Fournisseur, Adresse> idadresse;
    public static volatile SingularAttribute<Fournisseur, String> niu;
    public static volatile ListAttribute<Fournisseur, Livraison> livraisonList;
    public static volatile SingularAttribute<Fournisseur, String> bp;
    public static volatile SingularAttribute<Fournisseur, String> email;

}