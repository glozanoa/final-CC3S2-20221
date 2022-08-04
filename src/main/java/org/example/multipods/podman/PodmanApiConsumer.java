package org.example.multipods.podman;

import okhttp3.OkHttpClient;
import org.example.multipods.ApiConsumer;
import org.newsclub.net.unix.AFUNIXSocketAddress;

import java.io.File;
import java.net.SocketAddress;
import java.net.SocketException;

public class PodmanApiConsumer extends ApiConsumer {

    public PodmanApiConsumer() throws SocketException {
        super(AFUNIXSocketAddress.of(new File("/run/podman/podman.sock")));
    }
}