package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
@Autowired
    StudentRepository studentRepository = new StudentRepository();
public void addStudent(Student student){
    studentRepository.addStudent(student);
}
public void addTeacher(Teacher teacher){
    studentRepository.addTeacher(teacher);
}
public void addStudentTeacherPair(String name1,String name2){
    studentRepository.addStudentTeacherPair(name1,name2);
}
public Student getStudentByName(String name){
    return studentRepository.getStudentByName(name);
}
public List<Student> getAllStudents(){
    return studentRepository.getAllStudents();
}
public Teacher getTeacherByName(String name){
    return studentRepository.getTeacherByName(name);
}
public List<Student> getStudentsByTeacherName(String name){
    return studentRepository.getStudentsByTeacherName(name);
}
public void deleteTeacherByName(String name){
    studentRepository.deleteTeacherByName(name);
}
public void deleteAllTeachers(){
    studentRepository.deleteAllTeachers();
}
}
