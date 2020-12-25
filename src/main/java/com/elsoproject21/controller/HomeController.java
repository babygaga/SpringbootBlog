package com.elsoproject21.controller;


import java.util.Locale;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.elsoproject21.service.StoryService;

import org.springframework.web.bind.annotation.ExceptionHandler;

@Controller
public class HomeController {
	
	private StoryService storyservice;
	
	@Autowired
	public void setStoryservice(StoryService storyservice) {
		this.storyservice = storyservice;
	}

	@RequestMapping("/")
	public String stories(Model model, Locale locale) {  
		model.addAttribute("pageTitle", "Minden napra egy SFJ stori");
		model.addAttribute("stories", storyservice.getStories());
		System.out.println(String.format("Request received. Language: %s, Country: %s %n", locale.getLanguage(), locale.getDisplayCountry()));              
		return "stories";
	}
	
	//első story
	//nem szeretnék nézetet adni a projekthez csk backend-ként funkcionáljon a szerverünk
	/*@RequestMapping("/story")
	public String stories(Model model) {  
		model.addAttribute("pageTitle", "Minden napra egy SFJ stori");
		model.addAttribute("story", storyservice.getStory());		                                  
		return "story";
	}*/
	
	//user id alapján keresés a weboldal url beírásakor
	/*@RequestMapping("/user/{id}")
		 throws Exception {  
		if( id == null) {
			throw new Exception("Nincs ilyen id-jú felhasználó!");
		}
		return "user"; 
	}*/
	
	//title alapján keresés
	//nem szeretnék nézetet adni a projekthez csk backend-ként funkcionáljon a szerverünk
	/*@RequestMapping("/title/{title}")
	public String searchForUser(@PathVariable(value="title") String title, Model model) throws Exception {  
		if( title == null) 
			throw new Exception("Nincs ilyen címmel storink!");
			model.addAttribute("story", storyservice.getSpecificStory(title));
		return "story";
	}*/
	
	@ExceptionHandler(Exception.class)
	public String ExceptionHandler(HttpServletRequest ra, Exception ex, Model model) {
		model.addAttribute("errMessage", ex.getMessage());
		return "404";                      
	
		
	}
	

	//storyservice miatt nem kell
	/*private List<Story> getStories() {
		 //ArrayList<Story> stories = new  ArrayList<Story>();
		List<Story> stories = storyRepo.findAll(); 
		
		 Story story1 = new Story();
		 story1.setTitle("Első story");
		 story1.setPosted(new Date(120,11,10));
		 story1.setAuthor("Krisz");
		 story1.setContent("<p>Na ez az adat már éles adat!</p>");
		 
		 Story story2 = new Story();
		 story2.setTitle("Második story");
		 story2.setPosted(new Date(120,10,1));
		 story2.setAuthor("Gyula");
		 story2.setContent("<p>Gyula örténete senkit nem érdekel</p>");
		 
		 
		 stories.add(story1);
		 stories.add(story2);
		 
		 return stories;
	}*/
}
