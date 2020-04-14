package com.ceng.ceng351;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class Database implements DatabaseOps {
	private String user = "emre";
	private String password = "123456";
	private String host = "localhost";
	private String database = "test";
	private int port = 3306;
	
	private Connection con;
	
	public Database() {
		String url = "jdbc:mysql://" + this.host + ":" + this.port + "/" + this.database;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			this.con =  DriverManager.getConnection(url, this.user, this.password);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static DatabaseOps newInstance() {
		Database dt = new Database();
		
		return (DatabaseOps)dt;
	}
	
	@Override
	public void createTables() {
		int result;
		String query = "create table movie (" + 
					   "name varchar(50)," + 
					   "director varchar(50) not null," + 
					   "year varchar(4) not null," + 
					   "primary key (name))";
		
		try {
			Statement st = this.con.createStatement();
			result = st.executeUpdate(query);
			System.out.println(result);
			
		} catch (SQLException e) {
			// TODO 
		}
	}

	@Override
	public void dropTables() {
		int result;
		String query = "drop table if exists movie";
		
		try {
			Statement st = this.con.createStatement();
			result = st.executeUpdate(query);
			System.out.println(result);
			
		} catch (SQLException e) {
			// TODO 
		}
	}

	@Override
	public Movie getMovie(String name) {
		ResultSet rs;
		String query = "select * from movie where name = '" + name + "'";
		
		try {
			Statement st = this.con.createStatement();
			rs = st.executeQuery(query);
			while(rs.next()) {
				String m_name = rs.getString("name");
				String m_director = rs.getString("director");
				String m_year = rs.getString("year");
				
				return (Movie)new MovieObject(m_name, m_director, m_year);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}

	@Override
	public void addMovie(Movie movie) {
		int result;
		String query = "insert into movie values ('" + movie.getName() + "','" + movie.getDirectorName() + "','" + movie.getReleaseYear() + "')";
		
		try {
			Statement st = this.con.createStatement();
			result = st.executeUpdate(query);
			System.out.println(result);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void removeMovie(String name) {
		int result;
		String query = "delete from movie where name = '" + name +"'";
		
		try {
			Statement st = this.con.createStatement();
			result = st.executeUpdate(query);
			System.out.println(result);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
