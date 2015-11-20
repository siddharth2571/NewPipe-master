package com.pemikir.youtubeplus;

import android.graphics.Bitmap;

/**
 * Created by Christian Schabesberger on 26.08.15.
 * <p/>
 * Copyright (C) Christian Schabesberger 2015 <chris.schabesberger@mailbox.org>
 * VideoInfoItem.java is part of NewPipe.
 * <p/>
 * NewPipe is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * <p/>
 * NewPipe is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * <p/>
 * You should have received a copy of the GNU General Public License
 * along with NewPipe.  If not, see <http://www.gnu.org/licenses/>.
 */

public class VideoInfoItem {
    public String id = "";
    public String title = "";
    public String uploader = "";
    public String duration = "";
    public String thumbnail_url = "";
    public Bitmap thumbnail = null;
    public String webpage_url = "";
    public String upload_date = "";
}