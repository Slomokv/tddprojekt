<-------------------------------------------------------------------------------------------------------------->

TDD-projekt "Trailrunner", Daniel Kvist, MT24 Student

14/1:

1. Skapade SessionTest med en bild av hur Session skulle se ut (3 variabler, distance, time och date)
2. Kört testerna, Maven visar full täckning
3. Problem med Jacoco.exec


TODO:
- Fixa projektet för att fortskrida



15/1:

1. Slutligen fått ordning på projektet, skapade nytt från scratch
2. Skrev om testen för "date" i SessionTest, skapade ett eget custom datum ist för att bara testa konstruktörerna.
3. Jacoco-filen visar inga fel.
4. Lade upp projektet på GitHub


TODO:
- Påbörja steg 2, "SessionLogbook"



16/1 (1):

1. Skrivit tester för Athlete och logbook (HashMap i Athlete)
2. Skapat Athlete-klassen


TODO: 
- Skriva färdigt tester för Athlete och logbook
- Köra testerna innan jag fortskrider



16/1 (2):

1. Ändrat Athlete till Profile (som i användarprofil)
2. Byggt ut en räknare och lagt till km/h (double kmph) och kilometertid (double minPerKm)
3. Skapat en räknare som avrundar till en decimal efter uträkning av dessa
4. Testerna failade, problem i räknaren roundToOneDecimal...
5. roundToOneDecimal fungerar, upptäckte fel i konstruktorn när bSession testade i SessionTest

Reflektion:
    Kunde definitivt se nyttan i TDD innan projektstart, men det känns ganska bra
    när man ser hur fel fångas som man hade upptäckt lite senare och haft svårare att hitta


TODO:
- Fixa "konstruktor b" som automatiskt lägger in datum, så jag skapar en konstruktorkedja
- Testa färdig det sista i Session
- Därefter arbeta på att "gröna" de färdiga testerna i ProfileTest



16/1 (3):

1. Skrivit om konstruktorn för Session
2. Rundade av för varje operation för förväntat resultat på bSession kmph, avrundade endast på slutet
3. Alla tester för session godkända!


TODO:
- Skapa tester för fitnessScore
- Implementera Profile med metoder för att lägga till Sessions, och samtidigt räkna ut fitnessScore



16/1 (4):

1. Skapat tester för fitnessScore, där ett test körs för varje Session som läggs till
2. Flyttat roundToOneDecimal() till Calculator.java, skrivit ett test för denna
3. Börjat bygga addSession och calcFScore

TODO:
- Avsluta addSession, calcFScore och testa
- Skriva tester för att kunna hantera, visa och ta bort Sessions från logBook hos en Profile

