package engine;
import engine.level.Level;

import java.util.Collections;
import java.util.List;

public class GameSettings extends AbstractType implements Game {
	private String name;
    private String gameType;
    private String backgroundImage;
    private List<String> winningConditions;
    private List<String> losingConditions;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBackgroundImage() {
        return backgroundImage;
    }

    public void setBackgroundImage(String backgroundImage) {
        this.backgroundImage = backgroundImage;
    }

    public List<String> getWinningConditions() {
        return Collections.unmodifiableList(winningConditions);
    }

    public void setWinningConditions(String winningCondition) {
        winningConditions.add(winningCondition);
    }

    public List<String> getLosingConditions() {
        return Collections.unmodifiableList(losingConditions);
    }

    public void setLosingConditions(String losingCondition) {
        losingConditions.add(losingCondition);
    }

    public String getGameType() {
        return gameType;
    }

    public void setGameType(String gameType) {
        this.gameType = gameType;
    }
}
