package com.matrimony.users.dto;

import com.matrimony.users.util.ResponseStatus;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

public class ResponseDTO {

    public ResponseDTO(ResponseStatus status, HttpStatus httpStatus, String message, List<UserDTO> users){
        this.httpStatus=httpStatus;
        this.status=status;
        this.statusMessage=message;
        this.users=users;
    }

    private ResponseStatus status;
    private HttpStatus httpStatus;
    private String statusMessage;
    private List<UserDTO> users = new ArrayList<>();

    public ResponseStatus getStatus() {
        return status;
    }

    public void setStatus(ResponseStatus status) {
        this.status = status;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public List<UserDTO> getUsers() {
        return users;
    }

    public void setUsers(List<UserDTO> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "ResponseDTO{" +
                "status=" + status +
                ", httpStatus='" + httpStatus + '\'' +
                ", statusMessage='" + statusMessage + '\'' +
                ", users=" + users +
                '}';
    }
}
