package com.example.student.service.student;

import com.example.student.model.Student;
import com.example.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class StudentService implements IStudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Override
    public Iterable<Student> findAll() {
   return studentRepository.findAll();
    }

    @Override
    public Optional<Student> findById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public void save(Student student) {
        studentRepository.save(student);

    }

    @Override
    public void delete(Long id) {
    studentRepository.deleteById(id);
    }

    @Override
    public Iterable<Student> searchName(String name) {
       return studentRepository.findAllByNameContaining(name);
    }

    @Override
    public Iterable<Student> listSort() {
       return studentRepository.findAllByOrderByMarkDesc();
    }
}
