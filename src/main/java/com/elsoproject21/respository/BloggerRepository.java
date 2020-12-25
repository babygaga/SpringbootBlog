package com.elsoproject21.respository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
//public interface BloggerRepository {     // extends CrudRepository<Blogger, Long> - JDBC-hez nem kell
	public class BloggerRepository { //JDBC
	//List<Blogger>findAll(); JDBC-hez nem kell
	
	private JdbcTemplate jdbc;
	
	@Autowired
	public BloggerRepository(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}
	
	/*@Autowired
	public String findBlogger() {
		return "select * from Blogger where id = blogger_id";
	}*/
	
	
	
	
	
}
