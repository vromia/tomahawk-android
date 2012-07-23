/* == This file is part of Tomahawk Player - <http://tomahawk-player.org> ===
 *
 *   Copyright 2012, Christopher Reichert <creichert07@gmail.com>
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
package org.tomahawk.libtomahawk;

import java.util.ArrayList;
import java.util.HashMap;

import android.database.Cursor;

public class Artist {

    private long mId;
    private String mName;
    private HashMap<Long, Album> mAlbums;

    public Artist(long id) {
        mId = id;
        mAlbums = new HashMap<Long, Album>();
    }

    public void populate(Cursor cursor) {
        setId(cursor.getLong(0));
        setName(cursor.getString(1));
    }

    @Override
    public String toString() {
        return mName;
    }

    public void addAlbum(Album album) {
        mAlbums.put(album.getId(), album);
    }

    public ArrayList<Album> getAlbums() {
        return new ArrayList<Album>(mAlbums.values());
    }

    public void setName(String name) {
        mName = name;
    }

    public String getName() {
        return mName;
    }

    public void setId(long id) {
        mId = id;
    }

    public long getId() {
        return mId;
    }
}