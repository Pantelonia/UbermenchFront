package com.pokorili.musicOn.service;

import com.google.gson.Gson;
import com.pokorili.musicOn.entity.Genre;
import com.pokorili.musicOn.entity.Soundtrack;
import com.pokorili.musicOn.entity.Visitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class SoundtrackService {
    @Autowired
    ConnectionService connectionService;


    public Soundtrack[] getSoundtracksByTitle(String title) {
        Soundtrack[] soundtracks;
        Map<String, String> params = new HashMap<>();
        params.put("title", title);
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

    public Soundtrack[] getSoundtracksByAuthor(String author) {
        Soundtrack[] soundtracks;
        Map<String, String> params = new HashMap<>();
        params.put("author", author);
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
