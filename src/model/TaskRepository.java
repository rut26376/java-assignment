package model;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class TaskRepository {

	// יש לשנות את הניתוב בהתאם לתיקיה
	private final String JSON_FILE = "C:/Users/java/TaskManagement/src/model/Tasks.json";
	private List<Task> tasks;

	public TaskRepository() {
		this.tasks = new ArrayList<Task>();
		listAll();
	}
	
	public List<Task> getTasks() {
		return tasks;
	}
	
	public boolean add(String title, String description) {
		int id = getMaxId() + 1;

		Task t = new Task(id, title, description, Status.NEW);
		try {
			writeTaskToJson(t);
			tasks.add(t);
			return true;
		} catch (Exception e) {
			System.out.println( "Error appending data: " + e.getMessage());
			return false;
		}
	}

	private int getMaxId() {
		int max = 0;
		for (Task t : tasks)
			if (t.getId() > max)
				max = t.getId();
		return max;
	}

	public boolean update(Task t) {
		Task toUpdate = getById(t.getId());

		if (toUpdate != null) {
			delete(toUpdate.getId());
			try {
				writeTaskToJson(t);
				tasks.add(t);
				return true;
			} catch (Exception e) {
				System.out.println("Error appending data: " + e.getMessage());
				return false;
			}
		}
		return false;
	}

	public boolean delete(int id) {
		Task t = getById(id);
		if (t != null) {
			tasks.remove(t);
			if (!cleanJSon())
				return false;
			for (Task ts : tasks) {
				try {
					writeTaskToJson(ts);
				} catch (Exception e) {
					System.out.println("Error appending data: " + e.getMessage());
					return false;
				}
			}
			return true;
		}
		return false;

	}

	public Task getById(int id) {

		for (Task task : tasks) {
			if (task.getId() == id)
				return task;
		}
		return null;
	}
    //קורא את הנתונים מקובץ הjson וממיר אותם לרשימה
	public List<Task> listAll() {
		String data = "";
		tasks = new ArrayList<Task>();
		try {
			File myFile = new File(JSON_FILE);
			Scanner myReader = new Scanner(myFile);

			while (myReader.hasNextLine())
				data += myReader.nextLine();

			myReader.close();

			data = data.replace("{", "");
			data = data.replace("}", "");

			String[] d = data.split(",");
			Task t = new Task(0);
			for (String field : d) {
				String current[] = field.split(":");
				switch (current[0]) {
				case "id":
					t = new Task(Integer.parseInt(current[1]));
					break;
				case "title":
					t.setTitle(current[1]);
					break;
				case "description":
					t.setDescription(current[1]);
					break;
				case "status":
					switch (current[1]) {
					case "DONE":
						t.setStatus(Status.DONE);
						break;
					case "IN_PROGRESS":
						t.setStatus(Status.IN_PROGRESS);
						break;
					case "NEW":
						t.setStatus(Status.NEW);
						break;
					}
					tasks.add(t);
					break;
				}
			}

		} catch (Exception e) {
			System.out.println("An error occurred:" + e.getMessage());
			e.printStackTrace();
		}
		return tasks;
	}

	

	private boolean cleanJSon() {
		try {
			new PrintWriter(JSON_FILE).close();
			return true;
		} catch (Exception e) {
			System.out.println("Error appending data: " + e.getMessage());
			return false;
		}
	}

	private void writeTaskToJson(Task t) throws Exception {
		String data = t.toJson();
		try {
			FileWriter fw = new FileWriter(JSON_FILE, true);
			BufferedWriter writer = new BufferedWriter(fw);
			writer.write(data);
			writer.close();
		} catch (IOException e) {
			throw new Exception("Error appending data: " + e.getMessage());
		}
	}

}
