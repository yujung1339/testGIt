import java.util.Date;
public class Game_records {
    private int point;
    private int game_code;
    private String userid;
    private Date game_date;

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public int getGame_code() {
        return game_code;
    }

    public void setGame_code(int game_code) {
        this.game_code = game_code;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public Date getGame_date() {
        return game_date;
    }

    public void setGame_date(Date game_date) {
        this.game_date = game_date;
    }
}
