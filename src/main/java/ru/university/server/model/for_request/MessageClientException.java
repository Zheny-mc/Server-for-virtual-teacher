package ru.university.server.model.for_request;

public class MessageClientException extends RuntimeException {
    public MessageClientException(String message) {
        super(message);
    }
}
