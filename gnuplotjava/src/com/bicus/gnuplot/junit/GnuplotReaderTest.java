/**
 *
 */
package com.bicus.gnuplot.junit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.bicus.gnuplot.process.GnuplotReader;

/**
 * @author BIC US
 *
 */
public class GnuplotReaderTest {


	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		System.out.println("Begin");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		System.out.println("End");
	}

	/**
	 * Test method for {@link com.bicus.gnuplot.process.GnuplotReader#executeScript()}.
	 */
	@Test
	public void testExecuteScript() {
		GnuplotReader gnuReader = new GnuplotReader();
		gnuReader.setGnuName("map.gp");
		gnuReader.setGnuPath("C:/Users/BIC US/FFH/Petroleos/gnuplot/");
		gnuReader.setGnuCmd("C:/Program Files (x86)/gnuplot/bin/gnuplot.exe");

		assertEquals(true, gnuReader.executeScript());
	}

}
