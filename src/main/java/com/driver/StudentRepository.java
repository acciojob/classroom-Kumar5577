package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class StudentRepository {
   private HashMap<String,Student>student;
   private HashMap<String,Teacher>teacher;
   private HashMap<String, List<String>>pair;
   public StudentRepository(){
       this.student = new HashMap<>();
       this.teacher = new HashMap<>();
       this.pair = new HashMap<>();
   }
   public void addStudent(Student student1){
        student.put(student1.getName(),student1);
   }
   public void addTeacher(Teacher teacher1){
       teacher.put(teacher1.getName(),teacher1);
   }
   public void addStudentTeacherPair(String student1,String teacher1){
       if(!pair.containsKey(teacher1)){
           pair.put(teacher1,new ArrayList<>());
       }
       pair.get(teacher1).add(student1);
   }
   public Student getStudentByName(String name){
       return student.get(name);
   }
   public Teacher getTeacherByName(String name){
       return teacher.get(name);
   }
   public List<String> getStudentsByTeacherName(String name){

       return pair.get(name);
   }
   public List<String> getAllStudents(){
       List<String>students = new ArrayList<>();
       for(String name : student.keySet())
           students.add(name);
       return students;
   }

   public void deleteTeacherByName(String name){

       for(String student1 : pair.get(name))
           student.remove(student1);
       teacher.remove(name);
       pair.remove(name);
   }
   public void deleteAllTeachers(){
       for(String name: teacher.keySet() )
           deleteTeacherByName(name);
   }



}
