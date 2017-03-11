package com.uteamtec.pointplus.estimator;

import com.uteamtec.pointplus.geometry.Position;
import com.uteamtec.pointplus.signal.Signal;

/**
 * Created by liulingfeng on 3/11/17.
 */
public class WknnEstimator implements Estimator{
    ErrorMap errorMap;
    FpMap fpMap;

    public Position estimate(Signal sig) {
        wknn(sig);

        return null;
    }

    private void wknn(Signal sig){
        ErrorMap errMap = new ErrorMap(); //estimate error map

    }

    private ErrorMap sortErrMap(){
        return null;
    }
}
