package ball.model;

import ball.Ball;
import ball.behaviours.Behaviour;

import java.awt.*;

public class SuperBall implements Ball {
    public int x;
    public int y;
    public int radius;
    public Color color = Color.GREEN;
    protected Behaviour[] behaviours;

    protected SuperBall(int x, int y, int radius, Behaviour... behaviours) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.behaviours = behaviours;
    }

    protected SuperBall(int x, int y, Behaviour... behaviours) {
        this(x, y, BallConstants.DEFAULT_RADIUS, behaviours);
    }

    public void update() {
        for (Behaviour behaviour : behaviours) {
            behaviour.apply(this);
        }
    }

    @Override
    public Color color() {
        return color;
    }

    @Override
    public int radius() {
        return radius;
    }

    @Override
    public Point center() {
        return new Point(x, y);
    }

}
