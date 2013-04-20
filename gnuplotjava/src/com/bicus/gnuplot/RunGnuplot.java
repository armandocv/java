package com.bicus.gnuplot;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.bicus.gnuplot.common.Constants;
import com.bicus.gnuplot.process.GnuplotReader;

public class RunGnuplot {

	private final Properties prop = new Properties();

	public boolean runPlot() {
		try {
			prop.load(new FileInputStream(Constants.CONFIG_PATHNAME));

			GnuplotReader gnuplotReader = new GnuplotReader();
			gnuplotReader.setGnuCmd(prop.getProperty(Constants.GNUPLOT_CMD));
			gnuplotReader.setGnuName(prop.getProperty(Constants.GNUPLOT_NAME));
			gnuplotReader.setGnuPath(prop.getProperty(Constants.GNUPLOT_PATH));

			return gnuplotReader.executeScript();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	public static void main(String... args) {
		RunGnuplot loadPlot = new RunGnuplot();
		
		loadPlot.runPlot();
	}

}
