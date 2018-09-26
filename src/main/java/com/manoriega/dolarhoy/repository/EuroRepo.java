package com.manoriega.dolarhoy.repository;

import com.manoriega.dolarhoy.model.Euro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EuroRepo extends JpaRepository<Euro, Long> {
}
