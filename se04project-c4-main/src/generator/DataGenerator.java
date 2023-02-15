package generator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class DataGenerator {

	final String PATHNAME = "sort_target.csv";

	public void generate() throws IOException {
		ArrayList<String> numberBox = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9"));
		ArrayList<String> generateResult = new ArrayList<>();

		Random rand = new Random();
		while (numberBox.size() != 0) {
			generateResult.add(numberBox.remove(rand.nextInt(numberBox.size())));
		}

		FileWriter fw = new FileWriter(PATHNAME, false);
		PrintWriter pw = new PrintWriter(new BufferedWriter(fw));

		pw.print(String.join(",", generateResult.toArray(new String[generateResult.size()])));
		pw.close();
	}

	public String[] getStringList() throws IOException {
		File file = new File(PATHNAME);
		BufferedReader br = new BufferedReader(new FileReader(file));
		String[] stringList = br.readLine().split(",");
		br.close();

		return stringList;
	}

	public Integer[] getIntgerList() throws IOException {
		String[] stringList = getStringList();
		Integer[] integerList = new Integer[stringList.length];
		for (int i = 0; i < stringList.length; ++i) {
			integerList[i] = Integer.valueOf(stringList[i]);
		}

		return integerList;
	}
}
