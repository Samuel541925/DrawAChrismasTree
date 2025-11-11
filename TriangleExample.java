import javax.swing.*;
import java.awt.*;

public class TriangleExample extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        int cx = getWidth() / 2; // centro del panel

        // === Triángulos como los originales ===
        int[] x1 = {cx - 50, cx, cx + 50};
        int[] y1 = {150, 50, 150};

        int[] x2 = {cx - 70, cx, cx + 70};
        int[] y2 = {200, 100, 200};

        int[] x3 = {cx - 90, cx, cx + 90};
        int[] y3 = {260, 150, 260};

        // Tronco
        int troncoAncho = 30;
        int troncoAlto = 50;
        int troncoX = cx - troncoAncho / 2;
        int troncoY = 260;

        // === Dibujar triángulos ===
        g2d.setColor(new Color(0, 150, 0)); // verde
        g2d.fillPolygon(x1, y1, 3);
        g2d.fillPolygon(x2, y2, 3);
        g2d.fillPolygon(x3, y3, 3);

        // === Dibujar tronco ===
        g2d.setColor(new Color(101, 67, 33)); // marrón
        g2d.fillRect(troncoX, troncoY, troncoAncho, troncoAlto);

        // === Dibujar bolitas centradas ===
        g2d.setColor(Color.RED);
        int r = 8; // radio

        // Triángulo superior: 1 en punta, 2 en medio, 3 en base
        drawBalls(g2d, cx, 75, 1, 30, r);   // punta
        drawBalls(g2d, cx, 100, 2, 25, r);  // mitad
        drawBalls(g2d, cx, 135, 3, 25, r);  // base

        // Triángulo medio: 2 en mitad, 3 en base
        drawBalls(g2d, cx, 170, 2, 30, r);
        drawBalls(g2d, cx, 190, 3, 30, r);

        // Triángulo inferior: 2 en mitad, 3 en base
        drawBalls(g2d, cx, 225, 2, 35, r);
        drawBalls(g2d, cx, 245, 3, 35, r);
    }

    // Dibuja una línea de bolitas centradas en el eje X
    private void drawBalls(Graphics2D g2d, int cx, int y, int count, int spacing, int r) {
        int totalWidth = (count - 1) * spacing;
        int startX = cx - totalWidth / 2;
        for (int i = 0; i < count; i++) {
            int x = startX + i * spacing - r;
            g2d.fillOval(x, y, 2 * r, 2 * r);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Árbol de Navidad");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.add(new TriangleExample());
        frame.setVisible(true);
    }
}
