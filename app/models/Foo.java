package models;

import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Foo extends Model {

	@Id
	public String id;
	
	public String name;
	
	public static Finder<String,Foo> find = new Finder<String,Foo>(
		    String.class, Foo.class
		  );
}
