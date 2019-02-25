package com.manoriega.dolarhoy.dao;

import com.manoriega.dolarhoy.model.Dolar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface DolarDao extends JpaRepository<Dolar, Long>, QueryByExampleExecutor<Dolar> {

    @Query("select d from Dolar d where d.activo = true order by d.id desc")
    List<Dolar> allActive();

    List<Dolar> findAllByActivoEqualsOrderById(Boolean activo);
}
