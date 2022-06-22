package E07RetakeExam14april2021.university;

import java.util.ArrayList;
import java.util.List;

public class University {
    public List<Student> students;
    public int capacity;

    public University(int capacity){
        this.capacity = capacity;
        students = new ArrayList<>();
    }

    public List<Student> getStudents() {return students;}
    public int getCapacity() {return capacity;}
    public int getStudentCount(){return students.size();}

    public String registerStudent(Student student){
        if (capacity > students.size() && !students.contains(student)){
            students.add(student);
            return String.format("Added student %s %s",student.getFirstName(),student.getLastName());
        }else if (students.contains(student)){
            return "Student is already in the E07RetakeExam14april2021.university";
        }else if (capacity <= students.size()){
            return "No seats in the E07RetakeExam14april2021.university";
        }
        return null;
    }

    public String dismissStudent(Student student){
        if (!students.contains(student)){
            return "Student not found";
        }else{
            students.remove(student);
            return String.format("Removed student %s %s", student.getFirstName(),student.getLastName());
        }
    }

    public Student getStudent(String firstName, String lastName){
        for (Student cs : students){
            if (cs.getFirstName().equals(firstName) && cs.getLastName().equals(lastName)){
                return cs;
            }
        }
        return null;
    }

    public String getStatistics(){
        StringBuilder sb = new StringBuilder();
        for (Student cs:students){
            sb.append(String.format("==Student: First name = %s, Last name = %s, Best Subject = %s%n",
                    cs.getFirstName(),cs.getLastName(),cs.getBestSubject()));
        }
        return sb.toString().trim();
    }


}
