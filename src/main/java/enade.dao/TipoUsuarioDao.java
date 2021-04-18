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
import enade.model.TipoUsuario;


/**
 *
 * @author carolyne.carreira
 */
public class TipoUsuarioDao extends GenericDao<TipoUsuario, Integer>{

    public TipoUsuarioDao(){
        super(TipoUsuario.class);
    }

    public static TipoUsuarioDao tipoUsuarioDao;

    public static TipoUsuarioDao getInstance() {
        if (tipoUsuarioDao == null) {
            tipoUsuarioDao = new TipoUsuarioDao();
        }
        return tipoUsuarioDao;
    }
}
