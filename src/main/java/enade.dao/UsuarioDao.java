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
import enade.model.Usuario;


/**
 *
 * @author carolyne.carreira
 */
public class UsuarioDao extends GenericDao<Usuario, Integer>{

    public UsuarioDao(){
        super(Usuario.class);
    }

    public static UsuarioDao usuarioDao;

    public static UsuarioDao getInstance() {
        if (usuarioDao == null) {
            usuarioDao = new UsuarioDao();
        }
        return usuarioDao;
    }
}
