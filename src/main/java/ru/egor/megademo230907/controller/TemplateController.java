package ru.egor.megademo230907.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.egor.megademo230907.db.FakeDB;

import java.util.HashMap;
import java.util.Map;

@Controller
public class TemplateController {

    private FakeDB fakeDB;

    @Autowired
    public TemplateController(FakeDB fakeDB) {
        this.fakeDB = fakeDB;
    }

    @GetMapping("/html")
    public ModelAndView getAll(){

        Map<String, Object> model = new HashMap<>();
        model.put("msg", fakeDB.all());

        return new ModelAndView("list", model);
    }
}
