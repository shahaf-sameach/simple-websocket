package Sample;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

public class MessageEncoderServer implements Encoder.Text<Message> {

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void init(EndpointConfig arg0) {
		// TODO Auto-generated method stub
	}


	public String encode(Message message) throws EncodeException {
		ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(message);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "";
        }
    }
}
