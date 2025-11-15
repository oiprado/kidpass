package com.kidpass.reportingservice.service;

import com.kidpass.reportingservice.repository.AuthorizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.data.mongodb.core.aggregation.DateOperators;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;

@Service
public class ReportingService {

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<AuthorizationStatusReport> getAuthorizationStatusReport() {
        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.group("status").count().as("count"),
                Aggregation.project("count").and("status").previousOperation()
        );

        AggregationResults<AuthorizationStatusReport> results = mongoTemplate.aggregate(
                aggregation, "authorizations", AuthorizationStatusReport.class
        );

        return results.getMappedResults();
    }

    public List<AuthorizationTimeSeriesReport> getAuthorizationTimeSeriesReport() {
        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.match(org.springframework.data.mongodb.core.query.Criteria.where("requestDate").gte(LocalDate.now().minusDays(30).atStartOfDay(ZoneOffset.UTC))),
                Aggregation.project()
                        .and(DateOperators.DateToString.dateOf("requestDate").toString("%Y-%m-%d")).as("date"),
                Aggregation.group("date").count().as("count"),
                Aggregation.project("count").and("_id").as("date").andExclude("_id")
        );

        AggregationResults<AuthorizationTimeSeriesReport> results = mongoTemplate.aggregate(
                aggregation, "authorizations", AuthorizationTimeSeriesReport.class
        );

        return results.getMappedResults();
    }
}
