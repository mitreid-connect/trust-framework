package org.mitre.dtf.test;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashSet;

import org.mitre.dtf.model.Card;
import org.mitre.dtf.model.CardNode;
import org.mitre.dtf.model.Dependency;
import org.mitre.dtf.model.Instance;
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
	public static final Card CARD1 = new Card();
	public static final Card CARD2 = new Card();
	
	public static final Dependency DEPENDENCY1 = new Dependency("OpenID Provider #1");
	public static final Dependency DEPENDENCY2 = new Dependency("OpenID Provider #2");
	
	public static final Tag TAG1 = new Tag("OpenID Provider");
	
	public static final CardNode CARDNODE1 = new CardNode();
	public static final CardNode CARDNODE2 = new CardNode();
	public static final Instance INSTANCE1 = new Instance();
	
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
		CARD1.setTitle("MIT/MITRE Scenario");
		CARD1.setBusinessTxt("This is the BUSINESS text.");
		CARD1.setLegalTxt("This is the LEGAL text.");
		CARD1.setTechnicalTxt("This is the TECHNICAL text.");
		CARD1.setProvidesTags(new HashSet<Tag>());
		CARD1.setDependencies(Lists.newArrayList(DEPENDENCY1, DEPENDENCY2));
		
		CARD2.setId(2L);
		CARD2.setTitle("id.mitre.org");
		CARD2.setBusinessTxt("This is the BUSINESS text.");
		CARD2.setLegalTxt("This is the LEGAL text.");
		CARD2.setTechnicalTxt("This is the TECHNICAL text.");
		CARD2.setProvidesTags(Sets.newHashSet(TAG1));
		CARD2.setDependencies(new ArrayList<Dependency>());
		
		CARDNODE1.setId(1);
		CARDNODE1.setCard(CARD1);
		CARDNODE2.setId(2);
		CARDNODE2.setCard(CARD2);
		CARDNODE2.setParentCardNode(CARDNODE1);
		
		INSTANCE1.setId(1);
		INSTANCE1.setName("First Instance");
		INSTANCE1.setRootCardNode(CARDNODE1);
		INSTANCE1.setCardNodeTree(Sets.newHashSet(CARDNODE1, CARDNODE2));
		
	}
}
