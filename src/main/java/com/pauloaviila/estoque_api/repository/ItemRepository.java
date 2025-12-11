package com.pauloaviila.estoque_api.repository; // Ajustado

import org.springframework.data.jpa.repository.JpaRepository;
import com.pauloaviila.estoque_api.model.Item; // Import do SEU pacote

public interface ItemRepository extends JpaRepository<Item, Long> {
}