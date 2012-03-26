package controllers;

import java.util.ArrayList;
import java.util.List;


import models.Foo;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.foo;

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
//		Foo foo = new Foo();
//		foo.id = "1";
//		foo.name = "foo";
//		
//		List<Foo> foos = new ArrayList<Foo>();
//		foos.add(foo);
		
		List<Foo> foos = Foo.find.all();
		
		return ok(Json.toJson(foos));  //Json utils package
	}
	
	public static Result addFoo() {
		Form<Foo> form = form(Foo.class).bindFromRequest();
		Foo foo = form.get();
		foo.save();    //get from extending Model
		
		return redirect(routes.MyController.foo());
	}
}
