package Hotel;

public class Customer
{
    private String hoTen;
    private int tuoi;
    private String cmnd;
    private Room room;

    public Customer()
    {

    }

    public Customer(String hoTen, int tuoi, String cmnd)
    {
        this.hoTen = hoTen;
        this.tuoi = tuoi;
        this.cmnd = cmnd;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

}
