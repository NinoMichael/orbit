package com.orbit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

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
                String identifiant = resultSet.getString("identifiant");
                String email = resultSet.getString("email");
                String mdp = resultSet.getString("mdp");
                LocalDateTime dateRegister = (LocalDateTime) resultSet.getObject("date_inscription");
                LocalDateTime lastLogged = (LocalDateTime) resultSet.getObject("derniere_connexion");
                return new Utilisateur(idUtilisateur, identifiant, email, mdp, dateRegister, lastLogged);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
	
	public static boolean isUtilisateurExiste() {
		 String query = "SELECT * FROM utilisateur";
	        try (Connection connection = DatabaseConnection.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	        	
	            ResultSet resultSet = preparedStatement.executeQuery();
	            
	            if (resultSet.next()) {
	            	return false;
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		return true;
	}
	
	public static Utilisateur isUtilisateurExiste(String identifiant, String mdp) {
		 String query = "SELECT * FROM utilisateur where identifiant = ? and mdp = ?";
	        try (Connection connection = DatabaseConnection.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	        	
	        	preparedStatement.setString(1, identifiant);
	        	preparedStatement.setString(2, mdp);
	            ResultSet resultSet = preparedStatement.executeQuery();
	            
	            if (resultSet.next()) {
	            	int idUtilisateur = resultSet.getInt("id");
	            	String login = resultSet.getString("identifiant");
	            	String email = resultSet.getString("email");
	            	String password = resultSet.getString("mdp");
	            	LocalDateTime dateRegister = (LocalDateTime) resultSet.getObject("date_inscription");
	            	LocalDateTime lastLogged = (LocalDateTime) resultSet.getObject("derniere_connexion");
	            	return new Utilisateur(idUtilisateur, login, email, password, dateRegister, lastLogged);
	            } else {
	            	System.out.println("Echec de la connexion");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		return null;
	}
	
	public static void update(Utilisateur utilisateur) {
		String query = "UPDATE utilisateur set identifiant = ?, email = ?, mdp = ?, date_inscription = ?, derniere_connexion = ? where id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
        	
        	preparedStatement.setString(1, utilisateur.getIdentifiant());
        	preparedStatement.setString(2, utilisateur.getEmail());
        	preparedStatement.setObject(3, utilisateur.getMdp());
        	preparedStatement.setObject(4, utilisateur.getDateInscription());
        	preparedStatement.setObject(5, utilisateur.getLastLogged());
        	preparedStatement.setInt(6, utilisateur.getId());
        	
            preparedStatement.executeUpdate();
            connection.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
}
