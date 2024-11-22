package ma.emsi.gestionetudianttp5.repo;

import ma.emsi.gestionetudianttp5.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;


@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    Student findById(int id);
    @Query("SELECT YEAR (s.dateNaissance), " +
            "COUNT(s) FROM Student s " +
            "GROUP BY YEAR(s.dateNaissance)")
    Collection<Object []> findNbrStudentByYear();

}
