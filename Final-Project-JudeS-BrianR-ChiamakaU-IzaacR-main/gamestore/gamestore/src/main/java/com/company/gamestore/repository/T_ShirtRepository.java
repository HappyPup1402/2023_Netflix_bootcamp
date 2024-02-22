package com.company.gamestore.repository;

import com.company.gamestore.model.T_Shirt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface T_ShirtRepository extends JpaRepository<T_Shirt, Integer> {

    List<T_Shirt> findByColor(String color);
    List<T_Shirt> findBySize(String size);
}
