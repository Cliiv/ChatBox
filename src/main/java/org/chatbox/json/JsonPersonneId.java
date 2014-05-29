package org.chatbox.json;

import java.io.IOException;

import org.chatbox.business.Personne;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

/**
 * Serializer for Personne Bean. Taking only the id instead of recursively
 * exploring each attributes.
 * 
 * @author ChatBox Corporation.
 * @version 1.0 - 2014-05-28
 */
public class JsonPersonneId extends JsonSerializer<Personne> {
	@Override
	public void serialize(Personne personne, JsonGenerator jgen,
			SerializerProvider spro) throws IOException,
			JsonProcessingException {
		jgen.writeString(Long.toString(personne.getIdPersonne()));

	}

}