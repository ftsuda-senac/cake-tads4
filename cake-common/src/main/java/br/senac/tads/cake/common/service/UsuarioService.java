/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.cake.common.service;

import br.senac.tads.cake.common.entity.CredencialAcesso;
import br.senac.tads.cake.common.entity.Usuario;

/**
 *
 * @author Fernando
 */
public interface UsuarioService {
  
  public Usuario autenticar(CredencialAcesso credencial);
  
  public void criar(Usuario usuario);
  
  public void alterar(Usuario usuario);
  
  public void excluir(Long id);
  
  public void alterarSenha(String novoHash);
  
}
