package com.example.dictionary.controller;


import com.example.dictionary.service.SearchHistoryService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/AddMyWord")
public class addMyWordController {

    @Autowired
    private SearchHistoryService searchHistoryService;

    @GetMapping
    public String insertSearch(@RequestParam("cid") int cid, @RequestParam("wid") int wid,
                               HttpServletRequest request, HttpSession session){
        String s = searchHistoryService.insertSearch(session, request, wid, cid);
        return s;
    }
}
