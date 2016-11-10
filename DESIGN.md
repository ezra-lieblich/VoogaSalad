# Game authoring environment: 
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
