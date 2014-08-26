package ball.behaviours;

import ball.model.BallConstants;
import ball.model.SuperBall;
import ball.ui.BallWorld;

public class RandomRoute implements Behaviour {
    private SuperBall appliedBall;
    private double angle;

    public RandomRoute(double angle) {
        this.angle = angle;
    }

    public RandomRoute() {
        this(BallConstants.DEFAULT_ANGLE);
    }


    @Override
    public void apply(SuperBall ball) {
        this.appliedBall = ball;
        move();
    }

    private void move() {
        reflectDirectionIfNeeded();
        appliedBall.y -= BallConstants.MOVEMENT_SPEED * Math.sin(Math.toRadians(angle));
        appliedBall.x += BallConstants.MOVEMENT_SPEED * Math.cos(Math.toRadians(angle));
    }

    private void reflectDirectionIfNeeded() {
        if (closeToTop() || closeToBottom()) {
            angle = 360 - angle;
        } else if (closeToLeft() || closeToRight()) {
            if (angle < 180) angle = 180 - angle;
            else if (angle > 180) angle = 540 - angle;
        }
    }

    private boolean closeToBottom() {
        return appliedBall.y + appliedBall.radius >= BallWorld.BOX_HEIGHT && movingBottom();
    }

    private boolean movingBottom() {
        return angle > 180 && angle < 360;
    }

    private boolean closeToTop() {
        return appliedBall.y - appliedBall.radius <= 0 && movingTop();
    }

    private boolean movingTop() {
        return angle > 0 && angle < 180;
    }

    private boolean closeToLeft() {
        return appliedBall.x - appliedBall.radius <= 0 && movingLeft();
    }

    private boolean movingLeft() {
        return angle > 90 && angle < 270;
    }

    private boolean closeToRight() {
        return appliedBall.x + appliedBall.radius >= BallWorld.BOX_WIDTH && movingRight();
    }

    private boolean movingRight() {
        return angle < 90 || angle > 270;
    }


}
