/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.cake.dsw.rest.wsresource;

import br.senac.tads.cake.common.entity.Produto;
import br.senac.tads.cake.common.service.ProdutoService;
import br.senac.tads.cake.common.service.fakeimpl.ProdutoServiceFakeImpl;
import java.util.List;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
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
@Path("produto")
public class ProdutoResource {

  @Context
  private UriInfo context;

  /**
   * Creates a new instance of ProdutoResource
   */
  public ProdutoResource() {
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response listar(
          @DefaultValue("0") @QueryParam("offset") Integer offset,
          @DefaultValue("100") @QueryParam("quantidade") Integer quantidade) {
    ProdutoService service = new ProdutoServiceFakeImpl();
    // Para retornar listas de resultados, precisa usar o GenericEntity.
    List<Produto> lista = service.listar(offset, quantidade);
    GenericEntity<List<Produto>> listaRest = new GenericEntity<List<Produto>>(lista) {
    };
    return Response.ok().entity(listaRest).build();
    // ou Response.status(200).entity(service.listar(offset, quantidade).toArray()).build();
  }

  @GET
  @Path("{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public Response obter(@PathParam("id") Long id) {
    ProdutoService service = new ProdutoServiceFakeImpl();
    Produto produto = service.obter(id);
    return Response.ok().entity(produto).build();
    // ou Response.status(200).entity(service.obter(id)).build();
  }

}
