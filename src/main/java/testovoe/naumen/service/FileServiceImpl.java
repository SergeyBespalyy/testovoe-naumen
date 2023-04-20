package testovoe.naumen.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import testovoe.naumen.model.Person;
import testovoe.naumen.repository.FileRepository;

import java.util.ArrayList;

/**
 * Service для работы с данными из файла по адресу 'src/main/resources/files/listName'
 * */

@Service
@RequiredArgsConstructor
public class FileServiceImpl implements  FileService {

    private final FileRepository fileRepository;

    public ArrayList<Person> loadFile(){
        return fileRepository.load();
    }
}
