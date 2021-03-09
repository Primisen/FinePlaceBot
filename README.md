 # Application "FinePlaceBot"
 ### ***Description:***
Application controls "FinePlaceBot" telegram bot: user enter some city, 
and chat-bot returns tourist places in this city.
Also, this application works as a REST-ful WebService to provide access to the database.

 ### ***Run:***
1. Download this repository
2. Run the command `sudo mysql < tourist_guide.sql` to create database
3. Build application: `mvn package spring-boot:repackage` 
3. Run application: `java -jar target/tourist-guide-by-cities-bot-1.0-SNAPSHOT.jar`  

  
   *Telegram bot name:* FinePlaceBot  
   *Telegram bot token:* 1658052423:AAFTM8X9cQF_uyqe3nyE5zeKcwgLqrJZ_1g

 ### ***Use:***

*Telegram bot*:
1. Find telegram bot "FinePlaceBot"
2. Enter the name of the city (in russian) that the telegram bot offers

*RESTful Web Service*:

| Description     | HTTP Method and Path                                      |Example                                                  |
| --------------- |:---------------------------------------------| --------------------------------------------------------|
| Get all places  | `GET /place/`                                |                                                         |
| Get place by ID | `GET /place/{id}/`                           | `/place/23/`                                            |
| Add new place   | `POST /place?name=place_name&city=city_place`| `/place/?name=Красный костел&city=Миоры`                |
| Change place    | `PUT /place/{id}?name=changed_name`          | `/place/23&name=Костел Вознесения Пресвятой Девы Марии` |
| Delete place    | `DELETE /place/{id}`                         | `/place/23`                                             |
