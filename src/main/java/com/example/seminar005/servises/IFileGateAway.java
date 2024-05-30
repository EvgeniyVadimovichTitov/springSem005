package com.example.seminar005.servises;

import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.file.FileHeaders;
import org.springframework.messaging.handler.annotation.Header;

@MessagingGateway(defaultRequestChannel = "inputText")
public interface IFileGateAway {

    void writeToFile (@Header(FileHeaders.FILENAME) String filename, String data);
}
