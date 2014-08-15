package org.mitre.dtf.test;

import java.nio.charset.Charset;

import org.mitre.dtf.model.Card;
import org.mitre.dtf.model.Dependency;
import org.mitre.dtf.model.Tag;
import org.springframework.http.MediaType;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

/**
 * Class for storing unit test data in one place.
 * The initialize() method should be called before variables from here are used.
 * @author wkim
 *
 */
public final class TestData {
	
	/*
	 * See src/resources/db/*.sql files for expected initial data.
	 */
	
	// test data
	public static final Card CARD1 = new Card("MIT/MITRE Scenario", 
			"The Handshake site allows MITRE users to invite non-MITRE users to participate on the Handshake site.");
	public static final Card CARD2 = new Card("id.mitre.org", 
			"MITREid is an OpenID Identity Provider for MITRE employees.");
	
	public static final Dependency DEPENDENCY1 = new Dependency("OpenID Provider #1");
	public static final Dependency DEPENDENCY2 = new Dependency("OpenID Provider #2");
	
	public static final Tag TAG1 = new Tag("OpenID Provider");
	
    public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),                       
            Charset.forName("utf8")                    
            );
	
	public static void initialize() {
		TAG1.setId(1L);
		
		DEPENDENCY1.setId(1L);
		DEPENDENCY1.setCard(CARD1);
		DEPENDENCY1.setTags(Sets.newHashSet(TAG1));
		DEPENDENCY2.setId(2L);
		DEPENDENCY2.setCard(CARD1);
		DEPENDENCY2.setTags(Sets.newHashSet(TAG1));
		
		CARD1.setId(1L);
		CARD1.setDependencies(Lists.newArrayList(DEPENDENCY1, DEPENDENCY2));
		
		CARD2.setId(2L);
		CARD2.setProvidesTags(Sets.newHashSet(TAG1));
	}
}
