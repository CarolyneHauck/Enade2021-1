package enade.model;

import enade.model.Questao;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-04-18T22:56:31")
@StaticMetamodel(TipoQuestao.class)
public class TipoQuestao_ { 

    public static volatile SingularAttribute<TipoQuestao, String> nomeTipoQuestao;
    public static volatile SingularAttribute<TipoQuestao, Integer> idtipoQuestao;
    public static volatile ListAttribute<TipoQuestao, Questao> questaoList;

}