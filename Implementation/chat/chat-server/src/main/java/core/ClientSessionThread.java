package core;

import net.MessageSocketThread;
import net.MessageSocketThreadListener;
import src.main.java.MessageLibrary;

import java.net.Socket;

public class ClientSessionThread extends MessageSocketThread {

    private boolean isAuthorized = false;
    private String nickname;

    public ClientSessionThread(MessageSocketThreadListener listener, String name, Socket socket) {
        super(listener, name, socket);
    }

    public boolean isAuthorized() {
        return isAuthorized;
    }

    public String getNickname() {
        return nickname;
    }

    public void authAccept(String nickname) {
        this.nickname = nickname;
        this.isAuthorized = true;
        sendMessage( MessageLibrary.getAuthAcceptMessage(nickname));
    }

    public void authDeny() {
        sendMessage(MessageLibrary.getAuthDeniedMessage());
        close();
    }

    public void authError(String msg) {
        sendMessage(MessageLibrary.getMsgFormatErrorMessage(msg));
        close();
    }

}