package com.mapping.oneToOne;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args )
    {
    	 System.out.println( "project started" );
         SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
         
         //creating question
         Question q1 = new Question();
         q1.setQuestionId(1);
         q1.setQuestion("what is java?");
         
         Answer a1 = new Answer();
         a1.setAnswerId(10);
         a1.setAnswer("java is programming");
         a1.setQuestion(q1);
         q1.setAnswer(a1);
         
         Question q2 = new Question();
         q2.setQuestionId(2);
         q2.setQuestion("what is collection?");
         
         Answer a2 = new Answer();
         a2.setAnswerId(11);
         a2.setAnswer("collection is API framework");
         a2.setQuestion(q2);
         q2.setAnswer(a2);
         
         Session s = factory.openSession();
         Transaction tx = s.beginTransaction();
         s.save(q1);
         s.save(q2);
         s.save(a1);
         s.save(a2);
         tx.commit();
         Question newQ = (Question)s.get(Question.class, 2);
         System.out.println(newQ.getQuestion());
         System.out.println(newQ.getAnswer().getAnswer());
         s.close();
         factory.close();
    }
}
