package model;

public class Main {

	public static void main(String[] args) {
		TaskRepository t = new TaskRepository();
		try
		{
			t.ListAll();
		}
	 catch(Exception e)
		{
		 System.out.println(e);
		}
		
	}

}
