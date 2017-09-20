package com.codecool.lorem.dao;

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

}
