package com.bnb.gj.general.restclient;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.google.cloud.MonitoredResource;
import com.google.cloud.logging.LogEntry;
import com.google.cloud.logging.Logging;
import com.google.cloud.logging.LoggingOptions;
import com.google.cloud.logging.Payload.JsonPayload;
import com.google.cloud.logging.Payload.StringPayload;


public class GoogleCloudLogging {
	
	private String projectId;
	private String logName = "test-log";
	
	public GoogleCloudLogging() {
		
	}
	
	public GoogleCloudLogging(String projectId, String logName) {
		super();
		this.projectId = projectId;
		this.logName = logName;
	}

	public void process(String message) throws Exception{
		
		Map<String, String> jsonContent = new HashMap<>();
		jsonContent.put("Protractor_success",message);
		JsonPayload payload = JsonPayload.of(jsonContent);
		
		final LoggingOptions options = LoggingOptions.newBuilder().setProjectId(this.projectId).build();
		try (Logging logging = options.getService()) {
			final LogEntry firstEntry = LogEntry.newBuilder(StringPayload.of(message)).setLogName(logName)
					.setResource(
							MonitoredResource.newBuilder("global").addLabel("project_id", options.getProjectId()).build())
					.build();
			logging.write(Collections.singleton(firstEntry));
		}

	}


}
