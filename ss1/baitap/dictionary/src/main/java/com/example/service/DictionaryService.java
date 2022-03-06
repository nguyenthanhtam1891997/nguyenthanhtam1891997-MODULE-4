package com.example.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DictionaryService {
    private static Map<String, String> diction=null;
    static {
        diction = new HashMap<>();
        diction.put("hello", "Xin chào");
        diction.put("how", "Thế nào");
        diction.put("book", "Quyển vở");
        diction.put("computer", "Máy tính");
    }
public String search(String word){
return diction.get(word.trim());
}
}
