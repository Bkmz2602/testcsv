package ru.testcsv.service;

import com.opencsv.CSVReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.testcsv.dao.TableCsvRepository;
import ru.testcsv.model.Tablecsv;

import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;

@Component
public class ParserCsv {

    @Autowired
    TableCsvRepository csvRepository;

    public void parfFile(){
        String file = "test.csv";
        CSVReader reader;
        try{
            reader = new CSVReader(new FileReader(file));
            String[] line;
            while ((line = reader.readNext())!= null){
                try {
                    csvRepository.save(new Tablecsv(line));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }catch(IOException e){

        }
    }
}
