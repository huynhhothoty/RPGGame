package hcmute.myrpggame.controller;

import hcmute.myrpggame.dtos.quest.questDto;
import hcmute.myrpggame.service.quest.questService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/quest")
public class questController {

    private final questService questService;

    public questController(hcmute.myrpggame.service.quest.questService questService) {
        this.questService = questService;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody questDto dto){
        try {
            return new ResponseEntity<>(questService.create(dto), HttpStatus.OK);
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
            return new ResponseEntity<>(questService.getAll(page, size), HttpStatus.OK);
        } catch (Exception e) {
            String msg = e.getMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(msg);
        }
    }

    @GetMapping("/id")
    public ResponseEntity<?> getAll(@RequestParam String id){
        try {
            return new ResponseEntity<>(questService.getById(id), HttpStatus.OK);
        } catch (Exception e) {
            String msg = e.getMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(msg);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody questDto dto, @PathVariable String id) {
        try {
            return new ResponseEntity<>(questService.update(id, dto), HttpStatus.OK);
        } catch (Exception e) {
            String msg = e.getMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(msg);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        try {
            return new ResponseEntity<>(questService.delete(id), HttpStatus.OK);
        } catch (Exception e) {
            String msg = e.getMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(msg);
        }
    }
}
