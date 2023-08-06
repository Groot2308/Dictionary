package com.example.dictionary.service;

import com.example.dictionary.entity.SearchHistory;
import com.example.dictionary.entity.User;
import com.example.dictionary.repository.SearchHistoryRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class SearchHistoryService {
    @Autowired
    SearchHistoryRepository searchHistoryRepository;

    public String getMyWord(HttpSession session,HttpServletRequest request){
        if (session.getAttribute("account") == null) {
            return "redirect:/Login";
        }else {
            User u = (User) session.getAttribute("account");
            List<SearchHistory> slist = searchHistoryRepository.findWordByUserId(u.getId());
            request.setAttribute("slist", slist);
            return "MyWordList";
        }
    }

    public String insertSearch(HttpSession session, HttpServletRequest request,
                               int wid,
                               int cid){
        if (session.getAttribute("account") == null) {
            return "redirect:/Login";
        }else{
            User u = (User) session.getAttribute("account");
         //   searchHistoryRepository.insertSearch(wid, u.getId());
            request.setAttribute("cid", cid );
            return "forward:/LearnWord";
        }

    }

}
