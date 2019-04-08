package view;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;
import battle.Square;

public class GridTableFrame extends SimpleFrame {

  public GridTableFrame(Square[][] grid) {
    this.setSize(300,250);
    GridTableModel otmodel = new GridTableModel(grid);
    JTable tab = new JTable(otmodel);
    // to adjust some parameters
    tab.setShowGrid(true);
    tab.setGridColor(Color.BLUE);
    tab.setBackground(Color.LIGHT_GRAY);
    tab.setRowHeight(50);

    JScrollPane SP = new JScrollPane(tab);
    this.getContentPane().add(SP);

  }

 
}