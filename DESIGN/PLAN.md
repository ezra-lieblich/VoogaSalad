# Introduction
Our group will be implementing a game authoring and playing environment for tower defense games. We will need to support different types of tower defense games, such as Bloons and Plants vs. Zombies. Our design will

# Overview
At a high level, this project is divided into the "game authoring environment" and the "game player". The authoring environment will allow users to create their tower defense game and define settings. These settings and specifications will be recorded in an XML file, which will be used by the game player program to load the game and allow a user to play it. With this design, the primary means of communication between these two parts is the XML file. The only information the game player program needs to load the game is the game data, which the game authoring environment provides in the XML file. 
### Game Player
In the game player, we are dividing the work into parsing the xml file, using the data to create the game logic (back end), and displaying the game to the user (front end). The back and front ends will communicate through controllers. There will be many controllers, each of which represent a type of view. Each of these controllers will pass data and modifications between the model and the view (using observables). 
### Game Authoring

# User Interface

# Design Details
Game Player: The game player group is divided into two subsections: Frontend and Backend. For the basic implementation, front end is charge of the view portion of the game player. Specifically, front end is in charge of rendering the game as well as allowing users to interact with the game player to play the game/advance levels. The backend is in charge of parsing the xml created by users and then updating logic of all enemies, towers and game settings. 

Lucy Zhang's Modules: In charge of user interactivity with the game. Working on DragDrop, DragDropView and GameGUI. Has dependencies with the gameplayer controller and backend modeling. 

Ben Linde's Modules: In charge of grid updating. Working on GridGUI. Has dependencies with GameGUI and back end modeling. 

Yumin Zhang's Modules: In charge of updating logic for game player. Has dependencies with GameGUI and the controller. 

Naijiao Zhang's modules: In charge of xml parsing and integration with the backend and frontend of game player. Has dependencies with the gameauthoringenvirontment. 

Ezra Liebelich: Representation and controller of level specific data. Will write classes representing towers and weapons.

Sean Hudson: Focused primary on representation and control of data for the general game; will also write object representing data for enemies.

Andrew Bihl: Working on connecting the backend to the frontend and coordinating backend components; will also work on the xml writing process. 

Diane Hadley: Will design the visual interface for graphically creating the map, terrain, and path/tower/enemy appearances as well as other visual things. 

Kayla Schulz: Will design the process for setting rules and game settings. 

Aaron Chang: Working on updating backend logic for updating movement in the game player. 

# Example Games


# Design Considerations
We will need to consider the exact information that needs to be included in the XML file. This file is meant to encompass all game data/settings that are defined by the game author, so we must decide the type of data that will be in the XML. We also need to determine how to transition from the game authoring environment to the game playing environment.

### Game Playing Environment considerations
Some design choices we considered was how to update the position of the enemies. For some types of Tower Defense games, the enemies move along a path, but in other types, the enemies move straight across the screen. We decided to use a grid to represent the space in which the enemies move, and their paths will be defined by the cells on the grid. Moving forward, we will have to decide if we want to detect collisions from the occupants of a single cell, or if two objects have the same x and y coordinates. The advantage of using the cell method is that it is easier to detect collisions, but it also requires handling the case when multiple enemies occupy the same cell.

### Game Authoring Environment considerations
