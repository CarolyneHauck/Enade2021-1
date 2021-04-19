/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package enade.dao;

import enade.util.PersistenceUtil;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import enade.model.Questao;

/**
 *
 * @author carolyne.
public class ProvaDcarreira
 */
public class QuestaoDao extends GenericDao<Questao, Integer>{

    public QuestaoDao(){
        super(Questao.class);
    }

    public static QuestaoDao questaoDao;

    public static QuestaoDao getInstance() {
        if (questaoDao == null) {
            questaoDao = new QuestaoDao();
        }
        return questaoDao;
    }
}

