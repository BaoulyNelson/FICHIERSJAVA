import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

 public class FallingObstacleGame {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Falling Obstacle Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 600);

        GamePanel gamePanel = new GamePanel();
        frame.add(gamePanel);

        frame.setVisible(true);
    }
}
class GamePanel extends JPanel {
    // Le code de la classe GamePanel
        private Timer timer;
        private int obstacleX, obstacleY;
        private int obstacleWidth, obstacleHeight;
        private Random random;
    
        public GamePanel() {
            random = new Random();
            obstacleWidth = 50;
            obstacleHeight = 50;
    
            timer = new Timer(333, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Générer une position aléatoire pour l'obstacle
                    obstacleX = random.nextInt(getWidth() - obstacleWidth);
                    obstacleY = 0;
    
                    repaint();
                }
            });
    
            timer.start();
        }
    
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
    
            // Dessiner l'obstacle
            g.setColor(Color.RED);
            g.fillRect(obstacleX, obstacleY, obstacleWidth, obstacleHeight);
        }
    }
    


