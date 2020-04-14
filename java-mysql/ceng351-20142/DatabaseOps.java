package com.ceng.ceng351;

public interface DatabaseOps {
	public void createTables();
	public void dropTables();
	public Movie getMovie(String name);
	public void addMovie(Movie movie);
	public void removeMovie(String name);
}
