package com.orbit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.orbit.models.ProfilUtilisateur;
import com.orbit.utils.DatabaseConnection;

public class ProfilUtilisateurDao {
	public static void createProfil(ProfilUtilisateur profil) {
        String query = "INSERT INTO profil_utilisateur (id_utilisateur, nom, naissance, pays) VALUES (?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)
            ) {

            preparedStatement.setInt(1, profil.getUtilisateur().getId());
            preparedStatement.setString(2, profil.getNom());
            preparedStatement.setObject(3, profil.getNaissance());
            preparedStatement.setString(4, profil.getPays());
            
            preparedStatement.executeUpdate();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	 public static void setNiveauProfil(ProfilUtilisateur profil) {
	        String query = "UPDATE profil_utilisateur SET id_niveau = ? WHERE id = ?";
	        try (Connection connection = DatabaseConnection.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

	            preparedStatement.setInt(1, profil.getNiveau().getId());
	            preparedStatement.setInt(2, profil.getId());
	            preparedStatement.executeUpdate();

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	 }
	 
	 public static ProfilUtilisateur getIdProfilById() {
	        String query = "SELECT * FROM profil_utilisateur ORDER BY id DESC LIMIT 1";
	        try (Connection connection = DatabaseConnection.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	        	
	            ResultSet resultSet = preparedStatement.executeQuery();
	            
	            if (resultSet.next()) {
	                int idProfil = resultSet.getInt("id");
	                return new ProfilUtilisateur(idProfil);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return null;
	 }
}
