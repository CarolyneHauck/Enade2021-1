package enade.model;

import enade.model.Questao;
import enade.model.Resultado;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-04-18T22:56:31")
@StaticMetamodel(Prova.class)
public class Prova_ { 

    public static volatile SingularAttribute<Prova, Integer> idProva;
    public static volatile ListAttribute<Prova, Resultado> resultadoList;
    public static volatile SingularAttribute<Prova, Date> dataProva;
    public static volatile ListAttribute<Prova, Questao> questaoList;

}