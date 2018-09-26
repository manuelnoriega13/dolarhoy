package com.manoriega.dolarhoy.repository;

import com.manoriega.dolarhoy.model.Dolar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DolarRepo extends JpaRepository<Dolar, Long> {
}
