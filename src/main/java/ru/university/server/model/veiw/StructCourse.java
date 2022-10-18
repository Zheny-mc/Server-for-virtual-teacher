package ru.university.server.model.veiw;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.university.server.model.entity.UniversityСourse;


@RequiredArgsConstructor
@Component
@Data
public class StructCourse {
    private final UniversityСourse сourse;

    public String getStructCourse() {
        StringBuilder structCourse = new StringBuilder();
        structCourse.append( String.format("Курс: %s\n", сourse.getTitle()) );

        var сhapterList = сourse.getСhapterList();
        сhapterList.forEach(сhapter -> {
            int countChapter = сhapterList.indexOf(сhapter) + 1;
            structCourse.append(String.format("%2d) Раздел: %s\n", countChapter, сhapter.getTitle()));
            var testingList = сhapter.getTestingList();

            int countTest = 1;
            for (var testing: testingList) {
                structCourse.append( String.format("\t\t%2d.%2d) Тест: %s\n",
                        countChapter, countTest, testing.getTitle()) );
                countTest++;
            }
        });


        return structCourse.toString();
    }
}
