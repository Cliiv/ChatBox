package org.chatbox.json;

import java.io.IOException;

import org.chatbox.business.Message;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

public class JsonMessageId extends JsonSerializer<Message> {
	@Override
	public void serialize(Message message, JsonGenerator jgen,
			SerializerProvider spro) throws IOException,
			JsonProcessingException {
		jgen.writeString(Long.toString(message.getId()));

	}

}