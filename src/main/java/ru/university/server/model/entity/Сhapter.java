package ru.university.server.model.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Сhapter {
    String title;
    List<Testing> testingList;

    public void addTest(Testing testing) {
        testingList.add(testing);
    }

    public void clearTestingList() {
        testingList.clear();
    }
}
