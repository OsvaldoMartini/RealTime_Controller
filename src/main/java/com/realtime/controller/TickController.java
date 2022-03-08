package com.realtime.controller;

import java.time.Duration;
import java.time.Instant;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.realtime.ExecutorMultiRequests;
import com.realtime.pojos.TicksDTO;

@RestController
@RequestMapping("/")
public class TickController {
	private static Logger LOGGER = LogManager.getLogger(ExecutorMultiRequests.class);

	@Autowired
	ExecutorMultiRequests executorMultiRequests;

	/*
	 * To Handle all requests for "/ticks"
	 */
	@PostMapping("/ticks")
	public ResponseEntity<?> postTicks(@Valid @RequestBody TicksDTO tick) {
		long rule60SecondsAgo = Instant.now().minus(Duration.ofSeconds(60)).toEpochMilli();
		//long rule120SecondsAgo = Instant.now().minus(Duration.ofSeconds(120)).toEpochMilli();
		long ruleEpochNow = Instant.now().toEpochMilli();

		if (tick.getTimeStamp() < rule60SecondsAgo) {
			LOGGER.info("tick.getTimeStamp() < rule120SecondsAgo");
	        return new ResponseEntity<Object>(null, HttpStatus.NO_CONTENT);
		} else if (tick.getTimeStamp() > ruleEpochNow) {
			LOGGER.info("tick.getTimeStamp() > ruleEpochNow");
	        return new ResponseEntity<Object>(null, HttpStatus.NO_CONTENT);
		} else {
			LOGGER.info("ExecutorMultiRequests.mainMappedTick.put(tick.getInstrument()");
			ExecutorMultiRequests.mainMappedTick.put(tick.getInstrument() + "-" + tick.getTimeStamp(), tick);
	        return new ResponseEntity<Object>(null, HttpStatus.CREATED);
		}
    }

}
