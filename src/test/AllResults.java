package test;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AllResults
 */
@WebServlet("/AllResults")
public class AllResults extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllResults() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Results> results = MakeResults.getResults();
		String responceString="{	\"TileCollection\": [";
		for (Results result : results) {
			String avedible="Available";
			String status="Not Taken";
			
			if(result.getHasCertificate())
			{
				avedible="Completed";
				status="Taken already";
			}
			responceString+="{\"icon\": \""+result.icon+"\",\"number\": \"C-id: "+result.getCourseId()+"\",";
			responceString+="\"title\": \""+result.titel+"\",\"info\": \""+avedible+"\",\"status\": \""+status+"\"";
			if(result.getHasCertificate()){
				responceString+=",\"infoState\": \"Success\"},";
			}else{
				responceString+="},";
			}
		}
		responceString=responceString.substring(0,responceString.length()-1);
		responceString+="]}";
		response.getWriter().append(responceString);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
