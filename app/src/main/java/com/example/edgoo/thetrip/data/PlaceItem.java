
package com.example.edgoo.thetrip.data;

public class PlaceItem {

    private final String placeName;
    private final String address;
    private final int start;
    private final int end;
    private final String checkList;
    private final String image;

    public PlaceItem(String placeName, String address, int start, int end, String checkList, String image) {
        this.placeName = placeName;
        this.address = address;
        this.start = start;
        this.end = end;
        this.checkList = checkList;
        this.image = image;
    }

    public String getPlaceName() {
        return placeName;
    }

    public String getAddress() {
        return address;
    }

    public int getStartTime() {
        return start;
    }

    public int getEndTime() {
        return end;
    }

    public String getCheckList() {
        return checkList;
    }

    public String getImage() {
        return image;
    }
    @Override
    public String toString() {
        return "Place{" +
                "placeName='" + placeName + '\'' +
                ", address='" + address + '\'' +
                ", start=" + start +
                ", end=" + end +
                ", checkList='" + checkList + '\'' +
                '}';
    }

}
