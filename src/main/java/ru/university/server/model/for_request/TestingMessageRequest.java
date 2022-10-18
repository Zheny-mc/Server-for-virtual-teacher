package ru.university.server.model.for_request;

import lombok.Value;
import ru.university.server.model.entity.Question;

import java.util.List;


@Value
public class TestingMessageRequest {
    private String title;
    private List<Question> questionList;
}
