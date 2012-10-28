package ch20.ex20_11;
import java.io.*;

public class DirNameFilter implements FilenameFilter{
	public boolean accept(File dir, String name){
		return new File(dir, name).isDirectory();
	}
	public static void main(String[] args){
	File dir = new File("resource");
	String[] files = dir.list(new DirNameFilter());
	System.out.println(files.length + " dir(s)" );
	for (String file : files)
	System.out.println("\t" + file);
	}
}
