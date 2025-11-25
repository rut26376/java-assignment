package model;

import java.util.ArrayList;
import java.util.List;

public class TaskService extends TaskRepository{
	
	
	public void markAsDone(int id)
	{
		Task t = getById(id);
		t.setStatus(Status.DONE);
		update(t);
	}
	
	public List<Task> searchByText(String text)
	{
	    List<Task> tsk = new ArrayList<Task>();
	    for(Task t: tasks)
	    {
	    	if(t.getTitle().contains(text) || t.getDescription().contains(text))
	    		tsk.add(t);
	    }
		return tsk;
	}
	
	public List<Task> sortByStatus()
	{
	    
	    	tasks.sort((o1, o2) -> o1.compareTo(o2));
		    return tasks;
	}

}
