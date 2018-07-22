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
public class SearchServiceGetKeysByConditionTest {

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
    public void findConditionDocument() throws Exception {

        String condition = "Document";
        List<String> list = searchService.getKeysByCondition(condition);

        assertEquals(4, list.size());

        for (int i = 0; i < list.size(); i++) {
            assertEquals(new Integer(i+1), new Integer(list.get(i)));
        }

    }

    @Test
    public void findConditionNew() throws Exception {

        String condition = "New";
        List<String> list = searchService.getKeysByCondition(condition);

        assertEquals(1, list.size());
        assertEquals(new Integer(1), new Integer(list.get(0)));

    }

    @Test
    public void findConditionOld() throws Exception {

        String condition = "Old";
        List<String> list = searchService.getKeysByCondition(condition);

        assertEquals(2, list.size());
        assertEquals(new Integer(2), new Integer(list.get(0)));
        assertEquals(new Integer(3), new Integer(list.get(1)));

    }

    @Test
    public void findConditionPretty() throws Exception {

        String condition = "Pretty";
        List<String> list = searchService.getKeysByCondition(condition);

        assertEquals(2, list.size());
        assertEquals(new Integer(3), new Integer(list.get(0)));
        assertEquals(new Integer(4), new Integer(list.get(1)));


    }

}