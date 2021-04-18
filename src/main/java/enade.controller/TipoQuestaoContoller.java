package enade.controller;

import enade.dao.TipoQuestaoDAO;
import enade.model.TipoQuestao;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author carolyne.carreira
 */
@ManagedBean(name = "TipoQuestaoBean")
@ViewScoped
public class TipoQuestaoContoller{
    
    TipoQuestao tipoQuestao = new TipoQuestao();
    List<TipoQuestao> tipoQuestoes = new ArrayList<TipoQuestao>();
    
    public TipoQuestaoContoller(){
        tipoQuestoes=TipoQuestaoDAO.getInstance().buscarTodas();
        tipoQuestao = new TipoQuestao();
    }
    
    public void gravar (ActionEvent actionEvent){
        TipoQuestaoDAO.getInstance().atualizar(tipoQuestao);
        tipoQuestoes=TipoQuestaoDAO.getInstance().buscarTodas();
        tipoQuestao = new TipoQuestao();
    }
    
    public void remover (ActionEvent actionEvent){
        TipoQuestaoDAO.getInstance().remover(tipoQuestao);
        tipoQuestoes=TipoQuestaoDAO.getInstance().buscarTodas();
        tipoQuestao = new TipoQuestao();
    }

    public TipoQuestao getTipoQuestao() {
        return tipoQuestao;
    }

    public void setTipoQuestao(TipoQuestao tipoQuestao) {
        this.tipoQuestao = tipoQuestao;
    }
    
    public List<TipoQuestao> getTipoQuestoes(){
        return tipoQuestoes;
    }
    
    public void setTipoQuestao(List<TipoQuestao> tipoQuestoes){
        this.tipoQuestoes = tipoQuestoes;
    }
}
