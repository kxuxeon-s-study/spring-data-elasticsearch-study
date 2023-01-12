package com.example.elasticsearch.service;

import com.example.elasticsearch.document.Vehicle;
import com.example.elasticsearch.helper.Indices;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.rest.RestStatus;
import org.elasticsearch.xcontent.XContentType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class VehicleService {
    private static final ObjectMapper MAPPER = new ObjectMapper();
    private static final Logger LOG = LoggerFactory.getLogger(VehicleService.class);

    private final RestHighLevelClient client;

    public Boolean save(final Vehicle vehicle) {
        try {
            final String vehicleASString = MAPPER.writeValueAsString(vehicle);

            IndexRequest request = new IndexRequest(Indices.VEHICLE_INDEX);
            request.id(vehicle.getId());
            request.source(vehicleASString, XContentType.JSON);

            final IndexResponse response = client.index(request, RequestOptions.DEFAULT);
            return response != null && response.status().equals(RestStatus.OK);
        } catch (final Exception e) {
            LOG.error(e.getMessage(), e);
            return false;
        }
    }

    public Vehicle findById(final String vehicleId) {
        try {
            final GetResponse documentFields = client.get(
                    new GetRequest(Indices.VEHICLE_INDEX, vehicleId),
                    RequestOptions.DEFAULT
            );
            if (documentFields == null || documentFields.isSourceEmpty()) {
                return null;
            }
            return MAPPER.readValue(documentFields.getSourceAsString(), Vehicle.class);
        } catch (IOException e) {
            LOG.error(e.getMessage(), e);
            return null;
        }
    }

}
