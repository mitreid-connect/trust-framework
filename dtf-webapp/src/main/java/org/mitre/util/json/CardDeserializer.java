package org.mitre.util.json;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.mitre.dtf.model.Card;
import org.mitre.dtf.model.Dependency;
import org.mitre.dtf.model.Tag;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CardDeserializer extends JsonDeserializer<Card> {

	@Override
	public Card deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {

        ObjectCodec oc = jp.getCodec();
        JsonNode node = oc.readTree(jp);
        
        Card card = new Card();
        
        card.setId(node.get("id").asLong());
        card.setTitle(node.get("title").asText());
        card.setBusinessTxt(node.get("businessTxt").asText());
        card.setTechnicalTxt(node.get("technicalTxt").asText());
        card.setLegalTxt(node.get("legalTxt").asText());
        
        ObjectMapper objectMapper = new ObjectMapper();
        
        Set<Tag> tags = new HashSet<Tag>();
        for (JsonNode jn : node.get("providesTags")) {
        	Tag tag = objectMapper.readValue(jn.toString(), Tag.class);
        	tags.add(tag);
        }
        card.setProvidesTags(tags);
        
        List<Dependency> dependencies = new ArrayList<Dependency>();
        for (JsonNode jn : node.get("dependencies")) {
        	Dependency dependency = new Dependency();
        	dependency.setCard(card);
        	dependency.setId(jn.get("id").asLong());
        	dependency.setDescription(jn.get("description").asText());
        	Set<Tag> depTags = new HashSet<Tag>();
        	for (JsonNode tagJn : jn.get("tags")) {
            	Tag tag = objectMapper.readValue(tagJn.toString(), Tag.class);
            	depTags.add(tag);
        	}
        	dependency.setTags(depTags);
        	dependencies.add(dependency);
        }
        card.setDependencies(dependencies);
        
		return card;
	}

}
