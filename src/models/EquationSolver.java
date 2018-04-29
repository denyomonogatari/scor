package models;

import com.wolfram.alpha.WAEngine;
import com.wolfram.alpha.WAException;
import com.wolfram.alpha.WAPlainText;
import com.wolfram.alpha.WAPod;
import com.wolfram.alpha.WAQuery;
import com.wolfram.alpha.WAQueryResult;
import com.wolfram.alpha.WASubpod;

public class EquationSolver {
	private static String app_id = "5H9TY8-K9KRTJH57T";

	public static String getAnAnswer(String question) {
		StringBuilder result = new StringBuilder();
		WAEngine engine = new WAEngine();
		engine.setAppID(app_id);
		engine.addFormat("plaintext");

		WAQuery query = engine.createQuery();

		query.setInput(question);

		try {
			WAQueryResult queryResult = engine.performQuery(query);

			System.out.println("Successful query. Pods follow:\n");
			for (WAPod pod : queryResult.getPods()) {
				if (!pod.isError()) { // && (pod.getTitle().equals("Input") || pod.getTitle().equals("Result"))
					String title = pod.getTitle();
					result.append(title + "\n");
					result.append("------------\n");
					for (WASubpod subpod : pod.getSubpods()) {
						for (Object element : subpod.getContents()) {
							if (element instanceof WAPlainText) {
								result.append(((WAPlainText) element).getText() + "\n\n");
							}
						}
					}
				}
			}
		} catch (WAException e) {
			e.printStackTrace();
		}

		return result.toString();
	}
}
