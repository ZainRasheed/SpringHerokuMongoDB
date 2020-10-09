package com.example.SpringHerokuMongoDB.controller;


import com.example.SpringHerokuMongoDB.mongoTemplate_repo.MongoTemplateRepo;
import com.example.SpringHerokuMongoDB.properties.CompanyDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;


import java.util.List;

@Controller
public class IndexController {

    private static final String NAME = "name";
    private static final String COMPANY = "CompanyDetails";
    private static final String COMPANY_LIST = "CompanyDetailsList";

    @Autowired
    private MongoTemplateRepo mongoTemplateRepo;

    @RequestMapping("/")
    public ModelAndView getHomePageBasic() {
        ModelAndView modelAndView = new ModelAndView();
        List<CompanyDetails> companyDetailsList = mongoTemplateRepo.findAll();
        modelAndView.addObject(COMPANY_LIST, companyDetailsList);
        modelAndView.addObject("role", "");
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @PostMapping("addDataFromForm")
    public ModelAndView addDataFromForm(@Valid CompanyDetails companyDetails) {
        System.out.println(companyDetails.toString());
        mongoTemplateRepo.save(companyDetails);
        List<CompanyDetails> companyDetailsList = mongoTemplateRepo.findAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject(COMPANY, companyDetails);
        modelAndView.addObject(COMPANY_LIST, companyDetailsList);
        modelAndView.addObject("role", "REG");
        modelAndView.setViewName("index");
        return modelAndView;
    }
}


    /*@Autowired
    HttpServletRequest request;*/

    /*@RequestMapping("/{" + NAME + "}")
    public String getHomePage(@PathVariable(NAME) String name, HttpSession session) {
      //HttpSession session = request.getSession();
        session.setAttribute(NAME, name);
        System.out.println("Logging Path var... " + name);
        return "index";
    }*/

    /*@RequestMapping("/param")
    public String getHomePageRequestParam(@RequestParam(NAME) String name, HttpSession session) {
        //HttpSession session = request.getSession();
        session.setAttribute(NAME, name);
        System.out.println("Logging Request param... " + name);
        return "index";
    }*/

    //ADVANCED
    /*@GetMapping("/model/{" + NAME + "}")
    public ModelAndView getHomePage(@PathVariable(NAME) String name) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject(NAME, name);
        modelAndView.setViewName("index");
        System.out.println("Logging Path var Model and view... " + name);
        return modelAndView;
    }*/
