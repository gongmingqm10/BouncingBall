package ball.behaviours;

import ball.model.BallConstants;
import ball.model.SuperBall;
import ball.ui.BallWorld;

public class Bouncing implements Behaviour {

    private int direction;
    private SuperBall appliedBall;

    public Bouncing(int direction) {
        this.direction = direction;
    }

    @Override
    public void apply(SuperBall ball) {
        this.appliedBall = ball;
        reverseDirectionIfNecessary();
        appliedBall.y += BallConstants.MOVEMENT_SPEED * direction;
    }

    /***********************************************************************************
     *
     * Do not change Bouncing ALGORITHM below.
     *
     ***********************************************************************************/

    private void reverseDirectionIfNecessary() {
        if (movingTooHigh() || movingTooLow()) {
            direction = switchDirection();
        }
    }


    private boolean movingTooLow() {
        return appliedBall.y + appliedBall.radius >= BallWorld.BOX_HEIGHT && movingDown();
    }

    private boolean movingTooHigh() {
        return appliedBall.y - appliedBall.radius <= 0 && movingUp();
    }

    private int switchDirection() {
        return movingDown() ? BallConstants.UP : BallConstants.DOWN;
    }

    private boolean movingDown() {
        return direction == BallConstants.DOWN;
    }

    private boolean movingUp() {
        return direction == BallConstants.UP;
    }


}
