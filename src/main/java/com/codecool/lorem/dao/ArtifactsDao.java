package com.codecool.lorem.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.stream.Collectors;

import com.codecool.lorem.models.ArtifactModel;

public class ArtifactsDao extends Dao<ArtifactModel> {

    public ArtifactsDao() {
        readFromDatabase();
    }

    private void readFromDatabase() {
        Statement stmt = null;
        ResultSet rs = null;

        try {
            Connection c = DatabaseConnection.getConnection();
            stmt = c.createStatement();
            rs = stmt.executeQuery("SELECT * FROM artifacts;");

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

    public void addToDatabase(String name, Integer categoryId, String description, Integer price) {
        Statement stmt = null;
        ResultSet rs = null;

        try {
            Connection c = DatabaseConnection.getConnection();
            c.setAutoCommit(false);

            stmt = c.createStatement();

            stmt.executeUpdate("INSERT INTO artifacts (name, description, price, artifact_category_id)"
                    + "VALUES ('" + name + "', '" + description + "', " + price + ", " + categoryId + ")");
            rs = stmt.executeQuery("SELECT id from artifacts WHERE name = '" + name + "'");

            while (rs.next()) {
                Integer id = rs.getInt("id");
                ArtifactModel artifact = new ArtifactModel(id, name, categoryId, description, price);
                this.itemsList.add(artifact);
            }
            stmt.close();
            c.commit();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
    }

    public ArrayList<ArtifactModel> getGroupArtifacts() {
        ArtifactCategoriesDao artifactCategories = new ArtifactCategoriesDao();
        ArrayList<ArtifactModel> groupArtifacts;
        Integer groupCategoryId = artifactCategories.getCategoryByName("Group").getId();

        groupArtifacts = this.itemsList.stream()
                                       .filter(artifact -> artifact.getCategoryId().equals(groupCategoryId))
                                       .collect(Collectors.toCollection(ArrayList::new));
        return groupArtifacts;
    }

}
