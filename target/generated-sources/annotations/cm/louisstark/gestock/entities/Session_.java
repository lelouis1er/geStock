package cm.louisstark.gestock.entities;

import cm.louisstark.gestock.entities.Operation;
import cm.louisstark.gestock.entities.Societe;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-02-22T15:12:09")
@StaticMetamodel(Session.class)
public class Session_ { 

    public static volatile ListAttribute<Session, Operation> operationList;
    public static volatile SingularAttribute<Session, Societe> idSociete;
    public static volatile SingularAttribute<Session, Date> dateDebut;
    public static volatile SingularAttribute<Session, Integer> idSession;
    public static volatile SingularAttribute<Session, Date> dateFin;
    public static volatile SingularAttribute<Session, String> nom;

}