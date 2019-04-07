package com.pokorili.musicOn.service;


import com.google.gson.Gson;
import com.pokorili.musicOn.entity.Playlist;
import com.pokorili.musicOn.entity.Soundtrack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class PlaylistService {
    @Autowired
    ConnectionService connectionService;



    public Playlist[] getPlaylists(String title) {
        Playlist[] playlists;
        Map<String, String> params = new HashMap<>();
        params.put("title", title);
        Gson gson = new Gson();
        try {
            String link = "http://localhost:8080/playlists";
            playlists = gson.fromJson(connectionService.sendRequest(link,"GET", params, null), Playlist[].class);
        } catch (IOException e) {
            e.printStackTrace();
            playlists = new Playlist[0];
        }
        return playlists;
    }
}
