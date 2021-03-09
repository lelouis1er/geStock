package cm.louisstark.gestock.entities;

import cm.louisstark.gestock.entities.ArticleCommande;
import cm.louisstark.gestock.entities.Fournisseur;
import cm.louisstark.gestock.entities.Livraison;
import cm.louisstark.gestock.entities.OperationCaisse;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-03-04T16:15:08")
@StaticMetamodel(Commande.class)
public class Commande_ { 

    public static volatile SingularAttribute<Commande, Fournisseur> idFournisseur;
    public static volatile SingularAttribute<Commande, Date> dateLivraison;
    public static volatile SingularAttribute<Commande, OperationCaisse> idOperation;
    public static volatile SingularAttribute<Commande, String> libelle;
    public static volatile ListAttribute<Commande, ArticleCommande> articleCommandeList;
    public static volatile SingularAttribute<Commande, String> numeroRef;
    public static volatile ListAttribute<Commande, Livraison> livraisonList;
    public static volatile SingularAttribute<Commande, Integer> idCommande;
    public static volatile SingularAttribute<Commande, Date> dateEnregistrement;

}