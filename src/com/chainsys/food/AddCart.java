package com.chainsys.food;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AddCart")
public class AddCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String[] selectedFoodId = request.getParameterValues("foodId");
		int[] ids = new int[selectedFoodId.length];
		for (int i = 0; i < selectedFoodId.length; i++) {
			System.out.println(selectedFoodId[i]);
			ids[i] = Integer.parseInt(selectedFoodId[i]);
		}
		FoodDAO dao = new FoodDAO();
		try {
			ArrayList<FoodDetails> details = dao.findById(ids);
			/*System.out.println("Total Food: " + details.size());
			for (FoodDetails foodItem : details) {
				System.out.println(foodItem);
			}*/
			request.setAttribute("FOODS", details);
			RequestDispatcher rd = request.getRequestDispatcher("food3.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
