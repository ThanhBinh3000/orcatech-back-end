package vn.com.gsoft.socketio.system;

import lombok.Data;

@Data
public class MessageDTO {
    private String id;
    private String uuid;
    private String data;
}