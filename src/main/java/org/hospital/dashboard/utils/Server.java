package org.hospital.dashboard.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Server {

    @Value("${spring.application.name}") //Takes the name of the application
    private String graphicUserInterface;

    @Value("${server.port}")
    private int serverPort;

    public void startServer() {
        System.out.println("🤔 Wait a moment\n🔍Checking Server Availability....");
        System.out.printf("😎 Server is running on localhost %d! \nSpring Boot Application info: \n✔️%s%n", serverPort,graphicUserInterface);
    }
}
