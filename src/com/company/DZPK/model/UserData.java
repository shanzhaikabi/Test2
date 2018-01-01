package com.company.DZPK.model;

/**
 * Created by Shanzhai on 2018/1/1.
 */
public class UserData {
    //通用数据
    private int id;
    private String username;
    private String nickname;
    private int point;
    private int rank;

    public UserData(int id, String username, String nickname, int point, int rank) {
        this.id = id;
        this.username = username;
        this.nickname = nickname;
        this.point = point;
        this.rank = rank;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    /*//个人数据
    private double per_point;
    private double per_rank;
    private double per_income;
    private double per_score;
    private int income;
    private int rank;
    private int score;*/
}
