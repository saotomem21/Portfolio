package gui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame {

	final String EMPTY_STRING = "";
	final ArrayList<List<ArrayList<Integer>>> EMPTY_ARRAY = new ArrayList<>(Arrays.asList());

	public String[] PanelNames = { "main", "sort" };
	MainPanel mainPanel = new MainPanel(this, PanelNames[0]);
	SortPanel sortPanel = new SortPanel(this, PanelNames[1], EMPTY_STRING, EMPTY_ARRAY);

	public MainFrame() {
		this.setBounds(100, 100, 800, 600);
		this.setResizable(false);
		this.add(mainPanel);
	}

	public static void main(String[] args) {
		MainFrame mainFrame = new MainFrame();
		mainFrame.setTitle("TeamC4 - SortVisualizer");
		mainFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		mainFrame.setVisible(true);
	}

	// パネルのリロード
	public void reloadPanel(String reloadPanelName, String sortName, ArrayList<List<ArrayList<Integer>>> sortDetail) {
		if (reloadPanelName == PanelNames[0]) {
			this.remove(this.mainPanel);
			MainPanel mainPanel = new MainPanel(this, PanelNames[0]);
			this.add(mainPanel);
		} else if (reloadPanelName == PanelNames[1]) {
			this.remove(this.sortPanel);
			SortPanel sortPanel = new SortPanel(this, PanelNames[1], sortName, sortDetail);
			this.add(sortPanel);
		}
	}

	// メインパネルの表示
	public void showMainPanel(JPanel nowPanel) {
		nowPanel.setVisible(false);
		mainPanel.setVisible(true);
		reloadPanel(PanelNames[0], EMPTY_STRING, EMPTY_ARRAY);
	}

	// ソートパネルの表示
	public void showSortPanel(JPanel nowPanel, String sortName, ArrayList<List<ArrayList<Integer>>> sortDetail) {
		nowPanel.setVisible(false);
		sortPanel.setVisible(true);
		reloadPanel(PanelNames[1], sortName, sortDetail);
	}
}
