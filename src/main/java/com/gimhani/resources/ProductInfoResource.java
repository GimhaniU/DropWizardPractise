package com.gimhani.resources;

import com.codahale.metrics.annotation.Timed;
import com.gimhani.api.ProductInfo;
import com.gimhani.service.ProductInfoService;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.json.JsonXContent;
import org.elasticsearch.search.SearchHit;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Map;

/**
 * Created by gimhani on 8/16/16.
 */
@Path("/product")
@Produces(MediaType.APPLICATION_JSON)
public class ProductInfoResource {
    final private long productId;
    final private String productName;
    final private String[] tags;
    final private double[] location;
    final private float max_price;
    TransportClient client = null;
    ProductInfoService service=null;



    public ProductInfoResource( long productId, String productName, String[] tags, double[] location, float max_price) {
        try {
            client = TransportClient.builder().build()
                    .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("localhost"), 9300));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        service=new ProductInfoService();

        this.productId = productId;
        this.productName = productName;
        this.tags = tags;
        this.location = location;
        this.max_price = max_price;

    }

    //to search based on asked parameters
    @POST
    @Timed
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String searchProducts(ProductInfo info) {
        SearchResponse response = service.searchProducts(client, info);
        //SearchHit[] results = response.getHits().getHits();

        /*System.out.println("Current results: " + results.length);
        for (SearchHit hit : results) {
            System.out.println("------------------------------");
            Map<String,Object> result = hit.getSource();
            System.out.println(result);
        }*/
        return response.toString();


    }

    //to get all
    /*@GET
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> getAllProducts(){
        return ;
    }*/

    //to get information of a product by id
    @GET
    @Path("/{id}")
    @Timed
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Map<String, Object> viewProductById(@PathParam("id") String id)  {
        Map<String, Object> products = service.getProducts(client, id);
        return products;

    }


}
