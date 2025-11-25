package main;



import model.Status;
import model.Task;
import model.TaskService;

public class Main {

	public static void main(String[] args) {
		
		TaskService tr = new TaskService();
		
		System.out.println(tr.add(13, "iohi", "jidf"));
		tr.markAsDone(13);
		System.out.println(tr.add(1, "iohi", "jidf"));
		System.out.println(tr.add(2, "iohi", "jidf"));
		System.out.println(tr.add(3, "iohi", "jidf"));
		System.out.println(tr.add(12, "iohi", "jidf"));
		
		tr.listAll();
		System.out.println(tr.getById(14));
		Task t2 = tr.getById(3);
		t2.setStatus(Status.IN_PROGRESS);
		tr.update(t2);
		tr.markAsDone(13);
//		tr.markAsDone(1);
//		System.out.println("se" + tr.searchByText("i"));
		//System.out.println(tr.sortByStatus());
		;
	}

}
