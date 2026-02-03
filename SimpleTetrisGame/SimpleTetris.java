import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleTetris extends JPanel implements ActionListener {

    private final int TILE = 30;
    private final int WIDTH = 10;
    private final int HEIGHT = 18;

    private Timer timer;
    private int x = 4, y = 0;

    public SimpleTetris() {
        setPreferredSize(new Dimension(WIDTH * TILE, HEIGHT * TILE));
        setBackground(Color.BLACK);

        timer = new Timer(500, this);
        timer.start();

        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_LEFT) x--;
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) x++;
                repaint();
            }
        });

        setFocusable(true);
    }

    public void actionPerformed(ActionEvent e) {
        y++;
        if (y >= HEIGHT) y = 0;
        repaint();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.CYAN);
        g.fillRect(x * TILE, y * TILE, TILE, TILE);

        g.setColor(Color.DARK_GRAY);
        for (int i = 0; i <= WIDTH; i++)
            g.drawLine(i * TILE, 0, i * TILE, HEIGHT * TILE);

        for (int i = 0; i <= HEIGHT; i++)
            g.drawLine(0, i * TILE, WIDTH * TILE, i * TILE);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Simple Tetris");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new SimpleTetris());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
