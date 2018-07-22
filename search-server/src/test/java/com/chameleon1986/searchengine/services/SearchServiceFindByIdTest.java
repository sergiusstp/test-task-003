package com.chameleon1986.searchengine.services;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SearchServiceFindByIdTest {

    private static SearchService searchService;

    private static String[] strArray = new String[]
                    {"New Document",
                    "Old Document",
                    "Pretty Old Document",
                    "Pretty Document"};

    @BeforeClass
    public static void setUp() {
        searchService = new SearchServiceImpl();

        for (String s : strArray)
            searchService.saveDocument(s);

    }

    @Test
    public void getId1() throws Exception {
        Long idValue = 1L;
        String strValue = "New Document";
        HashMap<String, Object> map = searchService.findById(idValue);
        assertEquals(idValue.toString(), map.get("key"));
        assertEquals(strValue, map.get("document"));
    }


    @Test
    public void getId3() throws Exception {
        Long idValue = 3L;
        String strValue = "Pretty Old Document";
        HashMap<String, Object> map = searchService.findById(idValue);
        assertEquals(idValue.toString(), map.get("key"));
        assertEquals(strValue, map.get("document"));
    }

    @Test
    public void getId4() throws Exception {
        Long idValue = 4L;
        String strValue = "Pretty Document";
        HashMap<String, Object> map = searchService.findById(idValue);
        assertEquals(idValue.toString(), map.get("key"));
        assertEquals(strValue, map.get("document"));
    }

    @Test
    public void getId5() throws Exception {
        Long idValue = 5L;
        HashMap<String, Object> map = searchService.findById(idValue);
        assertNull(map);
    }

}