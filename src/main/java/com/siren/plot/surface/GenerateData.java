package com.siren.plot.surface;

import java.util.ArrayList;

public class GenerateData {

	private int num_rows = 45;
	private int num_cols = 45;
	private ArrayList<ArrayList<Double>> list = new ArrayList<ArrayList<Double>>();

	public static void main(String[] args) {

		GenerateData data = new GenerateData();
		data.generate();
		Utils.test(data.getList());

	}

	public void generate() {
		double d = 360 / 45;
		double result;

		for (int i = 0; i < num_rows; i++) {
			ArrayList<Double> col = new ArrayList<Double>();
			list.add(col);
			for (int j = 0; j < num_cols; j++) {
				result = (Math.cos(i * d * Math.PI / 180.0) * Math.cos(j * d * Math.PI / 180.0));
				col.add(result);
			}
		}

	}

	public ArrayList<ArrayList<Double>> getList() {
		return list;
	}
	
	

}
