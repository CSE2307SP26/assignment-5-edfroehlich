import java.awt.event.KeyEvent;

import edu.princeton.cs.introcs.StdDraw;

public class Player{
    private static final double RADIUS = 0.025;
    
    private double x;
    private double y;
    private double speed;

    public Player() {
        this.x = 0.5;
        this.y = 0.5;
        this.speed = 0.01;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public void move() {
        if (StdDraw.isKeyPressed(KeyEvent.VK_A)) { // Left arrow key
            this.x -= this.speed;
        }
        if (StdDraw.isKeyPressed(KeyEvent.VK_W)) { // Up arrow key
            this.y += this.speed;
        }
        if (StdDraw.isKeyPressed(KeyEvent.VK_D)) { // Right arrow key
            this.x += this.speed;
        }
        if (StdDraw.isKeyPressed(KeyEvent.VK_S)) { // Down arrow key
            this.y -= this.speed;
        }

        // Ensure the player stays within the bounds of the canvas
        remainInbounds();
    }

    private void remainInbounds() {
        if (this.x < 0) {
            this.x = 0;
        }
        if (this.x > 1) {
            this.x = 1;
        }
        if (this.y < 0) {
            this.y = 0;
        }
        if (this.y > 1) {
            this.y = 1;
        }
    }

    public void drawPlayer() {
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.filledCircle(this.x, this.y, RADIUS);
    }
}
