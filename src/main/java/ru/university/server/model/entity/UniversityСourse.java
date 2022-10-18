package ru.university.server.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Document
public class UniversityСourse {

    @Id
    private String _id;
    @NonNull
    private String title;
    @NonNull
    private List<Сhapter> сhapterList;

    public void addTest(Сhapter сhapter) {
        сhapterList.add(сhapter);
    }

    public void clearСhapterList() {
        сhapterList.clear();
    }
}
