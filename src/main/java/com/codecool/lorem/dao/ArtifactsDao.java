package com.codecool.lorem.dao;

import java.sql.*;
import java.util.ArrayList;

import com.codecool.lorem.models.ArtifactCategoryModel;
import com.codecool.lorem.models.ArtifactModel;

public class ArtifactsDao extends Dao<ArtifactModel> {

    public ArtifactsDao() {
        readFromDatabase();
    }

    private void readFromDatabase() {

        try {
            Connection c = DatabaseConnection.getConnection();
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM artifacts;");

            while (rs.next()) {

                Integer id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                Integer price = rs.getInt("price");
                Integer categoryId = rs.getInt("artifact_category_id");

                ArtifactModel artifact = new ArtifactModel(id, name, categoryId, description, price);

                this.itemsList.add(artifact);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

    public void addToDatabase(ArtifactModel artifact) {

        try {
            Connection c = DatabaseConnection.getConnection();
            c.setAutoCommit(false);

            Statement stmt = c.createStatement();

            stmt.executeUpdate(String.format(
                    "INSERT INTO artifacts (name, description, price, artifact_category_id)" +
                    "VALUES ('%s', '%s', '%d', '%d');", artifact.getName(), artifact.getDescription(),
                    artifact.getPrice(), artifact.getCategoryId()));

            stmt.close();
            c.commit();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
    }

    public ArrayList<ArtifactModel> getGroupArtifacts() {

        ArtifactCategoriesDao artifactCategories = new ArtifactCategoriesDao();
        ArrayList<ArtifactModel> groupArtifacts = new ArrayList<>();
        Integer groupCategoryId = artifactCategories.getCategoryByName("Group").getId();

        for (ArtifactModel artifact:this.itemsList) {
            if (artifact.getCategoryId().equals(groupCategoryId)) {
                groupArtifacts.add(artifact);
            }
        }
        return groupArtifacts;
    }

}
