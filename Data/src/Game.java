import java.util.Date;

public class Game {
    private int game_code;
    private Date game_date;
    private String userid;
    private int point;

    public int getGame_code() {
        return game_code;
    }

    public void setGame_code(int game_code) {
        this.game_code = game_code;
    }

    public Date getGame_date() {
        return game_date;
    }

    public void setGame_date(Date game_date) {
        this.game_date = game_date;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }
}
