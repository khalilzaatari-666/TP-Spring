package ma.zaatari.tp_spring.etudiant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface EtudiantRepository extends JpaRepository<Etudiant, Integer> {

    @Query("SELECT YEAR(e.dateNaissance) as year, COUNT(e) as nbr " +
            "FROM Etudiant e " +
            "GROUP BY YEAR(e.dateNaissance) " +
            "ORDER BY year")
    List<Object[]> findNbrEtudiantByYear();

}
