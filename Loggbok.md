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


17/1 (1):

1. Tänkt om kring tester av calcFScore, skapar mockad Profile för att se att klassen beter sig rätt
2. Insett under tiden jag implementerat calcFScore och dess undermetoder att jag behöver skriva om testerna för att matcha ny input
3. Lagt till en variabel "keyChain" i form av en ArrayList innehållande alla nycklar till logBook


Reflektion:
    Det har blivit väldigt mycket refaktorisering på addSession och calcFScore då jag inte tittat långt nog ner på listan i tid.
    Som jag har förstått, är det enligt process, men jag tittar hellre längre ner på listan oftare nästa gång.


TODO:
- Klura ut tidsdiff till variabel i dagar på två olika LocalDate-objekt.
- Skriva om tester samt nya för att matcha ny funktionalitet hos addSession, calcFScore och undermetoder


17/1 (2):

1. Skrivit ytterligare en metod timeBetweenDays som plockar antalet dagar mellan två sessioner, även om det gått flera år


TODO:
- Göra en smart metod som tar ut LocalDates från de två senast inlagda sessionerna i profilens logBook


18/1 (1):

1. Flyttat timeBetweenDays och fScoreFormula till Calculator
2. Lagt till de sista underfunktionerna som behövs för att smidigt köra calcFScore

TODO:
- Köra testerna för Profile, och lägga till tester för undermetoder. Lär använda mocks


18/1 (2):

1. Kört testerna för Profile, hittade lite glömda detaljer i både test och konstruktorn
2. Fixat konstruktor och test, gått från 31% till 77% täckning i Profile
3. Dock endast två tester som misslyckas, resten av koden saknar täckning för tillfället
4. Saknar exceptionhandling, men Exceptions uppstår troligtvis av dålig logik i metoder


TODO:
- Täcka resten av koden i Calculator och Profile med tester
- Söka efter dålig logik, refaktorera


18/1 (3):

1. Fått upp täckningen, men har problem med något indexOutOfBounds som jag sökt efter förgäves
2. Städat upp andra problem som väntade på att hända i Profile, och har rättat och lagt till saker i ProfileTest

TODO:
- Hitta vad, var och varför index hamnar out of bounds...

3. 1 - 2 = -1, inte 1...

TODO:
- Lös problemet med mockprofilen mcProfile, hur mockobjekt fungerar

4. Mock fungerar inte alls som jag förstått med mcProfile, men det fungerar nu
5. 92% täckning i Profile uppnådd, saknar bara removeSession och därmed sista if-satsens täckning i calcFScore

TODO:
- Implementera removeSession
- Städa upp i addSession, calcFScore och lastSession


19/1 (1):

1. Ökat täckning och slagit ihop add/removeSession och calcFScore
2. Städat upp i profile, implementerat removeSession
3. Får inte removeSession att ta bort målelementet i testUser.logBook

TODO:
- Ändra removeSession så jag kan använda mock för att kolla vilken beslutsgren som faktiskt exekveras i removeSession


19/1 (2):

1. 4 timmar in, med lite hjälp, förstod jag felet med villkoret i if-satsen i for-loopen i removeSession
2. Verkar vara java-problem, då "1" != "1" enligt programmet, trots att båda fungerar att använda och få samma output, men inte bra nog för villkoret i if-satsen (huvudvärk deluxe)
3. Integer.parseInt för att kringgå detta, fult men det fungerar
4. Kraven möts fortfarande för uppgiften

TODO:
- Tester för filter, avgKmph, totalDistance
- Test för fScoreFormula som resulterar i mindre än noll (eller värre, divisioner med noll), som ska hanteras
- Implementera spärrar för att lägga in ogiltiga time och distance (negativa värden)


20/1 (1):

1. Skrivit tester för totalDistance och avgKmph
2. Testerna körda och misslyckade
3. Åtgärdade snabbt, förstod inte syntaxet helt, igen...
4. Täckning 98%, testerna godkända

TODO:
- Tester för filter
- Test för fScoreFormula som resulterar i mindre än noll (eller värre, divisioner med noll), som ska hanteras
- Test för print för löprundor by id
- Implementera spärrar för att lägga in ogiltiga time och distance (negativa värden)


20/1 (2):

1. Kört tester för filtermetoderna, alla gröna utom filteredByTime
2. Refaktorerat metoderna för filtren, bra täckning
3. Instansierar Calculator överallt istället för att ha statiska metoder

TODO:
- Test för print
- Försöka få med ID i filtrerade logBooks
- Test för fScoreFormula

20/1 (3):

1. Lade till ID:t som en variabel i själva Sessionerna, för att underlätta printandemetoderna
2. Skapade tester för printLog-metoder, skapade en variant som inte tog några argument, och en som tog en ArrayList, med hänsyn till filter-metoderna
3. Implementerat printLog() och printLog(arrayList), samt sessionToString i Calculator
4. Alla tester godkända, försöker brainstorma sätt att få det att misslyckas, men allt ser faktiskt bra ut. Nån gång måste vara den första!
5. Täckning saknas för printLog() och printLog(arrayList) vad jag än gör

Reflektion:
Undrar om kodtäckningen ballar ur när man testar overloadade metoder? Skulle förklara täckningen

TODO:
- Skriva tester för testFScore, checkmetoderna som kollar att filtergränserna är okej för filtermetoderna
- Fixa jacoco.exec, igen... något hände när jag tog bort HelloWorld med main()


20/1 (4):

1. CalculatorTest har täckt checkIfBelowZero och checkIfLower till belåtenhet, testerna godkända
2. calcFScore är täckt, låter den vara pga deadline

TODO:
- Fixa jacoco.exec
