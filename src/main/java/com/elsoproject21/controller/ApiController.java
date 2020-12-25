package com.elsoproject21.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elsoproject21.domain.Story;
import com.elsoproject21.service.StoryService;
import com.fasterxml.jackson.annotation.JsonBackReference;

@RestController
public class ApiController { // adjuk ki az adatokat, nem szeretnék nézetet adni a projekthez csk backend-ként funkcionáljon a
								// szerverünk, nézet helyett csak adatot ad vissza
	
	private StoryService storyservice;

	@Autowired
	public void setStoryservice(StoryService storyservice) {
		this.storyservice = storyservice;
	}

	//böngészőben jasonban irja ki végtelenített adatfolyam, ezért a blogger.javaba - 	@JsonBackReference
	/*@RequestMapping("/story")
	public Story story() {
		//return storyservice.getStory().toString(); --story.javaból a tostriget kivesszük
		return storyservice.getStory();
	}*/

		@RequestMapping("/title/{title}")
	public Story searchForUser(@PathVariable(value = "title") String title) {
		//return storyservice.getSpecificStory(title).toString();
		return storyservice.getSpecificStory(title);
	}
	
	//több posztot ad viszza a blogger neve alapján
	/*@RequestMapping("/stories/{name}")
	public List	<Story> searchStoriesByBloggerName(@PathVariable(value = "name") String name) {
		//return storyservice.getSpecificStory(title).toString();
		return storyservice.getStoriesByBloggerName(name);
	}*/
}

