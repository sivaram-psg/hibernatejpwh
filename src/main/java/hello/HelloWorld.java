package hello;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.tutorial.util.HibernateUtil;

public class HelloWorld {
public static void main(String args[])
{
	Session session=HibernateUtil.getSessionFactory().openSession();
	Transaction tx=session.beginTransaction();
	Message message=new Message("Hello World");
	Long msgId=(Long)session.save(message);
	tx.commit();
	session.close();
	
	Session thirdSession = HibernateUtil.getSessionFactory().openSession();
	Transaction thirdtx = thirdSession.beginTransaction();
	
	message = (Message)thirdSession.get(Message.class, msgId);
	message.setText("Greetings earthling");
	message.setNextMessage(new Message("Take me to the parent"));
	
	thirdtx.commit();
	thirdSession.close();
	
	Session newSession = HibernateUtil.getSessionFactory().openSession();
	Transaction newTransaction = newSession.beginTransaction();
	
	List messages=newSession.createQuery("from Message m order by m.text asc").list();
	System.out.println("number of messages found"+messages.size());
	for(int i=0;i<messages.size();i++)
	{
		Message msgitem = (Message)messages.get(i);
		System.out.println(msgitem.getText());
	}
	newTransaction.commit();
	newSession.close();
	
	
		

	
		
		
	}}

