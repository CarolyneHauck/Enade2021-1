/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package enade.controller;

import enade.dao.ResultadoDao;
import enade.model.Resultado;
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
@ManagedBean(name = "ResultadoBean")
@ViewScoped
public class ResultadoController implements Serializable {
    private Resultado resultado = new Resultado();
    ResultadoDao resultadoDao;
    private List resultados = new ArrayList();
    
    public ResultadoController(){
        resultadoDao =  new ResultadoDao();
        resultados = resultadoDao.buscarTodos();
    }
    
    public void record(ActionEvent actionEvent) {
        resultadoDao.atualizar(this.getResultado());
        setResultados(resultadoDao.buscarTodos());
        setResultado(new Resultado());
    }

    public void exclude(ActionEvent actionEvent) {
        resultadoDao.remover(getResultado().getIdResultado());
        setResultados(resultadoDao.buscarTodos());
        setResultado(new Resultado());
    }

    public Resultado getResultado() {
        return resultado;
    }

    public void setResultado(Resultado resultado) {
        this.resultado = resultado;
    }

    public List<Resultado> getResultados() {
        return resultados;
    }

    public void setResultados(List<Resultado> resultados) {
        this.resultados = resultados;
    }
}