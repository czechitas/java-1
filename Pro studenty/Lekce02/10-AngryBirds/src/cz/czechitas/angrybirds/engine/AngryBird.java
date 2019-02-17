package cz.czechitas.angrybirds.engine;

import java.io.*;
import javax.imageio.*;
import javax.swing.*;
import net.sevecek.util.*;

public class AngryBird extends GenericTile {

    private Engine engine;
    private GameBoard gameBoard;
    private Direction direction;
    private ImageIcon uiRightSprite;
    private ImageIcon uiLeftSprite;
    private ImageIcon uiUpSprite;
    private ImageIcon uiDownSprite;

    public AngryBird(Engine engine, GameBoard gameBoard) {
        super(gameBoard, null);
        this.engine = engine;
        this.gameBoard = gameBoard;
        String uiRightSpriteFilename = "cz/czechitas/angrybirds/images/AngryBird-right.png";
        String uiLeftSpriteFilename = "cz/czechitas/angrybirds/images/AngryBird-left.png";
        String uiDownSpriteFilename = "cz/czechitas/angrybirds/images/AngryBird-down.png";
        String uiUpSpriteFilename = "cz/czechitas/angrybirds/images/AngryBird-up.png";
        ClassLoader loader = this.getClass().getClassLoader();
        try (InputStream rightStream = loader.getResourceAsStream(uiRightSpriteFilename);
             InputStream leftStream = loader.getResourceAsStream(uiLeftSpriteFilename);
             InputStream upStream = loader.getResourceAsStream(uiUpSpriteFilename);
             InputStream downStream = loader.getResourceAsStream(uiDownSpriteFilename)) {
            uiRightSprite = new ImageIcon(ImageIO.read(rightStream));
            uiLeftSprite = new ImageIcon(ImageIO.read(leftStream));
            uiUpSprite = new ImageIcon(ImageIO.read(upStream));
            uiDownSprite = new ImageIcon(ImageIO.read(downStream));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void setState(int x, int y, Direction direction) {
        setPosition(x, y);
        setDirection(direction);
    }

    void setDirection(Direction direction) {
        this.direction = direction;
        if (direction == Direction.UP) {
            setSprite(uiUpSprite);
        } else if (direction == Direction.RIGHT) {
            setSprite(uiRightSprite);
        } else if (direction == Direction.DOWN) {
            setSprite(uiDownSprite);
        } else if (direction == Direction.LEFT) {
            setSprite(uiLeftSprite);
        }
        super.repaint();
    }

    public void move() {
        engine.addCommand(new MoveCommand(this));
    }

    public void turnRight() {
        engine.addCommand(new TurnCommand(this, TurnDirection.RIGHT));
    }

    public void turnLeft() {
        engine.addCommand(new TurnCommand(this, TurnDirection.LEFT));
    }

    public boolean canMoveForward() {
        ThreadUtils.sleep(50L);
        int x = getX();
        int y = getY();
        if (direction == Direction.LEFT) {
            x = x - 1;
        }
        if (direction == Direction.RIGHT) {
            x = x + 1;
        }
        if (direction == Direction.UP) {
            y = y - 1;
        }
        if (direction == Direction.DOWN) {
            y = y + 1;
        }
        return gameBoard.isWall(x, y);
    }

    public boolean canMoveRight() {
        ThreadUtils.sleep(50L);
        int x = getX();
        int y = getY();
        if (direction == Direction.LEFT) {
            y = y - 1;
        }
        if (direction == Direction.RIGHT) {
            y = y + 1;
        }
        if (direction == Direction.UP) {
            x = x + 1;
        }
        if (direction == Direction.DOWN) {
            x = x - 1;
        }
        return gameBoard.isWall(x, y);
    }

    public boolean canMoveLeft() {
        ThreadUtils.sleep(50L);
        int x = getX();
        int y = getY();
        if (direction == Direction.LEFT) {
            y = y + 1;
        }
        if (direction == Direction.RIGHT) {
            y = y - 1;
        }
        if (direction == Direction.UP) {
            x = x - 1;
        }
        if (direction == Direction.DOWN) {
            x = x + 1;
        }
        return gameBoard.isWall(x, y);
    }

    void uiMove() {
        if (direction == Direction.LEFT) {
            if (getX() <= 0) {
                setPosition(-1, -1);
                gameBoard.dieBird();
                return;
            }
            setX(getX() - 1);
        } else if (direction == Direction.RIGHT) {
            if (getX() >= 7) {
                setPosition(-1, -1);
                gameBoard.dieBird();
                return;
            }
            setX(getX() + 1);
        } else if (direction == Direction.UP) {
            if (getY() <= 0) {
                setPosition(-1, -1);
                gameBoard.dieBird();
                return;
            }
            setY(getY() - 1);
        } else if (direction == Direction.DOWN) {
            if (getY() >= 7) {
                setPosition(-1, -1);
                gameBoard.dieBird();
                return;
            }
            setY(getY() + 1);
        }
        gameBoard.detectCollisionWithWall();
        gameBoard.detectCollisionWithPig();
    }

    void uiTurn(TurnDirection turnDirection) {
        if (turnDirection == TurnDirection.LEFT) {
            if (direction == Direction.LEFT) {
                setDirection(Direction.DOWN);
            } else if (direction == Direction.DOWN) {
                setDirection(Direction.RIGHT);
            } else if (direction == Direction.RIGHT) {
                setDirection(Direction.UP);
            } else if (direction == Direction.UP) {
                setDirection(Direction.LEFT);
            }
        } else if (turnDirection == TurnDirection.RIGHT) {
            if (direction == Direction.LEFT) {
                setDirection(Direction.UP);
            } else if (direction == Direction.UP) {
                setDirection(Direction.RIGHT);
            } else if (direction == Direction.RIGHT) {
                setDirection(Direction.DOWN);
            } else if (direction == Direction.DOWN) {
                setDirection(Direction.LEFT);
            }
        }
    }

}
