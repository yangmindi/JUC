package com.ymd.死锁;

import java.util.HashSet;
import java.util.Set;

class Point {
    Integer jing;
    Integer wei;

    public Point(Integer jing, Integer wei) {
        this.jing = jing;
        this.wei = wei;
    }
}

class Image {
    Integer newJing;
    Integer newWei;

    public void drawMarker(Point point) {
        this.newJing = point.jing;
        this.newWei = point.wei;
    }
}

class Taxi {
    private Point location, destination;
    private final Dispatcher dispatcher;

    public Taxi(Dispatcher dispatcher, Point destination) {
        this.dispatcher = dispatcher;
        this.destination = destination;
    }

    public synchronized Point getLocation() {
        return location;
    }

    public synchronized void setLocation(Point location) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.location = location;
        if (location.equals(destination)) {
            dispatcher.notifyAvailable(this);
        }
    }
}

class Dispatcher {
    private final Set<Taxi> taxis;
    private final Set<Taxi> availableTaxis;

    public Dispatcher() {
        taxis = new HashSet<Taxi>();
        availableTaxis = new HashSet<>();
    }

    public synchronized void notifyAvailable(Taxi taxi) {
        availableTaxis.add(taxi);
    }

    public synchronized Image getImage() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Image image = new Image();
        for (Taxi taxi : availableTaxis) {
            image.drawMarker(taxi.getLocation());
        }
        return image;
    }
}

public class 协作对象死锁 {
    public static void main(String[] args) {
        Dispatcher dispatcher = new Dispatcher();

        Point point = new Point(1, 2);
        Taxi taxi = new Taxi(dispatcher, point);


        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                taxi.setLocation(point);
                dispatcher.getImage();
            }
        });

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                dispatcher.getImage();
                taxi.setLocation(point);
            }
        });
        thread.start();
        thread1.start();

    }
}
