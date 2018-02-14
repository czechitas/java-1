package cz.czechitas.angrybirds.engine;

public abstract class AbstractLevel {

    protected abstract void setupLevel();

    protected abstract void run();

    public abstract String getInfo();
}
