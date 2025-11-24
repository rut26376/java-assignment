package model;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskRepository {

	private final String JSON_FILE = "C:/Users/java/TaskManagement/src/model/Tasks.json";
	private List<Task> tasks;
	
	public TaskRepository()
	{
		this.tasks = new ArrayList<Task>();
	}
	
	
	public String Add(int id , String title , String description)
	{
		if(getById(id) != null)
		{
			return "Error: Id already exists, try again";
		}
		else
		{
			Task t = new Task(id , title , description , Status.NEW);
			String data = t.toJson();
			 try  {
				 FileWriter fw = new FileWriter(JSON_FILE, true);
	             BufferedWriter writer = new BufferedWriter(fw);
		         writer.write(data);
		         writer.close();
		        } catch (IOException e) {
		           return "Error appending data: " + e.getMessage();
		        }
			
			return "The task was created successfully.";
		}
		
	}
	
	
	public Task getById(int id)
	{
		ListAll();
		for(Task task :tasks)
		{
			if(task.getId() == id)
				return task;
		}
		return null;
	}
	
	
	
	
	
	
	
	public List<Task> ListAll()
	{
		String data = "";
		try {
			File myFile = new File(JSON_FILE);
            Scanner myReader = new Scanner(myFile);
            
            while (myReader.hasNextLine()) 
                data += myReader.nextLine();
   
          myReader.close();
            
          data = data.replace("{", "");
          data = data.replace("}", "");
            
          String [] d =  data.split(",");
          Task t = new Task();;
          for(String field : d)
          {
       	  String current [] = field.split(":");
       	  switch(current[0])
       	  {
       	  case "id":
       		  t = new Task();
       		  t.setId(Integer.parseInt(current[1]));
       	      break;
       	  case "title":
       		  t.setTitle(current[1]);
       		  break;
       	  case "description":
       		  t.setDescription(current[1]);
       		  break;
       	  case "status":
       		  switch(current[1])
       		  {
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
}
