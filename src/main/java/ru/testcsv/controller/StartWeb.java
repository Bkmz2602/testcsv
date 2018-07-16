package ru.testcsv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.testcsv.dao.TableCsvRepository;
import ru.testcsv.model.Tablecsv;
import ru.testcsv.service.ParserCsv;
import java.util.Calendar;
import java.util.List;

@Controller
public class StartWeb {

    @Autowired
    private ParserCsv csv;

    @Autowired
    TableCsvRepository repository;

    @GetMapping("/")
    public String start() {
        csv.parfFile();
        return "index";
    }

    @RequestMapping("/query")
    public String getTable(Model model){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.HOUR, -1);
        //List<Tablecsv> list = repository.getHours(calendar.getTime());
        //model.addAttribute("ssoid", list.get(0).getSsoid());
        //model.addAttribute("formid", list.get(0).getFormid());
        model.addAttribute("ssoid", 1);
        model.addAttribute("formid", 2);
        return "query1";
    }

}
