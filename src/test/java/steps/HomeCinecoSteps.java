package steps;

import org.testng.Assert;

import io.cucumber.java.en.*;
import pages.CarteleraPage;
import pages.CinecoAlternativoPage;
import pages.ComidasPage;
import pages.HomeCinecoPage;
import pages.MoviePage;
import pages.ProntoPage;

public class HomeCinecoSteps {

    HomeCinecoPage homeCinecoPage = new HomeCinecoPage();
    CarteleraPage carteleraPage = new CarteleraPage();
    ProntoPage prontoPage = new ProntoPage();
    CinecoAlternativoPage cinecoAlternativoPage = new CinecoAlternativoPage();
    ComidasPage comidasPage = new ComidasPage();
    MoviePage moviePage = new MoviePage();

    @Given("The user navigates to Cinecolombia WebPage")
    public void theUserNavigatesToCinecolombiaWebPage(){
        homeCinecoPage.navigateToCinecoWebPage();
        System.out.println("La Página de Cinecolombia está cargando");
        homeCinecoPage.cleanAllInitialPage();
        System.out.println("Se limpian alertas y mensajes que interfieran");
    }

    @When("The user selects the option {word} in the header")
    public void theUserSelectsTheOptionCartelera(String sectionSelected){
        homeCinecoPage.selectHeaderOption(sectionSelected);
        System.out.println("Se ha seleccionado una opcion de navegacion del header");
    }

    @Then("The corresponding {word} is displayed for the {word}")
    public void theCorrespondingTitleIsDisplayed(String expectedTitle, String section){
        String actualTitle = carteleraPage.returnTextOfTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));
        System.out.println("Se ha verificado que el título de la sección aparezca en la nueva página");
        //Assert.assertEquals(actualTitle, expectedTitle);
    }

    @When("The user selects the menu bar")
    public void theUserSelectsTheMenuBar(){
        homeCinecoPage.selectTheMenuButton();
        System.out.println("Se ha seleccionado la barra de Menú");
    }

    @And("The user selects the option {word} in the menu bar")
    public void theUserSelectsTheOptionInTheMenuBar(String sectionSelected){
        homeCinecoPage.selectMenuOption(sectionSelected);
        System.out.println("Se ha seleccionado una seccion de navegacion en la barra de Menú");
    }

    @When("The user searchs the movie {string} in the search box")
    public void theUserSearchsTheMovieInTheSearchBox(String movieTitle){
        homeCinecoPage.searchMovieinSearchBox(movieTitle);
        System.out.println("Se ha buscado una película en la barra de búsqueda");
    }

    @Then("The movie poster is displayed")
    public void theMoviePosterIsDisplayed(){
        Assert.assertTrue(moviePage.isPosterPresent());
        System.out.println("Se ha verificado que el poster de la película exista");
    }
    
}
