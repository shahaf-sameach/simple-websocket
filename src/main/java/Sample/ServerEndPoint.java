package Sample;


import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;


@ServerEndpoint(value = "/ServerEndpoint", encoders = {MessageEncoderServer.class}, decoders = {MessageDecoderServer.class} )
public class ServerEndPoint {

	@OnOpen
	public void handleOpen(Session userSession) {
		System.out.println("open");
	}

	@OnMessage
	public void handleMessage(Message incomingMessage, Session userSession) throws IOException, EncodeException {
		System.out.println("[" + userSession.getId() +  "] got " + incomingMessage);
        userSession.getBasicRemote().sendObject(new Message("fuck off"));
	}

    @OnClose
    public void onClose(Session session, CloseReason closeReason) {
        System.out.println(String.format("Session %s closed because of %s", session.getId(), closeReason));
    }

    @OnError
    public void error(Session session, Throwable t) {
        System.out.println("Connection error. session " + session.getId() + " cause: " + t.toString());
    }


}
