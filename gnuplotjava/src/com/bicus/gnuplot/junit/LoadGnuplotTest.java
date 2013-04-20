package com.bicus.gnuplot.junit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.bicus.gnuplot.RunGnuplot;

public class LoadGnuplotTest {

	@Before
	public void setUp() throws Exception {
		System.out.println("Begin");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("End");
	}

	@Test
	public void test() {
		RunGnuplot loadGnu = new RunGnuplot();

		assertTrue(loadGnu.runPlot());
	}

}
