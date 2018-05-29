package wokao666.club.myapp.Main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import wokao666.club.myapp.dao.withTransaction.TNoUpdate;
import wokao666.club.myapp.dao.withTransaction.TWithUpdate;

public class Main {

	private static ClassPathXmlApplicationContext ctx = null;

	public static void main(String[] args) {

		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

		//		NoUpdate noTransaction = (NoUpdate) ctx.getBean("NoUpdate");
		//		noTransaction.getAll();
		//
		//		WithUpdate WithUpdate = (WithUpdate) ctx.getBean("WithUpdate");
		//		WithUpdate.getAll();

		TNoUpdate noTransaction = (TNoUpdate) ctx.getBean("TNoUpdate");
		noTransaction.getAll();

		TWithUpdate WithUpdate = (TWithUpdate) ctx.getBean("TWithUpdate");
		WithUpdate.getAll();
	}
}
