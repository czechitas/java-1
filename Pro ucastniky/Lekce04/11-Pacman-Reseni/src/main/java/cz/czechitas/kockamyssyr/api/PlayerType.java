package cz.czechitas.kockamyssyr.api;

public enum PlayerType {

    FOOD,
    GOOD,
    BAD;

    public boolean isCatching(PlayerType otherPlayerType) {
        if (this == BAD && otherPlayerType == GOOD) return true;
        if (this == GOOD && otherPlayerType == FOOD) return true;
        return false;
    }
}
