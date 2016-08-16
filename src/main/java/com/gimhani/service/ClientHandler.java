package com.gimhani.service;

import org.elasticsearch.client.Client;
import org.elasticsearch.node.Node;

import static org.elasticsearch.node.NodeBuilder.nodeBuilder;

/**
 * Created by gimhani on 8/16/16.
 */
public class ClientHandler {
    private static ClientHandler instance = null;
    private static Object lock      = new Object();

    private Client client;
    private Node node;

    public static ClientHandler instance(){

        if(instance == null) {
            synchronized (lock) {
                if(null == instance){
                    instance = new ClientHandler();
                }
            }
        }
        return instance;
    }

    public void prepareClient(){
        node   = nodeBuilder().node();
        client = node.client();
    }

    public void closeNode(){

        if(!node.isClosed())
            node.close();

    }

    public Client getClient(){
        return client;
    }
}
