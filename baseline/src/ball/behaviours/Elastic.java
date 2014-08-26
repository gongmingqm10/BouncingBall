package ball.behaviours;

import ball.model.BallConstants;
import ball.model.SuperBall;

public class Elastic implements Behaviour {

    private int direction;
    private SuperBall appliedBall;

    public Elastic(int direction) {
        this.direction = direction;
    }

    @Override
    public void apply(SuperBall ball) {
        this.appliedBall = ball;
        next();
    }

    /***********************************************************************************
     *
     * Do not change Elastic ALGORITHM below.
     *
     ***********************************************************************************/

    private void next() {
        reverseGrowthDirectionIfNecessary();
        appliedBall.radius += (BallConstants.GROWTH_RATE * direction);
    }

    private void reverseGrowthDirectionIfNecessary() {
        if (growingTooBig() || shrinkingTooSmall()) direction = switchDirection();
    }

    private boolean shrinkingTooSmall() {
        return appliedBall.radius <= 0 && shrinking();
    }

    private boolean growingTooBig() {
        return appliedBall.radius >= BallConstants.DEFAULT_RADIUS && growing();
    }

    private int switchDirection() {
        return growing() ? BallConstants.SHRINK : BallConstants.GROW;
    }

    private boolean shrinking() {
        return direction == BallConstants.SHRINK;
    }

    private boolean growing() {
        return direction == BallConstants.GROW;
    }

}
