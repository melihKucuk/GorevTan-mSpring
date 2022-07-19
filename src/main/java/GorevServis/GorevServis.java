package GorevServis;

import com.GorevTanim.GorevRepository;
import lombok.AllArgsConstructor;
import model.gorev;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class GorevServis {

    private final com.GorevTanim.GorevRepository GorevRepository;
    public gorev getGorevById;

    public List<gorev> getGorevler(String name) {

        return GorevRepository.findAll();
    }

    public gorev createGorev(gorev newGorev) {
        return GorevRepository.save(newGorev);
    }

    public void deleteGorev(String id) {
        GorevRepository.deleteById(id);
    }

    public gorev getGorevById(String id) {
        Optional<gorev>byId=GorevRepository.findById(id);
        if (byId.isEmpty()){
            throw new RuntimeException("bulunamadı.");
        }
        return byId.get();

    }

    public void updateGorev(String id, gorev newGorev) {
        gorev oldGorev=getGorevById(id);
        oldGorev.setName(newGorev.getName());
        GorevRepository.save(oldGorev);
    }
}