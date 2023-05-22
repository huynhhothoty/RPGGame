package hcmute.myrpggame.controller;

import hcmute.myrpggame.dtos.monster.monsterDto;
import hcmute.myrpggame.service.monster.monsterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/monster")
public class monsterController {

    private final monsterService monsterService;

    public monsterController(hcmute.myrpggame.service.monster.monsterService monsterService) {
        this.monsterService = monsterService;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody monsterDto dto){
        try {
            return new ResponseEntity<>(monsterService.create(dto), HttpStatus.OK);
        } catch (Exception e) {
            String msg = e.getMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(msg);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "2") int size ){
        try {
            return new ResponseEntity<>(monsterService.getAll(page, size), HttpStatus.OK);
        } catch (Exception e) {
            String msg = e.getMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(msg);
        }
    }

    @GetMapping("/id")
    public ResponseEntity<?> getAll(@RequestParam String id){
        try {
            return new ResponseEntity<>(monsterService.getById(id), HttpStatus.OK);
        } catch (Exception e) {
            String msg = e.getMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(msg);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody monsterDto dto, @PathVariable String id) {
        try {
            return new ResponseEntity<>(monsterService.update(id, dto), HttpStatus.OK);
        } catch (Exception e) {
            String msg = e.getMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(msg);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        try {
            return new ResponseEntity<>(monsterService.delete(id), HttpStatus.OK);
        } catch (Exception e) {
            String msg = e.getMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(msg);
        }
    }
}
