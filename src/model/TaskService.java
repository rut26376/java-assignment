package model;

import java.util.ArrayList;
import java.util.List;

public class TaskService{
	
	private TaskRepository tr;
	public TaskService(TaskRepository tr)
	{
		this.tr = tr;
	}
	public void markAsDone(int id)
	{
		Task t = tr.getById(id);
		t.setStatus(Status.DONE);
		tr.update(t);
	}
	
	public List<Task> searchByText(String text)
	{
	    List<Task> tsk = new ArrayList<Task>();
	    for(Task t: tr.getTasks())
	    {
	    	if(t.getTitle().contains(text) || t.getDescription().contains(text))
	    		tsk.add(t);
	    }
		return tsk;
	}
	
	public List<Task> sortByStatus()
	{
	    
	    	tr.getTasks().sort((o1, o2) -> o1.compareTo(o2));
		    return tr.getTasks();
	}

}
