package com.addhen.spotify.adapter;

import com.addhen.spotify.R;
import com.addhen.spotify.model.TrackModel;
import com.squareup.picasso.Picasso;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class TrackRecyclerViewAdapter
        extends RecyclerView.Adapter<TrackRecyclerViewAdapter.ViewHolder> {

    private final TypedValue mTypedValue = new TypedValue();

    private int mBackground;

    private List<TrackModel> mTrackList;

    public TrackRecyclerViewAdapter(Context context) {
        context.getTheme().resolveAttribute(R.attr.selectableItemBackground, mTypedValue, true);
        mBackground = mTypedValue.resourceId;
        mTrackList = new ArrayList<>();
    }

    public void setAdapterItems(List<TrackModel> trackList) {
        mTrackList.clear();
        mTrackList.addAll(trackList);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mTrackList.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.track_list_item, parent, false);
        view.setBackgroundResource(mBackground);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.trackId = mTrackList.get(position)._id;
        holder.mTrackName.setText(mTrackList.get(position).name);
        holder.mAlbumName.setText(mTrackList.get(position).album);
        Picasso.with(holder.mCoverPhoto.getContext())
                .load(mTrackList.get(position).coverPhoto)
                .placeholder(R.mipmap.ic_launcher)
                .into(holder.mCoverPhoto);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public String trackId;

        public final View mView;

        public final ImageView mCoverPhoto;

        public final TextView mTrackName;

        public final TextView mAlbumName;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mCoverPhoto = (ImageView) view.findViewById(R.id.coverPhoto);
            mTrackName = (TextView) view.findViewById(R.id.trackName);
            mAlbumName = (TextView) view.findViewById(R.id.albumName);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mTrackName.getText();
        }
    }
}

