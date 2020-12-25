package com.elsoproject21.respository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.elsoproject21.domain.Blogger;
import com.elsoproject21.domain.Story;

@Repository  //story objektumokat akarunk visszadni a blogger neve alapján avaló keresésnél
//public interface StoryRepository  {   //extends CrudRepository<Story, Long> - JDBC-hez nem kell
	public class StoryRepository  {   //JDBC
	
	private JdbcTemplate jdbc;
	
	@Autowired
	public StoryRepository(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}

	public List<Story> findAll() {
		String sql ="select * from story order by posted desc";
		return jdbc.query(sql, (rs, i) -> new Story(
				rs.getLong("id"),
				rs.getString("title"),
				rs.getString("content"),
				rs.getDate("posted"),
				rs.getLong("blogger_id")
				));
	}
	
//title alapján keresés a böngészőben /title/szia
	public Story findByTitle(String title) {
		String sql = "select * from story where title = ? order by posted";
		return jdbc.queryForObject(
				sql,
				new Object[]{title},
				new RowMapper<Story>() {
					public Story mapRow(ResultSet rs, int rowNum) throws SQLException {
		                Story story = new Story();
		                story.setId( rs.getLong("id") );
		                story.setTitle( rs.getString("title") );
		                story.setContent( rs.getString("content") );
		                story.setPosted( rs.getDate("posted") );
		                story.setBlogger( new Blogger(rs.getLong("blogger_id"),"Krisz",25) );
		    			return story;
		            }
				}
		);	
	}
	
	
	//Select * fromStory
	//List<Story> findAll(); -JDBC-hez nem kell
	
	//Select *from Story where posted in (Select max(posted) from Story) limit 1
	//Story findFirstByOrderByPostedDesc();// első story -JDBC-hez nem kell
	
	//JPA saját sql lekérdezéssel
	//@Query(value ="select * from story where title = ?1 limit 1", nativeQuery=true) //"" esetén jpql lekérdezés, mely az eredményre objektumként tekint nem sorként mint az sql, sql-hez kell a nativequerry=true
	//Story findByTitle(String title);
	//@Query(value ="select * from story where title = :title limit 1", nativeQuery=true)
	//jpql
	//@Query(value ="select s from Story s  where s.title = :title") - JDBC-hez nem kell
	//Story findByTitle(@Param("title") String title);
	
	//List<Story> findAllByBloggerNameIgnoreCaseOrderByPostedDesc(String name);//IgnoreCase - ne legyen case sensitive a blogger neve keresésénél -JDBC-hez nem kell
}
