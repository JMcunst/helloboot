package jmcunst.spring001.dto;

public class MyResponseDto {
    private String message;

    public MyResponseDto(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
