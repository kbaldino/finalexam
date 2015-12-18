package base;

import java.util.ArrayList;

import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import domain.RateDomainModel;
import util.HibernateUtil;

public class RateDAL {


	public static double getRate(int GivenCreditScore) {
		//FinalExam - please implement		
		// Figure out which row makes sense- return back the 
		// right interest rate from the table based on the given credit score
		
		//FinalExam - obviously change the return value
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		double rates = 0;		
		ArrayList<RateDomainModel> stus = new ArrayList<RateDomainModel>();
		
		try {
			session.beginTransaction();	
			
			List rt = session.createQuery("FROM RateDomainModel").list();
			for (Iterator iterator = rt.iterator(); iterator.hasNext();) {
				RateDomainModel rate = (RateDomainModel) iterator.next();
				rt.add(rate);

			}
			
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return rates;
	}

}