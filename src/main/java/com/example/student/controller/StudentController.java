package com.example.student.controller;

import com.example.student.model.Student;
import com.example.student.service.student.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import java.util.Optional;

@Controller
@RequestMapping("test")
public class StudentController {
    @Autowired
    private IStudentService studentService;

    @GetMapping("")
    public ModelAndView FormCreate() {
        ModelAndView modelAndView = new ModelAndView("student/formCreate");
        modelAndView.addObject("student", new Student());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView create(@ModelAttribute("student") Student student) {
        studentService.save(student);
        ModelAndView modelAndView = new ModelAndView("student/formCreate");
        modelAndView.addObject("student", new Student());
        modelAndView.addObject("message", "New customer created successfully");
        return modelAndView;
    }

    @GetMapping("/list")
    public ModelAndView listStudent() {
        ModelAndView modelAndVie = new ModelAndView("student/list");
        modelAndVie.addObject("list", studentService.findAll());
        return modelAndVie;
    }
    @GetMapping("/search")
    public ModelAndView searchName(@RequestParam("s")String name){
        Iterable<Student> findAllByName=studentService.searchName(name);
        ModelAndView modelAndVie = new ModelAndView("student/list");
        modelAndVie.addObject("list",findAllByName);
        return modelAndVie;

    }

    @GetMapping("/{id}/delete")
    public ModelAndView formDelete(@PathVariable("id") Long id) {
        Optional<Student> student = studentService.findById(id);
        if (student.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("student/delete");
            modelAndView.addObject("student", student.get());
            return modelAndView;

        } else {
            return new ModelAndView("error.404");
        }

    }
    @PostMapping("delete")
    public String deleteStudent(@ModelAttribute("student")Student student){
        studentService.delete(student.getId());
        return "redirect:list";
    }
    @GetMapping("/{id}/edit")
    public ModelAndView formEdit(@PathVariable("id")Long id){
     Optional<Student>student=studentService.findById(id);
     if(student.isPresent()){
         ModelAndView modelAndView=new ModelAndView("student/edit");
         modelAndView.addObject("student",student.get());
         return modelAndView;
     }
     else {
         return new ModelAndView("error.404");
     }

    }
    @PostMapping("edit")
    public ModelAndView updateStudent(@ModelAttribute("student") Student student){
     studentService.save(student);
     ModelAndView modelAndView=new ModelAndView("student/edit");
     modelAndView.addObject("student",student);
     modelAndView.addObject("message","Product updated successfully");
     return modelAndView;
    }
    @GetMapping("{id}/view")
    public ModelAndView views(@PathVariable Long id){
        Optional<Student>student=studentService.findById(id);
        ModelAndView modelAndView=new ModelAndView("/student/view");
        modelAndView.addObject("student",student.orElse(null));
        return modelAndView;
    }
    @GetMapping("/sort")
    public ModelAndView sort(){
        ModelAndView modelAndVie = new ModelAndView("student/list");
        modelAndVie.addObject("list", studentService.listSort());
        return modelAndVie;
    }
}
