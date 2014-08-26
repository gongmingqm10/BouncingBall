package ball.model;

import ball.Ball;
import org.junit.Test;

import static ball.BallTestHarness.*;

public class ElasticBallTest {
    @Test
    public void shouldDecreaseRadius() {
        Ball elasticBall = BallFactory.elasticBall(0, 0, BallConstants.SHRINK);

        elasticBall.update();

        assertRadiusIs(oneStepInwardsFrom(BallConstants.DEFAULT_RADIUS), elasticBall);
    }

    @Test
    public void shouldDecreaseInSizeAfterFullyExpanding() throws Exception {
        Ball elasticBall = BallFactory.elasticBall(0, 0, BallConstants.GROW);

        elasticBall.update();

        assertRadiusIs(oneStepInwardsFrom(BallConstants.DEFAULT_RADIUS), elasticBall);
    }

}
