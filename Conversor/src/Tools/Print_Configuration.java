package Tools;

import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

public class Print_Configuration {
	private boolean Enable=false;
	
	public Print_Configuration() {
	
	}
	
	public void Start_Configuration() {
		FileOutputStream fos = new FileOutputStream(FileDescriptor.out);
        PrintStream ps = new PrintStream(fos, true, StandardCharsets.UTF_8);
        System.setOut(ps);
        this.Enable=true;
	}
	
	public boolean IsEnable() {
		return this.Enable;
	}
	
}
