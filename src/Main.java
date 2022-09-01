import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		frameSplashScreen splash = new frameSplashScreen();
		splash.setVisible(true);
		
		int counter = 0;
		
		try {
			while(counter <= 100) {
				splash.progressBar.setValue(counter);
				splash.progressBar.setString(counter + " %");
				Thread.sleep(80);
				
				if(counter == 100) {
					splash.dispose();
					
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								Main frame = new Main();
								frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
								frame.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
				}
				counter++;
			}
		} catch (Exception err) {
			err.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				if (JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?",
						"Quit Application?", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
					setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				else
					setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			}
		});
		setTitle("SAMPLE APPLICATION");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1080, 650);
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		ImageIcon icon = new ImageIcon(this.getClass().getResource("/wallpaper.gif"));
		JLabel lblBackground = new JLabel(icon);
		contentPane.add(lblBackground, BorderLayout.CENTER);
	}
}
