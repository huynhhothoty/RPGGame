package hcmute.myrpggame.controller;

import hcmute.myrpggame.dtos.character.charDto;
import hcmute.myrpggame.service.character.charService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/character")
public class charController {

    private final charService charService;

    public charController(hcmute.myrpggame.service.character.charService charService) {
        this.charService = charService;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody charDto dto){
        try {
            return new ResponseEntity<>(charService.create(dto), HttpStatus.OK);
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
            return new ResponseEntity<>(charService.getAll(page, size), HttpStatus.OK);
        } catch (Exception e) {
            String msg = e.getMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(msg);
        }
    }

    @GetMapping("/id")
    public ResponseEntity<?> getAll(@RequestParam String id){
        try {
            return new ResponseEntity<>(charService.getById(id), HttpStatus.OK);
        } catch (Exception e) {
            String msg = e.getMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(msg);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody charDto dto, @PathVariable String id) {
        try {
            return new ResponseEntity<>(charService.update(id, dto), HttpStatus.OK);
        } catch (Exception e) {
            String msg = e.getMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(msg);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        try {
            return new ResponseEntity<>(charService.delete(id), HttpStatus.OK);
        } catch (Exception e) {
            String msg = e.getMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(msg);
        }
    }
}
