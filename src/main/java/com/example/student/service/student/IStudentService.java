package com.example.student.service.student;

import com.example.student.model.Student;
import com.example.student.service.IGeneralService;

public interface IStudentService extends IGeneralService<Student> {
    public Iterable<Student>searchName(String name);
    public Iterable<Student>listSort();
}
