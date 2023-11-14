package com.example.apiProdutos.dto;

import com.example.apiProdutos.model.Produto;

public record BuscarPorId(Long id, String nome,String marca,String modelo ) {

	public BuscarPorId(Produto busca) {
		this(busca.getId(),busca.getNome(),busca.getMarca(),busca.getModelo());
	}

}
