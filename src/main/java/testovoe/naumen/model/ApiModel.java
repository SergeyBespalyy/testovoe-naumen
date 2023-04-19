package testovoe.naumen.model;

/**
 * Модель для парсинга АПИ сервиса
 * */
public class ApiModel {
    private int age;
    private String name;

    public ApiModel(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public ApiModel() {
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }


}
