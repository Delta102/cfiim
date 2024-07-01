package com.dev.campusfrontute.models.helpers;

import com.dev.campusfrontute.models.MdlUser;

public class MdlUserWithRole {
    private MdlUser user;
    private int roleId;
    private String roleName;
    private String pictureUrl;

    public MdlUser getUser() {
        return user;
    }

    public void setUser(MdlUser user) {
        this.user = user;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }
}

