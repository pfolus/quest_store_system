package com.codecool.lorem.dao;

import java.util.Iterator;

import com.codecool.lorem.models.MentorModel;

public class MentorsDao extends Dao<MentorModel> {

    public MentorModel getById(Integer id) {
        for (MentorModel mentor : getItems()) {
            if (mentor.getId().equals(id)) {
                return mentor;
            }
        }
        return null;
    }

}
