import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import java.awt.Color;
import java.awt.Font;

public class frameSplashScreen extends JFrame {

	private JPanel contentPane;
	public static JProgressBar progressBar;

	public frameSplashScreen() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		progressBar = new JProgressBar();
		progressBar.setStringPainted(true);
		progressBar.setForeground(Color.DARK_GRAY);
		progressBar.setBounds(155, 546, 489, 29);
		contentPane.add(progressBar);
		
		ImageIcon icon = new ImageIcon(this.getClass().getResource("/robot.gif"));
		JLabel lblImage = new JLabel(icon);
		lblImage.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblImage.setBounds(5, 5, 790, 590);
		contentPane.add(lblImage);
	}
}
