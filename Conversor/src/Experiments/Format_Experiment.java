package Experiments;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Format_Experiment {
	public static void main(String[] args) {
		double dVal = 20.23;
        System.out.println("Double Value: "+dVal);
        String format = "0.000";
        NumberFormat formatter = new DecimalFormat(format);  
        String newDVal = formatter.format(dVal);
        System.out.println("Value After Formatting: "+newDVal);
	}
}
