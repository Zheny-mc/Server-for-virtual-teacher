package ru.university.server.services;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import ru.university.server.model.entity.Testing;
import ru.university.server.model.entity.UniversityСourse;

import java.util.Arrays;
import java.util.stream.Collectors;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class InfoTesting {

    final UniversityСourse сourse;
    @Getter @Setter
    Boolean isEndTest;

    public InfoTesting(UniversityСourse сourse) {
        this.сourse = сourse;
        this.isEndTest = false;
    }
    public Testing getTesting(String text) {
        var pathFoTest = Arrays.stream(text.split("_"))
                .map(i -> Integer.parseInt(i))
                .collect(Collectors.toList());

        Testing testing = selectTest(pathFoTest.get(0), pathFoTest.get(1));
        return testing;
    }

    private Testing selectTest(Integer sectionNumber, Integer testNumber) {
        sectionNumber--;
        testNumber--;
        return сourse.getСhapterList().get(sectionNumber)
                .getTestingList().get(testNumber);
    }
}
