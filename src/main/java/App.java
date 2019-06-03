import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App{

    public static void main(String[] args){

        staticFileLocation("/public");
        String layout = "templates/layout.vtl";

        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("template", "templates/index.vtl");
            return new ModelAndView(model,layout);
        }, new VelocityTemplateEngine());

        get("/form", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("species", Species.all());
            model.put("template", "templates/form.vtl");
            return new ModelAndView(model,layout);
        }, new VelocityTemplateEngine());

        get("/sightings", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("template", "templates/sightings.vtl");
            return new ModelAndView(model,layout);
        }, new VelocityTemplateEngine());

        post("/species", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            String name = request.queryParams("name");
            int population =Integer.parseInt(request.queryParams("population"));
            boolean endangered =Boolean.parseBoolean(request.queryParams("endangered")) ;
            Species species = new Species(name,population,endangered);
            species.save();
            model.put("species", Species.all());
            model.put("template", "templates/index.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        post("/ranger" , (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            String name = request.queryParams("name");
            int badge = Integer.parseInt(request.queryParams("badge"));
            Ranger ranger = new Ranger(name, badge);
            ranger.save();
            model.put("template", "templates/index.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        post("/animal", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            String name = request.queryParams("name");
            int species_id = Integer.parseInt(request.queryParams("species_id"));
            String age = request.queryParams("age");
            String health = request.queryParams("health");
            Animal animal = new Animal(name, species_id, age, health);
            animal.save();
            model.put("template", "templates/index.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());
    }




}