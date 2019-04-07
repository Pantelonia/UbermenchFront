package com.pokorili.musicOn.service;

import com.google.gson.Gson;
import com.pokorili.musicOn.entity.Soundtrack;
import com.pokorili.musicOn.entity.Visitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    @Autowired
    ConnectionService connectionService;

    public Visitor getVisitorByNickname(String nickname) {
        Visitor visitor;
        Map<String, String> params = new HashMap<>();
        params.put("nickname", nickname);
        Gson gson = new Gson();
        try {
            String link = "http://localhost:8080/visitors";
            visitor = gson.fromJson(connectionService.sendRequest(link,"GET", params, null), Visitor.class);
        } catch (IOException e) {
            e.printStackTrace();
            visitor = null;
        }

        return visitor;
    }
}
