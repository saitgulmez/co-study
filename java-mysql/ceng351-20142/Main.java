package com.ceng.ceng351;

public class Main {

	public static void main(String args[]) {
		DatabaseOps ops = Database.newInstance();
		
		//ops.createTables();
		// ops.dropTables();
		Movie m = new MovieObject("Flight", "Robert Zemeckis", "2012");
		ops.addMovie(m);
		// ops.removeMovie("Flight");
	
		//Movie mv = ops.getMovie("Flight");
		//System.out.println(mv.getName() + " - " + mv.getDirectorName() + " - " + mv.getReleaseYear());
	}
}
