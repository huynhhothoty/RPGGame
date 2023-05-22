package hcmute.myrpggame.controller;

import hcmute.myrpggame.dtos.gameClass.classDto;
import hcmute.myrpggame.service.gameClass.classService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/class")
public class classController {

    private final classService classService;

    public classController(hcmute.myrpggame.service.gameClass.classService classService) {
        this.classService = classService;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody classDto dto){
        try {
            return new ResponseEntity<>(classService.create(dto), HttpStatus.OK);
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
            return new ResponseEntity<>(classService.getAll(page, size), HttpStatus.OK);
        } catch (Exception e) {
            String msg = e.getMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(msg);
        }
    }

    @GetMapping("/id")
    public ResponseEntity<?> getAll(@RequestParam String id){
        try {
            return new ResponseEntity<>(classService.getById(id), HttpStatus.OK);
        } catch (Exception e) {
            String msg = e.getMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(msg);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody classDto dto, @PathVariable String id) {
        try {
            return new ResponseEntity<>(classService.update(id, dto), HttpStatus.OK);
        } catch (Exception e) {
            String msg = e.getMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(msg);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        try {
            return new ResponseEntity<>(classService.delete(id), HttpStatus.OK);
        } catch (Exception e) {
            String msg = e.getMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(msg);
        }
    }
}
