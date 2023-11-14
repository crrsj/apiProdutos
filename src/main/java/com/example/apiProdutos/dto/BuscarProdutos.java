package com.example.apiProdutos.dto;

import com.example.apiProdutos.model.Produto;

public record BuscarProdutos(Long id,String nome,String marca,String modelo) {

	
	 public BuscarProdutos(Produto produto) {
		 this(produto.getId(),produto.getNome(),produto.getMarca(),produto.getModelo());
	 }
}
