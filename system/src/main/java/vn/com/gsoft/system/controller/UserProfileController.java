package vn.com.gsoft.system.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.com.gsoft.system.constant.PathContains;
import vn.com.gsoft.system.model.dto.UserProfileReq;
import vn.com.gsoft.system.model.system.BaseResponse;
import vn.com.gsoft.system.service.UserProfileService;
import vn.com.gsoft.system.util.system.ResponseUtils;

@Slf4j
@RestController
@RequestMapping(value = PathContains.URL_USER_PROFILE)
@Tag(name = "User Information (Admin/Owner/Staff)")
public class UserProfileController {
    @Autowired
    private UserProfileService service;

    @Operation(summary = "Lookup", description = "Lookup")
    @PostMapping(value = PathContains.URL_SEARCH_PAGE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<BaseResponse> colection(@RequestBody UserProfileReq objReq) throws Exception {
        return ResponseEntity.ok(ResponseUtils.ok(service.searchPage(objReq)));
    }

    @Operation(summary = "Lookup", description = "Lookup")
    @PostMapping(value = PathContains.URL_SEARCH_LIST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<BaseResponse> colectionList(@RequestBody UserProfileReq objReq) throws Exception {
        return ResponseEntity.ok(ResponseUtils.ok(service.searchList(objReq)));
    }

    @Operation(summary = "Create", description = "Create")
    @PostMapping(value = PathContains.URL_CREATE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<BaseResponse> insert(@Valid @RequestBody UserProfileReq objReq) throws Exception {
        return ResponseEntity.ok(ResponseUtils.ok(service.create(objReq)));
    }

    @Operation(summary = "Update", description = "Update")
    @PostMapping(value = PathContains.URL_UPDATE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<BaseResponse> update(@Valid @RequestBody UserProfileReq objReq) throws Exception {
        return ResponseEntity.ok(ResponseUtils.ok(service.update(objReq)));
    }

    @Operation(summary = "Details", description = "Details")
    @GetMapping(value = PathContains.URL_DETAIL, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<BaseResponse> detail(@PathVariable("id") Long id) throws Exception {
        return ResponseEntity.ok(ResponseUtils.ok(service.detail(id)));
    }

    @Operation(summary = "Delete", description = "Delete")
    @PostMapping(value = PathContains.URL_DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<BaseResponse> delete(@Valid @RequestBody UserProfileReq idSearchReq) throws Exception {
        return ResponseEntity.ok(ResponseUtils.ok(service.delete(idSearchReq.getId())));
    }

    @Operation(summary = "Delete Forever", description = "Delete Forever")
    @PostMapping(value = PathContains.URL_DELETE_FOREVER, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<BaseResponse> deleteForever(@Valid @RequestBody UserProfileReq idSearchReq) throws Exception {
        return ResponseEntity.ok(ResponseUtils.ok(service.deleteForever(idSearchReq.getId())));
    }
}
