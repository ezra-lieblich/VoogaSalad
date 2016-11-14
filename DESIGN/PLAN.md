
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

