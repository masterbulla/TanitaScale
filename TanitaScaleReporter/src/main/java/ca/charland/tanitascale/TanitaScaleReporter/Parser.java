package ca.charland.tanitascale.TanitaScaleReporter;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Parser {

	public Map<Column, String> parseFile(List<String> contents) {
		Map<Column, String> values = new TreeMap<Column, String>();
		for (String line : contents) {
			String[] vals = line.split(" = ");

			Column keyColumn = null;
			String keyString = vals[0].trim();
			for (Column c : Column.values()) {
				if (keyString.equals(c.toString())) {
					keyColumn = c;
					break;
				}
			}
			values.put(keyColumn, getString(vals));
		}
		return values;
	}

	private static String getString(String[] vals) {
		String trim = vals[1].trim();
		if (trim.endsWith("%")) {
			String percentageString = trim.substring(0, trim.length() - 1);
			double percentage = Double.parseDouble(percentageString) / 100;
			trim = String.valueOf(percentage);
		}
		return trim;
	}

}
