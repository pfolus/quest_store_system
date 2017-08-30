import java.util.ArrayList;
import java.util.Iterator;


public class Class{

    private ArrayList<MentorModel> mentorsList;
    private ArrayList<StudentModel> studentsList;
    private Integer id;

    private static Integer nextID = 1;

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

