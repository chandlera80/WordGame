package controllers;

import models.Words;
import play.data.DynamicForm;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Random;

public class GameController extends Controller
{

        private FormFactory formFactory;

      @Inject
    public GameController(FormFactory formFactory)
    {
        this.formFactory = formFactory;
    }

    public Result getStart()
    {
        return ok(views.html.start.render());
    }

    public Result getFirstStory()
    {
        Words words = new Words();
        words.setPlace1("prison");
        words.setAdjective1("stressful");
        words.setNoun1("machete");
        words.setNoun2("pit of bodies");
        words.setVerbPastTense("high-fived");
        words.setPlace2("The basement");

        return ok(views.html.story.render(words));
    }

    public Result getSecondStory()
    {
        Words words = new Words();
        words.setPlace1("Carnival");
        words.setAdjective1("dramatic");
        words.setNoun1("wooden leg");
        words.setNoun2("bog of eternal stench");
        words.setVerbPastTense("audited");
        words.setPlace2("Wal-mart");

        return ok(views.html.story.render(words));
    }

    public Result getThirdStory()
    {
        Words words = new Words();
        words.setPlace1("Parking Lot");
        words.setAdjective1("festering");
        words.setNoun1("figit spinner");
        words.setNoun2("cotton candy machine");
        words.setVerbPastTense("bludgeoned");
        words.setPlace2("the Land of OZ");

        return ok(views.html.story.render(words));
    }

    public Result getRandomStory()
    {
        ArrayList<String> place = new ArrayList<>();
        place.add ("Miami");
        place.add ("Hades");
        place.add ("Your Mom's");
        place.add ("Saks 5th Avenue");
        place.add  ("the Matrix");
        place.add  ("the BatCave");
        place.add ("Ohio");
        place.add  ("the Kardashian house");

        Random random = new Random();
        int randomPlaceIndex = random.nextInt(place.size());
        String place1 = place.get(randomPlaceIndex);
        randomPlaceIndex = random.nextInt(place.size());
        String place2 = place.get(randomPlaceIndex);

        ArrayList<String> noun = new ArrayList<>();
        noun.add ("pinball machine");
        noun.add ("pasta maker 5000");
        noun.add ("angry great Dane");
        noun.add ("crying kindergartener");
        noun.add  ("hospital gurney");
        noun.add  ("magic wand");
        noun.add ("cigarette machine");
        noun.add  ("Donald Trump's hair piece");


        int randomNounIndex = random.nextInt(noun.size());
        String noun1 = noun.get(randomNounIndex);
        randomNounIndex = random.nextInt(noun.size());
        String noun2 = noun.get(randomNounIndex);

        ArrayList<String> adjective = new ArrayList<>();
        adjective.add ("elderly");
        adjective.add ("decrepit");
        adjective.add ("glittery");
        adjective.add ("tragic");
        adjective.add  ("sickly");
        adjective.add  ("bloated");
        adjective.add ("stale");
        adjective.add  ("fancy-pants");


        int randomAdjectiveIndex = random.nextInt(adjective.size());
        String adjective1 = adjective.get(randomAdjectiveIndex);





        ArrayList<String> verb = new ArrayList<>();
        verb.add ("slapped");
        verb.add ("dressed");
        verb.add ("drove over");
        verb.add ("tickled");
        verb.add  ("kicked");
        verb.add  ("pinched");
        verb.add ("sang to");
        verb.add  ("danced over");

        int randomVerbIndex = random.nextInt(verb.size());
        String verb1 = verb.get(randomVerbIndex);
        randomVerbIndex = random.nextInt(verb.size());

        Words words = new Words();
        words.setPlace1(place1);
        words.setAdjective1(adjective1);
        words.setNoun1(noun1);
        words.setNoun2(noun2);
        words.setVerbPastTense(verb1);
        words.setPlace2(place2);


        return ok(views.html.story.render(words));

    }
    public Result getMyOwnStory()
    {
        return ok(views.html.selectwords.render());

    }
    public Result postMyOwnStory()
    {
        DynamicForm form = formFactory.form().bindFromRequest();

        String place1 = form.get("place1");
        String adjective1 = form.get("adjective1");
        String noun1 = form.get("noun1");
        String noun2 = form.get("noun2");
        String verb1 = form.get("verb1");
        String place2 = form.get("place2");

        Words words = new Words();
        words.setPlace1(place1);
        words.setAdjective1(adjective1);
        words.setNoun1(noun1);
        words.setNoun2(noun2);
        words.setVerbPastTense(verb1);
        words.setPlace2(place2);


        return ok (views.html.story.render(words));
    }
}

