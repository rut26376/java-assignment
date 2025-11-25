package main;

import java.util.Scanner;

import model.Status;
import model.Task;
import model.TaskService;

public class Main {

	 public static void main(String[] args) {
		 Scanner console = new Scanner(System.in);
		int type = -1;
		TaskService ts = new TaskService();
		System.out.println("Choose an option:\n"
				+ "0. Exit"
				+ "1. Add\n"
				+ "2. Update\n"
				+ "3. Delete\n"
				+ "4. Get By Id\n"
				+ "5. List all\n"
				+ "6. Mark as done\n"
				+ "7. Search by text\n"
				+ "8. Sort by status");
		while(type != 0)
		{
			
			System.out.print("Your choice: ");
			type = console.nextInt();
			console.nextLine();
			switch (type)
			{
			case 1:
				System.out.print("id: ");
				int id = console.nextInt();
				console.nextLine();
				System.out.print("title: ");
				String title = console.nextLine();
				System.out.print("description: ");
				String des = console.nextLine();
				System.out.println(ts.add(id, title, des));
				break;
			case 2:
				System.out.print("id: ");
			    id = console.nextInt();
				console.nextLine();
				System.out.print("title: ");
			    title = console.nextLine();
				System.out.print("description: ");
			    des = console.nextLine();
			    System.out.print("status (NEW , IN_PROGRESS , DONE): ");
			    String status = console.nextLine();
			    Task t = ts.getById(id);
			    t.setTitle(title);
			    t.setDescription(des);
			    t.setStatus(Status.valueOf(status));
			    if(ts.update(t))
			    System.out.println("well!");
			    else
			    	System.out.println("Error!");
				break;
			case 3:
				System.out.print("id: ");
			    id = console.nextInt();
			    if(ts.delete(id))
				    System.out.println("well!");
				    else
				    System.out.println("Error!");
				break;
			case 4:
				System.out.print("id: ");
			    id = console.nextInt();
			    System.out.println(ts.getById(id));
				break;
			case 5:
				System.out.println(ts.listAll());
				break;
			case 6:
				System.out.print("id: ");
			    id = console.nextInt();
			    ts.markAsDone(id);
				break;
			case 7:
				System.out.print("text: ");
				String txt = console.nextLine();
				System.out.println(ts.searchByText(txt));
				break;
			case 8:
				System.out.println(ts.sortByStatus());
				break;
			
			}
		}
		 
		 
		 
		 
		 
		 
	    }

}
