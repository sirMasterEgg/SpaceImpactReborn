package space.impact.source;

public class PlayerInfo <T>{
    T playerName;

    public PlayerInfo(T playerName) {
        this.playerName = playerName;
    }

    public T getPlayerName() {
        return playerName;
    }

    public void setPlayerName(T playerName) {
        this.playerName = playerName;
    }
}
