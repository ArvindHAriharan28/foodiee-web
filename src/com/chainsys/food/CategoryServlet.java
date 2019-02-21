package com.chainsys.food;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CategoryServlet")
public class CategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String category =request.getParameter("category");
		if(category.equalsIgnoreCase("Veg")){
				FoodDetails food = new FoodDetails();
				food.setCategory(category);
		FoodDAO dao = new FoodDAO();
		try {
			ArrayList<FoodDetails> foodList1= dao.findFood(food); 
			request.setAttribute("FOODS", foodList1);
			RequestDispatcher rd = request.getRequestDispatcher("food.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		else if(category.equalsIgnoreCase("NonVeg")){
			FoodDetails food = new FoodDetails();
			food.setCategory(category);
	FoodDAO dao = new FoodDAO();
	try {
		ArrayList<FoodDetails> foodList1= dao.findFood(food); 
		request.setAttribute("FOODS", foodList1);
		RequestDispatcher rd = request.getRequestDispatcher("food1.jsp");
		rd.forward(request, response);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		}
		else if(category.equalsIgnoreCase("Snacks")){
			FoodDetails food = new FoodDetails();
			food.setCategory(category);
	FoodDAO dao = new FoodDAO();
	try {
		ArrayList<FoodDetails> foodList1= dao.findFood(food); 
		request.setAttribute("FOODS", foodList1);
		RequestDispatcher rd = request.getRequestDispatcher("food2.jsp");
		rd.forward(request, response);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
		}
		}
				
	}
