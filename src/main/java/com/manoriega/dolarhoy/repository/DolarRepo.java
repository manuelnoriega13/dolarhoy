package com.manoriega.dolarhoy.repository;

import com.manoriega.dolarhoy.model.Dolar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface DolarRepo extends JpaRepository<Dolar, Long> {

    @Query("select d from Dolar d where d.activo = true order by d.id desc")
    List<Dolar> allActive();

    @Query("select d from Dolar d where d.activo = true order by d.id desc")
    List<Dolar> allActive(Pageable pageable);
}
