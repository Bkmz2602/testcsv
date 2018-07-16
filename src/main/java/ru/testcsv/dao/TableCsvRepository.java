package ru.testcsv.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.testcsv.model.Tablecsv;

import java.util.Date;
import java.util.List;

public interface TableCsvRepository extends JpaRepository<Tablecsv, Long> {

    @Query("from Tablecsv p where p.ymdh >= ?1")
    List<Tablecsv> getHours(Date date);
}
