package com.gimhani.service;

import com.gimhani.api.ProductInfo;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.unit.DistanceUnit;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.sort.ScoreSortBuilder;

import java.util.Map;

/**
 * Created by gimhani on 8/18/16.
 */
public class ProductInfoService {

    /*public Product[] getProducts(ProductInfo info){
    }*/

    public Map<String, Object> getProducts(Client client, String id){
        GetResponse getResponse = client.prepareGet("index5", "type5", id)
                .execute()
                .actionGet();
        System.out.println(getResponse.getSource());
        Map<String, Object> source = getResponse.getSource();
        return source;

    }

    public SearchResponse searchProducts(Client client, ProductInfo info){
        SearchResponse response = client.prepareSearch("index5")
                .setTypes("type5")
               .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
                .setQuery(QueryBuilders.fuzzyQuery("name",info.getProductName()))
                .setQuery(QueryBuilders.nestedQuery("stores",QueryBuilders.geoDistanceQuery("stores.coordinates").point(info.getLocation()[0],info.getLocation()[1]).distance(10, DistanceUnit.KILOMETERS)))
                .setQuery(QueryBuilders.matchQuery("tags", info.getTags()))
                .setQuery(QueryBuilders.nestedQuery("variants",QueryBuilders.rangeQuery("variants.types.price.amount").lt(info.getMax_price())))
                .addSort(new ScoreSortBuilder())
                .execute()
                .actionGet();
        return response;
    }
}
