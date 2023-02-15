package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import algorithm.Sort;
import generator.DataGenerator;

public class MainPanel extends JPanel {

	MainFrame mainFrame;
	DataGenerator dataGenerator = new DataGenerator();
	Sort sort = new Sort();

	JLabel sortNameLabel;

	MainPanel(MainFrame mf, String name) {

		mainFrame = mf;

		this.setName(name);
		this.setLayout(null);

		// ボタン バブルソート 
		JButton toBubbleSortPanelButton = new JButton("Bubble Sort");
		toBubbleSortPanelButton.setBounds(50, 30, 200, 430);
		toBubbleSortPanelButton.setFont(new Font("Arial", Font.PLAIN, 18));
		toBubbleSortPanelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					panelChangeToBubbleSort(mainFrame.PanelNames[1]);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		add(toBubbleSortPanelButton);

		// ボタン 選択ソート
		JButton toSelectionSortPanelButton = new JButton("Selection Sort");
		toSelectionSortPanelButton.setBounds(300, 30, 200, 430);
		toSelectionSortPanelButton.setFont(new Font("Arial", Font.PLAIN, 18));
		toSelectionSortPanelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					panelChangeToSelectionSort(mainFrame.PanelNames[1]);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		add(toSelectionSortPanelButton);

		// ボタン 挿入ソート
		JButton toInertionSortPanelButton = new JButton("Insertion Sort");
		toInertionSortPanelButton.setBounds(550, 30, 200, 430);
		toInertionSortPanelButton.setFont(new Font("Arial", Font.PLAIN, 18));
		toInertionSortPanelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					panelChangeToInsertionSort(mainFrame.PanelNames[1]);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		add(toInertionSortPanelButton);

		// ボタン 配列ジェネレート
		JButton shuffleButton = new JButton("🔄");
		shuffleButton.setBounds(570, 475, 80, 80);
		shuffleButton.setFont(new Font("Arial", Font.PLAIN, 24));
		shuffleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					dataGenerator.generate();
					sortNameLabel.setText(Arrays.toString(dataGenerator.getStringList()));
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		add(shuffleButton);

		// ラベル ソート対象配列
		try {
			sortNameLabel = new JLabel(Arrays.toString(dataGenerator.getStringList()));
			sortNameLabel.setBounds(200, 488, 800, 50);
			sortNameLabel.setFont(new Font("Arial", Font.PLAIN, 36));
			add(sortNameLabel);
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		// パネル ラベルの背景用
		JPanel dataMonitor = new JPanel();
		dataMonitor.setBounds(180, 480, 400, 70);
		dataMonitor.setBackground(Color.WHITE);
		add(dataMonitor);
	}

	// 画面切り替え バブルソート
	public void panelChangeToBubbleSort(String toPanelName) throws IOException {
		ArrayList<Integer> sortTarget = new ArrayList<>(Arrays.asList(dataGenerator.getIntgerList()));
		mainFrame.showSortPanel((JPanel) this, "Bubble Sort", sort.getBubbleSortDetail(sortTarget));
	}

	// 画面切り替え 選択ソート
	public void panelChangeToSelectionSort(String toPanelName) throws IOException {
		ArrayList<Integer> sortTarget = new ArrayList<>(Arrays.asList(dataGenerator.getIntgerList()));
		mainFrame.showSortPanel((JPanel) this, "Selection Sort", sort.getSelectionSortDetail(sortTarget));
	}

	// 画面切り替え 挿入ソート
	public void panelChangeToInsertionSort(String toPanelName) throws IOException {
		ArrayList<Integer> sortTarget = new ArrayList<>(Arrays.asList(dataGenerator.getIntgerList()));
		mainFrame.showSortPanel((JPanel) this, "Insertion Sort", sort.getInsertionSortDetail(sortTarget));
	}

}
