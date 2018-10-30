package com.cleber.jsf.bean;

import com.cleber.jsf.dto.Faixa;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import java.io.Serializable;

@ManagedBean
@ViewScoped
public class IntersecaoBean implements Serializable {

    private static final long serialVersionUID = -687991492884005133L;

    private Faixa faixa1 = new Faixa();
    private Faixa faixa2 = new Faixa();

    public Faixa getFaixa1() {
        return faixa1;
    }

    public void setFaixa1(Faixa faixa1) {
        this.faixa1 = faixa1;
    }

    public Faixa getFaixa2() {
        return faixa2;
    }

    public void setFaixa2(Faixa faixa2) {
        this.faixa2 = faixa2;
    }

    public String consultar() {

        String mensagem;

        if(verificarIntersecaoDeFaixas(faixa1, faixa2)){
            mensagem = "Existe interseção entre as faixas 1 e 2.";
        } else {
            mensagem ="Não há interseção entre as faixas 1 e 2.";
        }

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", mensagem));

        return "";
    }

    private boolean verificarIntersecaoDeFaixas(Faixa faixa1, Faixa faixa2) {

        return faixa1.getInicio() < faixa1.getTermino() || faixa1.getTermino() > faixa2.getInicio();
    }
}
