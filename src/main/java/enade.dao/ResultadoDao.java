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
import enade.model.Resultado;


/**
 *
 * @author carolyne.carreira
 */
public class ResultadoDao extends GenericDao<Resultado, Integer>{

    public ResultadoDao(){
        super(Resultado.class);
    }

    public static ResultadoDao resultadoDao;

    public static ResultadoDao getInstance() {
        if (resultadoDao == null) {
            resultadoDao = new ResultadoDao();
        }
        return resultadoDao;
    }
}
