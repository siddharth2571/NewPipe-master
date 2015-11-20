package com.pemikir.youtubeplus;

import android.util.Log;

import com.pemikir.youtubeplus.youtube.YoutubeService;


/**
 * Created by Christian Schabesberger on 23.08.15.
 * <p/>
 * Copyright (C) Christian Schabesberger 2015 <chris.schabesberger@mailbox.org>
 * ServiceList.java is part of NewPipe.
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

public class ServiceList {
    private static final String TAG = ServiceList.class.toString();
    private static final StreamingService[] services = {
            new YoutubeService()
    };

    public static StreamingService[] getServices() {
        return services;
    }

    public static StreamingService getService(int serviceId) {
        return services[serviceId];
    }

    public static StreamingService getService(String serviceName) {
        return services[getIdOfService(serviceName)];
    }

    public static int getIdOfService(String serviceName) {
        for (int i = 0; i < services.length; i++) {
            if (services[i].getServiceInfo().name == serviceName) {
                return i;
            }
        }
        Log.e(TAG, "Error: Service " + serviceName + " not known.");
        return -1;
    }
}
