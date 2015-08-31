/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.cake.common.service.fakeimpl;

import br.senac.tads.cake.common.entity.Categoria;
import br.senac.tads.cake.common.service.CategoriaService;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Fernando
 */
public class CategoriaServiceFakeImpl implements CategoriaService {

  private static final Map<Long, Categoria> MAP_CATEGORIA = new LinkedHashMap<Long, Categoria>();

  static {
    MAP_CATEGORIA.put(1L, new Categoria(1L, "Bolo"));
    MAP_CATEGORIA.put(2L, new Categoria(2L, "Torta"));
    MAP_CATEGORIA.put(3L, new Categoria(3L, "Chocolate"));
    MAP_CATEGORIA.put(4L, new Categoria(4L, "Morango"));
    MAP_CATEGORIA.put(5L, new Categoria(5L, "Light"));
    MAP_CATEGORIA.put(6L, new Categoria(6L, "Crocante"));
    MAP_CATEGORIA.put(7L, new Categoria(7L, "Abacaxi"));
    MAP_CATEGORIA.put(8L, new Categoria(8L, "Coco"));
  }

  @Override
  public List<Categoria> listar() {
    return new ArrayList<Categoria>(MAP_CATEGORIA.values());
  }

  @Override
  public Categoria obter(Long id) {
    return MAP_CATEGORIA.get(id);
  }

}
