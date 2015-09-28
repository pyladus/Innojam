package test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HeloWold
 */
@WebServlet("/MakeResults")
public class MakeResults extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static List<Results> results = new ArrayList<Results>();
	private static  int calledonce = 0;

	public static List<Results> getResults() {
		if(calledonce==0){
			calledonce++;
			results.add(new Results(301, 0, "Exective Data Science"));
			results.add(new Results(302, 0, "Thermo Dynamics"));
			results.add(new Results(303, 0, "Fluid Mechanics"));
			results.add(new Results(304, 0, "Fluid Mechanics II"));
			results.add(new Results(305, 0, "Fluid Mechanics III"));
			results.add(new Results(306, 0, "Mechanics"));
			results.add(new Results(307, 0, "Mechanics II"));
			results.add(new Results(308, 0, "Mechanics III"));
}
		return results;
	}

	public void setResults(List<Results> results) {
		MakeResults.results = results;
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MakeResults() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String test2 = request.getParameter("id");
		int courseId = 0;
		int scoredCredits = 0;
		boolean hasCertificate = false;
		int id = 0;
		try {

			id = Integer.parseInt(request.getParameter("id"));
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {

			if (request.getParameter("courseId").length() > 0) {
				courseId = Integer.parseInt((request.getParameter("courseId")));
				scoredCredits = Integer.parseInt((request.getParameter("scoredCredits")));
				hasCertificate = Boolean.parseBoolean((request.getParameter("hasCertificate")));
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		if (id > 0) {
			String json = "{";
			for (Results result : this.getResults()) {
				if (id == result.getCourseId()) {
					json += "{ \"ScoredCredits\":\"" + Integer.toString(result.getScoredCredits())
							+ "\", \"HasCertificate\": \"" + Boolean.toString(result.getHasCertificate()) + "\"},";
				}
			}
			if (json.length() > 2) {
				json = json.substring(0, json.length() - 1);
			}
			json += "} ";
			response.getWriter().append(json);
		} else if (courseId > 0) {
			Boolean test = true;
			for (Results results2 : MakeResults.getResults()) {
				if (results2.getCourseId() == courseId && results2.getHasCertificate()) {
					test = false;
				}
			}

			if (test) {
				for (Results results2 : MakeResults.getResults()) {
					if (results2.getCourseId()==courseId) {
					results2.setScoredCredits(scoredCredits, hasCertificate);
						GameificationPoints.addGameponits(scoredCredits);
						response.getWriter().append("Uploaded Score"+"");
					}
				}
				

			} else {
				response.sendError(HttpServletResponse.SC_CONFLICT);
			}

		} else {
//			response.getWriter().append(
//					"<!doctype html> <html> <head> <meta charset=\"utf-8\"> <title>Formular Beispiel</title> </head> <body> <form action=\"\"> <label for=\"id\">Vorname</label> <input type=\"text\" id=\"courseId\" name=courseId maxlength=\"30\"><input type=\"text\" id=\"scoredCredits\" name=scoredCredits maxlength=\"30\"> <label for=\"zuname\">Zuname</label> <input type=\"text\" id=\"hasCertificate\" name=hasCertificate maxlength=\"40\"> <button type=\"reset\">Eingaben zurücksetzen</button> <button type=\"submit\">Eingaben absenden</button> </form> </body> </html>");
			 response.sendError(HttpServletResponse.SC_NOT_ACCEPTABLE);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
