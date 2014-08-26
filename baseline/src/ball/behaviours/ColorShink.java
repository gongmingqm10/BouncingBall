package ball.behaviours;

import ball.model.SuperBall;

import java.awt.*;

public class ColorShink implements Behaviour {
    Color[] colors = new Color[] {Color.GREEN, Color.RED, Color.BLUE, Color.CYAN};
    @Override
    public void apply(SuperBall ball) {
        ball.color = colors[(int)(Math.random() * colors.length)];
    }
}
