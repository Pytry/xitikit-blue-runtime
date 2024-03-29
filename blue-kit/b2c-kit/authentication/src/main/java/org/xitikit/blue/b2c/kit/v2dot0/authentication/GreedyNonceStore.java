package org.xitikit.blue.b2c.kit.v2dot0.authentication;

import org.xitikit.blue.b2c.kit.v2dot0.authentication.interfaces.NonceStore;

import javax.annotation.Nonnull;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static java.util.stream.Collectors.*;

/**
 * Provides greedy in memory storage of nonce values while
 * supporting the "full concurrency of retrievals and high expected
 * concurrency for updates" using a ConcurrentHashMap. This does
 * NOT provide validation.
 *
 * Copyright Xitikit.org 2017
 *
 * @author J. Keith Hoopes
 */
public class GreedyNonceStore implements NonceStore{

    private final Map<String, Nonce> nonceStore = new ConcurrentHashMap<>();

    private final int timeout;

    /**
     * @param timeout Time in seconds for which a nonce is valid.
     */
    public GreedyNonceStore(final int timeout){

        this.timeout = timeout > 0 ? timeout : 0;
    }

    @Override
    public void put(@Nonnull final Nonce nonce){

        nonceStore.put(nonce.getValue(), nonce);
    }

    @Override
    public Nonce get(@Nonnull final String nonceValue){

        return nonceStore.get(nonceValue);
    }

    @Override
    public void purge(){

        if(timeout > 0){

            nonceStore
                .values()
                .parallelStream()
                .filter(n -> checkExpired(n, timeout))
                .collect(toSet())
                .forEach(n -> nonceStore.remove(n.getValue()));
        }
    }

    private static boolean checkExpired(final Nonce nonce, final long timeout){

        return System.currentTimeMillis() - nonce.getSystemTimeAtCreation() > timeout;
    }
}
