package com.chameleon1986.searchengine.services;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class SearchServiceImpl implements SearchService {

    // By default Service annotation creates a singleton scoped bean.

    // document storage
    private ConcurrentHashMap<Long, String> storage = new ConcurrentHashMap<>();

    // token set storage
    private ConcurrentHashMap<Long, HashSet<String>> tokens = new ConcurrentHashMap<>();

    // current key value
    private AtomicLong key = new AtomicLong();


    @Override
    public List<HashMap<String, Object>> findAll() {

        int num = storage.size();

        List<HashMap<String, Object>> list = new LinkedList<>();

        // get documents from storage
        for (long i = 1; i <= num; i++) {
            String document = storage.get(i);

            HashMap<String, Object> map = new LinkedHashMap<>();

            map.put("key", Long.toString(i));
            map.put("document", document);

            list.add(map);
        }
            return list;
    }


    @Override
    public HashMap<String, Object> findById(Long l) {

        // get document from storage
        String document = storage.get(l);

        if (document == null)
            return null;
        else {
            HashMap<String, Object> map = new LinkedHashMap<>();

            map.put("key", l.toString());
            map.put("document", document);

            return map;
        }

    }


    @Override
    public Long saveDocument(String string) {

        // synchronize via AtomicLong
        long id = key.addAndGet(1);



        // split document down to tokens
        String strArray[] = string.split(" ");

        // save to token storage set.
        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < strArray.length; i++)
            set.add(strArray[i]);


        // save to tokens set storage
        tokens.put(id, set);

        // save to document storage
        storage.put(id, string);


        return id;

    }


    public List<String> getKeysByCondition(String string) {

        // get count of available documents
        int num = storage.size();

        // magic array (0 - not applied for the condition, 1 - good to return)
        byte[] keys = new byte[num];

        // fill array with 1 - all documents are good (first assumption)
        for (int i = 0; i < num; i++)
            keys[i] = 1;


        // parse input
        String strArray[] = string.split(" ");


        // external cycle by condition set of tokens
        // internal cycle by remaining items to return
        for (int i = 0; i < strArray.length; i++) {
            String token = strArray[i];

            for (int j = 0; j < num; j++) {
                if (keys[j] == 1) {
                    HashSet<String> set = tokens.get(new Long(j+1));


                    if (!set.contains(token))
                        keys[j] = 0;
                }
            }

        }

        LinkedList<String> list = new LinkedList<>();

        // get documents from storage that are good by keys structure
        for (int i = 0; i < num; i++) {
            if (keys[i] == 1)
                list.add(Long.toString(i+1)); // documents are counted starting 1
        }

        return list;
    }

}
