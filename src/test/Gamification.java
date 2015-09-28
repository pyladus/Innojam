package test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Gamification
 */
@WebServlet("/Gamification")
public class Gamification extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Gamification() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String test2 = request.getParameter("id");
		
		try {
			switch (test2) {
			case "addContetent":
				GameificationPoints.addGameponits(10);
				break;
			case "connectProfile":
				if (GameificationPoints.getConnectProfile()) {
					GameificationPoints.addGameponits(20);
					GameificationPoints.setConnectProfile(false);
				}
				break;
			default:
				break;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		response.getWriter().append(Integer.toString(GameificationPoints.getGameponits()));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
