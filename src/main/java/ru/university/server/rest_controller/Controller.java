package ru.university.server.rest_controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.university.server.Security.model.Developer;
import ru.university.server.model.entity.Testing;
import ru.university.server.model.for_request.SendMessageRequest;
import ru.university.server.model.for_request.TestingMessageRequest;
import ru.university.server.model.veiw.StructCourse;
import ru.university.server.services.InfoTesting;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("api/server")
@AllArgsConstructor
@Slf4j
public class Controller {

    private final StructCourse structCourse;
    private final InfoTesting testing;

    @PostMapping("/struct-course")
    @PreAuthorize("hasAuthority('developers:write')")
    public String getStructCourse(@RequestBody SendMessageRequest request) {
        String title = request.getTitle();
        log.info("title course = " + title);
        return structCourse.getStructCourse();
    }

    @PostMapping("/test")
    @PreAuthorize("hasAuthority('developers:write')")
    public TestingMessageRequest getTesting(@RequestBody SendMessageRequest request) {
        String title = request.getTitle();
        log.info("title testing = " + title);
        return testing.getTesting(title).toRequest();
    }

    @GetMapping("/status-test")
    @PreAuthorize("hasAuthority('developers:read')")
    public Boolean getStatusTest() {
        log.info("status-test = " + testing.getIsEndTest());
        return testing.getIsEndTest();
    }

    @PostMapping("/status-test")
    @PreAuthorize("hasAuthority('developers:write')")
    public void setStatusTest(@RequestBody SendMessageRequest request) {
        Boolean isEndTest = request.getIsEndTest();
        log.info("testing.setIsAnswer("+ isEndTest + ")");
        testing.setIsEndTest(isEndTest);
    }
}