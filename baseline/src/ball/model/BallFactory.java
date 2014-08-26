package ball.model;

import ball.Ball;
import ball.behaviours.Bouncing;
import ball.behaviours.ColorShink;
import ball.behaviours.Elastic;
import ball.behaviours.RandomRoute;

public class BallFactory {

    public static Ball[] all() {
        return new Ball[]{
                bouncingBall(75, 50, BallConstants.DOWN),
                elasticBall(250, 100, BallConstants.SHRINK),
                bouncingElasticBall(400, 200, BallConstants.UP, BallConstants.SHRINK),
                colorfulBouncingElasticBall(550, 300, BallConstants.DOWN, BallConstants.SHRINK),
                randomRouteBall(100, 100)
        };
    }

    public static Ball bouncingBall(int centerX, int centerY, int direction) {
        return new SuperBall(centerX, centerY, new Bouncing(direction));
    }

    public static Ball elasticBall(int centerX, int centerY, int direction) {
        return new SuperBall(centerX, centerY, new Elastic(direction));
    }

    public static Ball bouncingElasticBall(int centerX, int centerY,int bouncingDirection, int elasticDirection) {
        return new SuperBall(centerX, centerY, new Bouncing(bouncingDirection), new Elastic(elasticDirection));
    }

    public static Ball colorfulBouncingElasticBall(int centerX, int centerY, int bouncingDirection, int elasticDirection) {
        return new SuperBall(centerX, centerY, new Bouncing(bouncingDirection), new Elastic(elasticDirection), new ColorShink());
    }

    public static Ball randomRouteBall(int centerX, int centerY) {
        return new SuperBall(centerX, centerY, new RandomRoute());
    }
}
