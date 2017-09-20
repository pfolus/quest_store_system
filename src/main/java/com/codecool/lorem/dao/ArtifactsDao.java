package com.codecool.lorem.dao;

import java.sql.*;
import java.util.Iterator;

import com.codecool.lorem.models.ArtifactModel;

public class ArtifactsDao extends Dao<ArtifactModel> {

    public ArtifactModel getById(Integer id) {
        for (ArtifactModel artifact : getItems()) {
            if (artifact.getId().equals(id)) {
                return artifact;
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
            c.close();

        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

    public void addArtifact(String name, Integer categoryId, String description, Integer price) {
        Connection c = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {

            c = DriverManager.getConnection("jdbc:sqlite:src/main/db/quest-store.db");
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
            c.close();


        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
    }


}
