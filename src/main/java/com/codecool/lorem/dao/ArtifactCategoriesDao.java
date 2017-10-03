package com.codecool.lorem.dao;

import java.sql.*;
import com.codecool.lorem.models.ArtifactCategoryModel;

public class ArtifactCategoriesDao extends Dao<ArtifactCategoryModel> {

    public ArtifactCategoriesDao() {
        readFromDatabase();
    }

    private void readFromDatabase() {
        try {
            Connection connection = DatabaseConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT id, name FROM artifact_categories;");

            while (resultSet.next()) {

                Integer id = resultSet.getInt("id");
                String name = resultSet.getString("name");

                this.itemsList.add(new ArtifactCategoryModel(id, name));
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

    public void addToDatabase(String name) {
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

    public ArtifactCategoryModel getCategoryByName(String name) {
        return this.itemsList.stream()
                             .filter(category -> category.getName().equals(name))
                             .findFirst()
                             .orElse(null);
    }

}
