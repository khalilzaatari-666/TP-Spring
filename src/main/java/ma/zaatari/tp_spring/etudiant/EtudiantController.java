package ma.zaatari.tp_spring.etudiant;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Etudiants")
public class EtudiantController {

    @Autowired
    private EtudiantRepository etudiantRepository;

    // Get Mappings

    @GetMapping("/all")
    public List<Etudiant> findAll() {
        return etudiantRepository.findAll();
    }

    @GetMapping("/count")
    public long countEtudiant() {
        return etudiantRepository.count();
    }

    @GetMapping("/byYear")
    public List<Object[]> findByYear() {
        return etudiantRepository.findNbrEtudiantByYear();
    }

    // Put Mapping

    @PostMapping("/save")
    public void addEtudiant(@RequestBody Etudiant etudiant) {
        etudiantRepository.save(etudiant);
    }

    // Delete mapping

    @DeleteMapping("/delete/{id}")
    public void deleteEtudiant(@PathVariable(required = true) Integer id) {
        etudiantRepository.deleteById(id);
    }
}