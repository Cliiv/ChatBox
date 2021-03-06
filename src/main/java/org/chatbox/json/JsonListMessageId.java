package org.chatbox.json;

import java.io.IOException;
import java.util.List;

import org.chatbox.business.Message;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

/**
 * Serializer for Message List Bean. Taking only the id instead of recursively
 * exploring each attributes.
 * 
 * @author ChatBox Corporation.
 * @version 1.0 - 2014-05-28
 */
public class JsonListMessageId extends JsonSerializer<List<Message>> {
	@Override
	public void serialize(List<Message> message, JsonGenerator jgen,
			SerializerProvider spro) throws IOException,
			JsonProcessingException {
		jgen.writeStartArray();
		for (Message e : message) {
			jgen.writeString(Long.toString(e.getId()));
		}
		jgen.writeEndArray();
	}
}