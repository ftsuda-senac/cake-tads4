/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.cake.common.service;

import br.senac.tads.cake.common.entity.Categoria;
import java.util.List;

/**
 *
 * @author Fernando
 */
public interface CategoriaService {
  
  public List<Categoria> listar();
  
  public Categoria obter(Long id);
  
}
