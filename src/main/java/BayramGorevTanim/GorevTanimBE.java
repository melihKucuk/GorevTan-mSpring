package BayramGorevTanim;

import GorevServis.GorevServis;
import lombok.AllArgsConstructor;
import model.gorev;
import org.apache.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


//@SpringBootConfiguration
@RequestMapping(value = "/gorevtanim")
@RestController
@AllArgsConstructor

public class GorevTanimBE {
        private final GorevServis GorevServis;

        @GetMapping
        public ResponseEntity<List<gorev>> getGorevler(String name){
            return new  ResponseEntity<>(GorevServis.getGorevler(name), org.springframework.http.HttpStatus.valueOf(HttpStatus.SC_OK));
        }
        @GetMapping("/{id}")
        public ResponseEntity<gorev> getGorev(@PathVariable String id) {
            return new ResponseEntity<>(GorevServis.getGorevById, org.springframework.http.HttpStatus.OK);
        }

        @PostMapping
        public ResponseEntity<gorev> createGorev(@RequestBody gorev newGorev){
            return new ResponseEntity<>(GorevServis.createGorev(newGorev), org.springframework.http.HttpStatus.CREATED);
        }

        @PutMapping
        public ResponseEntity<Void>getGorev(@PathVariable String id,@RequestBody gorev newGorev){
            gorev oldGorev=getGorevById(id);
            oldGorev.setName(newGorev.getName());
            oldGorev.setCreatedate(new Date());

            GorevServis.updateGorev(id,newGorev);

            return new ResponseEntity<>(org.springframework.http.HttpStatus.OK);
        }
        @DeleteMapping("/{id}")
        public ResponseEntity<Void>deleteGorev(@PathVariable String id){
            GorevServis.deleteGorev(id);
            return new ResponseEntity<>(org.springframework.http.HttpStatus.OK);

        }


        public gorev getGorevById(String id){
            GorevServis.getGorevById(id);

            return null;
        }

    }