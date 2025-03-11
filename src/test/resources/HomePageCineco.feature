Feature: Cinecolombia HomePage
 To Verify the main subpages available in HomePage
 Searching movies in the searchBox
 and Login with and user and password


 Background: The user navigates to Cinecolombia WebPage
 Given The user navigates to Cinecolombia WebPage


 Scenario: I can search a movie in the search box 
  When The user searchs the movie "Flow" in the search box
  Then The movie poster is displayed
 

 Scenario Outline: I can access the sections in header bar 
  When The user selects the option <section> in the header
  Then The corresponding <title> is displayed for the <section>
  Examples:
      | section     | title        |
      | Cartelera   | CARTELERA    |
      | Pronto      | PRONTO       |
      | Alternativo | Ópera        |
      | Comidas     | Comidas      |
      
      
 Scenario Outline: I can access the sections in the Menu Button
  When The user selects the menu bar
  And The user selects the option <section> in the menu bar
  Then The corresponding <title> is displayed for the <section>
  Examples:
      | section     | title        |
      | Cartelera   | CARTELERA    |
      | Pronto      | PRONTO       |
      | Multiplex   | Multiplex    |
      | Ópera       | ÓPERA        |
      | Teatro      | TEATRO       |
      | Otros       | OTROS        |
      | Menú        | Comidas      |