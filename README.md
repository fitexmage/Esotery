# Esotery
This game is written in Java 1.8.0 using MVC. Players need to use mouse to control the character, making them become strong and explore the world. Players do not need to use keyboard.

# File structure

## /database
* ### /data/account.json
Store every player's account
* ### /data/attribute.json
Store every player's attribute
* ### /data/condition.json
Store every player's condition
* ### /data/creature.json
Store all the creatures
* ### /data/dialog.json
Store all the dialogs
* ### /data/event.json
Store all the events
* ### /data/map.json
Store all the map
* ### /data/originalCondition.json
Store all the conditions
* ### /data/originalSkill.json
Store all the skills
* ### /data/skill.json
Store every player's skill
   
## /src/main/java/esotery
* ###  /src/main/java/timenoter/Esotery
Main class
* ###  /src/main/java/timenoter/UIController
Connect controller and view, manage element and method on view
* ###  /src/main/java/timenoter/controller
Connect model and UIController, control the process
* ###  /src/main/java/timenoter/model
Read and write data

## /src/main/resources/fxml
* ### /src/main/resources/fxml/CombatUI.fxml
Combat interface
* ### /src/main/resources/fxml/CreateUI.fxml
Character creation interface
* ### /src/main/resources/fxml/DialogUI.fxml
Dialog interface
* ### /src/main/resources/fxml/LoginUI.fxml
Login interface
* ### /src/main/resources/fxml/MapUI.fxml
Map interface
* ### /src/main/resources/fxml/NavUI.fxml
Navagation interface
* ### /src/main/resources/fxml/RegisteredUI.fxml
Register successfully interface
* ### /src/main/resources/fxml/RegisterUI.fxml
Register interface
# Dependency
### jackson-annotations-2.6.2.jar
### jackson-core-2.6.2.jar
### jackson-databind-2.6.7.1.jar

# Test
* Username: test
* Password: test
