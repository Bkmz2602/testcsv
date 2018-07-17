package ru.testcsv.service;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.testcsv.dao.TableCsvRepository;
import ru.testcsv.pojo.PojoTableCsv;
import ru.testcsv.model.Tablecsv;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.Iterator;

@Component
public class ParserCsv {

    @Autowired
    TableCsvRepository csvRepository;

    public void parfFile(){
        String file = "test.csv";
        try{
            Reader reader = Files.newBufferedReader(Paths.get(file));
            CsvToBean<PojoTableCsv>csvToBean = new CsvToBeanBuilder(reader)
                    .withType(PojoTableCsv.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .withSeparator(';')
                    .build();
            Iterator<PojoTableCsv> tableCsvIterator = csvToBean.iterator();

            while (tableCsvIterator.hasNext()){
                PojoTableCsv tableCsv = tableCsvIterator.next();
                try {
                    csvRepository.save(new Tablecsv(tableCsv));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }catch(IOException e){

        }
    }
}
