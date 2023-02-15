package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

public class SortPanel extends JPanel {

	MainFrame mainFrame;
	int nowStep = 0;
	boolean nowAutoPlay = false;
	ArrayList<ChartPanel> sortStep = new ArrayList<>(Arrays.asList());;

	SortPanel(MainFrame mf, String name, String sortName, ArrayList<List<ArrayList<Integer>>> sortDetail) {

		mainFrame = mf;

		this.setName(name);
		this.setLayout(null);

		// ボタン メインパネルに戻る
		JButton toMainPanelButton = new JButton("←");
		toMainPanelButton.setBounds(10, 10, 50, 50);
		toMainPanelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelChangeToMain(mainFrame.PanelNames[0]);
			}
		});
		add(toMainPanelButton);

		// ラベル 使用ソート名
		JLabel sortNameLabel = new JLabel(sortName);
		sortNameLabel.setBounds(0, 10, 800, 50);
		sortNameLabel.setFont(new Font("Arial", Font.PLAIN, 36));
		sortNameLabel.setHorizontalAlignment(JLabel.CENTER);
		add(sortNameLabel);

		// グラフ ソート可視化
		for (int i = 0; i < sortDetail.size(); ++i) {
			DefaultCategoryDataset dataset = new DefaultCategoryDataset();

			ArrayList<Integer> oneStep = sortDetail.get(i).get(0);
			ArrayList<Integer> oneStepSorted = sortDetail.get(i).get(1);
			ArrayList<Integer> oneStepSortTargets = sortDetail.get(i).get(2);

			// ソートデータの読み込み
			for (int j = 0; j < oneStep.size(); ++j) {
				int number = oneStep.get(j);
				dataset.addValue(number, Integer.valueOf(number).toString(), "");
			}
			JFreeChart chart = ChartFactory.createBarChart("", "", "", dataset, PlotOrientation.VERTICAL, false, false,
					false);

			// 色付け
			CategoryPlot plot = chart.getCategoryPlot();
			CategoryItemRenderer renderer = (BarRenderer) plot.getRenderer();
			for (int j = 0; j < oneStep.size(); ++j) {
				renderer.setSeriesPaint(j, Color.RED);
			}
			for (int j = 0; j < oneStepSorted.size(); ++j) {
				renderer.setSeriesPaint(oneStepSorted.get(j), Color.GREEN);
			}
			for (int j = 0; j < oneStepSortTargets.size(); ++j) {
				renderer.setSeriesPaint(oneStepSortTargets.get(j), Color.ORANGE);
			}
			NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
			rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

			// 描写
			ChartPanel cpanel = new ChartPanel(chart);
			cpanel.setBounds(100, 70, 600, 400);
			if (i != 0) {
				cpanel.setVisible(false);
			}
			add(cpanel);
			sortStep.add(cpanel); // Visibleを使用するので配列に入れる必要がある
		}

		// ボタン 最初までステップを戻す
		JButton firstButton = new JButton("≪");
		firstButton.setBounds(180, 475, 70, 70);
		firstButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (nowStep > 0) {
					sortStep.get(0).setVisible(true);
					sortStep.get(nowStep).setVisible(false);
					nowStep = 0;
				}
			}
		});
		add(firstButton);

		// ボタン ステップを戻す
		JButton backButton = new JButton("Previous Step");
		backButton.setBounds(250, 475, 150, 70);
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (nowStep > 0) {
					--nowStep;
					sortStep.get(nowStep).setVisible(true);
					sortStep.get(nowStep + 1).setVisible(false);
				}
			}
		});
		add(backButton);

		// ボタン ステップを進める
		JButton nextButton = new JButton("Next Step");
		nextButton.setBounds(400, 475, 150, 70);
		nextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (nowStep < sortStep.size() - 1) {
					++nowStep;
					sortStep.get(nowStep).setVisible(true);
					sortStep.get(nowStep - 1).setVisible(false);
				}
			}
		});
		add(nextButton);

		// ボタン 最後までステップを進める
		JButton lastButton = new JButton("≫");
		lastButton.setBounds(550, 475, 70, 70);
		lastButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (nowStep < sortStep.size() - 1) {
					int lastStep = sortDetail.size() - 1;
					sortStep.get(lastStep).setVisible(true);
					sortStep.get(nowStep).setVisible(false);
					nowStep = lastStep;
				}
			}
		});
		add(lastButton);
	}

	// 画面切り替え メイン
	public void panelChangeToMain(String toPanelName) {
		mainFrame.showMainPanel((JPanel) this);
	}
}
