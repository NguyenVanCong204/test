package com.example.a124lttd04_travelappproject.view.hotel;

public class hotel_response_Model {
    private String message;
    private int madatkhachsan;

    // Constructor
    public void hotel_response_Model(String message, int madatkhachsan) {
        this.message = message;
        this.madatkhachsan = madatkhachsan;
    }

    // Getter and Setter methods
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getMadatkhachsan() {
        return madatkhachsan;
    }

    public void setMadatkhachsan(int madatkhachsan) {
        this.madatkhachsan = madatkhachsan;
    }
}
