/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.dsw.cake.jsf2.managedbean;

import br.senac.tads.cake.common.entity.Categoria;
import br.senac.tads.cake.common.service.CategoriaService;
import br.senac.tads.cake.common.service.fakeimpl.CategoriaServiceFakeImpl;
import br.senac.tads.cake.common.service.jpaimpl.CategoriaServiceJPAImpl;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author fernando.tsuda
 */
@ManagedBean
@ApplicationScoped
public class CategoriaBean {

    /**
     * Creates a new instance of CategoriaBean
     */
    public CategoriaBean() {
    }
    
    public List<Categoria> getLista() {
        CategoriaService service = new CategoriaServiceJPAImpl();
        return service.listar();
    }
    
}
