package com.example.seminar005.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.core.GenericTransformer;
import org.springframework.integration.file.FileWritingMessageHandler;
import org.springframework.integration.file.support.FileExistsMode;
import org.springframework.messaging.MessageChannel;

import java.io.File;

@Configuration
public class MyConfig {
    @Bean
    public MessageChannel inputText(){
        System.out.println("1");
        return new DirectChannel();
    }

    @Bean
    public MessageChannel fileWriter(){
        System.out.println("2");
        return new DirectChannel();
    }

    @Bean
    @Transformer(inputChannel = "inputText", outputChannel = "fileWriter")
    public GenericTransformer <String, String> textTransformer (){
        System.out.println("3");
        return text -> {
            System.out.println(text);
            text=text.toLowerCase();
        return text;
        };
    }
    @Bean
    @ServiceActivator(inputChannel = "fileWriter")
    public FileWritingMessageHandler outhandler(){
        System.out.println("4");
        FileWritingMessageHandler fwmh = new FileWritingMessageHandler(new File("C:\\Users\\Евгений Титов\\Desktop\\програмирование учеба\\javaSpring\\seminar005\\src\\main\\java\\com\\example"));
        fwmh.setExpectReply(false);
        fwmh.setFileExistsMode(FileExistsMode.APPEND);
        fwmh.setAppendNewLine(true);

        return fwmh;
    }

}
