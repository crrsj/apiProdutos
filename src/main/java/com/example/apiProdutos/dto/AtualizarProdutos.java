package com.example.apiProdutos.dto;

import com.example.apiProdutos.model.Produto;

import jakarta.validation.constraints.NotNull;

public record AtualizarProdutos(@NotNull Long id,String nome,String marca,String modelo) {

	public AtualizarProdutos(Produto atualiza) {
		this(atualiza.getId(),atualiza.getNome(),atualiza.getMarca(),atualiza.getModelo());
	}

}
