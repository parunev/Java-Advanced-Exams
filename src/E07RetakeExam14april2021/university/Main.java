package E07RetakeExam14april2021.university;

public class Main {
    public static void main(String[] args) {

        University university = new University(10);

        Student student = new Student("John","Smith","Astrology");
        Student student2 = new Student("Anna","Cameron","Geometry");
        Student student3 = new Student("Samy","Johnson","Algebra");
        Student student4 = new Student("Rihanna","Fenty","Music");
        Student student5 = new Student("Ellie","Goulding","Music");

        System.out.println(student);

        String registerStudent = university.registerStudent(student);
        System.out.println(university.getCapacity());
        System.out.println(registerStudent);
        String registerStudent2 = university.registerStudent(student2);
        String registerStudent3 = university.registerStudent(student3);
        String registerStudent4 = university.registerStudent(student4);

        String dismissStudent = university.dismissStudent(student);
        System.out.println(dismissStudent);
        String dismissStudent2 = university.dismissStudent(student5);
        System.out.println(dismissStudent2);

        System.out.println(university.getStudent("Rihanna","Fenty"));
        System.out.println(university.getStudentCount());
        System.out.println(university.getStatistics());
    }
}
