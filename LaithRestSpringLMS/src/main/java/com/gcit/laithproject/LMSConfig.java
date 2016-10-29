package com.gcit.laithproject;


import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.gcit.laithproject.dao.AuthorBookDAO;
import com.gcit.laithproject.dao.AuthorDAO;
import com.gcit.laithproject.dao.BookDAO;
import com.gcit.laithproject.dao.BorrowerDAO;
import com.gcit.laithproject.dao.BranchDAO;
import com.gcit.laithproject.dao.CopiesDAO;
import com.gcit.laithproject.dao.GenreBookDAO;
import com.gcit.laithproject.dao.GenreDAO;
import com.gcit.laithproject.dao.PublisherDAO;


@EnableTransactionManagement
@Configuration
public class LMSConfig {
	private static String driver= "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost/library";
	private static String username = "root";
	private static String pass = "";
	
	
	
	
	
	@Bean
	public AuthorDAO adao(){
		return new AuthorDAO();
	}
	
	@Bean
	public BookDAO bdao(){
		return new BookDAO();
	}
	
	@Bean
	public PublisherDAO pdao(){
		return new PublisherDAO();
	}
	
	@Bean
	public AuthorBookDAO abdao(){
		return new AuthorBookDAO();
	}
	
	@Bean
	public BranchDAO brdao(){
		return new BranchDAO();
	}
	
	@Bean
	public BorrowerDAO borrodao(){
		return new BorrowerDAO();
	}
	
	@Bean
	public CopiesDAO cpdao(){
		return new CopiesDAO();
	}
	
	@Bean
	public GenreDAO gdao(){
		return new GenreDAO();
	}
	@Bean
	public GenreBookDAO gbdao(){
		return new GenreBookDAO();
	}
	
	@Bean
	public BasicDataSource dataSource(){
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName(driver);
		ds.setUrl(url);
		ds.setUsername(username);
		ds.setPassword(pass);
		return ds;
	}
	
	@Bean
	public JdbcTemplate template(){
		JdbcTemplate template = new JdbcTemplate();
		template.setDataSource(dataSource());
		
		return template;
	}
	
	@Bean
	public JdbcTemplate template(String test){
		JdbcTemplate template = new JdbcTemplate();
		template.setDataSource(dataSource());
		
		return template;
	}
	
	@Bean
	public PlatformTransactionManager txManager(){
		DataSourceTransactionManager tx = new DataSourceTransactionManager();
		tx.setDataSource(dataSource());
		
		return tx;
	}
}
