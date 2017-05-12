package com.mycompany.rest.service;


import com.mycompany.rest.dao.Student;
import com.mycompany.rest.dao.StudentDAO;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author W0914440
 */
public class StudentController {

    @RequestMapping("/searchByID")
   
    public List<Student> student(@RequestParam(value = "id", defaultValue = "0") int id) {
        StudentDAO stdao = new StudentDAO();
        List<Student> lst = stdao.getAllStudents();
        return lst;
    }

}
