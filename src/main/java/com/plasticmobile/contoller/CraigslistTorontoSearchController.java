package com.plasticmobile.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.plasticmobile.entity.CraigslistItem;
import com.plasticmobile.service.CraigslistTorontoSearchService;

/**
 * 
 * @author Mingliang Ge
 * @version 0.0.1
 */
@RestController
public class CraigslistTorontoSearchController {

	@Autowired
	CraigslistTorontoSearchService craigslistTorontoSearchService;
	
	@RequestMapping("/search")
	public List<CraigslistItem> getSearchResponse(@RequestParam String query, 
			@RequestParam(required = false, defaultValue="0") Integer skip) {
		return craigslistTorontoSearchService.searchByQuery(query, skip);
	}

}
