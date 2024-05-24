package com.mapping.ManyToMany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args )
    {
       Configuration cfg = new Configuration();
       cfg.configure("hibernate.cfg.xml");
       SessionFactory factory = cfg.buildSessionFactory();
       
       Employee e1 = new Employee();
       Employee e2 = new Employee();
       e1.setEid(27);
       e1.setEname("Monika");
       e2.setEid(28);
       e2.setEname("muskan");
       
       Project p1 = new Project();
       Project p2 = new Project();
       p1.setPid(121);
       p1.setPname("Airline");
       p2.setPid(122);
       p2.setPname("netflix");
       
       List<Employee> list1 = new ArrayList<Employee>();
       List<Project> list2 = new ArrayList<Project>();
       list1.add(e1);
       list2.add(p1);
       list1.add(e2);
       list2.add(p2);
       
       e1.setProject(list2);
       p2.setEmp(list1);
       
       Session session=factory.openSession();
       Transaction tx=session.beginTransaction();
      
       session.save(e2);
       session.save(e1);
       session.save(p2);
       session.save(p1);
       tx.commit();
       session.close();
   
       factory.close();
       
    }
}
