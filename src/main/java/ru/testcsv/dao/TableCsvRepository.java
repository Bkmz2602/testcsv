package ru.testcsv.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.testcsv.model.Tablecsv;
import ru.testcsv.pojo.TopFromI;

import java.util.Date;
import java.util.List;

@Repository
public interface TableCsvRepository extends JpaRepository<Tablecsv, Long> {

    @Query("from Tablecsv p where p.ymdh >= ?1")
    List<Tablecsv> getHours(Date date);

    @Query(value= "select count(formid), formid from tablecsv p where p.formid <> '' group by p.formid ORDER BY p.count DESC limit 5",
            nativeQuery = true)
    List<TopFromI> getTopForm();

}