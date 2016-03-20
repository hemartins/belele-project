/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.belele.project.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import java.text.SimpleDateFormat;

/**
 *
 * @author P056913
 */
public class JsonObjectMapper extends ObjectMapper {

    private static final long serialVersionUID = 1262182854718395062L;

    public JsonObjectMapper() {

	//initialize with global configurations
	//read and write joda datetime
	this.registerModule(new JodaModule());
	//serialize without timestamp format
	this.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, true);
	this.setSerializationInclusion(JsonInclude.Include.NON_NULL);
	//date format with timezone
	this.setDateFormat(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ"));

    }

    public JsonObjectMapper(String datePattern) {

	//initialize with global configurations
	//read and write joda datetime
	this.registerModule(new JodaModule());
	//serialize without timestamp format
	this.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, true);
	this.setSerializationInclusion(JsonInclude.Include.NON_NULL);
	//date format with timezone
	this.setDateFormat(new SimpleDateFormat(datePattern));

    }
}
