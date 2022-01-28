package io.swagger.api;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import io.swagger.model.Lde;


import java.util.Random;
import java.util.UUID;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.service.InMemoryLdeCache;
import io.swagger.service.PublisherService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.threeten.bp.LocalDate;
import org.threeten.bp.OffsetDateTime;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-01-28T09:46:28.971Z[GMT]")
@RestController
public class ApplicationApiController implements ApplicationApi {

    private static final Logger log = LoggerFactory.getLogger(ApplicationApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Autowired
    private InMemoryLdeCache inMemoryLdeCache;

    @Autowired
    PublisherService publisherService;

    @org.springframework.beans.factory.annotation.Autowired
    public ApplicationApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<List<Lde>> findLogicalDateByApplicationAndProcessingGroup(@Parameter(in = ParameterIn.PATH, description = "application id", required=true, schema=@Schema()) @PathVariable("application") String application,@Parameter(in = ParameterIn.PATH, description = "processing group id", required=true, schema=@Schema()) @PathVariable("processinggroup") String processinggroup) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {

                Lde lde = inMemoryLdeCache.getLde(application,processinggroup);

                if (lde!=null) {
                    ObjectMapper mapper = new ObjectMapper()
                            .setAnnotationIntrospector(new JacksonAnnotationIntrospector())
                            .registerModule(new JavaTimeModule())
                            .setDateFormat(new StdDateFormat())
                            .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

                    return new ResponseEntity<List<Lde>>(objectMapper.readValue("[ " + mapper.writeValueAsString(lde) + "]", List.class), HttpStatus.NOT_IMPLEMENTED);
                } else {
                    log.error("Logical date not found for {} and {}",application,processinggroup);
                    return new ResponseEntity<List<Lde>>(HttpStatus.NOT_FOUND);
                }
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<Lde>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<Lde>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> updateLogicalDate(@Parameter(in = ParameterIn.PATH, description = "application id", required=true, schema=@Schema()) @PathVariable("application") String application,@Parameter(in = ParameterIn.PATH, description = "processing group id", required=true, schema=@Schema()) @PathVariable("processinggroup") String processinggroup,@Parameter(in = ParameterIn.HEADER, description = "id of this unique request" ,required=true,schema=@Schema()) @RequestHeader(value="WP-Request-ID", required=true) UUID wpRequestID,@Parameter(in = ParameterIn.HEADER, description = "content type contained in payload" ,required=true,schema=@Schema()) @RequestHeader(value="WP-Content-Type", required=true) String wpContentType,@Parameter(in = ParameterIn.HEADER, description = "encoding of content type contained in payload" ,required=true,schema=@Schema()) @RequestHeader(value="WP-Content-Encoding", required=true) String wpContentEncoding,@Parameter(in = ParameterIn.HEADER, description = "version of this header" ,required=true,schema=@Schema()) @RequestHeader(value="WP-Header-Version", required=true) Integer wpHeaderVersion) {
        String accept = request.getHeader("Accept");

        Lde lde = inMemoryLdeCache.getLde(application,processinggroup);
        if (lde !=null){
            LocalDate current = lde.getLogicalDate();
            lde.setLogicalDate(current.plusDays(1));
        } else {
            lde = new Lde();
            lde.setApplication(application);
            lde.setProcessingGroup(processinggroup);
            lde.setCreationDate(OffsetDateTime.now());
            lde.setLogicalDate(LocalDate.now());
            inMemoryLdeCache.putLde(application,processinggroup,lde);
        }

        publisherService.publishLogicalDateChanged(new Random().nextInt(),lde,wpRequestID);

        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
    }

}
