package com.myproject.api;

import com.myproject.exception.ResourceAlreadyExistException;
import com.myproject.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.myproject.validation.PutValidation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import io.swagger.annotations.*;
import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.security.Principal;
import java.util.List;


@Controller
public class UserApiController implements UserApi {

    private static final Logger log = LoggerFactory.getLogger(UserApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public UserApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Void> addUser( @ApiParam(value = "User to be added"  )  @Valid @RequestBody User userToBeAdded)  throws ResourceAlreadyExistException{
        String accept = request.getHeader("Accept");
        if(accept!=null && accept.contains("application/json")) throw new ResourceAlreadyExistException("Resource Already exist 1");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<User>> searchUser(@ApiParam(value = "pass an optional search string for looking up user") @Valid @RequestParam(value = "searchString", required = false) String searchString,@Min(0)@ApiParam(value = "number of records to skip for pagination") @Valid @RequestParam(value = "skip", required = false) Integer skip,@Min(0) @Max(50) @ApiParam(value = "maximum number of records to return") @Valid @RequestParam(value = "limit", required = false) Integer limit) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<User>>(objectMapper.readValue("[ {  \"firstname\" : \"Sonia\",  \"dob\" : \"10/28/2019\",  \"id\" : \"d290f1ee-6c54-4b01-90e6-d701748f0851\",  \"lastname\" : \"Jain\"}, {  \"firstname\" : \"Sonia\",  \"dob\" : \"10/28/2019\",  \"id\" : \"d290f1ee-6c54-4b01-90e6-d701748f0851\",  \"lastname\" : \"Jain\"} ]", List.class), HttpStatus.OK);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<User>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<User>>(HttpStatus.NOT_IMPLEMENTED);
    }


   public ResponseEntity<Void> updateUser( @ApiParam(value = "User to be Updated"  ) @Validated(value= PutValidation.class) @Valid @RequestBody User user) throws ResourceAlreadyExistException{
       String accept = request.getHeader("Accept");
       if(accept!=null && accept.contains("application/json")) throw new ResourceAlreadyExistException("Resource Already exist 1");
       return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
   }


}
