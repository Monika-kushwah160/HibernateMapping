package com.mapping;

import java.util.*;
import java.util.List;

import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class App 
{
    public static void main( String[] args )
    {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        
        Question q1 = new Question();
        q1.setQuestionId(1);
        q1.setQuestion("what is java?");
        
        Answer a1 = new Answer();
        a1.setAnswerId(10);
        a1.setAnswer("java is programming language");
        a1.setQuestion(q1);
        
        Answer a2 = new Answer();
        a2.setAnswerId(13);
        a2.setAnswer("java is bases on oops concept,with the help of java we create the website");
        a2.setQuestion(q1);
        
        Answer a3 = new Answer();
        a3.setAnswerId(16);
        a3.setAnswer("java is the important language");
        a3.setQuestion(q1);
        
        List<Answer> list = new ArrayList<Answer>();
        list.add(a1);
        list.add(a2);
        list.add(a3);
        
        q1.setAnswer(list);
      
        
        Session s = factory.openSession();
        org.hibernate.Transaction tx = s.beginTransaction();
        s.save(q1);
       s.save(a1);
       s.save(a2);
       s.save(a3);
       
       Question q = (Question)s.get(Question.class, 1);
       System.out.println(q.getQuestion());
       for(Answer a:q.getAnswer())
       {
    	   System.out.println(a.getAnswer());
       }
        tx.commit();
        s.close();
        factory.close();
    }
}
