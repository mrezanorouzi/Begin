package ir.maktab;
import ir.maktab.entities.Address;
import ir.maktab.entities.Student;
import ir.maktab.entities.Teacher;
import ir.maktab.util.JpaUtil;

import javax.persistence.EntityManager;
import java.util.Date;
import java.util.HashSet;

public class App {
    public static void main(String[] args) {

        EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        Address address = new Address();
        Address address1 = new Address();
        Address address2 = new Address();
        address.setCity("eslamshahr");
        address.setPostalCode("1234567");
        address.setPostalAddress("golha-madar street");
        address.setState("Tehran");
        address.setNumber(4);
        entityManager.persist(address);
        entityManager.persist(address1);
        entityManager.persist(address2);

        HashSet<Teacher> teachers = new HashSet<>();
        HashSet<Student> students = new HashSet<>();
        HashSet<Address> addresses = new HashSet<>();
        addresses.add(address);
        addresses.add(address1);
        addresses.add(address2);

        Date tchBirthDay = new Date(10000);
        Teacher teacher = new Teacher();
        teacher.setFirstName("ehsan");
        teacher.setLastName("ahmadi");
        teacher.setAddress(address);
        teacher.setBirthDay(tchBirthDay);
        teacher.setPhoneNumber("912");
        teacher.setTeacherCode(24932);
        teacher.setSalary(10.2);
        teacher.setStudents(students);
        teachers.add(teacher);
        entityManager.persist(teacher);

//        Teacher teacher1 = new Teacher();
//        teacher1.setFirstName("kamran");
//        teacher1.setLastName("bani");
//        teacher1.setAddress(address);
//        teacher1.setTeacherCode(25832);
//        teacher1.setBirthDay(tchBirthDay);
//        teacher1.setPhoneNumber("91092");
//        teacher1.setSalary(10.2);
//        teacher1.setStudents(students);
//        teachers.add(teacher1);
//        entityManager.persist(teacher1);

        Student student1 = new Student();
        student1.setFirstName("ali");
        student1.setLastName("eslami");
        student1.setBirthDay(new Date());
        student1.setAddressSet(addresses);
        student1.setPhoneNumber("56782121");
        student1.setStudentCode(42325);
        student1.setTeachers(teachers);
        entityManager.persist(student1);

        Student student2 = new Student();
        student2.setFirstName("nima");
        student2.setLastName("ebrahimi");
        student2.setBirthDay(new Date());
        //student2.setAddressSet(addresses);
        student2.setPhoneNumber("562348921");
        student2.setStudentCode(423231);
        student2.setTeachers(teachers);
        entityManager.persist(student2);


        Student student3 = new Student();
        student3.setFirstName("mohammad");
        student3.setLastName("saadati");
        student3.setBirthDay(new Date());
        //student3.setAddressSet(addresses);
        student3.setPhoneNumber("567128921");
        student3.setStudentCode(42213);
        student3.setTeachers(teachers);
        entityManager.persist(student3);


        entityManager.getTransaction().commit();
        entityManager.close();
        JpaUtil.shutdown();

    }
}
