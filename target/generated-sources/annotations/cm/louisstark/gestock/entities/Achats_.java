package cm.louisstark.gestock.entities;

import cm.louisstark.gestock.entities.AchatArticle;
import cm.louisstark.gestock.entities.OperationCaisse;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-02-26T08:09:33")
@StaticMetamodel(Achats.class)
public class Achats_ { 

    public static volatile ListAttribute<Achats, AchatArticle> achatArticleList;
    public static volatile SingularAttribute<Achats, OperationCaisse> idOperation;
    public static volatile SingularAttribute<Achats, Date> dateAchat;
    public static volatile SingularAttribute<Achats, Long> idAchat;
    public static volatile SingularAttribute<Achats, String> nomClient;
    public static volatile SingularAttribute<Achats, String> numFacture;

}