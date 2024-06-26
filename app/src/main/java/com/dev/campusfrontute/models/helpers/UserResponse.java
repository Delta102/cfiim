package com.dev.campusfrontute.models.helpers;

public class UserResponse {
    private long id;
    private String auth;
    private boolean confirmed;
    private boolean policyAgreed;
    private boolean deleted;
    private boolean suspended;
    private long mnethostid;
    private String username;
    private String password;
    private String idnumber;
    private String firstname;
    private String lastname;
    private String email;
    private boolean emailstop;
    private String phone1;
    private String phone2;
    private String institution;
    private String department;
    private String address;
    private String city;
    private String country;
    private String lang;
    private String calendartype;
    private String theme;
    private String timezone;
    private long firstaccess;
    private long lastaccess;
    private long lastlogin;
    private long currentlogin;
    private String lastip;
    private String secret;
    private long picture;
    private String description;
    private byte descriptionformat;
    private Boolean mailformat;
    private boolean maildigest;
    private byte maildisplay;
    private Boolean autosubscribe;
    private boolean trackforums;
    private long timecreated;
    private long timemodified;
    private long trustbitmask;
    private String imagealt;
    private String lastnamephonetic;
    private String firstnamephonetic;
    private String middlename;
    private String alternatename;
    private String moodlenetprofile;
    private String token;

    public UserResponse() {
    }

    public UserResponse(long id, String auth, boolean confirmed, boolean policyAgreed, boolean deleted, boolean suspended, long mnethostid, String username, String password, String idnumber, String firstname, String lastname, String email, boolean emailstop, String phone1, String phone2, String institution, String department, String address, String city, String country, String lang, String calendartype, String theme, String timezone, long firstaccess, long lastaccess, long lastlogin, long currentlogin, String lastip, String secret, long picture, String description, byte descriptionformat, Boolean mailformat, boolean maildigest, byte maildisplay, Boolean autosubscribe, boolean trackforums, long timecreated, long timemodified, long trustbitmask, String imagealt, String lastnamephonetic, String firstnamephonetic, String middlename, String alternatename, String moodlenetprofile, String token) {
        this.id = id;
        this.auth = auth;
        this.confirmed = confirmed;
        this.policyAgreed = policyAgreed;
        this.deleted = deleted;
        this.suspended = suspended;
        this.mnethostid = mnethostid;
        this.username = username;
        this.password = password;
        this.idnumber = idnumber;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.emailstop = emailstop;
        this.phone1 = phone1;
        this.phone2 = phone2;
        this.institution = institution;
        this.department = department;
        this.address = address;
        this.city = city;
        this.country = country;
        this.lang = lang;
        this.calendartype = calendartype;
        this.theme = theme;
        this.timezone = timezone;
        this.firstaccess = firstaccess;
        this.lastaccess = lastaccess;
        this.lastlogin = lastlogin;
        this.currentlogin = currentlogin;
        this.lastip = lastip;
        this.secret = secret;
        this.picture = picture;
        this.description = description;
        this.descriptionformat = descriptionformat;
        this.mailformat = mailformat;
        this.maildigest = maildigest;
        this.maildisplay = maildisplay;
        this.autosubscribe = autosubscribe;
        this.trackforums = trackforums;
        this.timecreated = timecreated;
        this.timemodified = timemodified;
        this.trustbitmask = trustbitmask;
        this.imagealt = imagealt;
        this.lastnamephonetic = lastnamephonetic;
        this.firstnamephonetic = firstnamephonetic;
        this.middlename = middlename;
        this.alternatename = alternatename;
        this.moodlenetprofile = moodlenetprofile;
        this.token = token;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    public boolean isPolicyAgreed() {
        return policyAgreed;
    }

    public void setPolicyAgreed(boolean policyAgreed) {
        this.policyAgreed = policyAgreed;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public boolean isSuspended() {
        return suspended;
    }

    public void setSuspended(boolean suspended) {
        this.suspended = suspended;
    }

    public long getMnethostid() {
        return mnethostid;
    }

    public void setMnethostid(long mnethostid) {
        this.mnethostid = mnethostid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIdnumber() {
        return idnumber;
    }

    public void setIdnumber(String idnumber) {
        this.idnumber = idnumber;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isEmailstop() {
        return emailstop;
    }

    public void setEmailstop(boolean emailstop) {
        this.emailstop = emailstop;
    }

    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getCalendartype() {
        return calendartype;
    }

    public void setCalendartype(String calendartype) {
        this.calendartype = calendartype;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public long getFirstaccess() {
        return firstaccess;
    }

    public void setFirstaccess(long firstaccess) {
        this.firstaccess = firstaccess;
    }

    public long getLastaccess() {
        return lastaccess;
    }

    public void setLastaccess(long lastaccess) {
        this.lastaccess = lastaccess;
    }

    public long getLastlogin() {
        return lastlogin;
    }

    public void setLastlogin(long lastlogin) {
        this.lastlogin = lastlogin;
    }

    public long getCurrentlogin() {
        return currentlogin;
    }

    public void setCurrentlogin(long currentlogin) {
        this.currentlogin = currentlogin;
    }

    public String getLastip() {
        return lastip;
    }

    public void setLastip(String lastip) {
        this.lastip = lastip;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public long getPicture() {
        return picture;
    }

    public void setPicture(long picture) {
        this.picture = picture;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte getDescriptionformat() {
        return descriptionformat;
    }

    public void setDescriptionformat(byte descriptionformat) {
        this.descriptionformat = descriptionformat;
    }

    public Boolean getMailformat() {
        return mailformat;
    }

    public void setMailformat(Boolean mailformat) {
        this.mailformat = mailformat;
    }

    public boolean isMaildigest() {
        return maildigest;
    }

    public void setMaildigest(boolean maildigest) {
        this.maildigest = maildigest;
    }

    public byte getMaildisplay() {
        return maildisplay;
    }

    public void setMaildisplay(byte maildisplay) {
        this.maildisplay = maildisplay;
    }

    public Boolean getAutosubscribe() {
        return autosubscribe;
    }

    public void setAutosubscribe(Boolean autosubscribe) {
        this.autosubscribe = autosubscribe;
    }

    public boolean isTrackforums() {
        return trackforums;
    }

    public void setTrackforums(boolean trackforums) {
        this.trackforums = trackforums;
    }

    public long getTimecreated() {
        return timecreated;
    }

    public void setTimecreated(long timecreated) {
        this.timecreated = timecreated;
    }

    public long getTimemodified() {
        return timemodified;
    }

    public void setTimemodified(long timemodified) {
        this.timemodified = timemodified;
    }

    public long getTrustbitmask() {
        return trustbitmask;
    }

    public void setTrustbitmask(long trustbitmask) {
        this.trustbitmask = trustbitmask;
    }

    public String getImagealt() {
        return imagealt;
    }

    public void setImagealt(String imagealt) {
        this.imagealt = imagealt;
    }

    public String getLastnamephonetic() {
        return lastnamephonetic;
    }

    public void setLastnamephonetic(String lastnamephonetic) {
        this.lastnamephonetic = lastnamephonetic;
    }

    public String getFirstnamephonetic() {
        return firstnamephonetic;
    }

    public void setFirstnamephonetic(String firstnamephonetic) {
        this.firstnamephonetic = firstnamephonetic;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getAlternatename() {
        return alternatename;
    }

    public void setAlternatename(String alternatename) {
        this.alternatename = alternatename;
    }

    public String getMoodlenetprofile() {
        return moodlenetprofile;
    }

    public void setMoodlenetprofile(String moodlenetprofile) {
        this.moodlenetprofile = moodlenetprofile;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
