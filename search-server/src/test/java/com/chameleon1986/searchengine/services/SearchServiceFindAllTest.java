package com.chameleon1986.searchengine.services;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SearchServiceFindAllTest {

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
    public void findAll() throws Exception {

        List<HashMap<String, Object>> list = searchService.findAll();

        for (int i = 0; i < list.size(); i++) {
            assertEquals(Integer.toString(i+1), list.get(i).get("key"));
            assertEquals(strArray[i], list.get(i).get("document"));
        }

    }

}