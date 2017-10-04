package com.codecool.lorem.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.stream.Collectors;

import com.codecool.lorem.models.BoughtArtifactModel;

public class ArtifactsBoughtDao extends Dao<BoughtArtifactModel> {

    public ArtifactsBoughtDao() {
        readFromDatabase();
    }

    public void readFromDatabase() {
        Statement stmt = null;
        ResultSet rs = null;

        try {
            Connection c = DatabaseConnection.getConnection();
            stmt = c.createStatement();
            rs = stmt.executeQuery(
                    "SELECT bought_artifacts.id, is_used, artifact_id, student_id, name, " +
                        "description, price, artifact_category_id FROM bought_artifacts " +
                        "INNER JOIN artifacts ON artifacts.id = bought_artifacts.artifact_id");

            while (rs.next()) {

                Integer id = rs.getInt("id");
                Boolean isUsed = rs.getBoolean("is_used");
                Integer artifactId = rs.getInt("artifact_id");
                Integer studentId = rs.getInt("student_id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                Integer price = rs.getInt("price");
                Integer category_id = rs.getInt("artifact_category_id");

                BoughtArtifactModel artifact = new BoughtArtifactModel(id, artifactId, studentId, isUsed, name, category_id, description, price);

                this.itemsList.add(artifact);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

    public ArrayList<BoughtArtifactModel> getItemsByStudentId(Integer id) {
        return this.itemsList.stream()
                             .filter(artifact -> artifact.getStudentId().equals(id))
                             .collect(Collectors.toCollection(ArrayList::new));
    }

    public void addToDatabase(Integer artifactId, Integer studentId) {
        Statement stmt = null;

        try {
            Connection c = DatabaseConnection.getConnection();
            c.setAutoCommit(false);

            stmt = c.createStatement();

            stmt.executeUpdate("INSERT INTO bought_artifacts (is_used, artifact_id, student_id)"
                    + " VALUES ('" + 0 + "', " + artifactId + ", " + studentId + ");");

            stmt.close();
            c.commit();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
    }

    public void updateBoughtArtifact(BoughtArtifactModel artifact) {
        Statement stmt = null;

        try {
            Connection c = DatabaseConnection.getConnection();
            c.setAutoCommit(false);

            stmt = c.createStatement();

            stmt.executeUpdate(String.format(
                    "UPDATE bought_artifacts SET is_used = '1' "
                    + "WHERE id = '%d'", artifact.getId()));

            stmt.close();
            c.commit();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage());
        }
    }
}