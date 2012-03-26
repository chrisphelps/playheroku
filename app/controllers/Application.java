package controllers;

import play.*;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {
  
  public static Result index() {
    return ok(index.render("Your new application is tehbomb."));
  }
 
  public static Result hello(String foo, String bar) {
	  return ok("hello " + foo + " from " + bar);
  }
  
}