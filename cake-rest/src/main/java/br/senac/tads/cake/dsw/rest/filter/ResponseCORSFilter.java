/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.cake.dsw.rest.filter;

import java.io.IOException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;

/**
 *
 * @author Fernando
 */
/*
 Referências:
 http://blog.usul.org/cors-compliant-rest-api-with-jersey-and-containerresponsefilter/
 https://jersey.java.net/documentation/latest/filters-and-interceptors.html
 */
@CORS
public class ResponseCORSFilter implements ContainerResponseFilter {

  @Override
  public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext)
          throws IOException {

    responseContext.getHeaders().add("Access-Control-Allow-Origin", "*");
    responseContext.getHeaders().add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, TRACE");

    String reqHead = responseContext.getHeaderString("Access-Control-Request-Headers");
    if (reqHead != null && reqHead.length() > 0) {
      responseContext.getHeaders().add("Access-Control-Request-Headers", reqHead);
    }
  }

}
