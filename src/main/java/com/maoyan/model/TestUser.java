package com.maoyan.model;

import java.util.Date;

public class TestUser {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column test_user.id
     *
     * @mbg.generated Mon May 06 21:25:25 CST 2024
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column test_user.username
     *
     * @mbg.generated Mon May 06 21:25:25 CST 2024
     */
    private String username;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column test_user.password
     *
     * @mbg.generated Mon May 06 21:25:25 CST 2024
     */
    private String password;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column test_user.create_time
     *
     * @mbg.generated Mon May 06 21:25:25 CST 2024
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column test_user.update_time
     *
     * @mbg.generated Mon May 06 21:25:25 CST 2024
     */
    private Date updateTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column test_user.id
     *
     * @return the value of test_user.id
     *
     * @mbg.generated Mon May 06 21:25:25 CST 2024
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column test_user.id
     *
     * @param id the value for test_user.id
     *
     * @mbg.generated Mon May 06 21:25:25 CST 2024
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column test_user.username
     *
     * @return the value of test_user.username
     *
     * @mbg.generated Mon May 06 21:25:25 CST 2024
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column test_user.username
     *
     * @param username the value for test_user.username
     *
     * @mbg.generated Mon May 06 21:25:25 CST 2024
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column test_user.password
     *
     * @return the value of test_user.password
     *
     * @mbg.generated Mon May 06 21:25:25 CST 2024
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column test_user.password
     *
     * @param password the value for test_user.password
     *
     * @mbg.generated Mon May 06 21:25:25 CST 2024
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column test_user.create_time
     *
     * @return the value of test_user.create_time
     *
     * @mbg.generated Mon May 06 21:25:25 CST 2024
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column test_user.create_time
     *
     * @param createTime the value for test_user.create_time
     *
     * @mbg.generated Mon May 06 21:25:25 CST 2024
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column test_user.update_time
     *
     * @return the value of test_user.update_time
     *
     * @mbg.generated Mon May 06 21:25:25 CST 2024
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column test_user.update_time
     *
     * @param updateTime the value for test_user.update_time
     *
     * @mbg.generated Mon May 06 21:25:25 CST 2024
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}