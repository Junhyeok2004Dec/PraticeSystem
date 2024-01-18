import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Main extends JFrame implements DefaultInfo {


	private JLabel totalMemoryLabel;
	private JLabel freeMemoryLabel;
	private JLabel usedMemoryLabel;
	private JLabel positionLabel;




	private Color originalColor;


	Painting paintingPanel;

	int dpi;
	Dimension screenSize;

	public static void main(String[] args)
	{



		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new Main().setVisible(true);

			}
		});

	}


	private void updateMemoryInfo() {
		// Runtime 객체 얻기
		Runtime runtime = Runtime.getRuntime();

		// 메모리 정보 업데이트
		long totalMemory = runtime.totalMemory();
		long freeMemory = runtime.freeMemory();
		long usedMemory = totalMemory - freeMemory;

		// 레이블 업데이트
		totalMemoryLabel.setText("전체 메모리: " + totalMemory + " bytes");
		freeMemoryLabel.setText("가용 메모리: " + freeMemory + " bytes");
		usedMemoryLabel.setText("현재 할당된 메모리: " + usedMemory + " bytes");
	}


	public Main() {


		paintingPanel = new Painting();



		setTitle(PROGRAM_NAME + " " + VERSION);
		setSize(640,480);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		originalColor = getContentPane().getBackground();
		getContentPane().add(paintingPanel, BorderLayout.CENTER);

		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));



		totalMemoryLabel = new JLabel("전체 메모리: ");
		freeMemoryLabel = new JLabel("가용 메모리: ");
		usedMemoryLabel = new JLabel("현재 할당된 메모리: ");
		positionLabel = new JLabel("x : " + paintingPanel.getPrevX() + ", y : " + paintingPanel.getPrevY());

		add(totalMemoryLabel);
		add(freeMemoryLabel);
		add(usedMemoryLabel);
		add(positionLabel);

		Timer timer = new Timer(10, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				updateMemoryInfo();

				positionLabel.setText("x : " + paintingPanel.getPrevX() + ", y : " + paintingPanel.getPrevY());

			}
		});
		timer.start();


		addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_SPACE) {
					getContentPane().setBackground(Color.BLACK);
					totalMemoryLabel.setForeground(Color.WHITE);
					freeMemoryLabel.setForeground(Color.WHITE);
					usedMemoryLabel.setForeground(Color.WHITE);
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_SPACE) {
					getContentPane().setBackground(originalColor);
					totalMemoryLabel.setForeground(Color.BLACK);
					freeMemoryLabel.setForeground(Color.BLACK);
					usedMemoryLabel.setForeground(Color.BLACK);
				}
			}
		});


		setFocusable(true);
		requestFocus();

	}


	public void getMonitorInfo() {
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice[] devices = ge.getScreenDevices();

		for (GraphicsDevice device : devices) {
			System.out.println("Monitor: " + device);

			// 화면 해상도 가져오기
			screenSize = device.getDefaultConfiguration().getBounds().getSize();

			// DPI(Dots Per Inch) 정보 가져오기
			dpi = Toolkit.getDefaultToolkit().getScreenResolution();

		}
	}


}
