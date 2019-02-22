package com.chainsys.food;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/AddCart")
public class AddCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int total = 0;
		HttpSession session = request.getSession(false);
		String[] selectedFoodId = request.getParameterValues("foodId");
		if (selectedFoodId != null) {
			int[] ids = new int[selectedFoodId.length];
			for (int i = 0; i < selectedFoodId.length; i++) {
				//System.out.println(selectedFoodId[i]);
				ids[i] = Integer.parseInt(selectedFoodId[i]);
			}
			FoodDAO dao = new FoodDAO();
			try {
				ArrayList<FoodDetails> details = dao.findById(ids);
				for (FoodDetails f : details) {
					int price = f.getPrice();
					total = total + price;
				}
				// System.out.println(total);
				/*
				 * System.out.println("Total Food: " + details.size()); for
				 * (FoodDetails foodItem : details) {
				 * System.out.println(foodItem); }
				 */
				session.setAttribute("FOODS", details);
				request.setAttribute("FOOD", total);
				RequestDispatcher rd = request
						.getRequestDispatcher("confirm.jsp");
				rd.forward(request, response);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			session.setAttribute("ERROR", "Please select the food");

			RequestDispatcher rd = request.getRequestDispatcher("food.jsp");
			rd.include(request, response);

		}
	}

}
