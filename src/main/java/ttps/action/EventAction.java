package ttps.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import ttps.model.Category;
import ttps.model.Event;
import ttps.service.CategoryService;
import ttps.service.EventService;

import com.opensymphony.xwork2.ActionSupport;

@Namespace("/event")
public class EventAction extends ActionSupport {


	private static final long serialVersionUID = 1L;

	private long idEvent;

	@Autowired
	private EventService eventService;
	
	@Autowired
	private CategoryService categoryService;
	
	private Event event;

	private List<Category> categories;

	private List<Event> events=new ArrayList<Event>();

	public long getIdEvent() {
		return idEvent;
	}
	
	//Getters and setters

	public void setIdEvent(long idEvent) {
		this.idEvent = idEvent;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}
	
	//Actions
	
	@Action("list")
	public String list() {
		setEvents(eventService.findAll());
        return SUCCESS;
	}
	
	@Action("edit")
	public String edit() {
		setCategories(categoryService.findAll());
        return SUCCESS;
	}
	
	@Action(value = "save", results = { 
			@Result(name = SUCCESS, location = "list", type = "redirect"),
			@Result(name = "input", location = "edit.jsp")})
	public String save() {System.out.println("action");
		eventService.save(event);
        return SUCCESS;
	}
	
	@Action(value = "delete", results = { @Result(name = SUCCESS, location = "list", type = "redirect") })
	public String deleteEvent() {
		eventService.delete(idEvent);
		return SUCCESS;
	}
	
//	public void validate(){
////		if(event.getTitle()!=null){
//			if (event.getDescription().equals(""))
//				addFieldError("username", "Se requiere una descripción del evento");
//			if (event.getCategory()==null)
//				addFieldError("name", "Se requiere una categoria");
//			if (event.getPlace().equals(""))
//				addFieldError("lastName","Se requiere especificar un lugar");
//			if (event.getTitle().equals(""))
//				addFieldError("password", "Se requiere un título");
//		
//	}
}
