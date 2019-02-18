package net.sevecek.turtle.engine;

import java.awt.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.net.*;
import javax.imageio.*;
import javax.swing.*;
import net.sevecek.util.*;

public class Turtle {

    private static final double DEGREES_TO_RADIAN_RATIO = Math.PI / 180.0;
    private static final String TURTLE_SPRITE_FILE_NAME = "net/sevecek/turtle/images/turtle.png";
    private static final Color DEFAULT_PEN_COLOR = new Color(70, 70, 140);
    private double x;
    private double y;
    private double angle;
    private Color color;
    private int penWidth;
    private boolean isPenDrawing;
    private Board board;
    private BufferedImage turtleSprite;
    private JLabel turtleVisualComponent;

    public Turtle() {
        try {
            board = Board.getInstance(Thread.currentThread());
            URL turtleSpriteResource = this.getClass().getClassLoader().getResource(TURTLE_SPRITE_FILE_NAME);
            if (turtleSpriteResource == null) {
                throw new ApplicationPublicException("Unable to load turtle image from " + TURTLE_SPRITE_FILE_NAME);
            }
            turtleSprite = ImageIO.read(turtleSpriteResource);
            angle = 0.0;
            penWidth = 10;
            isPenDrawing = true;
            color = DEFAULT_PEN_COLOR;
            uiInitialize();
            ThreadUtils.sleep(400L);
        } catch (Exception e) {
            throw ExceptionUtils.rethrowAsUnchecked(e);
        }
    }

    public double getX() {
        testPause();
        return x;
    }

    public void setX(double newValue) {
        testPause();
        setLocation(newValue, y);
    }

    public double getY() {
        testPause();
        return y;
    }

    public void setY(double newValue) {
        testPause();
        setLocation(x, newValue);
    }

    public void setLocation(double newX, double newY) {
        testPause();
        uiDrawTurtleOnLocation(newX, newY);
        setLocationInternal(newX, newY);
    }

    public Color getPenColor() {
        testPause();
        return color;
    }

    public void setPenColor(Color newValue) {
        testPause();
        this.color = newValue;
    }

    public int getPenWidth() {
        testPause();
        return penWidth;
    }

    public void setPenWidth(int newValue) {
        testPause();
        this.penWidth = newValue;
    }

    public void turnRight(double byAngle) {
        testPause();
        double oldAngle = angle;
        double newAngle = angle + byAngle;
        animateRotation(oldAngle, newAngle);
        setAngleInternal(newAngle);
    }

    public void turnLeft(double byAngle) {
        testPause();
        turnRight(-byAngle);
    }

    public void move(double pixels) {
        testPause();
        double newX = x + Math.cos((angle - 90.0) * DEGREES_TO_RADIAN_RATIO) * pixels;
        double newY = y + Math.sin((angle - 90.0) * DEGREES_TO_RADIAN_RATIO) * pixels;
        animateDrawing(x, y, angle, pixels);
        setLocation(newX, newY);
    }

    public boolean isPenDrawing() {
        testPause();
        return isPenDrawing;
    }

    public void penUp() {
        testPause();
        this.isPenDrawing = false;
    }

    public void penDown() {
        testPause();
        this.isPenDrawing = true;
    }

    public double getSpeed() {
        testPause();
        return board.getSpeed();
    }

    public void setSpeed(double newValue) {
        testPause();
        board.setSpeed(newValue);
    }

    //-------------------------------------------------------------------------

    private void testPause() {
        while (board.getShouldPause()) {
            ThreadUtils.sleep(100L);
        }
    }

    private void setLocationInternal(double newX, double newY) {
        this.x = newX;
        this.y = newY;
    }

    private void setAngleInternal(double newAngle) {
        if (newAngle > 360.0) {
            newAngle = newAngle % 360.0;
        }
        if (newAngle < 0.0) {
            newAngle = newAngle % 360.0;
        }
        angle = newAngle;
    }

    //-------------------------------------------------------------------------

    private void animateRotation(double originalAngle, double newAngle) {
        if (Math.abs(originalAngle - newAngle) > 25.0) {
            long duration = (long) ((Math.abs(newAngle - originalAngle) / 360.0) / board.getRotationSpeed() * 1000.0);
            long startTime = System.currentTimeMillis();
            long currentTime = startTime;
            long endTime = startTime + duration;
            double lastPercent = 0.0;
            while (currentTime < endTime) {
                duration = (long) ((Math.abs(newAngle - originalAngle) / 360.0) / board.getRotationSpeed() * 1000.0);
                endTime = startTime + duration;

                double percent = (double) (currentTime - startTime) / duration;
                if (percent >= 1.0) {
                    percent = 1.0;
                }
                if (percent < lastPercent) {
                    percent = lastPercent;
                }
                lastPercent = percent;
                angle = originalAngle + (newAngle - originalAngle) * percent;
                uiDrawRotatedTurtle(angle);
                ThreadUtils.sleep(5L);
                currentTime = System.currentTimeMillis();
            }
        }
        uiDrawRotatedTurtle(newAngle);
    }

