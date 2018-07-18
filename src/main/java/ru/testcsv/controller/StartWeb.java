package ru.testcsv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.testcsv.dao.TableCsvRepository;
import ru.testcsv.service.ParserCsv;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class StartWeb {

    @Autowired
    private ParserCsv csv;

    @Autowired
    TableCsvRepository repository;

    @GetMapping("/")
    public String start() {
        return "index";
    }

    @RequestMapping("/queryOne")
    public String queryOne(Model model) throws ParseException {
        /* текущая дата и -1 час
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.HOUR, -1);
        model.addAttribute("persons", repository.getHours(calendar.getTime());
        */
        SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-DD HH:MM");
        Date date = format.parse("2016-12-26 9:55");
        model.addAttribute("persons", repository.getHours(date));
        return "query1";
    }

    @RequestMapping("/queryTwo")
    public String queryTwo(Model model){
        model.addAttribute("persons", repository.findAll());
        return "query2";
    }

    @RequestMapping("/queryThree")
    public String queryThree(Model model){
        model.addAttribute("persons",repository.getTopForm());
        return "query3";
    }

    @RequestMapping("/load")
    public String loadFile(){
        csv.parfFile();
        return "index";
    }
}
