package com.chameleon1986.searchengine.services;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SearchServiceSaveDocumentTest {

    private static SearchService searchService;

    @BeforeClass
    public static void setUp() {
        searchService = new SearchServiceImpl();
    }

    @Test
    public void saveDocument1() throws Exception {
        Long idValue = 1L;
        Long documentKey = searchService.saveDocument("New Document");
        assertEquals(idValue, documentKey);
    }

    @Test
    public void saveDocument2() throws Exception {
        Long idValue = 2L;
        Long documentKey = searchService.saveDocument("Old Document");
        assertEquals(idValue, documentKey);
    }

    @Test
    public void saveDocument3() throws Exception {
        Long idValue = 3L;
        Long documentKey = searchService.saveDocument("Pretty Old Document");
        assertEquals(idValue, documentKey);
    }

    @Test
    public void saveDocument4() throws Exception {
        Long idValue = 4L;
        Long documentKey = searchService.saveDocument("Pretty Document");
        assertEquals(idValue, documentKey);
    }

}
