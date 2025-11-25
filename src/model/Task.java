package model;



public class Task implements Comparable<Task> {

	private int id;
	private String title;
	private String description;
	private Status status;
	
	//אין אפשרות ליצור ישירות משימה אלא רק דרך add()
    Task(int id, String title, String description, Status status) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.status = status;
	}
	//c- tor בהרשאה דיפולטיבית כדי למנוע יצירת משימה רק עם ID במקומות שאין הרשאה לכך
     Task(int id)
	{
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	
	public String toJson()
	{
		return "{\nid:" + id + ",\ntitle:"  + title + ",\ndescription:" + description + ",\nstatus:" + status + "\n},\n";
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", title=" + title + ", description=" + description + ", status=" + status + "]";
	}

	@Override
	public int compareTo(Task t) {
		
		if(t.status.equals(status))
		return 0;
		if(status == Status.DONE || (status == Status.IN_PROGRESS && t.getStatus() == Status.NEW))
			return 1;
		
		return -1;
	}
	
	
	
}
