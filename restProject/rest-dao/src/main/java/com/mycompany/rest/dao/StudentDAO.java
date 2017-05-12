package com.mycompany.rest.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


/**
 *
 * @author w0914440
 */
@Component
public class StudentDAO {
     // Injected database connection:
    @PersistenceContext()
    private EntityManager em;
    public EntityManager getEm(){
    return em;}
    public void setEm(EntityManager em){
        this.em = em;
}
 
    // Retrieves all the guests:
    public List<Student> getAllStudents() {

        TypedQuery<Student> query = em.createQuery("SELECT s FROM Student s ORDER BY s.id", Student.class);
        return query.getResultList();    
    }    
        // Stores a new student:
//    @Transactional
//    public void persist(Student student) {
//        em.persist(student);
//         //TypedQuery<Student> query = em.createQuery("SELECT s FROM Student s ORDER BY s.id", Student.class);
//    }

   @Transactional
    public void saveStudent() {
       //INSERT INTO RUSSELL.STUDENT (ID, ADDRESS, FIRSTNAME, LASTNAME) VALUES (4, 'Main', 'Tom', 'Davis')
        //em.getTransaction().begin();
        EntityManager myEm = getEm();
        
        myEm.getTransaction().begin();
        Student _student = new Student();
        _student.setId(5);
        _student.setFirstname("Tom");
        _student.setLastname("Jones");
        _student.setAddress("3007 Main St");
  
        myEm.persist(_student);
        myEm.getTransaction().commit();
                
    }
 
}
