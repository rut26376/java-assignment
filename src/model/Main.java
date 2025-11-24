package model;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		TaskRepository t = new TaskRepository();
		System.out.println(t.Add(12, "iohi", "jidf"));
		System.out.println(t.Add(14, "iohi", "jidf"));
		t.ListAll();
		System.out.println(t.getById(14));
		
	}

}
