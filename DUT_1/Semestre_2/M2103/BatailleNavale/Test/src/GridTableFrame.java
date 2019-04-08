package view;

import java.awt.Color;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import battle.Square;

public class GridTableFrame extends SimpleFrame {

	public GridTableFrame(Square[][] grid) {
		this.setSize(800,600);
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
