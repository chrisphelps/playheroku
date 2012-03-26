package controllers;

import java.util.ArrayList;
import java.util.List;


import models.Foo;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.foo;
import views.html.foolist;

import play.data.Form;
import play.db.ebean.Model;
import play.libs.Json;

public class MyController extends Controller {
	public static Result foo() {
	    return ok(foo.render());
	  }
	
	public static Result foo2(String name) {
		return ok(foo.render());
	}
	
	public static Result getFoos() {
		List<Foo> foos = Foo.find.all();
		
		return ok(foolist.render(foos));
	}
	
	public static Result getFoosJson() {
		List<Foo> foos = Foo.find.all();
		
		return ok(Json.toJson(foos)).as("application/json");  //Json utils package
	}
	
	public static Result addFoo() {
		Form<Foo> form = form(Foo.class).bindFromRequest();
		Foo foo = form.get();
		foo.save();    //get from extending Model
		
		return redirect(routes.MyController.foo());
	}
}
