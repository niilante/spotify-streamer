package com.addhen.spotify.model.mapper;

import com.addhen.spotify.model.TrackModel;
import com.addhen.spotify.util.Utils;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import kaaes.spotify.webapi.android.models.Track;

public class TrackModelMapper {

    public TrackModel map(@NonNull Track track) {
        TrackModel trackModel = new TrackModel();
        trackModel._id = track.id;
        trackModel.name = track.name;
        trackModel.album = track.album.name;
        trackModel.previewUrl = track.preview_url;
        trackModel.externalUrl = track.external_urls.get("spotify");
        // Using the first artist name as the artist of the track
        // The assumption here there will always be at least one
        // artist associated with a track.
        trackModel.artistName = track.artists.get(0).name;
        if (!Utils.isEmpty(track.album.images)) {
            trackModel.coverPhoto = track.album.images.get(0).url;
        }
        return trackModel;
    }

    public List<TrackModel> map(@NonNull List<Track> trackList) {
        List<TrackModel> trackModels = new ArrayList<>();
        for (Track track : trackList) {
            trackModels.add(map(track));
        }
        return trackModels;
    }
}
