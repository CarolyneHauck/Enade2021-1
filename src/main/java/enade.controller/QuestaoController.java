/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package enade.controller;

import enade.dao.QuestaoDao;;
import enade.model.Questao;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

/**
 *
 * @author carolyne.carreira
 */
@ManagedBean(name = "QuestaoBean")
@ViewScoped
public class QuestaoController implements Serializable {
    private Questao questao = new Questao();
    QuestaoDao questaoDao;
    private List questoes = new ArrayList();
    
    public QuestaoController(){
        questaoDao =  new QuestaoDao();
        questoes = questaoDao.buscarTodos();
    }
    
    public void record(ActionEvent actionEvent) {
        questaoDao.atualizar(this.getQuestao());
        setQuestoes(questaoDao.buscarTodos());
        setQuestao(new Questao());
    }

    public void exclude(ActionEvent actionEvent) {
        questaoDao.remover(getQuestao().getIdQuestao());
        setQuestoes(questaoDao.buscarTodos());
        setQuestao(new Questao());
    }

    public Questao getQuestao() {
        return questao;
    }

    public void setQuestao(Questao questao) {
        this.questao = questao;
    }

    public List<Questao> getQuestoes() {
        return questoes;
    }

    public void setQuestoes(List<Questao> questoes) {
        this.questoes = questoes;
    }
}