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
import enade.model.Prova;

/**
 *
 * @author carolyne.
public class ProvaDcarreira
 */
public class ProvaDao extends GenericDao<Prova, Integer>{

    public ProvaDao(){
        super(Prova.class);
    }

    public static ProvaDao provaDao;

    public static ProvaDao getInstance() {
        if (provaDao == null) {
            provaDao = new ProvaDao();
        }
        return provaDao;
    }
}

