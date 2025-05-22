package com.app.amedina.saot_ilokano;

import android.widget.ImageButton;

public interface RecyclerViewInterface {
    public void onItemClick(int position);
    public void onAudioButtonClick(int position);
    public void onFavoriteClick(ImageButton imgFave);
}
