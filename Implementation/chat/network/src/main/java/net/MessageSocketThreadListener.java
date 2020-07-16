package net;

import java.io.IOException;

public interface MessageSocketThreadListener {

    //  void onSocketStarted();
//  void onSocketClosed();
    void onMessageReceived(String msg);
    void onException(Throwable throwable);

    void onSocketException(MessageSocketThread messageSocketThread, IOException e);
}
