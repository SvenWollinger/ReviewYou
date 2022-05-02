package de.muenchen.reviewyou;

import de.muenchen.reviewyou.Socket.reviewServer;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        reviewServer reviewServer = new reviewServer();
        reviewServer.start(1111);
    }
}
