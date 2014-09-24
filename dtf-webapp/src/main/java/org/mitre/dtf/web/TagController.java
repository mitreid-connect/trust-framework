/**
 * 
 */
package org.mitre.dtf.web;

import java.util.Set;

import org.mitre.dtf.model.Tag;
import org.mitre.dtf.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wkim
 *
 */
@RestController
public class TagController {

	@Autowired
	TagService tagService;
	
	@RequestMapping(value = "/tag", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('ROLE_USER')")
	public @ResponseBody Set<Tag> getAll() {
		
		return tagService.getAll();
	}
	
	@RequestMapping(value = "/tag/new", method = RequestMethod.POST, consumes = "application/json")
	@PreAuthorize("hasRole('ROLE_USER')")
	public @ResponseBody Tag addNewTag(@RequestBody String tagName) {
		Tag tag = new Tag();
		tag.setName(tagName);
		return tagService.save(tag);
	}
}
