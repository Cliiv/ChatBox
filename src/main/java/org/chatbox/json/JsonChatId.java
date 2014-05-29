package org.chatbox.json;

import java.io.IOException;

import org.chatbox.business.Chat;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

public class JsonChatId extends JsonSerializer<Chat> {
	@Override
	public void serialize(Chat chat, JsonGenerator jgen, SerializerProvider spro)
			throws IOException, JsonProcessingException {
		jgen.writeString(Long.toString(chat.getId()));

	}

}