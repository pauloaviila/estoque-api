package com.pauloaviila.estoque_api.controller;

import com.pauloaviila.estoque_api.model.Item;
import com.pauloaviila.estoque_api.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/itens")

public class ItemController {
	
	@Autowired // Injeção
	private ItemRepository repository;
	
	
	@GetMapping
	public List<Item> listarTodos() {
        return repository.findAll();
    }
	
	@PostMapping
    public Item cadastrar(@RequestBody Item item) {
        return repository.save(item);
    }
}
