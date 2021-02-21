package cm.louisstark.gestock.entities;

import cm.louisstark.gestock.entities.ArticleLiv;
import cm.louisstark.gestock.entities.Commande;
import cm.louisstark.gestock.entities.Fournisseur;
import cm.louisstark.gestock.entities.Operation;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-02-21T08:04:21")
@StaticMetamodel(Livraison.class)
public class Livraison_ { 

    public static volatile SingularAttribute<Livraison, Double> coutTotal;
    public static volatile SingularAttribute<Livraison, Fournisseur> idFournisseur;
    public static volatile ListAttribute<Livraison, ArticleLiv> articleLivList;
    public static volatile SingularAttribute<Livraison, Date> dateLivraison;
    public static volatile SingularAttribute<Livraison, Operation> idOperation;
    public static volatile SingularAttribute<Livraison, String> libelle;
    public static volatile SingularAttribute<Livraison, String> numeroRef;
    public static volatile SingularAttribute<Livraison, Integer> idLivraison;
    public static volatile SingularAttribute<Livraison, Commande> idCommande;

}