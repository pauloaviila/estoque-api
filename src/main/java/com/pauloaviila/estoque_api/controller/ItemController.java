package com.pauloaviila.estoque_api.controller;

import com.pauloaviila.estoque_api.model.Item;
import com.pauloaviila.estoque_api.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/itens")
public class ItemController {

    @Autowired
    private ItemRepository repository;

    // 1. LISTAR TUDO (GET)
    @GetMapping
    public List<Item> listarTodos() {
        return repository.findAll();
    }

    // 2. CADASTRAR (POST)
    @PostMapping
    public Item cadastrar(@RequestBody Item item) {
        return repository.save(item);
    }

    // 3. EDITAR/ATUALIZAR (PUT) - Altera o item inteiro
    @PutMapping("/{id}")
    public ResponseEntity<Item> atualizar(@PathVariable Long id, @RequestBody Item itemAtualizado) {
        // Verifica se o item existe antes de tentar editar
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build(); // Retorna Erro 404
        }
        itemAtualizado.setId(id); // Força o ID para garantir que vai atualizar o certo
        Item itemSalvo = repository.save(itemAtualizado);
        return ResponseEntity.ok(itemSalvo);
    }
    
    @PatchMapping("/{id}/adicionar/{quantidade}")
    public ResponseEntity<?> adicionarEstoque(@PathVariable Long id, @PathVariable int quantidade) {
        
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        Item item = repository.findById(id).get();
        
        // AQUI ESTÁ A MÁGICA (SOMA)
        item.setQuantidade(item.getQuantidade() + quantidade);
        
        Item itemAtualizado = repository.save(item);
        return ResponseEntity.ok(itemAtualizado);
    }

    // 4. DELETAR (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(id);
        return ResponseEntity.noContent().build(); // Retorna 204 (Sem conteúdo, deu certo)
    }
    // 
    @PatchMapping("/{id}/vender/{quantidadeVendida}")
    public ResponseEntity<?> vender(@PathVariable Long id, @PathVariable int quantidadeVendida) {
        
        // Passo 1: Verifica se o item existe
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        // Passo 2: Busca o item no banco
        Item item = repository.findById(id).get();

        // Passo 3: Verifica se tem estoque suficiente
        if (item.getQuantidade() >= quantidadeVendida) {
            // Tem estoque? Vende!
            item.setQuantidade(item.getQuantidade() - quantidadeVendida);
            Item itemAtualizado = repository.save(item);
            return ResponseEntity.ok(itemAtualizado);
        } else {
            // Não tem estoque? Retorna erro 400 (Bad Request)
            return ResponseEntity.badRequest().body("Estoque insuficiente! Restam apenas: " + item.getQuantidade());
        }
    }
}