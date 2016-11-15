package gameauthoringenvironment.view;

import gameauthoringenvironment.view.enemy.IEnemyToEngine;
import gameauthoringenvironment.view.gameconditions.IGameConditionsToEngine;
import gameauthoringenvironment.view.level.ILevelToEngine;
import gameauthoringenvironment.view.path.IPathToEngine;
import gameauthoringenvironment.view.tower.ITowerToEngine;
import gameauthoringenvironment.view.weapon.IWeaponToEngine;


/**
 * 
 * The complete interface seen by the game engine to set the different components of the game
 * design.
 *
 */
public interface IGameAuthoringToEngine
        extends IEnemyToEngine, ILevelToEngine, IPathToEngine, ITowerToEngine, IWeaponToEngine,
        IGameConditionsToEngine {

}
