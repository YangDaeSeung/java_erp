package java_erp.utill;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class JdbcUtillTest {


	@After
	public void tearDown() throws Exception {
		System.out.println();
	}

	@Test
	public void testGetConnection() {
		System.out.println("test");
		Connection con = JdbcUtill.getConnection();
		Assert.assertNotNull(con);
		System.out.println("con >> "+con);
	}

}
