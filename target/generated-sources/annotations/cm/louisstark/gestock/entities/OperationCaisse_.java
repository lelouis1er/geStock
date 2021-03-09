package cm.louisstark.gestock.entities;

import cm.louisstark.gestock.entities.Achats;
import cm.louisstark.gestock.entities.Commande;
import cm.louisstark.gestock.entities.CommandeClient;
import cm.louisstark.gestock.entities.Employes;
import cm.louisstark.gestock.entities.Livraison;
import cm.louisstark.gestock.entities.Session;
import cm.louisstark.gestock.entities.TypeOperation;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-03-04T16:15:08")
@StaticMetamodel(OperationCaisse.class)
public class OperationCaisse_ { 

    public static volatile ListAttribute<OperationCaisse, CommandeClient> commandeClientList;
    public static volatile SingularAttribute<OperationCaisse, TypeOperation> idType;
    public static volatile ListAttribute<OperationCaisse, Commande> commandeList;
    public static volatile ListAttribute<OperationCaisse, Achats> achatsList;
    public static volatile SingularAttribute<OperationCaisse, Long> idOperation;
    public static volatile SingularAttribute<OperationCaisse, Session> idSession;
    public static volatile ListAttribute<OperationCaisse, Livraison> livraisonList;
    public static volatile SingularAttribute<OperationCaisse, String> intitule;
    public static volatile SingularAttribute<OperationCaisse, Employes> idEmploye;

}