    private void animateDrawing(double oldX, double oldY, double angle, double length) {
        double targetX = oldX + Math.cos((angle - 90.0) * DEGREES_TO_RADIAN_RATIO) * length;
        double targetY = oldY + Math.sin((angle - 90.0) * DEGREES_TO_RADIAN_RATIO) * length;
        UiLineAnimator uiLineAnimator = new UiLineAnimator(oldX, oldY, targetX, targetY);

        if (length > 20.0) {
            long duration = (long) (length / 100.0 / board.getSpeed() * 1000.0);
            long startTime = System.currentTimeMillis();
            long currentTime = startTime;
            long endTime = startTime + duration;
            double lastPercent = 0.0;
            while (currentTime < endTime) {
                duration = (long) (length / 100.0 / board.getSpeed() * 1000.0);
                endTime = startTime + duration;

                double percent = (double) (currentTime - startTime) / duration;
                if (percent >= 1.0) {
                    percent = 1.0;
                }
                if (percent < lastPercent) {
                    percent = lastPercent;
                }
                lastPercent = percent;
                double currentLength = length * percent;
                double newX = oldX + Math.cos((angle - 90.0) * DEGREES_TO_RADIAN_RATIO) * currentLength;
                double newY = oldY + Math.sin((angle - 90.0) * DEGREES_TO_RADIAN_RATIO) * currentLength;
                if (isPenDrawing()) {
                    uiLineAnimator.uiDrawLine(newX, newY);
                }
                uiDrawTurtleOnLocation(newX, newY);
                ThreadUtils.sleep(5L);
                currentTime = System.currentTimeMillis();
            }
        }

        if (isPenDrawing()) {
            uiLineAnimator.uiFinalDrawLine(targetX, targetY);
        }
    }

    //-------------------------------------------------------------------------

    private void uiInitialize() {
        Board.invokeAndWait(() -> {
            ImageIcon icon = new ImageIcon(turtleSprite);
            turtleVisualComponent = new JLabel();
            turtleVisualComponent.setIcon(icon);
            turtleVisualComponent.setSize(turtleVisualComponent.getPreferredSize());
            setLocationInternal(board.getSize().width / 2, board.getSize().height / 2);
            turtleVisualComponent.setLocation((int) (x - turtleSprite.getWidth() / 2),
                    (int) (y - turtleSprite.getHeight() / 2));
            board.add(turtleVisualComponent);
            board.repaint();
        });
    }

    private void uiDrawRotatedTurtle(double angle) {
        Board.invokeAndWait(() -> {
            AffineTransform tx = AffineTransform.getRotateInstance(
                    angle * DEGREES_TO_RADIAN_RATIO,
                    turtleSprite.getWidth() / 2.0,
                    turtleSprite.getHeight() / 2.0);
            AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BICUBIC);
            BufferedImage newTurtleSprite = op.filter(turtleSprite, null);
            turtleVisualComponent.setIcon(new ImageIcon(newTurtleSprite));
            turtleVisualComponent.setSize(turtleVisualComponent.getPreferredSize());
        });
    }

    private void uiDrawTurtleOnLocation(double newX, double newY) {
        Board.invokeAndWait(() -> {
            turtleVisualComponent.setLocation(
                    (int) (newX - turtleSprite.getWidth() / 2),
                    (int) (newY - turtleSprite.getHeight() / 2));
        });
    }

    private static Raster backupRaster;

    private class UiLineAnimator {

        private double oldX;
        private double oldY;
        private BufferedImage painting;
        private Graphics2D graphics;

        public UiLineAnimator(double oldX, double oldY, double newX, double newY) {
            this.oldX = oldX;
            this.oldY = oldY;

            painting = board.getPainting();
            graphics = (Graphics2D) painting.getGraphics();
            graphics.setColor(color);
            graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            graphics.setStroke(new BasicStroke((float) penWidth, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
            if (backupRaster == null) {
                backupRaster = painting.getData();
            }
        }

        public void uiDrawLine(double newX, double newY) {
            Board.invokeAndWait(() -> {
                graphics.drawLine((int) oldX, (int) oldY, (int) newX, (int) newY);
            });
        }

        public void uiFinalDrawLine(double newX, double newY) {
            Board.invokeAndWait(() -> {
                painting.setData(backupRaster);
                graphics.drawLine((int) oldX, (int) oldY, (int) newX, (int) newY);
                backupRaster = painting.getData();
                board.repaint();
            });
        }

    }
}
