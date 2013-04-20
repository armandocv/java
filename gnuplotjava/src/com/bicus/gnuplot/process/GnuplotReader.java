package com.bicus.gnuplot.process;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import com.bicus.gnuplot.common.Constants;

public class GnuplotReader {

	private String gnuName;
	private String gnuPath;
	private String gnuCmd;

	public String getGnuName() {
		return gnuName;
	}


	public void setGnuName(String gnuName) {
		this.gnuName = gnuName;
	}


	public String getGnuPath() {
		return gnuPath;
	}


	public void setGnuPath(String gnuPath) {
		this.gnuPath = gnuPath;
	}


	public String getGnuCmd() {
		return gnuCmd;
	}


	public void setGnuCmd(String gnuCmd) {
		this.gnuCmd = gnuCmd;
	}


	public boolean executeScript() {

		try {
			BufferedReader br = new BufferedReader(new FileReader(
					getGnuPath() + getGnuName()));

			Runtime rt = Runtime.getRuntime();
			Process proc = rt
					.exec(getGnuCmd());

			String cmd = br.readLine();

			java.io.OutputStream opStream = proc.getOutputStream();
			PrintWriter gp = new PrintWriter(new BufferedWriter(
					new OutputStreamWriter(opStream)));
			while (cmd != null) {
				gp.println(cmd);
				gp.flush();

				cmd = br.readLine();
			}
			gp.println(Constants.SHOW_CHART);
			gp.close();

			int exitVal = proc.waitFor();
			System.out.println(Constants.PRINT_RESULT + exitVal);

			br.close();
		} catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
			return false;
		}

		return true;
	}

}

