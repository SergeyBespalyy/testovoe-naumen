package testovoe.naumen.repository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import testovoe.naumen.model.Person;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

@Slf4j
@Component
public class FileRepository {
    private static final String filePath = "files/listName";

    public ArrayList<Person> load() {
        ArrayList<Person> personList = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(
                getClass().getClassLoader().getResourceAsStream(filePath)))) {
            while (bufferedReader.ready()){
                String line = bufferedReader.readLine();
                String[] lineSplit = line.split("_");
                personList.add(new Person(lineSplit[0], Integer.parseInt(lineSplit[1])));
            }
        } catch (NumberFormatException  e) {
            log.warn("Ошибка в данных файла, возможно в поле возвраст не число");
            throw new RuntimeException(e);
        }catch (IOException e) {
            log.warn("Файл по указанному пути не найден");
            throw new RuntimeException(e);
        }
        return personList;
    }
}
