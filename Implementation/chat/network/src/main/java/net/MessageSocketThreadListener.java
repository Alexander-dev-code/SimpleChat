package net;

import java.io.IOException;

public interface MessageSocketThreadListener {

    void onSocketReady();
    void onSocketClosed();
    void onMessageReceived(String msg);
    void onException(Throwable throwable);
}
