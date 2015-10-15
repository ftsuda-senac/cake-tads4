/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.cake.common.service.jpaimpl;

import br.senac.tads.cake.common.entity.Categoria;
import br.senac.tads.cake.common.service.CategoriaService;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author fernando.tsuda
 */
public class CategoriaServiceJPAImpl implements CategoriaService {

    private EntityManagerFactory emFactory
            = Persistence.createEntityManagerFactory("CakePU");

    @Override
    public List<Categoria> listar() {
        EntityManager em = emFactory.createEntityManager();
        Query query = em.createQuery("SELECT c FROM Categoria c");
        List<Categoria> resultados = query.getResultList();
        em.close();
        return resultados;
    }

    @Override
    public Categoria obter(Long id) {
        EntityManager em = emFactory.createEntityManager();
        Query query
                = em.createQuery("SELECT c FROM Categoria c " // Espaço entre c e "
                        + "WHERE c.id = :idCategoria")
                .setParameter("idCategoria", id);
        Categoria resultado = (Categoria) query.getSingleResult();
        em.close();
        return resultado;
    }

}
