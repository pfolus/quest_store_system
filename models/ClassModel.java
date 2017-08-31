package models;

import java.util.ArrayList;
import java.util.Iterator;


public class ClassModel {

    private ArrayList<MentorModel> mentorsList;
    private ArrayList<StudentModel> studentsList;
    private Integer id;

    private static Integer nextId = 1;

    public Class() {
        this.mentorsList = new ArrayList<MentorModel>();
        this.studentsList = new ArrayList<StudentModel>();
        this.id = nextID++;
    }

    public Iterator getStudentsIterator() {
        return this.studentsList.iterator();
    }

    public void removeStudent(Integer id) {
        Iterator iter = this.getStudentsIterator();

        while (iter.hasNext()) {
            if (next().getID().equals(id)) {
                iter.remove();
            }
        }
    }

    public Iterator getMentorsIterator() {
        return this.mentorsList.iterator();
    }

    public void removeMentor(Integer id) {
        Iterator iter = this.getMentorsIterator();

        while (iter.hasNext()) {
            if (next().getID().equals(id)) {
                iter.remove();
            }
        }
    }

    public void addMentor(MentorModel mentor) {
        this.mentorsList.add(mentor);
    }

    public void addStudent(StudentModel student) {
        this.studentsList.add(student);
    }
}
