
package neu.edu.csye6200.model;

import java.util.ArrayList;
import java.util.List;

public class ClassRoom {
        private String name;
	private int size;
	private int maxAge;
        private int minAge;
	private String teacherName;
	private List<Student> students;
	private Teacher teacher;

    public ClassRoom() {
    }
    public ClassRoom(String name,int maxAge,int minAge,int size) {
        students = new ArrayList<>();
        teacher = new Teacher();
        this.name = name;
        this.size = size;
        this.minAge = minAge;
        this.maxAge = maxAge;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getMaxAge() {
        return maxAge;
    }

    public void setMaxAge(int maxAge) {
        this.maxAge = maxAge;
    }

    public int getMinAge() {
        return minAge;
    }

    public void setMinAge(int minAge) {
        this.minAge = minAge;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
    public boolean isAvailableClassRoom(){
        if(size==students.size()){
            return false;
        }
        return true;
    } 
}
