package cm.louisstark.gestock.entities;

import cm.louisstark.gestock.entities.ArticlesCommandeClient;
import cm.louisstark.gestock.entities.Client;
import cm.louisstark.gestock.entities.OperationCaisse;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-03-04T16:15:08")
@StaticMetamodel(CommandeClient.class)
public class CommandeClient_ { 

    public static volatile ListAttribute<CommandeClient, ArticlesCommandeClient> articlesCommandeClientList;
    public static volatile SingularAttribute<CommandeClient, Boolean> livree;
    public static volatile SingularAttribute<CommandeClient, Client> idClient;
    public static volatile SingularAttribute<CommandeClient, OperationCaisse> idOperation;
    public static volatile SingularAttribute<CommandeClient, String> description;
    public static volatile SingularAttribute<CommandeClient, Date> dateCommande;
    public static volatile SingularAttribute<CommandeClient, String> numCmd;
    public static volatile SingularAttribute<CommandeClient, String> intitule;
    public static volatile SingularAttribute<CommandeClient, Date> dateLiv;
    public static volatile SingularAttribute<CommandeClient, Long> idCommande;
    public static volatile SingularAttribute<CommandeClient, Boolean> supprime;

}