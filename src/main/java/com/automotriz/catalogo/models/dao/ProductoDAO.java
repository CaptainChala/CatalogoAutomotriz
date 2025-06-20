package com.automotriz.catalogo.models.dao;

import org.springframework.data.repository.PagingAndSortingRepository;




import com.automotriz.catalogo.models.entities.Producto;

public interface ProductoDAO extends PagingAndSortingRepository<Producto, Long> {
}
