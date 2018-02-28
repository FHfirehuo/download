package com.ciecc.fire.download.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Receiver {
    private static final Logger LOGGER = LoggerFactory.getLogger(Receiver.class);

    /*private CountDownLatch latch;

    @Autowired
    public Receiver(CountDownLatch latch) {
        this.latch = latch;
    }*/

    public void receiveMessage(String message) {
        LOGGER.info("Received <" + message + ">");
       // latch.countDown();
    }
}