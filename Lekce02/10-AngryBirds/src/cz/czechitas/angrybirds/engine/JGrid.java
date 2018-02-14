package cz.czechitas.angrybirds.engine;

import java.awt.*;
import java.util.List;
import java.util.*;
import javax.swing.*;

public class JGrid extends JPanel {

    private int rows;
    private int cols;
    private List<List<JPanel>> cells;

    public JGrid(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
    }

    public void init(Dimension size) {
        setLayout(new GridLayout(rows, cols));
        cells = new ArrayList<>(rows);
        for (int i = 0; i < rows; i++) {
            cells.add(new ArrayList<>(cols));
        }
        for (int x = 0; x < rows; x++) {
            for (int y = 0; y < cols; y++) {
                JPanel singleCell = new JPanel();
                singleCell.setLayout(new BorderLayout());
                singleCell.setOpaque(false);
                this.add(singleCell);
                cells.get(x).add(singleCell);
            }
        }

        this.setSize(size);
        this.setOpaque(false);
    }

    public void setCell(int x, int y, JComponent component) {
        cells.get(y).get(x).add(component, BorderLayout.CENTER);
    }

    public void clearCell(int x, int y) {
        JPanel panel = cells.get(y).get(x);
        if (panel.getComponentCount() > 0) {
            panel.remove(0);
        }
    }

}
