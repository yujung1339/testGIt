import java.util.Date;
public class Ranking {
    private int game_code;
    private Date game_date;
    private String userid;
    private String username;

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
