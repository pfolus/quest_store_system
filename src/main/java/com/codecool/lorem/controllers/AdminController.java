package com.codecool.lorem.controllers;

import com.codecool.lorem.models.AdminModel;
import com.codecool.lorem.views.AdminView;

public class AdminController {

    public static void runController(AdminModel admin) {
        String choice = "";

        while (!choice.equals("0")) {
            AdminView.showMenu();
            choice = chooseOption();
        }
    }

    public static String chooseOption() {
        String option = AdminView.getOption();

        return option;
    }

    public static void createMentor() {}

    public static void createClass() {}

    public static void editMentorProfile() {}

    public static void showMentorProfile() {}

    public static void createExperienceLevel() {}
}
