package org.chatbox.json;

import java.io.IOException;
import java.util.List;

import org.chatbox.business.Personne;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

public class JsonListPersonneId extends JsonSerializer<List<Personne>> {
	@Override
	public void serialize(List<Personne> personne, JsonGenerator jgen,
			SerializerProvider spro) throws IOException,
			JsonProcessingException {
		jgen.writeStartArray();
		for (Personne e : personne) {
			jgen.writeString(Long.toString(e.getIdPersonne()));
		}
		jgen.writeEndArray();
	}
}