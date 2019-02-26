package com.chainsys.food;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class FoodDAO {

	public ArrayList<FoodDetails> findFood(FoodDetails food) throws Exception {

		ArrayList<FoodDetails> foodList = new ArrayList<FoodDetails>();
		try {
			Connection connection = ConnectionUtil.getConnection();
			String sql4 = "select id,name,price,availability from food_details where category=?";
			PreparedStatement preparedStatement = connection
					.prepareStatement(sql4);
			preparedStatement.setString(1, food.getCategory());
			ResultSet resultSet = preparedStatement.executeQuery();

			food = null;
			while (resultSet.next()) {
				food = new FoodDetails();
				food.setId(resultSet.getInt("id"));
				food.setName(resultSet.getString("name"));
				food.setPrice(resultSet.getInt("price"));
				
				foodList.add(food);
			}
			ConnectionUtil.close(connection, preparedStatement, resultSet);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// throw new Exception("unable findFood");
		}
		return foodList;
	}

	public ArrayList<FoodDetails> findById(int[] ids) throws Exception {
		FoodDetails food1 = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ArrayList<FoodDetails> details = new ArrayList<FoodDetails>();
		try {
			Connection connection = ConnectionUtil.getConnection();
			for (int id : ids) {
				String sql4 = "select id,name,price from food_details where id=?";
				preparedStatement = connection.prepareStatement(sql4);
				preparedStatement.setInt(1, id);
				resultSet = preparedStatement.executeQuery();
				while (resultSet.next()) {
					food1 = new FoodDetails();
					food1.setId(resultSet.getInt("id"));
					food1.setName(resultSet.getString("name"));
					food1.setPrice(resultSet.getInt("price"));
					System.out.println(food1);
					details.add(food1);

				}
			}
			ConnectionUtil.close(connection, preparedStatement, resultSet);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception("unable findbyid");
		}

		return details;
	}
}
