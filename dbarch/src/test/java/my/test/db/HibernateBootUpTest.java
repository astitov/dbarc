package my.test.db;

import org.junit.*;
import org.hibernate.SessionFactory;

public class HibernateBootUpTest {
	@Test
	public void test() throws Exception {
		System.out.println("Session >>>> " + HibernateBootUp.getSessionFactory());
	}
}
