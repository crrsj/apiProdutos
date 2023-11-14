package com.example.apiProdutos.model;

import java.util.Objects;

import com.example.apiProdutos.controller.dto.CadastrarProduto;
import com.example.apiProdutos.dto.AtualizarProdutos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;

@Entity(name = "produto")
@Table(name = "produto")
public class Produto {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private String nome;
private String tipo;
private String marca ;
private String modelo;
private int garantia;
private Boolean ativo;
public Produto(Long id, String nome, String tipo, String marca, String modelo, int garantia, Boolean ativo) {
	
	this.id = id;
	this.nome = nome;
	this.tipo = tipo;
	this.marca = marca;
	this.modelo = modelo;
	this.garantia = garantia;
	this.ativo = true;
}
public Produto() {
	
}
public Produto(@Valid CadastrarProduto produtos) {
	this.nome = produtos.nome();
	this.tipo = produtos.tipo();
	this.marca = produtos.marca();
	this.modelo = produtos.modelo();
	this.garantia = produtos.garantia();
	this.ativo = true;
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}
public String getTipo() {
	return tipo;
}
public void setTipo(String tipo) {
	this.tipo = tipo;
}
public String getMarca() {
	return marca;
}
public void setMarca(String marca) {
	this.marca = marca;
}
public String getModelo() {
	return modelo;
}
public void setModelo(String modelo) {
	this.modelo = modelo;
}
public int getGarantia() {
	return garantia;
}
public void setGarantia(int garantia) {
	this.garantia = garantia;
}
public Boolean getAtivo() {
	return ativo;
}
public void setAtivo(Boolean ativo) {
	this.ativo = ativo;
}
@Override
public int hashCode() {
	return Objects.hash(ativo, garantia, id, marca, modelo, nome, tipo);
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Produto other = (Produto) obj;
	return Objects.equals(ativo, other.ativo) && garantia == other.garantia && Objects.equals(id, other.id)
			&& Objects.equals(marca, other.marca) && Objects.equals(modelo, other.modelo)
			&& Objects.equals(nome, other.nome) && Objects.equals(tipo, other.tipo);
}
public void update(@Valid AtualizarProdutos atualizacao) {
	if(atualizacao.nome() != null) {
		this.nome = atualizacao.nome();
	}
	if(atualizacao.marca()!= null) {
		this.marca = atualizacao.marca();
	}
	if(atualizacao.modelo()!= null) {
		this.modelo = atualizacao.modelo();
	}
}
public void inativar() {
	this.ativo = false;
	
}
public void ativar() {
	this.ativo = true;
	
}



}
