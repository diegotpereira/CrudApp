/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controller;

import br.com.dao.DAOPessoa;
import br.com.dao.PessoaHashMap;
import br.com.model.Pessoa;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Diego
 */

@Controller
public class PessoaController {
    
    private DAOPessoa dao;
	@RequestMapping("cadastroPessoa")
	public String cadastroPessoa()
	{
		if(dao == null)
		dao = new PessoaHashMap();
		
		return "pessoaForm";
	}
	
	@RequestMapping(value="adicionaPessoa",method= RequestMethod.POST)
	public String cadastroPessoa(@RequestParam("nome") String nome,
								 @RequestParam("cpf") String cpf,
								 @RequestParam("email") String email)
	{
		if(dao == null)
			dao = new PessoaHashMap();
		Pessoa pessoa = new Pessoa();
		pessoa.setCpf(cpf);
		pessoa.setEmail(email);
		pessoa.setNome(nome);
		dao.persistir(pessoa);
		return "redirect:cadastroPessoa";
	}
	
	@RequestMapping("editarPessoa")
	public String alterarPessoa(Long id, Model model)
	{
		if(dao == null)
			dao = new PessoaHashMap();
		model.addAttribute("pessoa", dao.getPessoa(id));
		return "pessoa/editarPessoa";
	}
	
	@RequestMapping("alterarPessoa")
	public String alteraPessoa(Pessoa pessoa) 
	{
		if(dao == null)
			dao = new PessoaHashMap();
		dao.alterar(pessoa);
		return "redirect:listaPessoas";
	}
	
	@RequestMapping("removePessoa")
	public String removerPessoa(Pessoa pessoa)
	{
		if(dao == null)
			dao = new PessoaHashMap();
		dao.excluir(pessoa);
		return "redirect:listaPessoas";
	}
	
	@RequestMapping("listaPessoas")
	public String listaCadastroPessoa(Model model)
	{
		if(dao == null)
			dao = new PessoaHashMap();
		model.addAttribute("pessoas", dao.list());
		return "listaPessoa";
	}
	
	public DAOPessoa getDao() 
	{
		return dao;
	}

	public void setDao(DAOPessoa dao) 
	{
		this.dao = dao;
	}
    
}
