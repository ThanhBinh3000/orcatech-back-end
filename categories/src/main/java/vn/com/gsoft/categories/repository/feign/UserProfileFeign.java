package vn.com.gsoft.categories.repository.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import vn.com.gsoft.categories.model.system.BaseResponse;

@FeignClient(name = "security")
public interface UserProfileFeign {
    @GetMapping("/profile")
    BaseResponse getProfile();
}
