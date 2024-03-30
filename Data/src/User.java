// 먼저 변수를 선언해야지 게터 세터를 만들 수 있음 !!!
// DTO는 Data Transfer Object의 약자로, 계층 간(Controlelr, View, Business Layer) 데이터 교환을 위한 Java Bean를 의미한다.
// DTO는 로직을 가지지 않는 데이터 객체이고, getter, setter 메소드만 가진 클래스를 의미한다.
public class User {
    private String userid;
    private String username;
    private String pw;

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

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }
}
