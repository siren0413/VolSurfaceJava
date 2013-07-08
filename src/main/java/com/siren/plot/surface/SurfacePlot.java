package com.siren.plot.surface;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.XMLOutputter;

public class SurfacePlot {

//	public static void main(String[] args) {
//		test();
//	}

	public static void plot3DSurface(ArrayList<ArrayList<Double>> list) {
		SAXBuilder builder = new SAXBuilder();

		Element surface = new Element("surface");
		Document doc = new Document(surface);
		int num_rows = list.size();
		int num_cols = list.get(0).size();
		Element row = new Element("row");
		Element col = new Element("col");
		row.addContent(String.valueOf(num_rows));
		col.addContent(String.valueOf(num_cols));
		surface.addContent(row);
		surface.addContent(col);

		for (int i = 0; i < list.size(); i++) {
			ArrayList<Double> l = list.get(i);
			for (int j = 0; j < l.size(); j++) {
				Element point = new Element("point");
				surface.addContent(point);
				point.setAttribute("x", String.valueOf(i));
				point.setAttribute("y", String.valueOf(j));
				point.setAttribute("z", String.valueOf(l.get(j)));
			}

		}
		// Attribute path_atbt1= new Attribute("path", "/test");
		// Attribute class_atb1 = new Attribute("class", "com.my.demo");
		//
		// action1.setAttribute(path_atbt1);
		// action1.setAttribute(class_atb1);
		try {
			File file = new File("plot.xml");
			XMLOutputter xo = new XMLOutputter();
			FileWriter fw = new FileWriter(file);
			xo.output(doc, fw);
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println(doc);

	}

}
