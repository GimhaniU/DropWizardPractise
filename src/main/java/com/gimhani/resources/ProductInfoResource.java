package com.gimhani.resources;

import com.codahale.metrics.annotation.Timed;
import com.gimhani.api.ProductInfo;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

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


    public ProductInfoResource( long productId, String productName, String[] tags, double[] location, float max_price) {
        this.productId = productId;
        this.productName = productName;
        this.tags = tags;
        this.location = location;
        this.max_price = max_price;

    }

    @POST
    @Timed
    public ProductInfo sayHello() {
        return new ProductInfo(123,"Biscuits", new String[]{"kfc", "keels"}, new double[]{12, 23}, (float) 23.45);
    }

    /*@GET
    @Timed
    public Saying sayHello(@QueryParam("name") Optional<String> name) {
        final String value = String.format(template, name.orElse(defaultName));
        return new Saying(counter.incrementAndGet(), value);
    }*/
}
