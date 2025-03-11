package pages;

public class MoviePage extends BasePage {
    
    public MoviePage(){
        super(driver);
    }

    String posterMovie = "//figure[@class=\"movie-banner-poster\"]";

    public boolean isPosterPresent(){
        return isElementPresent(posterMovie);
    }
    
}
