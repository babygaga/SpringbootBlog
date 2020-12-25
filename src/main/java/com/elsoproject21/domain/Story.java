package com.elsoproject21.domain;

import java.util.Date;



//@Entity() //name="stories" - más nevet lehet adni neki - JDBC-hez nem kell
public class Story {  //POJO
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	//@Id
	private Long id;  //ab-hoz
	//@Column( length=1000) // name="cím" -  ab-ben 1000 karakter
	private String title;
	//@Column(columnDefinition="Text")  //AB-ben text adattipus
	private String content;
	private Date posted;
	//@ManyToOne
	private Blogger blogger;
	
	
	public Story() {
		
	}
	
	//JDBC-hez
	public Story(Long id, String title, String content, Date posted, Long bloggerId) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.posted = posted;
		this.blogger = new Blogger (bloggerId, "Krisz", 21);
	}
	
	
	public Story(String title, String content, Date posted, Blogger blogger) {

		this.title = title;
		this.content = content;
		this.posted = posted;
		this.blogger = blogger;
	}


	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	

	public Date getPosted() {
		return posted;
	}
	
	public void setPosted(Date posted) {
		this.posted = posted;
	}

	public Blogger getBlogger() {
		return blogger;
	}

	public void setBlogger(Blogger blogger) {
		this.blogger = blogger;
	}

	/*@Override
	public String toString() {
		return "story [title=" + title + "]";
	}*/
	
	

}
