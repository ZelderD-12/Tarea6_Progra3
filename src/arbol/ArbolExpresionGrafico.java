package arbol;

import java.awt.*;
import java.util.HashMap;
import javax.swing.*;

public class ArbolExpresionGrafico extends JPanel {
    private ArbolBB miArbol;
    private HashMap<Nodo, Rectangle> posicionNodos;
    private HashMap<Nodo, Dimension> subtreeSizes;
    private boolean dirty = true;
    private int parent2child = 20, child2child = 30;
    private Dimension empty = new Dimension(0, 0);
    private FontMetrics fm = null;
    private JScrollPane scrollPane; // Referencia al JScrollPane

    // Constructor modificado para recibir el JScrollPane y el JPanel
    public ArbolExpresionGrafico(ArbolBB miArbol, JScrollPane scrollPane, JPanel panel) {
        this.miArbol = miArbol;
        this.scrollPane = scrollPane;
        this.setBackground(Color.WHITE);
        posicionNodos = new HashMap<>();
        subtreeSizes = new HashMap<>();
        dirty = true;

        // Asignar este panel al JScrollPane
        scrollPane.setViewportView(this);
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        fm = g.getFontMetrics();

        if (dirty) {
            calcularPosiciones();
            dirty = false;
        }

        Graphics2D g2d = (Graphics2D) g;
        g2d.translate(getWidth() / 2, parent2child);
        dibujarArbol(g2d, miArbol.getRaiz(), Integer.MAX_VALUE, Integer.MAX_VALUE, fm.getLeading() + fm.getAscent());
        fm = null;
    }

    private void calcularPosiciones() {
        posicionNodos.clear();
        subtreeSizes.clear();
        Nodo root = miArbol.getRaiz();
        if (root != null) {
            calcularTamañoSubarbol(root);
            calcularPosicion(root, Integer.MAX_VALUE, Integer.MAX_VALUE, 0);
        }
    }

    private Dimension calcularTamañoSubarbol(Nodo n) {
        if (n == null) return new Dimension(0, 0);

        Dimension ld = calcularTamañoSubarbol(n.getIzq());
        Dimension rd = calcularTamañoSubarbol(n.getDer());

        int h = fm.getHeight() + parent2child + Math.max(ld.height, rd.height);
        int w = ld.width + child2child + rd.width;

        Dimension d = new Dimension(w, h);
        subtreeSizes.put(n, d);

        return d;
    }

    private void calcularPosicion(Nodo n, int left, int right, int top) {
        if (n == null) return;

        Dimension ld = subtreeSizes.getOrDefault(n.getIzq(), empty);
        Dimension rd = subtreeSizes.getOrDefault(n.getDer(), empty);

        int center = 0;

        if (right != Integer.MAX_VALUE)
            center = right - rd.width - child2child / 2;
        else if (left != Integer.MAX_VALUE)
            center = left + ld.width + child2child / 2;

        int width = fm.stringWidth(n.getDato() + "");

        posicionNodos.put(n, new Rectangle(center - width / 2 - 3, top, width + 6, fm.getHeight()));

        calcularPosicion(n.getIzq(), Integer.MAX_VALUE, center - child2child / 2, top + fm.getHeight() + parent2child);
        calcularPosicion(n.getDer(), center + child2child / 2, Integer.MAX_VALUE, top + fm.getHeight() + parent2child);
    }

    private void dibujarArbol(Graphics2D g, Nodo n, int puntox, int puntoy, int yoffs) {
        if (n == null) return;

        Rectangle r = posicionNodos.get(n);
        g.draw(r);
        g.drawString(n.getDato() + "", r.x + 3, r.y + yoffs);

        if (puntox != Integer.MAX_VALUE)
            g.drawLine(puntox, puntoy, (int) (r.x + r.width / 2), r.y);

        dibujarArbol(g, n.getIzq(), (int) (r.x + r.width / 2), r.y + r.height, yoffs);
        dibujarArbol(g, n.getDer(), (int) (r.x + r.width / 2), r.y + r.height, yoffs);
    }

    @Override
    public Dimension getPreferredSize() {
        if (miArbol.getRaiz() == null) {
            return new Dimension(0, 0); // Si no hay árbol, tamaño mínimo
        }

        // Obtener las dimensiones del árbol
        Rectangle bounds = calcularLimitesArbol(miArbol.getRaiz());
        int width = bounds.width + 50; // Margen adicional
        int height = bounds.height + 50; // Margen adicional

        return new Dimension(width, height);
    }

    // Método para calcular los límites del árbol
    private Rectangle calcularLimitesArbol(Nodo nodo) {
        if (nodo == null) {
            return new Rectangle(0, 0, 0, 0);
        }

        Rectangle leftBounds = calcularLimitesArbol(nodo.getIzq());
        Rectangle rightBounds = calcularLimitesArbol(nodo.getDer());

        int width = leftBounds.width + rightBounds.width + 100; // Espacio entre nodos
        int height = Math.max(leftBounds.height, rightBounds.height) + 50; // Espacio vertical

        return new Rectangle(0, 0, width, height);
    }
}