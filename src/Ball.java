import edu.princeton.cs.introcs.StdDraw;

public class Ball {

    private static final double LOWER_VELOCITY = 0.005;
    private static final double UPPER_VELOCITY = 0.01;
    private static final double RADIUS = 0.025;
    
    private double x;
    private double y;
    private double xVelocity;
    private double yVelocity;
    private boolean isTouchingPlayer;

    public Ball() {
        this.x = Math.random();
        this.y = Math.random();
        this.xVelocity = Math.random() * (UPPER_VELOCITY - LOWER_VELOCITY) + LOWER_VELOCITY;
        this.yVelocity = Math.random() * (UPPER_VELOCITY - LOWER_VELOCITY) + LOWER_VELOCITY;
        this.isTouchingPlayer = false;
    }

    public void updatePosition(Ball[] balls, Player player) {
        this.x += this.xVelocity;
        this.y += this.yVelocity;

        if (this.x + RADIUS > 1 || this.x - RADIUS < 0) {
            this.xVelocity = -this.xVelocity;
        }
        if (this.y + RADIUS > 1 || this.y - RADIUS < 0) {
            this.yVelocity = -this.yVelocity;
        }

        for(Ball ball : balls) {
            if(this != ball && this.isTouchingOtherBall(ball)) {
                this.xVelocity = -this.xVelocity;
                this.yVelocity = -this.yVelocity;
            }
        }

        if(this.isTouchingPlayer(player)) {
            this.isTouchingPlayer = true;
        }
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public boolean isTouchingOtherBall(Ball other) {
        double distance = Math.sqrt(Math.pow(this.x - other.getX(), 2) + Math.pow(this.y - other.getY(), 2));
        return distance < 2 * RADIUS;
    }

    public boolean isTouchingPlayer(Player player) {
        double distance = Math.sqrt(Math.pow(this.x - player.getX(), 2) + Math.pow(this.y - player.getY(), 2));
        return distance < 2 * RADIUS;
    }

    public void drawBall() {
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.filledCircle(this.x, this.y, RADIUS);
    }


}
