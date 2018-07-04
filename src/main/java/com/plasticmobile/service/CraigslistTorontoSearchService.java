package com.plasticmobile.service;

import java.util.List;

import com.plasticmobile.entity.CraigslistItem;

/**
 * 
 * @author Mingliang Ge
 * @version 0.0.1
 */
public interface CraigslistTorontoSearchService {

	/**
	 * Return Craigslist Items based on search Query
	 * @param query
	 * @return
	 */
	List<CraigslistItem> searchByQuery(String query);
	
	List<CraigslistItem> searchByQuery(String query, Integer skip);
	
}
