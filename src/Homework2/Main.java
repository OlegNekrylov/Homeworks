package Homework2;

import java.util.*;
import java.util.stream.Stream;

import static Homework2.Education.HIGHER;

public class Main {
    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4);
        Collections.sort(intList);
        for (Integer i : intList) {
            if (i > 0 && i % 2 == 0){
                System.out.println(i);
            }
        }
        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10_000_000; i++) {
            persons.add(new Person(
                    names.get(random.nextInt(names.size())),
                    families.get(random.nextInt(families.size())),
                    random.nextInt(100),
                    Sex.values()[random.nextInt(Sex.values().length)],
                    Education.values()[random.nextInt(Education.values().length)])
            );
        }
        System.out.println("Количество несовершеннолетних: " + persons.stream().filter(x -> x.getAge() < 18).count());
        List<String> list = persons.stream().filter(x -> x.getAge() >= 18 && x.getAge() < 27 && x.getSex() == Sex.MAN).map(x -> x.getFamily()).toList();
        List<Person> people = persons.stream().filter(x -> x.getAge() >= 18 && x.getEducation() == HIGHER).
                filter(x -> x.getAge() < 60 && x.getSex() == Sex.WOMAN || x.getAge() < 65 && x.getSex() == Sex.MAN).sorted(Comparator.comparing(Person::getFamily)).toList();
        System.out.println();



    }
}
