package com.example.apiProdutos.controller.dto;

import com.example.apiProdutos.model.Produto;

import jakarta.validation.constraints.NotBlank;

public record CadastrarProduto(@NotBlank String nome,@NotBlank String tipo, String marca,String modelo,int garantia) {

	public CadastrarProduto(Produto prod) {
		this(prod.getNome(),prod.getTipo(),prod.getMarca(),prod.getModelo(),prod.getGarantia());
	}

}
