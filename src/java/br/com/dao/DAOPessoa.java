package br.com.dao;

import br.com.model.Pessoa;

public interface DAOPessoa extends DAOBase<Pessoa> 
{
	public Pessoa getPessoa(long id);
}
