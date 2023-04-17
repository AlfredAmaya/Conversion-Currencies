package Experiments;

import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

public class UTF_Experiment {
	public static void main(String[] args) throws IOException {
		String str = "¿æŁéİüłïąņąø"; // Sample data from the question.
        
        // Redirect System.out to use a PrintStream using UTF-8 charset.
        FileOutputStream fos = new FileOutputStream(FileDescriptor.out);
        PrintStream ps = new PrintStream(fos, true, StandardCharsets.UTF_8);
        System.setOut(ps);
        
        System.out.println("str: " + str); 
	}
}
