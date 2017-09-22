package com.codecool.lorem.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;

import com.codecool.lorem.models.BoughtArtifactModel;

public class ArtifactsBoughtDao extends Dao<BoughtArtifactModel> {

    public BoughtArtifactModel getById(Integer id) {
        for (BoughtArtifactModel boughtArtifact : getItems()) {
            if (boughtArtifact.getId().equals(id)) {
                return boughtArtifact;
            }
        }
        return null;
    }

    public void readFromDatabase() {
        Statement stmt = null;
        ResultSet rs = null;

        try {
            Connection c = DatabaseConnection.getConnection();
            stmt = c.createStatement();
            rs = stmt.executeQuery(
                    "SELECT bought_artifacts.id, is_used, artifact_id, student_id, name, description, price, artifact_category_id FROM bought_artifacts LEFT JOIN artifacts ON artifacts.id = bought_artifacts.artifact_id");

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
        ArrayList<BoughtArtifactModel> studentsBoughtArtifacts = new ArrayList<>();

        for (BoughtArtifactModel artifact:this.itemsList) {
            if (artifact.getStudentId().equals(id)) {
                studentsBoughtArtifacts.add(artifact);
            }
        }
        return studentsBoughtArtifacts;
    }

    public void addBoughtArtifactToDatabase(Integer artifactId, Integer studentId) {
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

    public void deleteArtifactFromDb(Integer id) {
        Statement stmt = null;

        try {
            Connection c = DatabaseConnection.getConnection();
            c.setAutoCommit(false);

            stmt = c.createStatement();

            stmt.executeUpdate(String.format(
                    "DELETE FROM bought_artifacts WHERE id = %d;", id));

            stmt.close();
            c.commit();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
    }

    public void deleteArtifactFromDao(Integer id) {
        Iterator<BoughtArtifactModel> iterator = this.getItems().iterator();
        while(iterator.hasNext()){
            if(iterator.next().getId().equals(id)) {
                iterator.remove();
            }
        }
    }
}