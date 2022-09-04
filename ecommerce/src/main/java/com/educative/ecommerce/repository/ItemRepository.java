package com.educative.ecommerce.repository;

import com.educative.ecommerce.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer> {

}
