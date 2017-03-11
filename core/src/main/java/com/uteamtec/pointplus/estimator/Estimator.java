package com.uteamtec.pointplus.estimator;

import com.uteamtec.pointplus.geometry.Position;
import com.uteamtec.pointplus.signal.RssSignal;
import com.uteamtec.pointplus.signal.Signal;

/**
 * Created by liulingfeng on 3/11/17.
 */
public interface Estimator {
    Position estimate(Signal sig);
}
