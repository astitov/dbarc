package my.test.db;

import org.junit.*;
import org.junit.Assert.*;

public class ConnectTest {

  private Connect conn;

  @Before
  public void initTest() {
    conn = new Connect();
  }

  @After
  public void afterTest(){
    conn = null;
  }

  @Test
  public void testConnect() throws Exception { 
//    System.out.println("Connection: >>>" + conn.getConnect());
  }

}

