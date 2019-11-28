
package com.suicidaesquadrao.estacionamento.dao;


import java.sql.SQLException;
import java.util.List;
import util.validacaoException;

public interface CRUD <T>{
       
  void excluir(Integer objeto) throws validacaoException, SQLException, ClassNotFoundException;
  Object listarId(Integer objeto) throws validacaoException, SQLException, ClassNotFoundException;
  List <T> listar() throws validacaoException, SQLException, ClassNotFoundException;
  void salvar(T objeto) throws validacaoException, SQLException, ClassNotFoundException;
  void atualizar(T objeto) throws validacaoException, SQLException, ClassNotFoundException; 
    
}
