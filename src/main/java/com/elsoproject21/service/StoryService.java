      package com.elsoproject21.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import com.elsoproject21.domain.Blogger;
import com.elsoproject21.domain.Story;
import com.elsoproject21.respository.BloggerRepository;
import com.elsoproject21.respository.StoryRepository;

@Service
public class StoryService {

	private StoryRepository storyRepo;
	private BloggerRepository bloggerRepo;

	@Autowired
	public void setStoryRepo(StoryRepository storyRepo) {
		this.storyRepo = storyRepo;
	}

	@Autowired
	public void setBloggerRepo(BloggerRepository bloggerRepo) {
		this.bloggerRepo = bloggerRepo;
	}

	public List<Story> getStories() {
		//init();
		return storyRepo.findAll();
	}
	

	//első story
	/*public Story getStory() {
		return storyRepo.findFirstByOrderByPostedDesc();
	}*/

	public Story getSpecificStory(String title) {
		return storyRepo.findByTitle(title);
		
	}

	/*public List<Story> getStoriesByBloggerName(String name) {
		return storyRepo.findAllByBloggerNameIgnoreCaseOrderByPostedDesc(name);
	}*/
	
	//saját mnka hibakezelés nem működik
	/*public void missingTitle(String title) throws Exception {
		if(storyRepo.findByTitle(title)== null) {
			throw new Exception("Nincs ilyen id-jú felhasználó!");
		}
	}
	
	@ExceptionHandler(Exception.class)
	public String ExceptionHandler(HttpServletRequest ra, Exception ex, Model model) {
		model.addAttribute("errMessage", ex.getMessage());
		return "404";                      		
	}*
	
	
	
	
/*@PostConstruct 
	public void init() {
		Blogger blogger = new Blogger("belső Gyula", 25);
		bloggerRepo.save(blogger);
		
		Story story = new Story("belső cím", "belső tartalom", new Date(), blogger);
		storyRepo.save(story);
		}*/

}
