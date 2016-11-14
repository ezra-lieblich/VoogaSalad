# Game authoring environment: 

# Introduction
Our group will be implementing a game authoring and playing environment for tower defense games. We will need to support different types of tower defense games, such as Bloons and Plants vs. Zombies. Our design will

# Overview
At a high level, this project is divided into the "game authoring environment" and the "game player". The authoring environment will allow users to create their tower defense game and define settings. These settings and specifications will be recorded in an XML file, which will be used by the game player program to load the game and allow a user to play it. With this design, the primary means of communication between these two parts is the XML file. The only information the game player program needs to load the game is the game data, which the game authoring environment provides in the XML file. 
### Game Player
In the game player, we are dividing the work into parsing the xml file, using the data to create the game logic (back end), and displaying the game to the user (front end). The back and front ends will communicate through controllers. There will be many controllers, each of which represent a type of view. Each of these controllers will pass data and modifications between the model and the view (using observables). 
### Game Authoring

# User Interface

# Design Details

# Example Games


# Design Considerations
We will need to consider the exact information that needs to be included in the XML file. This file is meant to encompass all game data/settings that are defined by the game author, so we must decide the type of data that will be in the XML. We also need to determine how to transition from the game authoring environment to the game playing environment.

### Game Playing Environment considerations
Some design choices we considered was how to update the position of the enemies. For some types of Tower Defense games, the enemies move along a path, but in other types, the enemies move straight across the screen. We decided to use a grid to represent the space in which the enemies move, and their paths will be defined by the cells on the grid. Moving forward, we will have to decide if we want to detect collisions from the occupants of a single cell, or if two objects have the same x and y coordinates. The advantage of using the cell method is that it is easier to detect collisions, but it also requires handling the case when multiple enemies occupy the same cell.

### Game Authoring Environment considerations


program of visual tools for placing, specifying, editing, and combining general game elements together to make a particular game

## View
### Classes:
* GameConditions (number of rounds, health, money…)
* EditingInterface: Interface to create the game 
* EnemyView: Displays all of the available enemy images, contains dropdowns/input fields to set enemy settings
* WeaponView: Displays input fields for weapon settings
* TowerView: Displays input fields for tower settings
* LevelView: Dropdown to customize each level (?)

# Game Engine: 
framework of general Java classes to support any kind of game within a specific game genre
## Model
### Classes:
* Tower (abstract class?)
    * Subclasses represent tower types
    - Upgrades represented as subclasses of subclasses?
    ### Variables
    - attackRange: Determines the distance at which the tower can attack enemies
    - fireRate/frequency: Determines how much time it takes the tower to reload and fire again.
    - Weapon instance
    - Ground vs. Aerial 
    - Cost
    - Attack preference (first vs last)   
    - Image

* Weapon
    * Upgrade-able weapons?
    * Image: Image representing bullet
    * Hitbox: Hitbox to check to see if you hit enemy
    * Damage: Determines how much damage this tower inflicts on enemies
    * SlowRate: Determines how much this bullet will slow enemies
    * Piercing: Determines whether the bullet will pierce through multiple enemies    
    * Projectile Path? Curving, boomerang, etc.
    * Effect
    * Spread
    * Projectile Speed
    * Image
    * Hit effect – object representing effect on enemy after hit by certain type of projectile
    * Enemy
    * Speed
    * Image?
    * HP
    * Layering? 
    * Death effect
    * Regen?
    * Image
    * EnemyPath 
This may be auto-generated if we do “open” type
* Player: made using the game authoring environment, creates a user with # of lives, wealth, etc. 
* BattleGrid (of some sort)
* Profile (name, etc. idk)
* Terrain
* Affects how enemies move, where towers can be placed
* Water/Deadspace 
* Level
    * Numbers/types of creeps
    * Release times
    * Game Logic (how the enemies move: randomly vs. …)
    * Interval time vs. Manual Start

* Game Setting
    * Health/gameover condition (number of creeps that can pass)
    * Score?
    * Number of Levels
* Map/Board/whatever
    * Size
    * Terrains locations
    * Background image 

# Game Data: 
files, assets, preferences, and code that represent a particular game
## Classes
* XML data:
    * Tags:
        * num_towers
        * num_enemies
        * grid_position

# Game Player: 
program that loads the game data and uses the game engine to run a particular game
## View
### Classes:
* BattleGrid: Grid that contains the towers, enemies, etc.
* EventHandler: To drag and drop ALL THE THINGS
* EnemyAnimator: Handles animation of the enemy (any cool effects?), holds all of the animation effects
* WeaponAnimator: Handles animation of weapons
## Model（Back end）
* XML Loader: Loads information from game engine 
* Abstract enemy, tower classes


## Controller
* Tower Manager
* Game Setting Manager

### Model
GamePlayModel: primary class containing all game objects, updates grid
Tower: fires weapons, has cost
Enemy
Grid: represents the area of gameplay, enemies move along paths in the grid
Weapon
Cell: point on the grid, collisions of weapons and enemies occur within cells
Collision: has enemy and weapon attributes, effect of collision is updated on the enemy object


