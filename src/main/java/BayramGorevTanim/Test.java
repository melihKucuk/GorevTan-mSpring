package BayramGorevTanim;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping(value = "/test")
public class Test {

    @GetMapping(value = "/test12", produces = "application/json")
    @ResponseBody
    public ResponseEntity<String> getTest(){
        return new  ResponseEntity<>("Hello World", org.springframework.http.HttpStatus.valueOf(HttpStatus.SC_OK));
    }
}
