package org.example;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
            // Создание массива объектов типа Animal
            Animal[] animals = {
                    new Dog("Buddy", 3, "Golden Retriever"),
                    new Cat("Whiskers", 2, true),
                    // Добавьте дополнительные объекты по необходимости
            };

            // Использование Reflection API
            for (Animal animal : animals) {
                // Вывод информации о каждом объекте
                Class<?> animalClass = animal.getClass();
                System.out.println("Class: " + animalClass.getSimpleName());

                Field[] fields = animalClass.getDeclaredFields();
                for (Field field : fields) {
                    field.setAccessible(true);
                    try {
                        System.out.println(field.getName() + ": " + field.get(animal));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }

                // Вызов метода makeSound() у каждого объекта, если он присутствует
                try {
                    Method makeSoundMethod = animalClass.getMethod("makeSound");
                    makeSoundMethod.invoke(animal);
                } catch (Exception e) {
                    // Обработка исключений, если метод не найден или возникли другие проблемы
                    // В данном случае, ничего не предпринимаем, так как отсутствие метода makeSound() не является ошибкой
                }

                System.out.println(); // Добавление пустой строки между объектами для удобства чтения
            }
        }
}