package model;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class TaskRepository {

	private final String JSON_FILE = "C:/Users/java/TaskManagement/src/model/Tasks.json";
	private List<Task> tasks;
	
	
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
            
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred: File not found.");
            e.printStackTrace();
        }
		
		
		return tasks;
	}
}
