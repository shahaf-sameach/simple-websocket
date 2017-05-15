package Sample;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;

import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;
import java.io.IOException;
import java.io.StringReader;


public class MessageDecoderServer implements Decoder.Text<Message>{


	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void init(EndpointConfig arg0) {
		// TODO Auto-generated method stub

	}

	public Message decode(String message) {
	    Message msg = null;
	    if (willDecode(message)){
            try {
                JSONObject obj = new JSONObject(new StringReader(message));
                ObjectMapper mapper = new ObjectMapper();
                msg = mapper.readValue(message, Message.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return msg;
	}

	public boolean willDecode(String message) {
        try {
            JSONObject obj = new JSONObject(new StringReader(message));
            return true;
        } catch(Exception e){
            e.printStackTrace();
        }
        return false;
	}
	

}
