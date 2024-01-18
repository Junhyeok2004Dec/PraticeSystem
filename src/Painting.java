import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Painting extends JPanel {


	private int prevX, prevY;
	private boolean drawing;

	public Painting() {


		drawing = false;

		addMouseListener(new MouseAdapter() {
			/**
			 * {@inheritDoc}
			 *
			 * @param e
			 */
			@Override
			public void mousePressed(MouseEvent e) {
				prevX = e.getX();
				prevY = e.getY();
				drawing = true;
			}

			/**
			 * {@inheritDoc}
			 *
			 * @param e
			 */
			@Override
			public void mouseReleased(MouseEvent e) {
				drawing = false;
			}

		});


		addMouseMotionListener(new MouseAdapter() {
			/**
			 * {@inheritDoc}
			 *
			 * @param e
			 * @since 1.6
			 */
			@Override
			public void mouseDragged(MouseEvent e) {
				if(drawing)

				{
					Graphics g = getGraphics();
					g.setColor(Color.blue);
					g.drawLine(prevX, prevY, e.getX(), e.getY());
					prevX = e.getX();
					prevY = e.getY();




				}
			}
		});





	}


	public int getPrevX() {
		return prevX;
	}

	public int getPrevY() {
		return prevY;
	}

	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		//추가예정
		//
	}
}
