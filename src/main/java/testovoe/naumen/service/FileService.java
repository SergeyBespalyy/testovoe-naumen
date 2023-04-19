package testovoe.naumen.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import testovoe.naumen.model.Person;
import testovoe.naumen.repository.FileRepository;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class FileService {

    private final FileRepository fileRepository;

    public ArrayList<Person> loadFile(){
        return fileRepository.load();
    }
}
