package com.plasticmobile.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.plasticmobile.entity.CraigslistItem;
import com.sun.syndication.feed.module.DCModule;
import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;

/**
 * 
 * @author Mingliang Ge
 * @version 0.0.1
 */

@Service
public class CraigslistTorontoSearchServiceImpl implements CraigslistTorontoSearchService {
	
	private static final String SEARCH_BY_QUERY="https://toronto.craigslist.ca/search/hhh?format=rss&query=#QUERY#&sort=rel&s=#SKIP#";
	
	Logger logger = LoggerFactory.getLogger(CraigslistTorontoSearchServiceImpl.class);
	
	@Override
	public List<CraigslistItem> searchByQuery(String query) {
		return this.searchByQuery(query, 0);
	}
	
	@Override
	public List<CraigslistItem> searchByQuery(String query, Integer skip) {
		
		List<CraigslistItem> items = new ArrayList<CraigslistItem>();
		CraigslistItem newItem = null;
		
		URL feedSource;
		try {
			feedSource = new URL(SEARCH_BY_QUERY.replace("#QUERY#", query).replace("#SKIP#", skip.toString()));
			SyndFeedInput input = new SyndFeedInput();
			SyndFeed feed = input.build(new XmlReader(feedSource));
			
			if (null!=feed) {
				for (Object o: feed.getEntries()){
					
					SyndEntry e = (SyndEntry) o;
					String title = e.getTitle();
					Date date = null;
					if (null != e.getModules() && e.getModules().size() >0) {
						DCModule m = (DCModule) e.getModules().get(0);
						date = m.getDate();
					}
					newItem = new CraigslistItem(title, date);
					items.add(newItem);
				}
			}
			return items;
		} catch (MalformedURLException e) {
			logger.error(e.getMessage());
		} catch (IllegalArgumentException e) {
			logger.error(e.getMessage());
		} catch (FeedException e) {
			logger.error(e.getMessage());
		} catch (IOException e) {
			logger.error(e.getMessage());
		}
		return null;
	}
}
