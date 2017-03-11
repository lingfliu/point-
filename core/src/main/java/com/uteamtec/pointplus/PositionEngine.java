package com.uteamtec.pointplus;

import com.uteamtec.pointplus.geometry.Position;
import com.uteamtec.pointplus.signal.Signal;

import java.util.List;
import java.util.concurrent.*;

/**
 * Created by liulingfeng on 3/11/17.
 */
public class PositionEngine {
    ArrayBlockingQueue<Signal> sigQueue;
    List<PositionTarget> targets;

    public PositionEngine(){
        new Thread(
        new Runnable() {
            public void run() {
                while(true){
                    try {
                        Signal sig = sigQueue.poll(500, TimeUnit.SECONDS);
                        if (sig != null){
                            threadPoolExecutor.submit(new RunnableFuture<Position>() {
                                public void run() {
                                }

                                public boolean cancel(boolean mayInterruptIfRunning) {
                                    return false;
                                }

                                public boolean isCancelled() {
                                    return false;
                                }

                                public boolean isDone() {
                                    return false;
                                }

                                public Position get() throws InterruptedException, ExecutionException {
                                    return null;
                                }

                                public Position get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
                                    return null;
                                }
                            });
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (TimeoutException) {

                    }

                }

            }
        }).start();

        new Thread(new Runnable(){
            public void run() {
                for (PositionTarget target : targets){
                    if (true){
                        //TODO: remove target
                        break;
                    }
                }
            }
        }).start();

    }


    public Position requestPositionEstimation(Signal sig, PositionTarget target) throws ExecutionException, InterruptedException{
        Position pos = null;
        try {
           threadPoolExecutor.submit(new Callable<Position>() {
                public Position call() throws Exception {
                    return null;
                }
            }).get(2000, TimeUnit.MILLISECONDS);
        } catch (TimeoutException e){
            pos = null;
        }
        return pos;
    }

    private ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(100, 200, 300, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>());

    public interface EstimationResultResponder{
        void onResult(Position pos, PositionTarget target);
    }
}