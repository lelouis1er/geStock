package cm.louisstark.gestock.entities;

import cm.louisstark.gestock.entities.OperationCaisse;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-03-04T16:15:08")
@StaticMetamodel(TypeOperation.class)
public class TypeOperation_ { 

    public static volatile SingularAttribute<TypeOperation, Integer> idType;
    public static volatile SingularAttribute<TypeOperation, String> code;
    public static volatile ListAttribute<TypeOperation, OperationCaisse> operationCaisseList;
    public static volatile SingularAttribute<TypeOperation, String> nom;

}