/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.cake.dsw.rest.wsresource;

import br.senac.tads.cake.common.entity.Categoria;
import br.senac.tads.cake.common.service.CategoriaService;
import br.senac.tads.cake.common.service.fakeimpl.CategoriaServiceFakeImpl;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 * REST Web Service
 *
 * @author Fernando
 */
@Path("categoria")
public class CategoriaResource {

  @Context
  private UriInfo context;

  /**
   * Creates a new instance of CategoriaResource
   */
  public CategoriaResource() {
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response listar() {
    CategoriaService service = new CategoriaServiceFakeImpl();
    List<Categoria> lista = service.listar();
    GenericEntity<List<Categoria>> listaRest = new GenericEntity<List<Categoria>>(lista) {
    };
    return Response.status(200).entity(listaRest).build();
  }
}
