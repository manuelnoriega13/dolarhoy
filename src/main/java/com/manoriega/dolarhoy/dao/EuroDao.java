package com.manoriega.dolarhoy.dao;

import com.manoriega.dolarhoy.model.Euro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EuroDao extends JpaRepository<Euro, Long> {

    @Query("select e from Euro e where e.activo = true order by e.id desc")
    List<Euro> allActive();


}
