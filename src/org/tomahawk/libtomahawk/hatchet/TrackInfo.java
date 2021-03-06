/* == This file is part of Tomahawk Player - <http://tomahawk-player.org> ===
 *
 *   Copyright 2013, Enno Gottschalk <mrmaffen@googlemail.com>
 *
 *   Tomahawk is free software: you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation, either version 3 of the License, or
 *   (at your option) any later version.
 *
 *   Tomahawk is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 *
 *   You should have received a copy of the GNU General Public License
 *   along with Tomahawk. If not, see <http://www.gnu.org/licenses/>.
 */
package org.tomahawk.libtomahawk.hatchet;

import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

/**
 * Author Enno Gottschalk <mrmaffen@googlemail.com> Date: 20.04.13
 */
public class TrackInfo implements Info {

    private final static String TAG = TrackInfo.class.getName();

    public static final String TRACKINFO_KEY_ARTIST = "Artist";

    public static final String TRACKINFO_KEY_ID = "Id";

    public static final String TRACKINFO_KEY_NAME = "Name";

    public static final String TRACKINFO_KEY_URL = "Url";

    private ArtistInfo mArtist;

    private String mId;

    private String mName;

    private String mUrl;

    @Override
    public void parseInfo(JSONObject rawInfo) {
        try {
            if (!rawInfo.isNull(TRACKINFO_KEY_ARTIST)) {
                JSONObject rawArtistInfo = rawInfo.getJSONObject(TRACKINFO_KEY_ARTIST);
                mArtist = new ArtistInfo();
                mArtist.parseInfo(rawArtistInfo);
            }
            if (!rawInfo.isNull(TRACKINFO_KEY_ID)) {
                mId = rawInfo.getString(TRACKINFO_KEY_ID);
            }
            if (!rawInfo.isNull(TRACKINFO_KEY_NAME)) {
                mName = rawInfo.getString(TRACKINFO_KEY_NAME);
            }
            if (!rawInfo.isNull(TRACKINFO_KEY_URL)) {
                mUrl = rawInfo.getString(TRACKINFO_KEY_URL);
            }
        } catch (JSONException e) {
            Log.e(TAG, "parseInfo: " + e.getClass() + ": " + e.getLocalizedMessage());
        }
    }

    public ArtistInfo getArtist() {
        return mArtist;
    }

    public String getId() {
        return mId;
    }

    public String getName() {
        return mName;
    }

    public String getUrl() {
        return mUrl;
    }
}
