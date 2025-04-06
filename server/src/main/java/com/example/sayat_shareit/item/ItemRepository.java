package com.example.sayat_shareit.item;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Integer> {

    Page<Item> findByOwnerId(int ownerId, Pageable pageable);

    @Query("select i from Item i where i.available " +
            "and (upper(i.name) like upper(concat('%', :text, '%')) " +
            "or upper(i.description) like upper(concat('%', :text, '%'))) ")
    Page<Item> search(String text, Pageable pageable);
}
