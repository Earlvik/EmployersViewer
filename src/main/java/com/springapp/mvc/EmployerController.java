package com.springapp.mvc;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class EmployerController {
	@Autowired
    private EmployerRepository employerRepository;


    @RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Employer> findAllEmployers(){
        return employerRepository.findAll();
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView EmployersPage(){
        ModelAndView modelAndView = new ModelAndView("employers");
        List<Employer> employers = new ArrayList<Employer>();
        employers.addAll(findAllEmployers());
        modelAndView.addObject("employers", employers);
        modelAndView.addObject("employer",new Employer());
        return modelAndView;
    }

    @RequestMapping(value = "/find", method = RequestMethod.GET)
    public ModelAndView findEmployersPage(@RequestParam("firstName") String firstName,
                                          @RequestParam("secondName") String secondName,
                                          @RequestParam("lastName") String lastName){
        ModelAndView modelAndView = new ModelAndView("employers");
        List<Employer> employers = employerRepository.findByFirstNameOrSecondNameOrLastName(firstName,secondName, lastName);
        modelAndView.addObject("employers", employers);
        modelAndView.addObject("employer",new Employer());
        return modelAndView;
    }

    @RequestMapping(value="/edit/{employerId}", method = RequestMethod.GET)
    public ModelAndView editEmployerPage(@PathVariable("employerId") long id){
        ModelAndView modelAndView = new ModelAndView("edit-employer");
        Employer employer = employerRepository.findOne(id);
        if(employer == null) throw new IllegalArgumentException("Element not found");
        modelAndView.addObject("employer",employer);
        return modelAndView;
    }

    @RequestMapping(value = "/edit/{employerId}", method = RequestMethod.POST)
    @ResponseBody
    public Employer editEmployer(@PathVariable("employerId") long id,
                                 @RequestParam("firstName") String firstName,
                                 @RequestParam("secondName") String secondName,
                                 @RequestParam("lastName") String lastName,
                                 @RequestParam("age") int age,
                                 @RequestParam("experience") int experience,
                                 @RequestParam("description") String description){
        Employer employer = new Employer();
        employer.setFirstName(firstName);
        employer.setSecondName(secondName);
        employer.setLastName(lastName);
        employer.setAge(age);
        employer.setExperience(experience);
        employer.setDescription(description);
        employer.setId(id);
        return employerRepository.saveAndFlush(employer);
    }

    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public ModelAndView addEmployerPage(){
        ModelAndView modelAndView = new ModelAndView("new-employer");
        modelAndView.addObject("employer",new Employer());
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public Employer addEmployer(@RequestParam("firstName") String firstName,
                                @RequestParam("secondName") String secondName,
                                @RequestParam("lastName") String lastName,
                                @RequestParam("age") int age,
                                @RequestParam("experience") int experience,
                                @RequestParam("description") String description){
        Employer employer = new Employer();
        employer.setFirstName(firstName);
        employer.setSecondName(secondName);
        employer.setLastName(lastName);
        employer.setAge(age);
        employer.setExperience(experience);
        employer.setDescription(description);
        return employerRepository.saveAndFlush(employer);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public Employer deleteEmployer(@RequestParam("employerId") long id){
        Employer employer = employerRepository.findOne(id);
        employerRepository.delete(id);
        return employer;
    }

    @RequestMapping(value = "/api/employers", method = RequestMethod.GET)
    public @ResponseBody String listEmployersJson(ModelMap model) throws JSONException{
        JSONArray employerArray = new JSONArray();
        for(Employer employer: employerRepository.findAll()){
            JSONObject employerJSON = new JSONObject();
            employerJSON.put("id",employer.getId());
            employerJSON.put("firstName",employer.getFirstName());
            employerJSON.put("secondName",employer.getSecondName());
            employerJSON.put("lastName",employer.getLastName());
            employerJSON.put("age",employer.getAge());
            employerJSON.put("experience",employer.getExperience());
            employerJSON.put("description",employer.getDescription());
            employerArray.put(employerJSON);
        }
        return employerArray.toString();
    }

}