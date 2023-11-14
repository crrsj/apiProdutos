package com.example.apiProdutos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.apiProdutos.controller.dto.CadastrarProduto;
import com.example.apiProdutos.dto.AtualizarProdutos;
import com.example.apiProdutos.dto.BuscarPorId;
import com.example.apiProdutos.dto.BuscarProdutos;
import com.example.apiProdutos.model.Produto;
import com.example.apiProdutos.repository.ProdutoRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
	
 @Autowired
 private ProdutoRepository repository;
	
    @PostMapping
    @Transactional
	public ResponseEntity<CadastrarProduto>cadastrar(@RequestBody @Valid CadastrarProduto produtos, UriComponentsBuilder uriBuilder){
	var prod = new Produto(produtos);	
	repository.save(prod);
	var uri = uriBuilder.path("produto/{id}").buildAndExpand(prod.getId()).toUri();
	return ResponseEntity.created(uri).body(new CadastrarProduto(prod));
	}
    @GetMapping    
    public ResponseEntity<List<BuscarProdutos>>buscar(){
     var list = repository.findAllByAtivoTrue().stream().map(BuscarProdutos::new).toList();
     return ResponseEntity.ok(list);
    }
    @PutMapping
    @Transactional
    public ResponseEntity<AtualizarProdutos>atualizar(@RequestBody @Valid AtualizarProdutos atualizacao){
    	var atualiza = repository.getReferenceById(atualizacao.id());
    	atualiza.update(atualizacao);
    	return ResponseEntity.ok( new AtualizarProdutos(atualiza));
    }
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> deletar(@PathVariable Long id){
     repository.deleteById(id);
     return ResponseEntity.noContent().build();
    }
    @DeleteMapping("desativando/{id}")
    @Transactional
    public ResponseEntity<Void>desativar(@PathVariable Long id){
    	var desative = repository.getReferenceById(id);
    	desative.inativar();
    	return ResponseEntity.noContent().build();
    	
    }
    @GetMapping("/{id}")
    public ResponseEntity<BuscarPorId>buscarId(@PathVariable Long id){
     var busque = repository.getReferenceById(id);
     return ResponseEntity.ok(new BuscarPorId(busque) );
    }
    
    @PutMapping("ativando/{id}")
    @Transactional
    public ResponseEntity<Void>ativarProduto(@PathVariable Long id){
    	var ative = repository.getReferenceById(id);
    	ative.ativar();
    	return ResponseEntity.ok().build();
    }
}

  