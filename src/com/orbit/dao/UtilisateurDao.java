package com.orbit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.orbit.models.Utilisateur;
import com.orbit.utils.DatabaseConnection;

public class UtilisateurDao {
	public static void createUtilisateur1(Utilisateur utilisateur) {
        String query = "INSERT INTO utilisateur (identifiant, mdp) VALUES (?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)
            ) {

            preparedStatement.setString(1, utilisateur.getIdentifiant());
            preparedStatement.setString(2, utilisateur.getMdp());
            preparedStatement.executeUpdate();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	public static void createUtilisateur2(Utilisateur utilisateur) {
        String query = "INSERT INTO utilisateur (identifiant, email, mdp) VALUES (?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)
            ) {

            preparedStatement.setString(1, utilisateur.getIdentifiant());
            preparedStatement.setString(2, utilisateur.getEmail());
            preparedStatement.setString(3, utilisateur.getMdp());
            preparedStatement.executeUpdate();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	public static Utilisateur getIdUtilisateurById() {
        String query = "SELECT * FROM utilisateur ORDER BY id DESC LIMIT 1";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
        	
            ResultSet resultSet = preparedStatement.executeQuery();
            
            if (resultSet.next()) {
                int idUtilisateur = resultSet.getInt("id");
                return new Utilisateur(idUtilisateur);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
