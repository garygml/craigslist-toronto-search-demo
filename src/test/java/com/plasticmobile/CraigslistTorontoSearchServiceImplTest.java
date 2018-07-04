package com.plasticmobile;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.plasticmobile.entity.CraigslistItem;
import com.plasticmobile.service.CraigslistTorontoSearchService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CraigslistTorontoSearchServiceImplTest {

	@Autowired
	CraigslistTorontoSearchService craigslistTorontoSearchService;
	
	@Test
	public void testSearchQuery() {
		List<CraigslistItem> items = craigslistTorontoSearchService.searchByQuery("apartment");
		assertNotNull(items);
	}
	
	@Test
	public void testSearchQuery_noResults() {
		List<CraigslistItem> items = craigslistTorontoSearchService.searchByQuery("asjfklasdjlfkajklsdf");
		assertTrue(items.isEmpty());
	}
	

}
