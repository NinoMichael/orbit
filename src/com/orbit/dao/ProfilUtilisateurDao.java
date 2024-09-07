package com.orbit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
}
