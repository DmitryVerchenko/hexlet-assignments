package exercise.service;

import exercise.dto.AuthorCreateDTO;
import exercise.dto.AuthorDTO;
import exercise.dto.AuthorUpdateDTO;
import exercise.exception.ResourceNotFoundException;
import exercise.mapper.AuthorMapper;
import exercise.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository repository;

    @Autowired
    private AuthorMapper authorMapper;


    public List<AuthorDTO> getAll() {
        var authors = repository.findAll();
        var result = authors.stream()
                .map(authorMapper::map)
                .toList();
        return result;
    }

    public AuthorDTO create(AuthorCreateDTO authorCreateDTO) {
        var author = authorMapper.map(authorCreateDTO);
        //author.setAuthor(userUtils.getCurrentUser());
        repository.save(author);
        var authorDTO = authorMapper.map(author);
        return authorDTO;
    }

    public AuthorDTO findById(Long id) {
        var author = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not Found: " + id));
        var authorDTO = authorMapper.map(author);
        return authorDTO;
    }

    public AuthorDTO update(AuthorUpdateDTO authorUpdateDTO, Long id) {
        var post = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not Found"));
        authorMapper.update(authorUpdateDTO, post);
        repository.save(post);
        var authorDTO = authorMapper.map(post);
        return authorDTO;
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
