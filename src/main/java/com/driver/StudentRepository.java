package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class StudentRepository {
   private HashMap<String,Student>student;
   private HashMap<String,Teacher>teacher;
   private HashMap<Teacher, List<Student>>pair;
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
       pair.put(teacher.get(teacher1), (List<Student>) student.get(student1));
   }
   public Student getStudentByName(String name){
       return student.get(name);
   }
   public Teacher getTeacherByName(String name){
       return teacher.get(name);
   }
   public List<Student> getStudentsByTeacherName(String name){
       Teacher teacher2 = teacher.get(name);

           return pair.get(teacher2);
   }
   public List<Student> getAllStudents(){
       List<Student>students = new ArrayList<>();
       for(String name : student.keySet())
           students.add(student.get(name));
       return students;
   }

   public void deleteTeacherByName(String name){
       Teacher teacher2 = teacher.get(name);
       List<Student> student2 = pair.get(teacher2);

       if(pair.containsKey(teacher2))
           pair.remove(teacher2);
       if(teacher.containsKey(name))
           teacher.remove(name);
       for(int i =0;i<student2.size();i++){
           student.remove(student2.get(i));
       }
   }
   public void deleteAllTeachers(){
       pair.clear();
       teacher.clear();
   }



}
