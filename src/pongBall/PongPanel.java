package pongBall;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class PongPanel extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int ballX = 250;
	private int ballY = 250;
	private int diameter = 20;
	private int ballDeltaX = -1;
	private int ballDeltaY = 3;

	public PongPanel() {
		setBackground(Color.black);
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		g.setColor(Color.white);
		g.fillOval(250, 250, 20, 20);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		step();
	}

	public void step() {

		// where will the ball be after it moves?
		int nextBallLeft = ballX + ballDeltaX;
		int nextBallRight = ballX + diameter + ballDeltaX;
		int nextBallTop = ballY + ballDeltaY;
		int nextBallBottom = ballY + diameter + ballDeltaY;

		// ball bounces off top and bottom of screen
		if (nextBallTop < 0 || nextBallBottom > getHeight()) {
			ballDeltaY *= -1;
		}

		// will the ball go off the left side?
		if (nextBallLeft < 0) {
			ballDeltaX *= -1;
		}

		// will the ball go off the right side?
		if (nextBallRight > getWidth()) {
			ballDeltaX *= -1;
		}

		// move the ball
		ballX += ballDeltaX;
		ballY += ballDeltaY;

		// stuff has moved, tell this JPanel to repaint itself
		repaint();
	}
}
