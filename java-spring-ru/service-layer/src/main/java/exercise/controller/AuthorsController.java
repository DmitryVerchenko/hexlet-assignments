package exercise.controller;

import exercise.dto.AuthorDTO;
import exercise.dto.AuthorCreateDTO;
import exercise.dto.AuthorUpdateDTO;
import exercise.exception.ResourceNotFoundException;
import exercise.service.AuthorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorsController {

    @Autowired
    private AuthorService authorService;

    // BEGIN
    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<AuthorDTO>> index() {
        var posts = authorService.getAll();

        return ResponseEntity.ok()
                .header("X-Total-Count", String.valueOf(posts.size()))
                .body(posts);
    }

    @GetMapping(path = "/{id}")
    public AuthorDTO show(@PathVariable long id) {
        return authorService.findById(id);
    }

    @PostMapping(path = "")
    @ResponseStatus(HttpStatus.CREATED)
    public AuthorDTO create(@RequestBody AuthorCreateDTO authorCreateDTO) {
        return authorService.create(authorCreateDTO);
    }

    @PutMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AuthorDTO update(@RequestBody @Valid AuthorUpdateDTO authorUpdateDTO, @PathVariable Long id) {
        return authorService.update(authorUpdateDTO, id);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable long id) {
        authorService.delete(id);
    }
    // END
}
