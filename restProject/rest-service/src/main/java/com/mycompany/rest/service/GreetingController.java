package com.mycompany.rest.service;

import com.mycompany.rest.dao.Student;
import com.mycompany.rest.dao.StudentDAO;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author W0914440
 */
@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    
    @Autowired
    StudentDAO studentDAO;


    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }
    
    
     @RequestMapping("/students")
    public List<Student> student() {
        
        return studentDAO.getAllStudents();
    }
    
     @RequestMapping(value = "/studentins", method = RequestMethod.POST)
     public void createStudent(){
     
         studentDAO.saveStudent();
     }
     
//     	@PostMapping(value = "/studentinsert")
//	public ResponseEntity createCustomer(@RequestBody Student student) {
//
//		studentDAO.saveStudent(student);
//
//		return new ResponseEntity(student, HttpStatus.OK);
//	}

}
