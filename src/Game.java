import java.awt.Color;
import java.awt.event.KeyEvent;

import edu.princeton.cs.introcs.StdDraw;

public class Game {

	private int numberOfBalls;
	private int score;
	private int highScore;
	private Ball[] balls;
	private Player player;
	private long startTime;

	public Game(int numberOfBalls) {
		this.numberOfBalls = numberOfBalls;
		this.score = 0;
		this.highScore = 0;
		this.balls = new Ball[numberOfBalls];
		for(int i = 0; i < numberOfBalls; i++) {
			balls[i] = new Ball();
		}
		this.player = new Player();
	}

	public void updateBalls() {
		for(Ball ball : balls) {
			ball.updatePosition(balls, player);
			if(ball.isTouchingPlayer(player)) {
				resetGame();
				return;
			}
		}
	}

	private void resetGame() {
		this.score = 0;
		this.player = new Player();
		this.balls = new Ball[numberOfBalls];
		for(int i = 0; i < numberOfBalls; i++) {
			balls[i] = new Ball();
		}
	}

	public void run() {
		StdDraw.enableDoubleBuffering();
		
		long elapsedTime = System.currentTimeMillis();
		long startTime = System.currentTimeMillis();
		
		while (true) {
			StdDraw.clear();
			boolean touchingPlayer = false;
			updateBalls();
			long now = System.currentTimeMillis();
			updateScore(now);
			player.move();
			drawBalls();
			drawPlayer();
			StdDraw.show();
			StdDraw.pause(10);
		}

	}

	public void drawBalls() {
		for(Ball ball : balls) {
			ball.drawBall();
		}
	}

	public void drawPlayer() {
		player.drawPlayer();
	}

	public void updateScore(long now) {
		if(now > startTime + 1000) {
			score++;
			if(score > highScore) {
				highScore = score;
			}
			startTime = now;
		}
	}

	public static void main(String[] args) {

		Game game = new Game(3);
		game.run();
	}
}
			
			if(now > startTime + 10000) {
				numberOfBalls++;
				double[] ballXnew = new double[numberOfBalls];
				double[] ballYnew = new double[numberOfBalls];
				double[] ballXVnew = new double[numberOfBalls];
				double[] ballYVnew = new double[numberOfBalls];
				for(int i = 0; i < numberOfBalls - 1; i++) {
					ballXnew[i] = ballsX[i];
					ballYnew[i] = ballsY[i];
					ballXVnew[i] = ballsXVelocity[i];
					ballYVnew[i] = ballsYVelocity[i];
				}
				ballXnew[numberOfBalls-1] = Math.random();
				ballYnew[numberOfBalls-1] = Math.random();
				ballXVnew[numberOfBalls-1] = Math.random() * (upperVelocity - lowerVelocity) + lowerVelocity;
				ballYVnew[numberOfBalls-1] = Math.random() * (upperVelocity - lowerVelocity) + lowerVelocity;
				ballsX = ballXnew;
				ballsY = ballYnew;
				ballsXVelocity = ballXVnew;
				ballsYVelocity = ballYVnew;
				elapsedTime = now;
			}
			
			
			
			
			
		
	