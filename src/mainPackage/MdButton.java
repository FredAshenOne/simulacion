package mainPackage;
import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class MdButton extends JButton {

	public MdButton(Color back, Color fore, String text) {
		setOpaque(true);
		setBorder(null);
		setBackground(back);
		setForeground(fore);
		setHorizontalAlignment(SwingConstants.CENTER);
		setText(text);
		setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 15));
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				setBackground(fore);
				setContentAreaFilled(false);
				setBorder(new LineBorder(back, 3, true));
				setOpaque(true);
				setForeground(back);
				btnPointer();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				setBorder(null);
				setBackground(back);
				setForeground(fore);
			}
		});

	}
	
	public void btnPointer() {
		setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
		new ImageIcon("views/cursor.png").getImage(),
		new Point(0,0), "custom cursor"));
	}

}