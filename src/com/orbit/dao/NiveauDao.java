package com.orbit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.orbit.models.Niveau;
import com.orbit.utils.DatabaseConnection;

public class NiveauDao {
	 public static Niveau getIdNiveauById(int id) {
	        String query = "SELECT * FROM niveau where id = ?";
	        try (Connection connection = DatabaseConnection.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	        	
	        	preparedStatement.setInt(1, id);
	            ResultSet resultSet = preparedStatement.executeQuery();
	            
	            if (resultSet.next()) {
	                int idNiveau = resultSet.getInt("id");
	                return new Niveau(idNiveau);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return null;
	 }
}
