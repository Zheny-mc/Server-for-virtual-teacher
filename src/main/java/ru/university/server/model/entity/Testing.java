package ru.university.server.model.entity;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import ru.university.server.model.for_request.TestingMessageRequest;

import java.util.ArrayList;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Testing {
    String title;
    List<Question> questionList;
    Integer currentQuestion;

    public Testing(String title) {
        this.title = title;
        this.questionList = new ArrayList<>();
        this.currentQuestion = 0;
    }

    public void clearIteratorQuestion() {
        currentQuestion = 0;
    }

    public void add(Question q) {
        questionList.add(q);
    }

    public Question getFirst() throws Exception {
        if (questionList.isEmpty())
            throw new Exception("There are no questions");

        currentQuestion = 0;
        return questionList.get(currentQuestion);
    }

    public Question next() throws Exception {
        if (currentQuestion + 1 >= questionList.size()) {
            throw new Exception("No more questions");
        }
        ++currentQuestion;
        return questionList.get(currentQuestion);
    }

    public TestingMessageRequest toRequest() {
        return new TestingMessageRequest(
                this.title,
                this.questionList
        );
    }
}



