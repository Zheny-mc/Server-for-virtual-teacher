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
public class Question {

    String title;
    List<Answer> answerList;
    List<Recommendation> recommendationList;

    public void add(Answer q) {
        answerList.add(q);
    }

    public void addRecommendation(Recommendation r) {
        recommendationList.add(r);
    }

    public void clear() {
        title = "default";
        answerList.clear();
        recommendationList.clear();
    }
}
