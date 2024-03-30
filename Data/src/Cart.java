import java.util.Date;

public class Cart {
    private int c_no;
    private String c_name;
    private int c_ea;
    private int c_price;
    private Date c_time;

    public int getC_no() {
        return c_no;
    }

    public void setC_no(int c_no) {
        this.c_no = c_no;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public int getC_ea() {
        return c_ea;
    }

    public void setC_ea(int c_ea) {
        this.c_ea = c_ea;
    }

    public int getC_price() {
        return c_price;
    }

    public void setC_price(int c_price) {
        this.c_price = c_price;
    }

    public Date getC_time() {
        return c_time;
    }

    public void setC_time(Date c_time) {
        this.c_time = c_time;
    }
}
