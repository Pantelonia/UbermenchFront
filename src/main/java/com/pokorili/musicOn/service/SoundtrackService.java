package com.pokorili.musicOn.service;

import com.google.gson.Gson;
import com.pokorili.musicOn.entity.Soundtrack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class SoundtrackService {
    @Autowired
    ConnectionService connectionService;


    public Soundtrack[] getSoundtracksBy(String searchtype, String variable) {
        Soundtrack[] soundtracks;
        Map<String, String> params = new HashMap<>();
        params.put(searchtype, variable);
        Gson gson = new Gson();
        try {
            String link = "http://localhost:8080/soundtrack";
            soundtracks = gson.fromJson(connectionService.sendRequest(link,"GET", params, null), Soundtrack[].class);
        } catch (IOException e) {
            e.printStackTrace();
            soundtracks = new Soundtrack[0];
        }
        return soundtracks;
    }
}
