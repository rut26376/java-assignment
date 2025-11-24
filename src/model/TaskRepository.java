package model;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskRepository {

	private final String JSON_FILE = "C:/Users/java/TaskManagement/src/model/Tasks.json";
	private List<Task> tasks  = new ArrayList<Task>();
	
	
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
       		  case " DONE":
       			  t.setStatus(Status.DONE);
       			  break;
       		  case " IN_PROGRESS":
       			  t.setStatus(Status.IN_PROGRESS);
       			  break;
       		  case " NEW":
           		  t.setStatus(Status.NEW);
           		  break;
       		  }
       		  tasks.add(t);
       		  break;
       	  }
          }
           
            
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred: File not found.");
            e.printStackTrace();
        }
		
		
		return tasks;
	}
}
