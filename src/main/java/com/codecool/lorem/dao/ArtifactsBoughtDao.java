package com.codecool.lorem.dao;

import java.sql.*;
import java.util.ArrayList;

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
        Connection c = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            c = DriverManager.getConnection("jdbc:sqlite:db/quest-store.db");

            stmt = c.createStatement();
            rs = stmt.executeQuery(
                    "SELECT bought_artifacts.id, is_used, artifact_id, student_id, name, description, price, artifact_category_id FROM bought_artifacts INNER JOIN artifacts ON artifacts.id = bought_artifacts.id");

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
            c.close();

        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

    public ArrayList<BoughtArtifactModel> getItemsByStudentId(Integer id) {
        ArrayList<BoughtArtifactModel> studentsBoughtArtifacts = new ArrayList<BoughtArtifactModel>();

        for (BoughtArtifactModel artifact:this.itemsList) {
            if (artifact.getStudentId().equals(id)) {
                studentsBoughtArtifacts.add(artifact);
            }
        }
        return studentsBoughtArtifacts;
    }
}
