package com.example.apiProdutos.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.apiProdutos.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

	List<Produto> findAllByAtivoTrue();

}
