package com.codecool.lorem.dao;

import java.sql.*;
import com.codecool.lorem.models.ArtifactCategoryModel;

public class ArtifactCategoriesDao extends Dao<ArtifactCategoryModel> {

    public ArtifactCategoryModel getById(Integer id) {
        for (ArtifactCategoryModel artifactCat : getItems()) {
            if (artifactCat.getId().equals(id)) {
                return artifactCat;
            }
        }
        return null;
    }

    public void readFromDatabase() {
        Connection c = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            Connection connection = DatabaseConnection.getConnection();
            stmt = connection.createStatement();
            rs = stmt.executeQuery("SELECT id, name FROM artifact_categories;");

            while (rs.next()) {

                Integer id = rs.getInt("id");
                String name = rs.getString("name");

                this.itemsList.add(new ArtifactCategoryModel(id, name));
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

    public void addCategory(String name) {
        Connection c = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            Connection connection = DatabaseConnection.getConnection();
            connection.setAutoCommit(false);

            stmt = connection.createStatement();

            stmt.executeUpdate("INSERT INTO artifact_categories (name)"
                                         + "VALUES ('" + name + "')");
            rs = stmt.executeQuery("SELECT id from artifact_categories WHERE name = '" + name + "'");

            while (rs.next()) {
                Integer id = rs.getInt("id");
                ArtifactCategoryModel artifactCat = new ArtifactCategoryModel(id, name);
                this.itemsList.add(artifactCat);
            }
            stmt.close();
            c.commit();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
    }

}
