/**    
* @Title: CaculatorTest.java  
* @Package com.tz.jspstudy.test  
* @Description: TODO 
* @author keven     
* @date 2016年8月5日 下午9:46:40  
* @version V1.0    
*/ 
package com.tz.jspstudy.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
 
/**   
 * 类描述：  
 * 类名称：com.tz.jspstudy.test.CaculatorTest       
 * 创建人：keven  
 * 创建时间：2016年8月5日 下午9:46:40     
 * @version   V1.0      
 */
public class CaculatorTest {

	private Caculator caculator = null;

	/**  
	 * @Title: setUpBeforeClass  
	 * @Description: TODO
	 * @throws java.lang.Exception   
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		//ssm架构的系统，我们现在要测试一个service方法 ，而且这个service里面用到
		//了内存信息
		//1：将我们系统spring初始化完成
		//2:将我们的内存加载进来	
	}

	
	/**  
	 * @Title: setUp  
	 * @Description: TODO
	 * @throws java.lang.Exception   
	 */
	@Before
	public void setUp() throws Exception {
		caculator = new Caculator();
	}

	
	/**
	 * Test method for {@link com.tz.jspstudy.test.Caculator#add(int, int)}.
	 */
	@Test
	public void testAdd() {
		int result = caculator.add(2, 3);
		//assertEquals(5,result);
		assertNotEquals(4,result);
		
	}

	private void assertNotEquals(int i, int result) {
		// TODO Auto-generated method stub
		
	}


	/**
	 * Test method for {@link com.tz.jspstudy.test.Caculator#substract(int, int)}.
	 */
	@Test
	public void testSubstract() {
 		int result = caculator.substract(2, 3);
		assertEquals(-1,result);
	}

	/**
	 * Test method for {@link com.tz.jspstudy.test.Caculator#multiply(int, int)}.
	 */
	@Test
	public void testMultiply() {
 		int result = caculator.multiply(2, 3);
		assertEquals(6,result);
 	}

	/**
	 * Test method for {@link com.tz.jspstudy.test.Caculator#divide(int, int)}.
	 */
	@Test
	public void testDivide() {
 		int result = caculator.divide(2, 3);
		assertEquals(0,result);
 	}

	/**  
	 * @Title: tearDown  
	 * @Description: TODO
	 * @throws java.lang.Exception   
	 */
	@After
	public void tearDown() throws Exception {
		caculator = null;
	}
	/**  
	 * @Title: tearDownAfterClass  
	 * @Description: TODO
	 * @throws java.lang.Exception   
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

}
